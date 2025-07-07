package com.utils;
 
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
 
import java.io.InputStream;
 
public class ExcelReader {
 
    private static Workbook workbook;
 
    static {
        try {
            // ✅ Use relative path inside resources folder
            InputStream inputStream = ExcelReader.class.getClassLoader()
                .getResourceAsStream("src\\test\\resources\\ExcelData\\Data.xlsx");
 
            if (inputStream == null) {
                throw new RuntimeException("Excel file not found in resources/ExcelData folder");
            }
 
            workbook = new XSSFWorkbook(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load Excel workbook: " + e.getMessage());
        }
    }
 
    public static String getCellData(String sheetName, int rowNum, int colNum) {
        try {
            Sheet sheet = workbook.getSheet(sheetName);
            if (sheet == null) throw new RuntimeException("Sheet not found: " + sheetName);
 
            Row row = sheet.getRow(rowNum);
            if (row == null) return "";
 
            Cell cell = row.getCell(colNum);
            if (cell == null) return "";
 
            DataFormatter formatter = new DataFormatter();
            return formatter.formatCellValue(cell);
 
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}