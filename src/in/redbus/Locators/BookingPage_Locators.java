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

	

	@FindBy(how = How.CSS,using = "div > input[id='src'][class='db']")
	public WebElement from_searchbox ; 
	@FindBy(how = How.CSS,using = ".autoFill>li")
	public List<WebElement> From_list_Box;
	
	
	
	
	
	
	
}
