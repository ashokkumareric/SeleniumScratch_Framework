/**
 * 
 */
package com.hp.bladeserver.Pages;

import com.hp.bladeserver.Locators.LoginPage_Locators;
import com.ssf.TestSuiteBase.BaseClass;
import com.ssf.property.Selenium_TestData_Files;

/**
 * @author muthupan
 *
 */
public class LoginPage extends BaseClass {

	/**
	 * @param args
	 */
	
	
	public void Login(){
		Selenium_TestData_Files Testdata = new Selenium_TestData_Files();
//		try{
//			Helper Helper = new Helper();
//			driver = Helper.Handle_Certificates_ff(driver);
//			
//		}catch(Exception e){
//			
//		}
		String username = Testdata.getdata_redbus()[2];
		String password = Testdata.getdata_redbus()[3];
		LoginPage_Locators.username.clear();
		LoginPage_Locators.username.sendKeys(username);
		LoginPage_Locators.password.clear();
		LoginPage_Locators.password.sendKeys(password);
		LoginPage_Locators.LoginBtn.click();
		
	}
	
	

}
