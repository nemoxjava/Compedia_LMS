package com.crm.pages;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.testng.Assert;

import com.hotportal.pages.BasePage;

public class CRMHomePage extends BasePage {

	static final Logger log = LogManager.getLogger(CRMHomePage.class.getName());

	public CRMHomePage(WebDriver driver) throws IOException {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "HT_PTL_SRCH_WRK_HT_SRCH_TYPE")
	WebElement selectSearchType;
	
	@FindBy(id = "HT_PTL_SRCH_WRK_COMPANYID")
	WebElement iSiteNumber;
	
	@FindBy(id = "HT_PTL_SRCH_WRK_HT_CUST_IDENTITY")
	WebElement iClientNumber;

	@FindBy(id = "HT_PTL_SRCH_WRK_HT_SEARCH_BTN")
	WebElement bSearch;

	@FindBy(id = "ptpgltlbl_HT_PTL_CST_INFO_GBL")
	WebElement tCustomerDetails;

	//

	public boolean searchSite(String SiteNumber) throws InterruptedException, IOException {
		boolean searchSite = false;
		Thread.sleep(1000);
		// Begin flow of the login
		log.info("Begin the flow of the search Site");
		try {
			fillText(iSiteNumber, SiteNumber);
			click(bSearch);
			searchSite = true;
		} catch (TimeoutException te) {
			log.fatal("Exception received: ");
			te.printStackTrace();
			return false;
		} catch (Exception e) {
			log.fatal("Exception received: ");
			e.printStackTrace();
			return false;
		}

		if (searchSite) {
			searchSite = isTextAppearInWL(tCustomerDetails, "נתוני לקוח");
		} else
			return false;
		return searchSite;
	}

	public boolean searchCustomer(String CustomerNumber) throws InterruptedException, IOException {
		boolean searchCustomer = false;
		Thread.sleep(3000);
		// Begin flow of the login
		log.info("Begin the flow of the search Site");
		try {
			selectText(selectSearchType, "לקוח");
			fillText(iSiteNumber, CustomerNumber);
			click(bSearch);
			searchCustomer = true;
		} catch (TimeoutException te) {
			log.fatal("Exception received: ");
			te.printStackTrace();
			return false;
		} catch (Exception e) {
			log.fatal("Exception received: ");
			e.printStackTrace();
			return false;
		}

		if (searchCustomer) {
			searchCustomer = isTextAppearInWL(tCustomerDetails, "נתוני לקוח");
		} else
			return false;
		return searchCustomer;
	}

}
