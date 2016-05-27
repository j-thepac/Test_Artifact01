package com.Test_cases;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class TestCase101_200 implements Page_Object_Model{
	public  SoftAssert TestCase199(WebDriver driver,HashMap<String, String> hTest_data,SoftAssert soft_assert){	
		//driver.get("http://catchbug.blogspot.in/2014/08/basic-html.html");
		//driver.findElement(this..)
		//soft_assert.assertTrue(driver.findElement(this.page1_button1).isDisplayed());

//		System.out.println("TestCase44");
		System.out.println(hTest_data);
		soft_assert.assertEquals("ABC", "ABC");
	//soft_assert.assertAll();
		return soft_assert;
	}
}
