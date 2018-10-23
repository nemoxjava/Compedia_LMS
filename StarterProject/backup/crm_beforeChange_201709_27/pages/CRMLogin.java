package com.crm.pages;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.hotportal.pages.BasePage;

public class CRMLogin extends BasePage {

	static final Logger log = LogManager.getLogger(CRMLogin.class.getName());

	
	@FindBy(id = "userid")
	WebElement iLogin;

	@FindBy(id = "pwd")
	WebElement iPass;
	
	
	@FindBy(name = "Submit")
	WebElement bSubmit;
	
	
	
	public CRMLogin(WebDriver driver) throws IOException {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public boolean login(String sUserId, String sPassword) throws InterruptedException,
			IOException {
		boolean bLogin = false;

		// Begin flow of the login
		log.info("Begin the flow of the login");
		try {
			fillText(iLogin, sUserId);
			//iLogin.sendKeys("025204116");
			fillText(iPass, sPassword);
			click(bSubmit);
			bLogin = IsObjectExist(By.id("pthdr2logimg"));
		} catch (TimeoutException te) {
			log.fatal("Exception received: ");
			te.printStackTrace();
			return false;
		}
		catch (Exception e) {
			log.fatal("Exception received: ");
			e.printStackTrace();
			return false;
		}

		Thread.sleep(1000);

		if (bLogin) {
			bLogin = driver.getPageSource().contains("חיפוש לקוח");
		}
		else
			return false;
		
		return bLogin;
	}

	

}
