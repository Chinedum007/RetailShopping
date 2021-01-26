package com.eshopping.womenshopping.generic;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelLibrary {
	
	public static String getStringData(String filePath, String sheetName, int rowNum, int cellNum) {
		try {
			FileInputStream fin = new FileInputStream(filePath);
			
			//Create Object Representation of ExcelFile
			Workbook workBook = WorkbookFactory.create(fin);
			
			//Create Object Representation of Sheet
			Sheet sheet=workBook.getSheet(sheetName);
			
			return sheet.getRow(rowNum).getCell(cellNum).getStringCellValue();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static Double getNumericData(String filePath, String sheetName, int rowNum, int cellNum) {
		try {
			FileInputStream fin = new FileInputStream(filePath);
			
			//Create Object Representation of ExcelFile
			Workbook workBook = WorkbookFactory.create(fin);
			
			//Create Object Representation of Sheet
			Sheet sheet=workBook.getSheet(sheetName);
			
			return sheet.getRow(rowNum).getCell(cellNum).getNumericCellValue();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public static Boolean getBooleanData(String filePath, String sheetName, int rowNum, int cellNum) {
		try {
			FileInputStream fin = new FileInputStream(filePath);
			
			//Create Object Representation of ExcelFile
			Workbook workBook = WorkbookFactory.create(fin);
			
			//Create Object Representation of Sheet
			Sheet sheet=workBook.getSheet(sheetName);
			
			return sheet.getRow(rowNum).getCell(cellNum).getBooleanCellValue();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String[][] getMultipleData(String filePath, String sheetName) {
		try {
			FileInputStream fin = new FileInputStream(filePath);
			
			//Create Object Representation of ExcelFile
			Workbook workBook = WorkbookFactory.create(fin);
			
			//Create Object Representation of Sheet
			Sheet sheet=workBook.getSheet(sheetName);
			
			int rowCount = sheet.getPhysicalNumberOfRows();//4
			int cellCount = sheet.getRow(0).getPhysicalNumberOfCells();//5
			
			String[][] sarr = new String[rowCount][cellCount];
			
			for(int i=0;i<=rowCount-1;i++) {
				for(int j=0;j<=cellCount-1;j++) {
					sarr[i][j] = sheet.getRow(i).getCell(j).toString();
				}
			}
			
			return sarr;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
