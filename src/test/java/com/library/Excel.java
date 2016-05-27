package com.library;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class Excel {
	private Workbook wb;
	private Sheet sheet;
	
	public Excel(String sPath){
		try{
			wb = WorkbookFactory.create(new FileInputStream(sPath));
	  	}catch(InvalidFormatException | IOException e){
	  		System.out.println("Something Wroong with the Excel file !! Please check");
		}
	}
	
	public  ArrayList<Integer> get_testcases(String sSheet_name) 
    {

	  ArrayList<Integer> sTest_case_ID=new ArrayList<Integer>();
	  sheet = wb.getSheet(sSheet_name);
		
		/*Loop through all rows and hardcoded columns  to Grab only TCID and making sure it is of type integer*/
		for(int row=0;row<=sheet.getLastRowNum();row++){
			if(sheet.getRow(row).getCell(1).getRichStringCellValue().toString().toLowerCase().equals("yes"))
				sTest_case_ID.add((int) sheet.getRow(row).getCell(0).getNumericCellValue());
		}
		
		return sTest_case_ID;
    }
	
	public HashMap<String,String> get_TestData(String sSheet_name){
		HashMap<String ,String> dictTestdata=new HashMap<String,String>();
		sheet = wb.getSheet(sSheet_name);
		for(int row=0;row<=sheet.getLastRowNum();row++)
			dictTestdata.put(sheet.getRow(row).getCell(0).getRichStringCellValue().toString(),sheet.getRow(row).getCell(1).getRichStringCellValue().toString());
		
		return dictTestdata;
		
	}

}
