package pages;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.bytebuddy.asm.Advice.OffsetMapping.ForAllArguments;

public class UMSPage extends HomePage {
	
	@FindBy(how = How.CSS,using = "a[href=\"https://backend.compedia.net/lms/admin/search.php\"]")
	private WebElement siteAdmin;
	 
	
	@FindBy(partialLinkText="editSchools")
	private WebElement linkUMS;
	
	@FindBy(css = "[id = #school > ul > li.list-group-item.ng-binding.active]")
	private WebElement openSchoolTab;
	
	@FindBy(css = "[id = #name]")
	private WebElement schoolName;
	
	@FindBy(css = "[id = #curriculumtype]")
	private WebElement curriculumtype;
	
	@FindBy(css = "[id = #country]")
	private WebElement country;
	
	@FindBy(css = "[id = #city]")
	private WebElement City;
	
	@FindBy(css = "[id = #address]")
	private WebElement Address;
	
	@FindBy(css = "[id = #zipcode]")
	private WebElement Zipcode;
	
	@FindBy(css = "[id = #timezone]")
	private WebElement timezone;
	
	@FindBy(css = "[id = #phone]")
	private WebElement Phone;
	
	@FindBy(css = "[id = #email]")
	private WebElement Email;
	
	@FindBy(css = "[id = #licensetype]")
	private WebElement licensetype;
	
	@FindBy(css = "[id = #uncMethod]")
	private WebElement uncMethod;

	public UMSPage (WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}


	//go to Site Administration
	public void siteAdministration() {
		goHomePage();
		doLogin();
		siteAdmin.click();
	}

	//go to UMS
	public void openUMS () {
		siteAdministration();
		sleep(1000);
		linkUMS.click();
	}

	//open tab Create School
	public void openCreateSchool() {
		openSchoolTab.click();
		((BasePage) openSchoolTab).sleep(10);
	}

	//fill School name
	public void schoolName(String name) throws Exception {
		wait.until(ExpectedConditions.elementToBeClickable(schoolName)).sendKeys(name);
		//writeText(By.xpath("//input[@id='name']"), name);
	}

	//fill school curriculum type
	public void curriculumType(int i) throws Exception {
		selectMulti(curriculumtype, i);
	}

	//fill school country
	public void fillCountry(String name) throws Exception {
		selectByText(country, name);
	}

	//fill school city
	public void fillCity (String city) throws Exception {
		writeText(City, city);
	}

	//fill school address
	public void fillAddress(String address) throws Exception {
		wait.until(ExpectedConditions.elementToBeClickable(Address)).sendKeys(address);
	}

	//fill school zip code
	public void fiilZipcode(String zipcode) throws Exception {
		wait.until(ExpectedConditions.elementToBeClickable(Zipcode)).sendKeys(zipcode);
	}

	//fill school time zone
	public void fillTimezone(int i) throws Exception {
		selectMulti(timezone, i);
	}

	//fill school phone number
	public void fiilPhone(String phone) throws Exception {
		wait.until(ExpectedConditions.elementToBeClickable(Phone)).sendKeys(phone);
	}

	//fill school email
	public void fillEmail(String email) throws Exception {
		wait.until(ExpectedConditions.elementToBeClickable(Email)).sendKeys(email);
	}

	//fill school license type
	public void fillLicense(int i) throws Exception {
		selectMulti(licensetype, i);
	}

	//fill school How to create username?
	public void fillUsername(int i) throws Exception {
		selectMulti(uncMethod, i);
	}

	//assign school admin
	public void clickAssignAdmin() {
		driver.findElement(By.xpath("/html/body/div/div/div[2]/form/div[9]/div/div/button")).click();
		sleep(2000);
		
		List<WebElement> list= 	driver.findElements(By.cssSelector(".table.users-table [type=\"checkbox\"]"));
		click(list.get(list.size()-1));
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
