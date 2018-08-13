package tests;

import org.testng.annotations.Test;

import pages.UMSPage;

public class UMSTests extends BaseTest{
	
	@Test (priority = 0)
	
	public void createOrganization() throws Exception {
		UMSPage umsPage = new UMSPage(driver, wait);
		umsPage.openUMS();
		umsPage.waitElement(driver);
		umsPage.openCreateSchool();
		umsPage.waitElement(driver);
		umsPage.fiilCreateSchool("testPavel", 1, "Israel", "Holon", "Salame", "1515", 0, "0524209775", "test@test.me", 0, 0);
		umsPage.findCheckbox("testPavel");
		umsPage.timeLimitation();
		
	}

}
