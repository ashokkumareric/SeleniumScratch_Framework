package in.redbus.Pages;

import com.ssf.TestSuiteBase.BaseClass;

import in.redbus.Locators.BookingPage_Locators;

public class Booking_page extends BaseClass{

	BookingPage_Locators bpl = new BookingPage_Locators();
	
	public void setdata_from_textbox(){
		
		bpl.from_searchbox.sendKeys("a");
		
	}
	
	
	

}
