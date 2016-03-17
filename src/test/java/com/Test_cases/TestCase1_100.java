package com.Test_cases;

import java.util.ArrayList;
import java.util.HashMap;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class TestCase1_100 {
	  //SoftAssert soft_assert=new SoftAssert();
	
	public  boolean TestCase44(HashMap<String, String> hTest_data,SoftAssert soft_assert){		
		System.out.println("TestCase44");
		soft_assert.assertEquals("abc", "ABC");
   
		return true;
	}

	public  boolean TestCase48(HashMap<String, String> hTest_data,SoftAssert soft_assert){			
			System.out.println("TestCase48");
			Assert.assertEquals("abc", "ABC");  
			return true;
		}
	
	public boolean TestCase52(HashMap<String, String> hTest_data,SoftAssert soft_assert){		
		System.out.println("TestCase52");
		soft_assert.assertEquals("ABC", "ABC");
		return true;
	}
	
	public boolean TestCase4(HashMap<String, String> hTest_data,SoftAssert soft_assert){		
		System.out.println("TestCase4");

		return true;
	}
	
	
}
