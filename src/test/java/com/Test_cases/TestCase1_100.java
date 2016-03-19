package com.Test_cases;


import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;


public class TestCase1_100 implements  Page_Object_Model {
	  SoftAssert soft_assert=new SoftAssert();
	
	
	public  boolean TestCase44(WebDriver driver,HashMap<String, String> hTest_data,SoftAssert soft_assert){	
		driver.get("http://catchbug.blogspot.in/2014/08/basic-html.html");
		soft_assert.assertTrue(driver.findElement(this.page1_button1).isDisplayed());

//		System.out.println("TestCase44");
//		soft_assert.assertEquals("abc", "ABC");
   
		return true;
	}

	public  boolean TestCase48(WebDriver driver,HashMap<String, String> hTest_data,SoftAssert soft_assert){			
			System.out.println("TestCase48");
			Assert.assertEquals("abc", "ABC");  
			return true;
		}
	
	public boolean TestCase52(WebDriver driver,HashMap<String, String> hTest_data,SoftAssert soft_assert){		
		System.out.println("TestCase52");
		soft_assert.assertEquals("ABC", "ABC");
		return true;
	}
	
	public boolean TestCase56(WebDriver driver,HashMap<String, String> hTest_data,SoftAssert soft_assert){		
		System.out.println("TestCase4");

		return true;
	}
	
	
}
