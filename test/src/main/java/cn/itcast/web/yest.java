package cn.itcast.web;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class yest {
    public static void main(String[] args) throws Exception {
        Workbook wb = new XSSFWorkbook();
        Sheet sheet = wb.createSheet("abc");
        Row row = sheet.createRow(2);
        Cell cell = row.createCell(2);
        cell.setCellValue("666");
        FileOutputStream fos = new FileOutputStream("F://abc.xlsx");
        wb.write(fos);
        fos.close();
    }
}
