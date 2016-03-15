package com.Test_cases;

//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;




import java.util.ArrayList;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.google.common.primitives.Ints;
import com.library.Excel;
import com.library.GUI;

import javax.swing.*;

/**
 * Created by Guest on 2/21/2016.
 */
public class Test_cases {

    public static StringBuffer check_execution =new StringBuffer();
    public static String username;

	public static boolean bGUI_checkbox;
	public static String sGUI_testcases;
	public static String sGUI_Browser;
	
	public Excel oExcel;
	public int[] iTest_cases;
    
    @BeforeSuite
    public void before_suite() throws InterruptedException{
    	
    	ArrayList<Integer> aTest_case_ID=new ArrayList<Integer>();
    	oExcel=new Excel();
    	String[] stemp_Test_cases;
    	
    	GUI GUI_object=new GUI();
    	GUI_object.setModal(true);
		GUI_object.setVisible(true);
		
		if(bGUI_checkbox==true){
			aTest_case_ID.addAll(oExcel.get_testcases(".\\src\\test\\java\\com\\Test_cases\\Test_sheet.xls", "Index"));
			iTest_cases= new int[aTest_case_ID.size()];
			iTest_cases=Ints.toArray(aTest_case_ID);//Guava api
			//iTest_cases=aTest_case_ID.toArray();
		}
		else
		{
			stemp_Test_cases=(sGUI_testcases.split(","));
			iTest_cases=new int[stemp_Test_cases.length];
			int i=0;
			for(String s:stemp_Test_cases){
				iTest_cases[i]=Integer.parseInt(s.trim());
				i=i+1;
			}
		}
			//aTest_case_ID.add(1);
		
		for (int i:iTest_cases){
			System.out.println(i);
		}
		//GUI_object.dispose();
	   // System.out.println("bGUI_checkbox="+bGUI_checkbox+" " +"sGUI_Browser="+sGUI_Browser+" "+"sGUI_testcases="+sGUI_testcases);
	    		
    	}


    @Test
    public void test1(){
        System.out.println("test1");
    }

    
    @AfterMethod
    public void teardown(){
    	
    }
    
    @AfterSuite
    public void cleanup(){
    	
    }
    
    
}
