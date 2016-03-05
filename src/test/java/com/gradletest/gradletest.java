package com.gradletest;

//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;




import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.library.GUI;

import javax.swing.*;

/**
 * Created by Guest on 2/21/2016.
 */
public class gradletest {

    public   static StringBuffer check_execution =new StringBuffer();
    public static String username;

	public static boolean bGUI_checkbox;
	public static String sGUI_testcases;
	public static String sGUI_Browser;

    
    @BeforeSuite
    public void before_suite() throws InterruptedException{

    	GUI GUI_object=new GUI();
    	GUI_object.setModal(true);
		GUI_object.setVisible(true);
		//GUI_object.dispose();
	    System.out.println("bGUI_checkbox="+bGUI_checkbox+" " +"sGUI_Browser="+sGUI_Browser+" "+"sGUI_testcases="+sGUI_testcases);
	    		
    	}


    @Test
    public void test1(){
        System.out.println("test1");
    }

    @Test
    public void test2(){
        System.out.println("test2");
    }
}
