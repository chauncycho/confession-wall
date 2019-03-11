package chauncy.bean;

import chauncy.dao.CWallDataDao;
import chauncy.utility.SqlSessionFactoryUtil;
import com.csvreader.CsvReader;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.io.Charsets;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

public class TableAnalyser {
    public static final String CSV = "csv";
    public static final String XLXS = "xlsx";

    private String type = null;
    private boolean hasHead = true;

    public TableAnalyser(String type, Boolean hasHead){
        this.type = type;
        this.hasHead = hasHead;
    }

    public List<CWallData> getResult(InputStream is){
        if (type == null){
            return null;
        }
        if (CSV.equals(type.toLowerCase())){//处理csv
            return getResultFromCsv(is);
        }else if (XLXS.equals(type.toLowerCase())){//处理xlsx
            return getResultFromXlsx(is);
        }
        return null;
    }

    private List<CWallData> getResultFromXlsx(InputStream is){
        List<CWallData> list = new LinkedList<>();

        try {
            // 获得工作簿
            Workbook workbook = WorkbookFactory.create(is);
            // 获得工作表个数
            int sheetCount = workbook.getNumberOfSheets();
            // 遍历工作表
            for (int i = 0; i < sheetCount; i++)
            {
                Sheet sheet = workbook.getSheetAt(i);
                // 获得行数
                int rows = sheet.getLastRowNum() + 1;
                // 获得列数，先获得一行，在得到改行列数
                Row tmp = sheet.getRow(0);
                if (tmp == null)
                {
                    continue;
                }
                int cols = tmp.getPhysicalNumberOfCells();
                // 读取数据
                CWallData cWallData = new CWallData();
                for (int row = 0; row < rows; row++)
                {
                    if (hasHead){
                        hasHead = false;
                        continue;
                    }
                    Row r = sheet.getRow(row);

                    //Cell0
                    Cell cell0 = r.getCell(0);
                    if (cell0 == null){
                        break;
                    }
                    cell0.setCellType(CellType.STRING);
                    cWallData.setDid(Integer.valueOf(cell0.getStringCellValue()));


                    //Cell1
                    Cell cell1 = r.getCell(1);
//                    cell1.setCellType(CellType.STRING);
//                    String date1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(cell1.getDateCellValue());
                    cWallData.setStart_time(new Timestamp(cell1.getDateCellValue().getTime()));

                    //Cell2
                    Cell cell2 = r.getCell(2);
//                    cell2.setCellType(CellType.STRING);
//                    String date1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(cell1.getDateCellValue());
                    cWallData.setEnd_time(new Timestamp(cell2.getDateCellValue().getTime()));

                    //Cell3
                    Cell cell3 = r.getCell(3);
                    if (TableAnalyser.isCellEmpty(cell3)) {
                        cWallData.setDiy_text("");
                    }else{
                        cell3.setCellType(CellType.STRING);
                        cWallData.setDiy_text(cell3.getStringCellValue());
                    }

                    //Cell4
                    Cell cell4 = r.getCell(4);
                    if (TableAnalyser.isCellEmpty(cell4)) {
                        cWallData.setContent("");
                    }else{
                        cell4.setCellType(CellType.STRING);
                        cWallData.setContent(cell4.getStringCellValue());
                    }

                    //Cell5
                    Cell cell5 = r.getCell(5);
                    if (TableAnalyser.isCellEmpty(cell5)) {
                        cWallData.setContact("");
                    }else{
                        cell5.setCellType(CellType.STRING);
                        cWallData.setContact(cell5.getStringCellValue());

                    }

                    //Cell6
                    Cell cell6 = r.getCell(6);
                    if (TableAnalyser.isCellEmpty(cell6)) {
                        cWallData.setSong("");
                    }else{
                        cell6.setCellType(CellType.STRING);
                        cWallData.setSong(cell6.getStringCellValue());

                    }

                    list.add(cWallData);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }
        return list;
    }

    private List<CWallData> getResultFromCsv(InputStream is){
        List<CWallData> list = new LinkedList<>();

        try {
            Iterable<CSVRecord> records = CSVFormat.EXCEL.parse(new InputStreamReader(is));
            for (CSVRecord record : records){
                if (hasHead){
                    hasHead = false;
                    continue;
                }
                CWallData data = new CWallData();
                data.setDid(Integer.valueOf(record.get(0)));
                data.setStart_time(Timestamp.valueOf(record.get(1)));
                data.setEnd_time(Timestamp.valueOf(record.get(2)));
                data.setDiy_text(record.get(3));
                data.setContent(record.get(4));
                data.setContact(record.get(5));
                data.setSong(record.get(6));
                list.add(data);
            }
            
//            // 创建CSV读对象
//            CsvReader csvReader = new CsvReader(is, Charsets.UTF_8);
//
//            // 读表头
//            csvReader.readHeaders();
//            while (csvReader.readRecord()){
//                // 读这行的某一列
//                
//                try {
//                    data.setDid(Integer.valueOf(csvReader.get(0)));
//                    data.setStart_time(Timestamp.valueOf(csvReader.get(1)));
//                    data.setEnd_time(Timestamp.valueOf(csvReader.get(2)));
//                    data.setDiy_text(csvReader.get(3));
//                    data.setContent(csvReader.get(4));
//                    data.setContact(csvReader.get(5));
//                    data.setSong(csvReader.get(6));
//                } catch (Exception e) {
//                    // 读一整行
//                    System.err.println(csvReader.getRawRecord());
//                    continue;
//                }
//                list.add(data);
//            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    private static boolean isCellEmpty(Cell cell){
        if (cell == null){
            return true;
        }else if (cell.getCellTypeEnum().equals(CellType.BLANK)){
            return true;
        }else if (cell.getCellTypeEnum().equals(CellType._NONE)){
            return true;
        }
        return false;
    }

    public static void main(String[] args){
//        try {
//            SqlSessionFactoryUtil.initSqlSessionFactory();
//            TableAnalyser analyser = new TableAnalyser(TableAnalyser.CSV);
//            List<CWallData> list = analyser.getResult(new FileInputStream("/Users/shihuazhuo/Desktop/csvtest.csv"));
//            CWallDataDao.insertList(list);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }

        try {
            SqlSessionFactoryUtil.initSqlSessionFactory();
            TableAnalyser analyser = new TableAnalyser(TableAnalyser.XLXS,true);
            List<CWallData> list = analyser.getResult(new FileInputStream("/Users/shihuazhuo/Desktop/testexcel.xlsx"));
            CWallDataDao.insertList(list);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
