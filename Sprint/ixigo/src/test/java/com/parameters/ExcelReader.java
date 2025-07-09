package com.parameters;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	
static String filePath;
	
	public ExcelReader(String filePath)
	{
		this.filePath = filePath;
	}
	
	public String getCellData(int rowNum, int colNum) {
	    String cellData = "";
	    try (FileInputStream fis = new FileInputStream(filePath);
	         Workbook workbook = new XSSFWorkbook(fis)) {

	        Sheet sheet = workbook.getSheetAt(0);
	        Row row = sheet.getRow(rowNum);
	        if (row != null) {
	            Cell cell = row.getCell(colNum);
	            if (cell != null) {
	                cellData = cell.toString();
	            }
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return cellData;
	}
	
	public static String getCellData(int sheetIndex, int rowNum, int colNum) {
		
        try (FileInputStream fis = new FileInputStream("src\\test\\resource\\Exceldata\\Data.xlsx");
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(sheetIndex);
            Row row = sheet.getRow(rowNum);
            Cell cell = row.getCell(colNum);
            return cell.getStringCellValue();

        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }


}
