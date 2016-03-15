package com.library;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class Excel {
	
	public  ArrayList<Integer> get_testcases(String sPath,String sSheet_name) 
    {

	  Workbook wb = null;
	  Sheet sheet;
	  ArrayList<Integer> sTest_case_ID=new ArrayList<Integer>();
	  
	  try{
			wb = WorkbookFactory.create(new FileInputStream(sPath));
	  	}catch(InvalidFormatException | IOException e){
			e.printStackTrace();
		}
		sheet = wb.getSheet(sSheet_name);
		for(int row=0;row<=sheet.getLastRowNum();row++)
			if(sheet.getRow(row).getCell(1).getRichStringCellValue().toString().toLowerCase().equals("yes"))
				sTest_case_ID.add((int) sheet.getRow(row).getCell(0).getNumericCellValue());

		return sTest_case_ID;
    }

}
