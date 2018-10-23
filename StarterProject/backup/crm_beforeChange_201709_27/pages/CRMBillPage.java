package com.crm.pages;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.hotportal.pages.BasePage;


public class CRMBillPage extends BasePage {

	static final Logger log = LogManager.getLogger(CRMBillPage.class.getName());
	
	WebElement rbOther;
	
	

	public CRMBillPage(WebDriver driver) throws IOException {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public boolean approveSendBill(String SiteNumber) throws InterruptedException,
			IOException {
		boolean approveSendBill = false;
		Thread.sleep(5000);
		
		int iWhichFrame = 3;
		//In case want to find the frame by dynamic search
		//int iWhichFrame = returnFrameNumberAccordingToElement(By.xpath(".//tr[3]/td[2]/div[1]/*[contains(@name,'HT_QF_DATES_DRV_HT_MONTH_BACK_RB')][@type='radio']"));

		
		driver.switchTo().defaultContent();

		log.info("Begin the flow of the go to site");
		try {
			driver.switchTo().frame(iWhichFrame);
			//rbOther = driver.findElement(By.xpath(".//tr[3]/td[2]/div[1]/*[contains(@name,'HT_QF_DATES_DRV_HT_MONTH_BACK_RB')][@type='radio']"));
			//click(rbOther);
			driver.findElement(By.xpath("//*[@id='HT_QF_DATES_DRV_HT_MONTH_BACK_RB$4$_LBL']")).click();
			
		
			Thread.sleep(2000);
			
			WebElement fromDate = driver.findElement(By.id("HT_QF_DATES_DRV_HT_QF_FROM_DATE"));
			WebElement toDate = driver.findElement(By.id("HT_QF_DATES_DRV_HT_QF_TO_DATE"));
			
			if (driver instanceof InternetExplorerDriver) {
				fromDate.click();
				fromDate.sendKeys(Keys.DOWN);
				fromDate.sendKeys(Keys.ENTER);
			}
			else
			{
			
				Select sfromMonth = new Select(fromDate);
				Select sToMonth = new Select(toDate);
				
				
				sfromMonth.selectByVisibleText("09/2017");
				sToMonth.selectByVisibleText("09/2017");
			}
			
			WebElement bApprove = returnSlowElement(By.id("HT_QF_INVSV_DRV_HT_SEND_PB"));
			click(bApprove);
			
			approveSendBill = true;
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

		return approveSendBill;
	}

	

}
