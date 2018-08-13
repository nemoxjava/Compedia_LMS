package tests;

import org.testng.annotations.Test;

import pages.UMSPage;

public class UMSTests extends BaseTest{
	
	@Test (priority = 0)
	
	public void createOrganization() {
		UMSPage umsPage = new UMSPage(driver, wait);
		umsPage.openUMS();
		umsPage.waitElement(driver);
		umsPage.createSchool();
	}

}
