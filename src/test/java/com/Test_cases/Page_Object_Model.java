package com.Test_cases;

import org.openqa.selenium.By;

/* There is 2 Main uses - Object Repository and for Polymorphism in TestNG_Suite.java
1. Used as Object Repository ie., uses POM keyword "By"
2. All properties should be public static final 
3. Used instead of storing in properties file 
4. User can type "this.ctrl+space" to access the properties below in testcases file
5. All testcases file should implement this interface
6. Since all testcases "implements" rather than "extends" , all testcases still have the option to extend when needed
Note - **It is better to use interface than extend a base class whereever necessary **

 * */


public interface Page_Object_Model {
	
	public static final By page1_button1=By.xpath("//input[@name='firstname']");
	public static final By page1_button2=By.xpath("");
	public static final By page1_button3=By.xpath("");
	public static final By page1_button4=By.xpath("");
	public static final By page1_button5=By.xpath("");
	public static final By page1_button6=By.xpath("");

}
