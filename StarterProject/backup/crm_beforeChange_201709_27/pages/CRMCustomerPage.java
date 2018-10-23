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

public class CRMCustomerPage extends BasePage {

	static final Logger log = LogManager.getLogger(CRMCustomerPage.class.getName());
	WebElement lSite;

	public CRMCustomerPage(WebDriver driver) throws IOException {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "HT_PRTLCASE_DRV_HT_CR_TECHCASE_PB")
	WebElement TSR_MASTER;

	public boolean goToSite(String SiteNumber) throws InterruptedException, IOException {
		boolean goToSite = false;

		// Begin flow of the login
		log.info("Begin the flow of the go to site");
		try {
			Thread.sleep(2000);
		
			lSite = returnSlowElement(By.xpath(".//*[@id='HT_PTL_SITEI_DR_URL']"));
			click(lSite);
			goToSite = true;
		} catch (TimeoutException te) {
			log.fatal("Exception received: ");
			te.printStackTrace();
			return false;
		} catch (Exception e) {
			log.fatal("Exception received: ");
			e.printStackTrace();
			return false;
		}

		Thread.sleep(2000);

		if (goToSite) {
			driver.switchTo().frame("ptifrmtgtframe");
			WebElement tSite = driver.findElement(By.xpath(".//*[contains(@id,'_PAGETITLE')]"));
			goToSite = isTextAppearInWL(tSite, SiteNumber);
			driver.switchTo().defaultContent();
		} else
			return false;

		return goToSite;
	}

	public boolean goToTSRMASTER() throws InterruptedException, IOException {
		boolean goToTSRMASTER = false;

		// Begin flow of the login
		log.info("Begin the flow of the go to site");
		try {
			Thread.sleep(2000);
			clickJS(TSR_MASTER);
			goToTSRMASTER = true;
		} catch (TimeoutException te) {
			log.fatal("Exception received: ");
			te.printStackTrace();
			return false;
		} catch (Exception e) {
			log.fatal("Exception received: ");
			e.printStackTrace();
			return false;
		}

		Thread.sleep(2000);

		if (goToTSRMASTER) {
			
		} else
			return false;

		return goToTSRMASTER;
	}

}
