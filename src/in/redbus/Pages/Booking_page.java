package in.redbus.Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ssf.TestSuiteBase.BaseClass;
import com.ssf.property.Selenium_TestData_Files;

import in.redbus.Locators.BookingPage_Locators;

public class Booking_page extends BaseClass{

	WebDriverWait wait;
	WebDriver driver;	
	BookingPage_Locators bpl = new BookingPage_Locators();
	Selenium_TestData_Files testdata = new Selenium_TestData_Files();
	
	public Booking_page(WebDriver driver){
		this.driver = driver;
		bpl = PageFactory.initElements(this.driver, BookingPage_Locators.class);
	}
	
	
	public void setdata_from_textbox(){
		
		wait = new WebDriverWait(this.driver, 500);
		bpl.from_searchbox.sendKeys("a");
		try{
		wait.until(ExpectedConditions.visibilityOfAllElements(bpl.From_list_Box));
		}catch(Exception e){
			System.out.println("Try more time");
		}
		
		List<WebElement> list = bpl.From_list_Box;
		String from_location = testdata.from_text;
		WebElement Departure = null;
		for (WebElement str : list) {
			 if (((str.getText()).toLowerCase()).equals(from_location.toLowerCase())){
				 Departure = str;
				 
			 }
		}
		Departure.click();
		
	}
	
	public void setdata_to_textbox(){
		
		wait = new WebDriverWait(this.driver, 500);
		bpl.to_searchbox.sendKeys("b");
		try{
		wait.until(ExpectedConditions.visibilityOfAllElements(bpl.To_list_Box));
		}catch(Exception e){
			System.out.println("Try more time");
		}
		
		List<WebElement> list = bpl.To_list_Box;
		String from_location = testdata.to_text;
		WebElement Destination = null;
		for (WebElement str : list) {
			 if (((str.getText()).toLowerCase()).equals(from_location.toLowerCase())){
				 Destination = str;
				 
			 }
		}
		Destination.click();
		
	}
	
	public enum Months{JAN(1),FEB(2),MAR(3),APR(4),MAY(5),JUN(6),JUL(7),AUG(8),SEP(9),OCT(10),NOV(11),DEC(12);
		
		private int value;
		private Months(int value){
			this.value = value;
		}
		
	}
	
	public int get_month_value(int Curr_Month,int Input_Month){
		int month_total = 12;
		int move_value = 0;
//		System.out.println("reached---------get_month_value");
		if (Input_Month == Curr_Month){
			
		}
		else if (Input_Month > Curr_Month){
			move_value = Input_Month - Curr_Month;
//			System.out.println("1----Move Value = " + move_value);
			return move_value;
		}
		else if (Curr_Month > Input_Month) {
			move_value = (month_total + Input_Month) - Curr_Month;
//			System.out.println("2----Move Value = " + move_value);
			return move_value;
		}
//		System.out.println("ended-----------get_month_value");
		return move_value;
		
	}
	
	private int get_month(String Curr_Month, String Inp_Month){
		int Current_Month_value = 0;
		int Input_Month_value = 0;
		int move_value = 0;
		for (Months month : Months.values()){
//			System.out.println("Month 1 in the list: " + month);
//			System.out.println("Curr_Month: " + Curr_Month );
			if ( ((Curr_Month).toLowerCase()).equals(month.toString().toLowerCase())){
//				System.out.println("Month and Month value: " + month +month.value );
				Current_Month_value = month.value; 
			}
		}
		for (Months month : Months.values()){
//			System.out.println("Month 2 in the list: " + month);
//			System.out.println("Input_Month: " + Inp_Month );
			if ( ((Inp_Month).toLowerCase()).equals(month.toString().toLowerCase())){
//				System.out.println("Month and Month value: " + month +month.value );
				Input_Month_value = month.value; 
			}
		}
//		System.out.println("Input_Month_Value: " + Input_Month_value);
//		System.out.println("Current_Month_Value: " + Current_Month_value);
		move_value = get_month_value(Current_Month_value,Input_Month_value);
		return move_value;
		
	}
	
	/*
	 * This function gives the number of clicks to be performed to be clicked 
	 * for navigating to the required year based on the Input provided
	 */
	
	private int get_year(String Curr_year, String Inp_year){
		int Current_Month_value = 0;
		int Input_Month_value = 0;
		int move_value = 0;
		
		move_value = get_month_value(Current_Month_value,Input_Month_value);
		return 0;
		
	}
	
	/*
	 * This function moves the Calender to the respective 
	 * Month and year based on the Input provided.
	 * 
	 */
	
	
	public void setdata_from_date(){
		
		
		String[] date_month_year = testdata.from_date.split("-"); // Input data from Testdata file
		String Inp_date = date_month_year[0];
		String Inp_month = date_month_year[1];
		String Inp_year = date_month_year[2];
		wait = new WebDriverWait(driver, 50);
		String Browser = (testdata.getdata_redbus())[1];
		WebElement Datetoolbar = bpl.from_setmonth;
		WebElement Datebar_nxtbtn = bpl.from_datenext_btn;
		WebElement from_setdatebox = bpl.from_setdate_box;
		Actions act_chrome = new Actions(this.driver);
		String[] get_month_year; // Data from UI
		String Curr_month = null;
		String Curr_year = null;
		
		int move_value_month = 0;
		int move_value_year = 0;
		
		if (Browser.equals("chrome")){
			
			act_chrome.moveToElement(from_setdatebox).click().perform();
			
		}
		if (Browser.equals("firefox")){
			from_setdatebox.click();
		}
		
		try{
		
			wait.until(ExpectedConditions.visibilityOf(Datetoolbar));
			get_month_year = (Datetoolbar.getText()).split(" ");
			Curr_month = get_month_year[0];
//			System.out.println("reached.........This year");
//			Call get_year function for moving the years using the next button from GUI
			move_value_year = this.get_year(Curr_year,Inp_year);
			
//			Call get_month function for moving the Months using the next button from GUI
			move_value_month = this.get_month(Curr_month,Inp_month);
			System.out.println("more value month: " + move_value_month);

		}catch(Exception e){
			System.out.println("Datetool bar not found. Try to increase the time");
		}
		
		for (int i = 1; i <= move_value_month; i++){
			wait.until(ExpectedConditions.visibilityOf(bpl.from_datenext_btn));

			Datebar_nxtbtn.click();
//			String jun2 = bpl.from_Jun2.getText();
//			System.out.println("jun2: "+ jun2);
		}		
		
	}
	
	public void setdata_to_date(){
		
		
	}
	
	

}
