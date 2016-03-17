package com.Test_cases;

//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;




import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

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
	HashMap<String, String> hTest_data;
    
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
			
//		for(int j=0;j<=iTest_cases.length-1;j++)
//			System.out.println(iTest_cases[j]);
		}

		
    }


    @DataProvider
    public Object[][] TestCase_loop() {

    	Object[][] oaTestcase_ID = new Object[iTest_cases.length][2];
    	for(int i=0;i<=iTest_cases.length-1;i++){
    		oaTestcase_ID[i][0]=iTest_cases[i];
    		oaTestcase_ID[i][1]=i+1;
    	}
    	return oaTestcase_ID;
    }    
    
    
    @BeforeMethod
    public void init(){

    	//System.out.print("Preparing to Execute : ");
    }
    
    
    @Test(dataProvider="TestCase_loop")  //4th
    public void someTest(int iTestCase_ID,int iSlno) {
    	SoftAssert soft_assert=new SoftAssert();
    	hTest_data=new HashMap<String,String>();
    	hTest_data.put("abc", "xyz");
    	TestCase1_100 oTestcase=new TestCase1_100();
    //	System.out.println(oTestcase.getClass().getMethods().toString());
    	try {
    		//String sTestCase_ID="TestCase"+iTestCase_ID;
			Method m=oTestcase.getClass().getMethod("TestCase"+iTestCase_ID,java.util.HashMap.class,org.testng.asserts.SoftAssert.class);		
				try {
					m.invoke(new TestCase1_100(),hTest_data,soft_assert);					
					soft_assert.assertAll();        
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		} catch (NoSuchMethodException |SecurityException e) {
			//System.out.print(e.getMessage());
			e.printStackTrace();
		}
 //   	System.out.print(iSlno+") Starting execution of Test Case bearing TestID- "+iTestCase_ID);
//        i=i+1;
//        System.out.println("Name of test is " + method.getName()+" "+i);
//        System.out.println("Suite name is " + context.getSuite().getName()+" "+i);
    }
   



    
    @AfterMethod
    public void teardown(){
    	System.out.print("----------------Performing teardown ----------------\n");
    }
    
    @AfterSuite
    public void cleanup(){
    	System.out.print("----------------Performing clean up of Suite----------------\n");
    }
    
    
}
