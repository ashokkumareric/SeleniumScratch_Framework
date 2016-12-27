package com.ssf.Helperutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.ssf.property.Selenium_TestData_Files;

public class Helper {

	Selenium_TestData_Files Testdata = new Selenium_TestData_Files();
	
	
	
	public WebDriver Testdriver(WebDriver driver){
		
		String[] Inputs = this.Testdata.getdata_redbus();
		
		try {
			if (Inputs[1] == "firefox"){
				System.setProperty("webdriver.gecko.driver","E:\\Workspace\\SeleniumScratch_Framework\\Drivers\\geckodriver.exe" );
				driver = new FirefoxDriver();
			}
			else if (Inputs[1] == "chrome"){
				System.setProperty("webdriver.chrome.driver","E:\\Workspace\\SeleniumScratch_Framework\\Drivers\\chromedriver.exe" );
				driver = new ChromeDriver();
			}
			else if(Inputs[1] == "IE"){
				System.setProperty("webdriver.IE.driver","E:\\Workspace\\SeleniumScratch_Framework\\Drivers\\IEDriverServer.exe" );
				driver = new InternetExplorerDriver();
			}			
			else{
				System.out.println("Provided driver is not a valid Browser. Please provide a valid Browser");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Driver location is not correct");
		}
		
		try {
			driver.get(Inputs[0]);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("SSL Certificate is enabled for this website");
			driver.quit();
			System.out.println("Closing the driver");
			
		}

/***		
		try {
			if (Inputs[1] == "firefox"){
				ProfilesIni profile = new ProfilesIni();
				FirefoxProfile myprofile = new FirefoxProfile(new File("C:\\Users\\muthupan\\AppData\\Local\\Mozilla\\Firefox\\Profiles\\8mp6tjj7.CustomUserProfile"));
				//profile.getProfile("CustomUserProfile");
				myprofile.setAcceptUntrustedCertificates(true);
				myprofile.setAssumeUntrustedCertificateIssuer(true);
				System.setProperty("webdriver.gecko.driver","C:\\Workspace\\SeleniumScratch_Framework\\Drivers\\geckodriver.exe" );
				driver = new FirefoxDriver(myprofile);
			}
			else if (Inputs[1] == "chrome"){
				System.setProperty("webdriver.chrome.driver","C:\\Workspace\\SeleniumScratch_Framework\\Drivers\\chromedriver.exe" );
				driver = new ChromeDriver();
			}
			else{
				System.out.println("Provided driver is not a valid Browser. Please provide a valid Browser");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Some issue after opening the ");
		}
		driver.get(Inputs[0]);
***/
		driver.manage().window().maximize();
		return driver;
	}
	
	
	
	
		
		

	
}
