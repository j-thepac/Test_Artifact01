package com.Test_cases;


import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;


public class TestCase1_100 implements  Page_Object_Model {
	  //SoftAssert soft_assert1=new SoftAssert();
	
	
	public  SoftAssert TestCase44(WebDriver driver,HashMap<String, String> hTest_data,SoftAssert soft_assert){	
		//driver.get("http://catchbug.blogspot.in/2014/08/basic-html.html");
		//driver.findElement(this..)
		//soft_assert.assertTrue(driver.findElement(this.page1_button1).isDisplayed());

//		System.out.println("TestCase44");
	soft_assert.assertEquals("abc", "ABC");
	//soft_assert.assertAll();
		return soft_assert;
	}

	public  SoftAssert TestCase48(WebDriver driver,HashMap<String, String> hTest_data,SoftAssert soft_assert){			
			System.out.println("TestCase48");
			Assert.assertEquals("abc", "ABC");  
			return soft_assert;
		}
	
	public SoftAssert TestCase52(WebDriver driver,HashMap<String, String> hTest_data,SoftAssert soft_assert){		
		System.out.println("TestCase52");
		soft_assert.assertEquals("ABC", "ABC");
		//soft_assert.assertAll();
		return soft_assert;
	}
	
	public SoftAssert TestCase56(WebDriver driver,HashMap<String, String> hTest_data,SoftAssert soft_assert){		
		System.out.println("TestCase4");
		soft_assert.assertEquals("abc", "ABC");
		return soft_assert;
	}
	
	
}
