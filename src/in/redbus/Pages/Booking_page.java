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

	
/*
 * This constructor initializes this class with the Driver that is being sent from the test case.
 */
	public Booking_page(WebDriver driver){
		this.driver = driver;
		bpl = PageFactory.initElements(this.driver, BookingPage_Locators.class);
	}

/*
 * This function sets the "Starting" location in the Redbus website 	
 */
	
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

/*
 * This function sets the "Destination" location in the Redbus website 	
 */

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
	
/*
 * This is enum function which is used for calculating the months to be moved in the GUI
 * 
 */
	public enum Months{JAN(1),FEB(2),MAR(3),APR(4),MAY(5),JUN(6),JUL(7),AUG(8),SEP(9),OCT(10),NOV(11),DEC(12);
		
		private int value;
		private Months(int value){
			this.value = value;
		}
		
	}

/*
 * This  function is used for calculating the months to be moved in the GUI and returns to the get_month function
 * 
 */
	public int get_month_value(int Curr_Month,int Input_Month, int year_diff){
		
		int month_total = 12;
		int move_value = 0;
		int year_diff_n1 = 0;
//		System.out.println("reached---------get_month_value");
		System.out.println("diff_year value: " + year_diff);
		if (year_diff == 0){
			if (Input_Month == Curr_Month){
				move_value = 0;
			}
			else if (Input_Month > Curr_Month){
				move_value = Input_Month - Curr_Month;
//				System.out.println("1----Move Value = " + move_value);
				
			}
			else if (Curr_Month > Input_Month) {
				System.out.println("The selected date is less than Current date.Please select a latter date");
//				System.out.println("2----Move Value = " + move_value);
				
			}
			
		}
		if (year_diff > 0){
			year_diff_n1 = year_diff - 1;
			System.out.println("diff_year value_ 1: " + year_diff_n1);

			if (year_diff_n1 > 1 ) {
				year_diff_n1 = year_diff_n1 * 12 ;
				System.out.println("diff_year value_ 2: " + year_diff_n1);
				move_value = year_diff_n1 + (month_total - Curr_Month) + Input_Month;
				System.out.println("The number of clicks to be performed for navigating to the expected month: " + move_value);
			}
			else {
				move_value = (month_total - Curr_Month) + Input_Month;
			}
		}
		
//		System.out.println("ended-----------get_month_value");
		return move_value;
		
	}
	
	private int get_month(String Curr_Month, String Inp_Month, int year_diff){
		
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
		move_value = get_month_value(Current_Month_value, Input_Month_value, year_diff);
		System.out.println("Inside Get_month func_ Move_value : " + move_value);
		return move_value;
		
	}
	
	private int get_year_value(int Curr_year, int Inp_year){
		
		int year_diff = 0;
		
		if (Curr_year == Inp_year){
			System.out.println("Years are same");
		}
		
		else if (Curr_year > Inp_year){
			System.out.println("Please select valid recent year");
			return -1;
		}
		
		else if (Curr_year < Inp_year){
			year_diff = Inp_year - Curr_year;
			System.out.println("Years_diff in get_year_value fun: " + year_diff);
			return year_diff;
		}

		return year_diff;
	}
	
	/*
	 * This function gives the number of clicks to be performed to be clicked 
	 * for navigating to the required year based on the Input provided
	 */
	
	private int get_year(String Curr_year, String Inp_year, String Curr_Month, String Inp_Month){
		int Current_year_value = 0;
		int Input_year_value = 0;
		int year_diff = 0;
		int move_value = 0;
		
		
		Current_year_value = Integer.parseInt(Curr_year);
		Input_year_value = Integer.parseInt(Inp_year);
				
		year_diff = get_year_value(Current_year_value,Input_year_value);
		
		if (year_diff == -1){
			System.out.println("The Selected date is not the latest date. Please provide a date greater than or equal to the current date");
			System.exit(0);
		}
		
//		Call get_month function for moving the Months using the next button from GUI
		move_value = this.get_month(Curr_Month,Inp_Month,year_diff);
		
		return move_value;
		
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
		int move_value = 0;
		
		
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
			Curr_year = get_month_year[1];
//			System.out.println("reached.........This year");
//			Call get_year function for moving the years using the next button from GUI
			move_value = this.get_year(Curr_year, Inp_year, Curr_month, Inp_month);
			System.out.println("more value : " + move_value);

		}catch(Exception e){
			e.printStackTrace();
			System.out.println(Thread.currentThread().getStackTrace()[2].getLineNumber());
		}
		
		for (int i = 1; i <= move_value; i++){
			wait.until(ExpectedConditions.visibilityOf(Datebar_nxtbtn));
			Datebar_nxtbtn.click();
		}		
		
	}
	
	public void setdata_to_date(){
		String[] date_month_year = testdata.to_date.split("-"); // Input data from Testdata file
		String Inp_date = date_month_year[0];
		String Inp_month = date_month_year[1];
		String Inp_year = date_month_year[2];
		wait = new WebDriverWait(driver, 50);
		String Browser = (testdata.getdata_redbus())[1];
		WebElement Datetoolbar = bpl.return_setmonth;
		WebElement Datebar_nxtbtn = bpl.return_datenext_btn;
		WebElement from_setdatebox = bpl.return_setdate_box;
		Actions act_chrome = new Actions(this.driver);
		String[] get_month_year; // Data from UI
		String Curr_month = null;
		String Curr_year = null;
		int move_value = 0;
		
		
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
			Curr_year = get_month_year[1];
//			System.out.println("reached.........This year");
//			Call get_year function for moving the years using the next button from GUI
			move_value = this.get_year(Curr_year, Inp_year, Curr_month, Inp_month);
			System.out.println("more value : " + move_value);

		}catch(Exception e){
			e.printStackTrace();
			System.out.println(Thread.currentThread().getStackTrace()[2].getLineNumber());
		}
		
		for (int i = 1; i <= move_value; i++){
			wait.until(ExpectedConditions.visibilityOf(Datebar_nxtbtn));
			Datebar_nxtbtn.click();
		}		
		
	}
	
	

}
