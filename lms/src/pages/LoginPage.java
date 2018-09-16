package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage extends BasePage{
	
	@FindBy(css = "[id = #username]")
	private WebElement userName;
	
	@FindBy(css = "[id = #password]")
	private WebElement passWord;
	
	@FindBy(css = "[id = #loginbtn]")
	private WebElement loginBtn;
	
	@FindBy(css = "[id = #region-main > div > div.row > div > div > div > div.loginerrors.m-t-1 > div]")
	private WebElement errMsg;
	
	public LoginPage (WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}
	
	
	
	public void LoginToLMS (String username, String password) throws Exception {
		writeText(userName, username);
		writeText(passWord, password);
		loginBtn.click();
	}

	// Verify wrong credentials
	public void wrongMessage () throws Exception {
		
		Assert.assertEquals(readText(errMsg), expectedMessage);
	}
	
}
