package tests;

import org.testng.annotations.Test;

import pages.UMSPage;

public class UMSTests extends BaseTest{
	
	@Test (priority = 4)
	
	public void createOrganization() throws Exception {
		UMSPage umsPage = new UMSPage(driver, wait);
		umsPage.openUMS();
		umsPage.sleep(1000);
		umsPage.openCreateSchool();
		umsPage.schoolName("testPavel");
		umsPage.curriculumType(1);
		umsPage.fillCountry("Israel");
		umsPage.explWait(driver);
		umsPage.fillCity("TLV");
		umsPage.fillAddress("address");
		umsPage.fiilZipcode("123123");
		umsPage.fillTimezone(1);
		umsPage.fiilPhone("0524209775");
		umsPage.fillEmail("test@test.me");
		umsPage.fillLicense(0);
		umsPage.fillUsername(0);
		umsPage.findCheckbox("testPavel");
		umsPage.timeLimitationStart("08/16/2018");
		umsPage.timelimitationEnd("08/16/2019");
		umsPage.clickAssignAdmin();
		umsPage.clickSubmit();
		
	}

}
