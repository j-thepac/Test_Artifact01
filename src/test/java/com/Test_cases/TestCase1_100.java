package com.Test_cases;

import java.util.ArrayList;
import java.util.HashMap;

import org.testng.asserts.SoftAssert;

public class TestCase1_100 {
	  //SoftAssert soft_assert=new SoftAssert();
	
	public  boolean TestCase44(HashMap<String, String> hTest_data,SoftAssert soft_assert){		
		System.out.println("TestCase1");
		soft_assert.assertEquals("abc", "ABC");
   
		return true;
	}

	public  boolean TestCase48(HashMap<String, String> hTest_data,SoftAssert soft_assert){			
			System.out.println("TestCase2");
			soft_assert.assertEquals("ABC", "ABC");
    
			return true;
		}
	
	public boolean TestCase3(HashMap<String, String> hTest_data,SoftAssert soft_assert){		
		System.out.println("TestCase3");
		soft_assert.assertTrue(false);
		return true;
	}
	
	public boolean TestCase4(HashMap<String, String> hTest_data,SoftAssert soft_assert){		
		System.out.println("TestCase4");

		return true;
	}
	
	
}
