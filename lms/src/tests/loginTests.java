package tests;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;

public class loginTests extends BaseTest {
	
	@Test (priority = 1)
	
	public void LoginToHomePage () throws Exception {
		
		HomePage homePage = new HomePage (driver,wait);
		LoginPage loginPage = new LoginPage (driver,wait);
		homePage.goHomePage();
		loginPage.LoginToLMS("admina", "Compedia123!");
		Thread.sleep(500);
		loginPage.wrongMessage();
		loginPage.LoginToLMS("admin", "compedia123!");
		Thread.sleep(500);
		loginPage.wrongMessage();
		homePage.doLogin();
		
	}

}
