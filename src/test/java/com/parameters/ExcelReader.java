package com.parameters;

<<<<<<< HEAD
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
=======
import java.io.FileInputStream;
>>>>>>> ed83b207d06e2c8156bab4542d29e1ddfb2416ab

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
<<<<<<< HEAD
import org.apache.poi.ss.usermodel.WorkbookFactory;
=======
>>>>>>> ed83b207d06e2c8156bab4542d29e1ddfb2416ab
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
 
public class ExcelReader {
	
<<<<<<< HEAD
//	 public static List<List<String>> getData(String filePath, String sheetName) {
//	        List<List<String>> data = new ArrayList<>();
//	        try {
//            FileInputStream file = new FileInputStream(new File(filePath));
//            Workbook workbook = WorkbookFactory.create(file);
//            Sheet sheet = workbook.getSheet(sheetName);
//
//            // Skip header
//            int rows = sheet.getPhysicalNumberOfRows();
//            for (int i = 1; i < rows; i++) {
//                Row row = sheet.getRow(i);
//                List<String> rowData = new ArrayList<>();
//                short cols = row.getLastCellNum();
//                for (int j = 0; j < cols; j++) {
//                    Cell cell = row.getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
//                    switch (cell.getCellType()) {
//                        case STRING:
//                            rowData.add(cell.getStringCellValue());
//                            break;
//                        case NUMERIC:
//                            rowData.add(String.valueOf((int) cell.getNumericCellValue()));
//                            break;
//                        default:
//                            rowData.add("");
//                    }
//                }
//                data.add(rowData);
//            }
//
//            workbook.close();
//            file.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return data;
//    }

public static String getCity(String sheetno,int rowno,int colno) {
 
    	
    	FileInputStream fis;
		try {
			fis = new FileInputStream("C:\\Users\\VAIDCHAN\\OneDrive\\eclipse\\ixigo\\src\\test\\resource\\ExcelData\\Data.xlsx");
			Workbook work=new XSSFWorkbook(fis);
	    	Sheet sheet=work.getSheet(sheetno);
	        return sheet.getRow(rowno).getCell(colno).getStringCellValue() ;
		}
    	catch(Exception e){
    		e.printStackTrace();
    		return "";
    	}
		
    }
    	
    			
} 
 

=======
	String filePath;
	
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
 
 
}
>>>>>>> ed83b207d06e2c8156bab4542d29e1ddfb2416ab
