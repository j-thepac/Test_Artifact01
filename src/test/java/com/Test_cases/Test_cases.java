package com.Test_cases;

//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;




import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.google.common.base.Splitter;
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
    	
    	ArrayList<Integer> ilTest_case_ID = null;
    	List<String> slTest_case_ID = null;
    	
    	oExcel=new Excel();
    	int size,i=0;
    	
    	GUI GUI_object=new GUI();
    	GUI_object.setModal(true);
		GUI_object.setVisible(true);
		
		/*If Check box is set retrieve the test case id from the Excel Index sheet
		Check box is not set , retrieve data from edit field and split it
		Uses Guava API */
		
		if(bGUI_checkbox==true){
			ilTest_case_ID=oExcel.get_testcases(".\\src\\test\\java\\com\\Test_cases\\Test_sheet.xls", "Index");
			iTest_cases=new int[ilTest_case_ID.size()];
			iTest_cases=Ints.toArray(ilTest_case_ID);
		}
		else{		
				/*To grab data from edit field  - convert to list (remove blanks)- validate each element is integer
				 Add it to Integer array*/
				
				slTest_case_ID=Splitter.on(",").omitEmptyStrings().trimResults().splitToList(sGUI_testcases);
				iTest_cases=new int[slTest_case_ID.size()];
				for (String s:slTest_case_ID){			
					try{
						if(Integer.parseInt(s.toString())>0)
								iTest_cases[i]=Integer.parseInt(s.toString());
					}catch(NumberFormatException er){
						System.out.println("---------Class:Test_cases method:before_suite()"+er.getMessage());
					}
					i=i+1;
			}
			
		for(int j=0;j<=iTest_cases.length-1;j++)
			System.out.println(iTest_cases[j]);
		}
		
		
			
//		{
//			ArrayList<Integer> oTest_case_ID=new ArrayList<Integer>();
//			oTest_case_ID.addAll(oExcel.get_testcases(".\\src\\test\\java\\com\\Test_cases\\Test_sheet.xls", "Index"));		
//		}
//		else	
//
//			ArrayList<Object> oTest_case_ID=new ArrayList(Splitter.on(",").omitEmptyStrings().trimResults().splitToList(sGUI_testcases));	//Guava API
//		
//	    iTest_cases= new int[oTest_case_ID.size()];
//	    
//	    //Validating and accepting only Test Case ID of type Integer and dumping it into an array
//		for (Object o:oTest_case_ID){			
//			try{
//				if(Integer.parseInt(o.toString())>0)
//						iTest_cases[i]=Integer.parseInt(o.toString());
//			}catch(NumberFormatException er){
//				System.out.println("---------Class:Test_cases , Line 69 = "+er.getMessage());
//			}
//			i=i+1;
//		}

	    
		
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
