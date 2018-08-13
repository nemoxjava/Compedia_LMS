package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UMSPage extends HomePage {
	
	public UMSPage (WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}
	
	//go to Site Administration
		public void siteAdministration() {
			goHomePage();
			doLogin();
			driver.findElement(By.xpath("//*[@id=\"nav-drawer\"]/nav[2]/a/div")).click();
		}
		
	//go to UMS
		public void openUMS () {
			siteAdministration();
			driver.findElement(By.partialLinkText("UMS")).click();
		}
		
		//open tab Create School
		public void createSchool() {
			driver.findElement(By.xpath("//*[@id=\"school\"]/ul/li[1]")).click();
		}

}
