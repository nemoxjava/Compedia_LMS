package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage extends BasePage{
	
	public LoginPage (WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}
	
	
	
	public void LoginToLMS (String username, String password) throws Exception {
		
		writeText(By.id("username"), username);
		writeText(By.id("password"), password);
		driver.findElement(By.id("loginbtn")).click();
	}

	// Verify wrong credentials
	public void wrongMessage () throws Exception {
		
		Assert.assertEquals(readText(By.xpath("//*[@id=\"region-main\"]/div/div[2]/div/div/div/div[2]/div")), expectedMessage);
	}
	
}
