package com.Test_cases;

//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
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
import com.library.Driver_class;
import com.library.Excel;
import com.library.GUI;

import javax.swing.*;

/**
1. User can change the test cases in excel or entering 44,48 in GUI
2. Currently only 3 test cases are created 44,48,52
3. To run right ck on build.gradle >Run as Gradle  in Eclipse
4. To run in Cmd prompt:  refer "http://catchbug.blogspot.in/2016/03/gradle-how-to-set-gradle.html"

How to Run:
1. right ck on build.gradle >Run as Gradle  in Eclipse
2. Files gets downloded
3. GUI will open
4. You can directly check the checkbox and press start  ( use selection already made in excel )
5. Or manually type testcase ID Eg: 44,48 and Press OK

@dataprovider- Loops (@Before-@Test-@AfterTest) in sequencedepeding on the number of test cases or TestID provided in GUI

@Beforemethod -Configures driver ie., IE ,FF etc., but does not open the browser
@Test - User gets the driver arguement here . User needs to specifically enter link or link is fetched from excel(not implemented yet)
@After - closes the driver 

 */
public class TestNG_Suite {

    public static StringBuffer check_execution =new StringBuffer();
    public static String username;

	public static boolean bGUI_checkbox;
	public static String sGUI_testcases;
	public static String sGUI_Browser;
	
	public Excel oExcel;
	public int[] iTest_cases;
	HashMap<String, String> hTest_data;
	public WebDriver driver;
	
	TestNG_Suite(){
		oExcel=new Excel(".\\src\\test\\java\\com\\Test_cases\\Test_sheet.xls");
	}
    
    @BeforeSuite
    public void before_suite() throws InterruptedException{

    	ArrayList<Integer> ilTest_case_ID = null;
    	List<String> slTest_case_ID = null;
    	
    	//oExcel=new Excel(".\\src\\test\\java\\com\\Test_cases\\Test_sheet.xls");
    	int size,i=0;
    	
    	GUI GUI_object=new GUI();
    	GUI_object.setModal(true);
		GUI_object.setVisible(true);
		
		/*If Check box is set retrieve the test case id from the Excel Index sheet
		Check box is not set , retrieve data from edit field and split it
		Uses Guava API */
		
		if(bGUI_checkbox==true){
			ilTest_case_ID=oExcel.get_testcases("Index");
			iTest_cases=new int[ilTest_case_ID.size()];
			iTest_cases=Ints.toArray(ilTest_case_ID); //Convert to Array for DataProvider(Ints is Guava API)
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
    	Driver_class dc=new Driver_class();
    	this.driver=dc.create_driver(this.sGUI_Browser, 40, 40);
    	//System.out.print("Preparing to Execute : ");
    }
    
    
    @Test(dataProvider="TestCase_loop")  //4th
    public void someTest(int iTestCase_ID,int iSlno) {
    	Page_Object_Model oTestcase=null;			//Polymorhism ie., Page_Object_Model is an interface 
    	SoftAssert soft_assert=new SoftAssert();
    	hTest_data=oExcel.get_TestData(Integer.toString(iTestCase_ID));//new HashMap<String,String>();
    	//hTest_data.put("abc", "xyz"); 				//some junk data to avoid nullpointerexception

    	try{
	    	if(iTestCase_ID<=100)	
	    		oTestcase=new TestCase1_100();	    //Polymorhism ie., TestCase1_100 implements Page_Object_Model 	
	    	else if(iTestCase_ID>100 && iTestCase_ID<=200)
	    		oTestcase=new TestCase101_200();	//Polymorhism ie., TestCase101_200 implements Page_Object_Model 	
	    	}catch(Exception e){
	    		System.out.println("----------Err: Test_cases.java , someTest !! ----------");
	    		Assert.assertTrue(false);
	    		e.printStackTrace();
    	}

    	try {//reflections getMethod(methodname,driverclass,excelDataclass,assertclass)
			Method m=oTestcase.getClass().getMethod("TestCase"+iTestCase_ID,WebDriver.class,java.util.HashMap.class,org.testng.asserts.SoftAssert.class);		
				try {
					soft_assert=(SoftAssert) m.invoke(oTestcase,driver,hTest_data,soft_assert);					
					soft_assert.assertAll();        
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
		} catch (NoSuchMethodException |SecurityException e) {

			e.printStackTrace();
		}

    }
   



    
    @AfterMethod
    public void teardown(){
    	driver.close();
    	//driver.quit();
    	System.out.print("----------------Performing teardown ----------------\n");
    }
    
    @AfterSuite
    public void cleanup(){
    	System.out.print("----------------Performing clean up of Suite----------------\n");
    }
    
    
}
