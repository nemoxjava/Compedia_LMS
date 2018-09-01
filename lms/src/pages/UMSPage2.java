package pages;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.bytebuddy.asm.Advice.OffsetMapping.ForAllArguments;

public class UMSPage2 extends HomePage {
	@FindBy(partialLinkText="UMS")
	private WebElement umsLink;
	
	@FindBy(css="[name='city']")
	private WebElement cityField;
	
	public UMSPage2 (WebDriver driver, WebDriverWait wait) {
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
		click(umsLink);
	}

	//open tab Create School
	public void openCreateSchool() {
		//driver.findElement(By.xpath("/html/body/div/div/div[1]/nav/div/div/div/div[6]/h4")).click();
		//WebDriver By = driver;
		wait.until(ExpectedConditions.visibilityOfElementLocated(org.openqa.selenium.By.xpath("//*[@id=\"school\"]/ul/li[1]"))).click();
		/*driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//*[@id=\"school\"]/ul/li[1]")).click();*/
	}

	//fill School name
	public void schoolName(String name) throws Exception {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='name']"))).sendKeys(name);
		//writeText(By.xpath("//input[@id='name']"), name);
	}

	//fill school curriculum type
	public void curriculumType(int i) throws Exception {
		selectMulti(By.xpath("//*[@id=\"curriculumtype\"]"), i);
	}

	//fill school country
	public void fillCountry(String name) throws Exception {
		selectByText(By.xpath("//*[@id=\"country\"]"), name);
	}

	//fill school city
	public void fillCity (String city) throws Exception {
		fillText(cityField, city);
	}

	//fill school address
	public void fillAddress(String address) throws Exception {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"address\"]"))).sendKeys(address);
	}

	//fill school zip code
	public void fiilZipcode(String zipcode) throws Exception {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"zipcode\"]"))).sendKeys(zipcode);
	}

	//fill school time zone
	public void fillTimezone(int i) throws Exception {
		selectMulti(By.xpath("//*[@id=\"timezone\"]"), i);
	}

	//fill school phone number
	public void fiilPhone(String phone) throws Exception {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"phone\"]"))).sendKeys(phone);
	}

	//fill school email
	public void fillEmail(String email) throws Exception {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"email\"]"))).sendKeys(email);
	}

	//fill school license type
	public void fillLicense(int i) throws Exception {
		selectMulti(By.xpath("//*[@id=\"licensetype\"]"), i);
	}

	//fill school How to create username?
	public void fillUsername(int i) throws Exception {
		selectMulti(By.xpath("//*[@id=\"uncMethod\"]"), i);
	}

	//assign school admin
	public void clickAssignAdmin() {
		driver.findElement(By.xpath("/html/body/div/div/div[2]/form/div[9]/div/div/button")).click();
		sleep(2000);
		
		List<WebElement> list= 	driver.findElements(By.cssSelector(".table.users-table [type=\"checkbox\"]"));
		click(list.get(list.size()-1));
//		
//		ArrayList <WebElement> allList = new ArrayList <WebElement>(driver.findElements(By.cssSelector("#ngdialog1 > div.ngdialog-content"))); 		
//		for (WebElement item : allList) {
//			if (item.getText().matches("PavelAdminTest")) {
//				item.findElement(By.cssSelector("#ngdialog1 > div.ngdialog-content > table > tbody > tr:nth-child(107) > td:nth-child(1) > input")).click();
//				System.out.println(item);
//			}}

		//driver.findElement(By.xpath("//*[@id=\"ngdialog1\"]/div[2]/table/tbody/tr[107]/td[1]/input")).click();
	}


	//find template checkbox 
	public void findCheckbox(String name) {
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("checkbox-2")))).click();
	}

	//fill time limitation start
	public void timeLimitationStart(String start) throws Exception {
		driver.findElement(By.xpath("//*[@id=\"stratdate-2\"]")).sendKeys(start);
	}

	//fill time limitation end
	public void timelimitationEnd(String end) {
		driver.findElement(By.xpath("//*[@id=\"enddate-2\"]")).sendKeys(end);
	}

	public void waitElement(By driver) {
		wait.until(ExpectedConditions.elementToBeClickable(driver));

	}

	//submit create school form
	public void clickSubmit() {
		click(driver.findElement(By.xpath("/html/body/div/div/div[2]/form/button")));
	}


}
