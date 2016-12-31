/**
 * 
 */
package in.redbus.Locators;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * @author wipro
 *
 * 
 * 
 */
public class BookingPage_Locators {

	@FindBy(how = How.XPATH, using = ".//*[@id='page_main_header']/nav/ul/li[1]/a")
	public WebElement abc;

	@FindBy(how = How.CSS,using = "div > input[id='src'][class='db']")
	public WebElement from_searchbox ; 
	
	@FindBy(how = How.CSS,using = ".autoFill>li")
	public List<WebElement> From_list_Box;
	
	@FindBy(how=How.XPATH,using = "//div/input[@id='dest']")
	public WebElement to_searchbox ;
	
	@FindBy(how = How.CSS,using = ".autoFill>li")
	public List<WebElement> To_list_Box;
	
	
	@FindBy(how = How.XPATH,using = ".//div/input[@id='onward_cal']")
	public WebElement from_setdate_box;

	@FindBy(how = How.XPATH, using = ".//*[@id='rb-calendar_onward_cal']/table/tbody/tr[1]/td[2]")
	public WebElement from_setmonth;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='rb-calendar_onward_cal']/table/tbody/tr[1]/td[3]/button")
	public WebElement from_datenext_btn;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='rb-calendar_onward_cal']/table/tbody/tr[3]/td[5]")
	public WebElement from_Jun2;
	
	@FindBy(how = How.XPATH, using = ".//input[@id='return_cal']")
	public WebElement return_setdata_box;
		
	@FindBy(how = How.XPATH, using = ".//*[@id='rb-calendar_return_cal']/table/tbody/tr[1]/td[2]")
	public WebElement return_setmonth;
	
	@FindBy(how = How.CSS, using = "div > button[id='search_btn']")
	public WebElement search_btn;
	
	
	
	
	
	
}
