package chauncy.service;

import chauncy.bean.CWallData;
import chauncy.bean.TableAnalyser;
import chauncy.dao.CWallDataDao;
import chauncy.utility.UUIDCreator;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * 处理文件上传
 */
public class FileUploadService {
    private HttpServletRequest req;
    private Logger logger = Logger.getLogger(FileUploadService.class);
    private InputStream inputStream;
    private String type;
    private String datePosition;
    private boolean showContract;
    private boolean hasHead;
    private boolean saveComplete = false;
    private boolean insertComplete = false;

    //上传流程
    public void doService(HttpServletRequest req){
        this.req = req;

        //分析请求
        requestAnalyse(req);

        //InputStream复制
        InputStream cloneInputStream = null;
        try {
            cloneInputStream = (InputStream) BeanUtils.cloneBean(inputStream);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        //并发上传
        if(inputStream != null) {
            backgroundUpload(cloneInputStream);
        }

        //处理
        TableAnalyser analyser = new TableAnalyser(type,hasHead);
        List<CWallData> list = analyser.getResult(inputStream);
        logList(list);

        //存入数据库
        CWallDataDao.insertList(list);
        insertComplete = true;

        req.setAttribute("CWallData",list);
        req.setAttribute("DataPosition",datePosition);
        req.setAttribute("ShowContact",showContract);
    }

    private void requestAnalyse(HttpServletRequest req){
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setHeaderEncoding("UTF-8");
        try {
            if(ServletFileUpload.isMultipartContent(req)){
                List<FileItem> list = upload.parseRequest(req);
                for (FileItem item : list){
                    if(!item.isFormField()){
                        String fileName = item.getName();
                        logger.debug("fileName:"+fileName);
                        inputStream = item.getInputStream();
                    }else{
                        String fieldName = item.getFieldName();
                        String value = item.getString();
                        logger.debug(fieldName+":"+value);
                        if("type".equals(fieldName)){
                            type = value;
                        }
                        if("datePosition".equals(fieldName)){
                            datePosition = value;
                        }
                        if("showContract".equals(fieldName)){
                            if ("yes".equals(value)){
                                showContract = true;
                            }
                            if ("no".equals(value)){
                                showContract = false;
                            }
                        }
                        if("hasHead".equals(fieldName)){
                            if ("yes".equals(value)){
                                hasHead = true;
                            }
                            if ("no".equals(value)){
                                hasHead = false;
                            }
                        }
                    }
                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void backgroundUpload(final InputStream is){
        Thread thread = new Thread(){
            @Override
            public void run() {
                upload(is);
            }
        };
        thread.start();
    }

    private void upload(InputStream is){
        FileOutputStream fos = null;
        try {
            //判断目录是否存在
            logger.debug("文件开始存入服务器");
            File dir = new File(req.getServletContext().getRealPath("WEB-INF/fileUpload"));
            if (!(dir.exists()&&dir.isDirectory())){
                dir.mkdir();
            }
            File file = new File(dir.getPath()+"/"+ UUIDCreator.getUUID()+"."+type);

            //创建文件
            file.createNewFile();

            //上传
            fos = new FileOutputStream(file);
            byte[] bytes = new byte[1024];
            int len = 0;
            while((len = is.read(bytes))!= -1){
                fos.write(bytes,0,len);
            }
            fos.flush();
            saveComplete = true;
            logger.debug("文件已存入服务器");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }
                if (saveComplete && insertComplete){
                    isClose();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void isClose(){
        if (inputStream != null){
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void logList(List<CWallData> list){
        for (CWallData data : list){
            logger.debug(data);
        }
    }
}
