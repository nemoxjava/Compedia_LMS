package pages;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	private static final Select select = null;
	public WebDriver driver;
	public WebDriverWait wait;
	
	//Constructor
	public BasePage (WebDriver driver, WebDriverWait wait) {
		//super(driver,wait);
		this.driver = driver;
		this.wait = wait;
	}
	
	//Click Method
	public void click (By elementLocation) throws Exception {
		driver.findElement(elementLocation).click();
	}
	
	//Write Text
	public void writeText (By elementLocation, String text) throws Exception {
		driver.findElement(elementLocation).sendKeys(text);
	}
	
	//Read Text
	public String readText (By elementLocation) throws Exception {
		return driver.findElement(elementLocation).getText();
	}
	
	//Select multi-choice from drop-box
	public void  selectMulti (By by, int i) throws Exception {	
		
		 Select selectIndex = new Select(driver.findElement(by));
		 
		 selectIndex.selectByIndex(i);
		 
		 System.out.println(i);
	
	}
	
	//select from list
	public  void selectByText (By elementLocation, String text) throws Exception {
		
		Select selectIndex = new Select(driver.findElement(elementLocation));
		selectIndex.selectByVisibleText(text);
				
	}
	
	//Select check-box
	public void checkBox (By elementLocation) throws Exception {
		driver.findElement(elementLocation).click();
	}
	
	// Expected message for wrong credentials
	String expectedMessage = "Invalid login, please try again";
	
	//wait function for upload element
	public void waitElement(WebDriver driver) {
		try {
			  Thread.sleep(3000);
			} catch(InterruptedException ex) {
			  Thread.currentThread().interrupt();
			}
		
	}
}
