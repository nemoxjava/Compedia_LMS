package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import pages.UMSPage;

public class UMSTests extends BaseTest{
	
	@Test (priority = 4)
	
	public void createOrganization() throws Exception {
		UMSPage umsPage = new UMSPage(driver, wait);
		umsPage.openUMS();
		umsPage.openCreateSchool();
		umsPage.schoolName("testPavel");
		umsPage.curriculumType(1);
		//umsPage.fiilCreateSchool("testPavel", 1, "Israel", "Holon", "Salame", "1515", 0, "0524209775", "test@test.me", 0, 0);
		umsPage.fillCountry("Israel");
		umsPage.explWait(driver);
		umsPage.fillCity("TLV");
		umsPage.fillAddress("address");
		umsPage.fiilZipcode("123123");
		umsPage.fillTimezone(0);
		umsPage.fiilPhone("0524209775");
		umsPage.fillEmail("test@test.me");
		umsPage.fillLicense(0);
		umsPage.fillUsername(0);
		umsPage.findCheckbox("testPavel");
		umsPage.timeLimitation();
		
	}

}
