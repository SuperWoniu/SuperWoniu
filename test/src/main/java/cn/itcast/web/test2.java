package cn.itcast.web;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;

public class test2 {
    public static void main(String[] args) throws Exception {

        Workbook wb = new XSSFWorkbook("E:\\项目1\\day09\\03-资料\\上传货物模板.xlsx");
        Sheet sheet = wb.getSheetAt(0);
        for (int i = 0; i <=sheet.getLastRowNum() ; i++) {
            Row row = sheet.getRow(i);
            for (int j = 2; j < row.getLastCellNum(); j++) {
                Cell cell = row.getCell(j);
                Object obj=getCellValue(cell);
                System.out.print(obj +"   ");
            }
                System.out.println("");
        }


    }


    //解析每个单元格的数据
    public static Object getCellValue(Cell cell) {
        Object obj = null;
        //单元格类型
        CellType cellType = cell.getCellType();
        switch (cellType) {
            case STRING: { //字符串单元
                obj = cell.getStringCellValue();
                break;
            }
            //excel默认将日志也理解为数字
            case NUMERIC:{ //数字单元格
                if(DateUtil.isCellDateFormatted(cell)) { //日期
                    obj = cell.getDateCellValue();
                }else {
                    obj = cell.getNumericCellValue();
                }
                break;
            }
            case BOOLEAN:{ //boolean
                obj = cell.getBooleanCellValue();
                break;
            }
            default:{
                break;
            }
        }
        return obj;
    }
}
