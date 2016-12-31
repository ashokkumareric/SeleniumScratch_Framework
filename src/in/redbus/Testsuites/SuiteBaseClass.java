/**
 * 
 */
package in.redbus.Testsuites;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.ssf.Helperutility.Helper;
import in.redbus.Pages.Booking_page;

/**
 * @author wipro
 *
 */
public class SuiteBaseClass {

	WebDriver driver;
	Helper helper = new Helper();
	
	Booking_page bp;
	
	@BeforeClass
	public void Test_LauchBrowser(){
		this.driver = helper.Testdriver(this.driver);
		
	}
	
	@Test
	public void Test_SetDates(){
		
		bp = new Booking_page(this.driver);
		
		bp.setdata_from_textbox();
		bp.setdata_to_textbox();
		bp.setdata_from_date();
	}
	
	
	
}
