package com.utils;
 
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
 
import java.io.FileInputStream;
 
public class ExcelReader {
 
    public static String readExcelCell(String excelPath, String sheetName, int rowNum, int colNum) {
        String cellValue = "";
        try {
            FileInputStream fis = new FileInputStream(excelPath);
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheet(sheetName);
            Row row = sheet.getRow(rowNum);
            Cell cell = row.getCell(colNum);
 
            DataFormatter formatter = new DataFormatter();
            cellValue = formatter.formatCellValue(cell); // handles any type
 
            workbook.close();
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cellValue;
    }
}