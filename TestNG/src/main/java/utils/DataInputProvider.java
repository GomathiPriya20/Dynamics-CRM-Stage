package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Driver;
import java.sql.DriverAction;
import java.util.HashMap;
import java.util.Map;


import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.http.conn.ssl.BrowserCompatHostnameVerifier;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFTableColumn;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.helpers.XSSFColumnShifter;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.LoginPage;


  
public class DataInputProvider 
   {
         
	public static Object[][] getSheet(String dataSheetName) throws IOException {
	
		Object[][] data = null ;
		try {
			String text = "./data/"+dataSheetName+".xlsx";
			System.out.println(text);
			FileInputStream fis = new FileInputStream("./data/"+dataSheetName+".xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheetAt(0);	

			// get the number of rows
			int rowCount = sheet.getLastRowNum();

		    //   int rowCount = 3;  //sel only this
			// get the number of columns
			int columnCount = sheet.getRow(0).getLastCellNum();
			
			data = new String[rowCount][columnCount];

			// loop through the rows 
			
			for(int i=1; i <rowCount+1; i++)
			
			{
				try {
					XSSFRow row = sheet.getRow(i);						   
				   
				
				//f((row.getCell(0).getStringCellValue()).equals(Testcasename.contentEquals(TestId))) {
					for(int j=0; j<columnCount; j++) {
					 // loop through the columns
						try {
							String cellValue = "";
							try{
								cellValue = row.getCell(j).getStringCellValue();
							}catch(NullPointerException e){

							}
							
 						data[i-1][j]  = cellValue; // add to the data array
						} 
					catch (Exception e) {
							e.printStackTrace();
						}				
					}
						
					
				}					
					
				 catch (Exception e) {
					e.printStackTrace();
				}
			}
			fis.close();
			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;         

		
		}
   }
//ren	
//	public static void setMapData(Object TestId) throws IOException 
//	{			  
//	  
//		String path = "E:\\skm\\Dynamics Crm Updated\\data\\MasterData.xlsx";
//	//	String path = "user.dir" + "\\Dynamics Crm Updated\\data\\MasterData.xlsx";
//		FileInputStream fis = new FileInputStream(path);
//		Workbook workbook = new XSSFWorkbook(fis);
//		Sheet sheet1 =  workbook.getSheetAt(0);
//		 
//		int totalNoOfRows = sheet1.getLastRowNum() - sheet1.getFirstRowNum();
//        Row headerrow = sheet1.getRow(0);
//        HashMap<String, String> map = new HashMap<String, String>();
//        for (int row = 1; row < totalNoOfRows; row++) {
//            Row row1 = sheet1.getRow(row);
//            if ((row1.getCell(0).getStringCellValue()).equals(TestId)) {
//                for (int col = 1; col < row1.getLastCellNum(); col++) {
//                    map.put(headerrow.getCell(col).getStringCellValue(), row1.getCell(col).getStringCellValue());
//                }
//            }
          //  System.out.println(map);// TODO Auto-generated method stub
     //   }
	
		
		
	
		
		
		
		
//		int lastRow = sheet1.getLastRowNum();
//		
//		Map<String, Map<String, String>> excelFileMap = new HashMap<String, Map<String,String>>();
//		Map<String, String> dataMap = new HashMap<String, String>();
//
//		//Looping over entire row
//
//		for(int i=0; i<=lastRow; i++){
//		Row row = sheet1.getRow(i);
//
//		//1st Cell as Value
//		Cell valueCell = row.getCell(1);
//
//		//0th Cell as Key
//		Cell keyCell = row.getCell(0);
//
//		String value = valueCell.getStringCellValue().trim();
//		String key = keyCell.getStringCellValue().trim();
//
//		//Putting key & value in dataMap
//		dataMap.put(key, value);
//
//		//Putting dataMap to excelFileMap
//		excelFileMap.put("dataSheetName", dataMap);
//		}
//
//		//Returning excelFileMap
//		return excelFileMap;
//		}
	//Method to retrieve value
//	public static String getMapData(String key) throws IOException{
//	Map<String, String> m = setMapData().get("dataSheetName");
//	String value = m.get(key);
//	return value;
//           }
//	public static Object[][] getSheet(String dataSheetName) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	

	

	
      
           
