package com.hp.bladeserver.Locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage_Locators {

	@FindBy(how=How.CSS,using="td[class='signInInput'] > input[id='usernameInput']")
	public static WebElement username;
	
	@FindBy(how=How.CSS,using="td[class='signInInput']>input[id='passwordInput']")
	public static WebElement password;
	
	@FindBy(how=How.CSS,using="button[id='ID_LOGON']")
	public static WebElement LoginBtn;
}
