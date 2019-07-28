package mobile.ebay.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class DataManager {
	
	/**
	 * To Manage the data from the external files
	 */
	public Cell readExcelData(String filePath,String filename,String sheetName,int rowNum,int cellNum) throws IOException
	{
		/**
		 * To get the data from the excel
		 */ 
		
		File file = new File(filename);
		FileInputStream fis = new FileInputStream(file);
		FileInputStream inputStream = new FileInputStream(file);
		Workbook workbook = new HSSFWorkbook(inputStream);
		Sheet sheet = workbook.getSheet(sheetName);
		return sheet.getRow(rowNum).getCell(cellNum);
	}
	
	public String readPropertiesData(String filePath,String propertyName) throws IOException
	{
		/**
		 * To get the data from the properties file
		 */ 
		
		File file = new File(filePath);
		FileInputStream fis = new FileInputStream(file);
		
		Properties properties  = new Properties();
		properties.load(fis);
		
		return properties.getProperty(propertyName);
	}

}
