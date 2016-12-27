package com.ssf.TestSuiteBase;

import org.openqa.selenium.WebDriver;

import com.ssf.Helperutility.Helper;

public class BaseClass {

	public  WebDriver driver;
	Helper Helper = new Helper();


	public WebDriver Testdriver(WebDriver driver){
	
		
		this.driver = Helper.Testdriver(driver);
		
		return this.driver;
	}
	
	
	
	

}
