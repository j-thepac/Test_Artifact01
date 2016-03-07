package com.library;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Driver_class {
	

	private WebDriver driver;
	Driver_class driver_class;
	private int iPage_loadtimeout;
	private int implicitlyWait;
	
	public void Driver_class(String sBrowser,int iPage_loadtimeout,int implicitlyWait)
	{
		if (sBrowser.toLowerCase()=="ie")
			this.driver=new InternetExplorerDriver();
		else if (sBrowser.toLowerCase()=="chromedriver")
			this.driver=new ChromeDriver();
		else
			this.driver=new FirefoxDriver();
		
		
		//System.setProperty("webdriver.ie.driver", +"\\IEDriverServer.exe");
		//System.setProperty("webdriver.ie.logfile", "F:\\Study\\IEDriverServer.log");
		
		this.driver.manage().timeouts().pageLoadTimeout(iPage_loadtimeout, TimeUnit.SECONDS); 
		this.driver.manage().timeouts().implicitlyWait(implicitlyWait,TimeUnit.SECONDS);
		
		
	}
	


}
