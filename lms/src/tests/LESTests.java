package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import pages.BasePage;
import pages.LESPage;

public class LESTests extends BaseTest {
	
	

	@Test (priority = 5)
	
	public void createReport() throws Exception{
		
		LESPage lesPage = new LESPage(driver, wait);
		lesPage.doLogin();
		lesPage.goLESpage();
		lesPage.openReportTab();
		lesPage.openTool();
		lesPage.addLanguage();
		lesPage.selectLanguage(117);
		lesPage.sleep(5000);
		lesPage.editTitle();
	}

}
