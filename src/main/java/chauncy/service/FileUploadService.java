package chauncy.service;

import chauncy.utility.UUIDCreator;
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
import java.util.List;

public class FileUploadService {
    private HttpServletRequest req;
    private Logger logger = Logger.getLogger(FileUploadService.class);
    private InputStream inputStream;
    private String type;
    private String datePosition;
    private boolean showContract;
    private boolean hasHead;

    //上传流程
    public void doService(HttpServletRequest req){
        this.req = req;

        //分析请求
        requestAnalyse(req);

        //上传
        if(inputStream != null) {
            backgroundUpload(inputStream);
        }

        //关闭inputStream
        isClose();
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
        Thread thread = new Thread(){
            @Override
            public void run() {

            }
        };
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
            logger.debug("文件已存入服务器");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fos != null) {
                    fos.close();
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
}
