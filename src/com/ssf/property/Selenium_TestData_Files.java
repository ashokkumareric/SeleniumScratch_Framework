package com.ssf.property;


/*
 * This class gets the required details like URL, Browser name, Credentials for part
 * particular URL, etc., from the XML file.
 */
public class Selenium_TestData_Files {

	public String[] getdata_redbus(){
		
		String[] Credentials = {"Administrator", "12iso*help"};
		//String URL = "https://15.213.117.249/";
		String URL = "https://www.redbus.in/";
		String Browser = "firefox";
		String[] testdata = new String[4];
		
		testdata[0] = URL;
		testdata[1] = Browser;
		testdata[2] = Credentials[0];
		testdata[3] = Credentials[1];
		
		return testdata;
		
	}
	
}
