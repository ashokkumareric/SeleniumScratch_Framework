//package com.ssf.SuiteOne;
//
//import java.util.List;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.annotations.Parameters;
//import org.testng.annotations.Test;
//
//import com.ssf.TestSuiteBase.BaseClass;
//
//import in.redbus.Locators.BookingPage_Locators;
//import in.redbus.Pages.Booking_page;
//
//public class SuitBaseClass {
//
//	BaseClass bc = new BaseClass();
//	bpl = PageFactory.initElements(this.driver, BookingPage_Locators.class);
//	
//	BookingPage_Locators bpl;
//	WebDriver driver;
//	Booking_page bp = new Booking_page(driver);
//	
//	
//	@Test
//	public void TestLaunchBrowser(){
//		this.driver = bc.Testdriver(this.driver);
//		bpl = PageFactory.initElements(this.driver, BookingPage_Locators.class);
//	}
//	
//
//	@Test
//	@Parameters("character")
//	public void set_Values(String character){
//		WebDriverWait  wait = new WebDriverWait(driver, 50);
//		bpl.from_searchbox.sendKeys(character);
//		wait.until(ExpectedConditions.visibilityOfAllElements(bpl.From_list_Box));
//		this.print_webelements();
//	}
//	
//	public void print_webelements(){
//		List<WebElement> ll = bpl.From_list_Box;
//		
//		System.out.println("Size of Webelements: "+ ll.size());
//		
//		for (WebElement l:  ll)
//		{
//			
//			if ("Bijapur".equals(l.getText()))
//			{
//				System.out.println("True");
//				
//			}
//			else
//			{
//				System.out.println("False");
//			}
//				
//		}
//	}
//			
//		
//	
//
//}
