package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LESPage extends BasePage {
	
		@FindBy(how = How.XPATH,using = "//*[@id=\"side-menu\"]/li[1]/a")
		private WebElement openReportTab;
		
		@FindBy(how = How.XPATH, using = "//*[@id=\"config-btn\"]/button/span")
		private WebElement btnConfig;
		
		@FindBy(how = How.XPATH, using = "//*[@id=\"config-btn\"]/ul/span[1]/p")
		private WebElement addLanguage;
		
		@FindBy(how = How.XPATH, using = "//*[@id=\"ngdialog1\"]/div[2]/div[2]/div/div/div[1]/select")
		private WebElement listlanguage;
		
		@FindBy(how = How.XPATH, using = "//*[@id=\"ngdialog1\"]/div[2]/div[3]/button[2]")
		private WebElement addLanguageBtn;
		
		@FindBy(how = How.XPATH, using = "//*[@id=\"config-btn\"]/ul/span[3]/p")
		private WebElement clickEdit;
		
		@FindBy(how = How.XPATH, using = "//*[@id=\"config-btn\"]/button/span")
		private WebElement btnConfigAfter;

	public LESPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
		
	}

	
	    //Page Variables
		String baseURL = "https://backend.compedia.net/lms/les/#";
		
		//goLESpage
		public void goLESpage() {
			driver.get(baseURL);
		}
		
		//open Report tab
		public void openReportTab() {
			sleep(1000);
			openReportTab.click();
		}
		
		//wait until element be clicable
		public void waitElement(WebElement webElement) {
			wait.until(ExpectedConditions.elementToBeClickable(webElement));

		}
		
		//login
		public void doLogin() {
			goLESpage();
			driver.findElement(By.id("username")).sendKeys("admin"); //user name
			driver.findElement(By.id("password")).sendKeys("Compedia123!"); //password
			driver.findElement(By.id("loginbtn")).click();
		}
		
		//open config administrative tool 
		public void openTool() {
			sleep(1000);
			waitElement(btnConfig);
			btnConfig.click();
			//wait.until(ExpectedConditions.elementToBeClickable(btnConfig));
		}
		
		//click on add language button from tool-menu
		public void addLanguage() {
			wait.until(ExpectedConditions.elementToBeClickable(addLanguage)).click();
		}
		
		//select language from the list
		public void selectLanguage(int lang) throws Exception {
			sleep(1000);
			listlanguage.click();
			selectMulti(listlanguage, lang);
			
			addLanguageBtn.click();
			
			
			//List<WebElement> list = driver.findElements(By.partialLinkText(lang));
			
			//selectByText(listlanguage, lang);
		}
		
		//add translated text and save
		public void editTitle() {
			btnConfigAfter.isEnabled();
			click(btnConfigAfter);
			waitElement(clickEdit);
			click(clickEdit);
		}
		
		
}
