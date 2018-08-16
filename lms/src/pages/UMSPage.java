package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
			selectByText(By.xpath("\"//*[@id=\\\"city\\\"]\""), name);
		}
		
		//fill school city
		public void fillCity (String city) throws Exception {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id("city"))).sendKeys(city);
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
		//fill all fields in Create School page: name(name), curriculum type(i), country(country), city(city), address(address), zip code (zipcode), timezone(c), phone(phone), mail(email), licnse(l), username choice(u)
		/*public  void fiilCreateSchool( int i, String country, String city, String address, String zipcode, int c, String phone, String email, int l, int u) throws Exception {
			// wait.until(ExpectedConditions.visibilityOfAllElements(driver ));
			//writeText(By.xpath("//input[@id='name']"), name);
			selectMulti(By.xpath("//*[@id=\"curriculumtype\"]"), i);
			selectByText(By.xpath("//*[@id=\"country\"]"), country);
			writeText(By.xpath("//*[@id=\"city\"]"), city);
			writeText(By.xpath("//*[@id=\"address\"]"), address);
			writeText(By.xpath("//*[@id=\"zipcode\"]"), zipcode);
			selectMulti(By.xpath("//*[@id=\"timezone\"]"), c);
			writeText(By.xpath("//*[@id=\"phone\"]"), phone);
			writeText(By.xpath("//*[@id=\"email\"]"), email);
			selectMulti(By.xpath("//*[@id=\"licensetype\"]"), l);
			selectMulti(By.xpath("//*[@id=\"uncMethod\"]"), u);
			
		}*/
		
		//find template checkbox
		public void findCheckbox(String name) {
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("checkbox-2")))).click();
		}
		
		//fill time limitation
		public void timeLimitation() throws Exception {
			driver.findElement(By.xpath("/html/body/div/div/div[2]/form/div[14]/div[3]/div/div/span/button/i")).click();
			driver.findElement(By.xpath("//*[@id=\"datepicker-115-2577-title\"]/strong")).sendKeys("August 2019");
			
			
		}

		public void waitElement(By driver) {
			wait.until(ExpectedConditions.elementToBeClickable(driver));
			
		}
		
		

}
