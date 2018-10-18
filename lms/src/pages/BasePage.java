package pages;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
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
		PageFactory.initElements(driver, this);
	}
	

	//Click Method
	public void click(WebElement el)  {
		//hilehlight
		 el.click();
	}
	
	public void fillText(WebElement el,String text) {
		el.sendKeys(text);
	}
	
	
	
	//Write Text
	public void writeText (WebElement el, String text) {
		el.sendKeys(text);
	}
	
	//Read Text
	public String readText (WebElement el) {
		return el.getText();
	}
	
	//Select multi-choice from drop-box
	public void  selectMulti (WebElement el, int i) throws Exception {	
		
		 Select selectIndex = new Select((el));
		 
		 selectIndex.selectByIndex(i);
		 
		 System.out.println(i);
	
	}
	
	//select from list
	public  void selectByText (WebElement el, String text) {
		
		Select selectIndex = new Select((el));
		selectIndex.selectByVisibleText(text);
				
	}
	
	//Select check-box
	public void checkBox (By elementLocation) throws Exception {
		driver.findElement(elementLocation).click();
	}
	
	// Expected message for wrong credentials
	String expectedMessage = "Invalid login, please try again";
	
	//explicit wait
	public void explWait(WebDriver driver) {
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	}
	
	public void sleep(long mill) {
		try {
			Thread.sleep(mill);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
}
