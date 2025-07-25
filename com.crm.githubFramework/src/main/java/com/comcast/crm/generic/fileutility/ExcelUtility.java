
package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
 public String getDataFromExcel(String SheetName, int rowNum , int colNum) throws Throwable
 {
	 FileInputStream fis=new FileInputStream("./testdata/ExcelSheetData.xlsx");
	 Workbook wb = WorkbookFactory.create(fis);
	 String data = wb.getSheet(SheetName).getRow(rowNum).getCell(colNum).getStringCellValue();
	 wb.close(); 
	return data;
	 
 }
 public int getRow(String SheetName) throws Throwable 
 {
	 FileInputStream fis=new FileInputStream("./testdata/ExcelSheetData.xlsx");
	 Workbook wb = WorkbookFactory.create(fis);
	 int rowcount = wb.getSheet(SheetName).getLastRowNum();
	 wb.close(); 
	return rowcount;
	 
 }
 public void SetDataIntoExcel(String SheetName, int rowNum , int colNum,String Data) throws Throwable
 {
	 FileInputStream fis=new FileInputStream("./testdata/ExcelSheetData.xlsx");
	 Workbook wb = WorkbookFactory.create(fis);
	 wb.getSheet(SheetName).getRow(rowNum).createCell(colNum);
	 
	 FileOutputStream fos=new FileOutputStream("./testdata/ExcelSheetData.xlsx");
	 wb.write(fos);
	 wb.close();
	
 }
}
