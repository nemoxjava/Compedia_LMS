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
		public void openCreateSchool() {
			driver.findElement(By.xpath("//*[@id=\"school\"]/ul/li[1]")).click();
		}
		
		//fill all fields in Create School page: name(name), curriculum type(i), country(country), city(city), address(address), zip code (zipcode), timezone(c), phone(phone), mail(email), licnse(l), username choice(u)
		public void fiilCreateSchool(String name, int i, String country, String city, String address, String zipcode, int c, String phone, String email, int l, int u) throws Exception {
			writeText(By.xpath("//*[@id=\"name\"]"), name);
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
			
		}
		
		//find template checkbox
		public void findCheckbox(String name) {
			driver.findElement(By.id("checkbox-2")).click();
		}
		
		//fill time limitation
		public void timeLimitation() throws Exception {
			driver.findElement(By.xpath("/html/body/div/div/div[2]/form/div[14]/div[3]/div/div/span/button/i")).click();
			driver.findElement(By.xpath("/html/body/div/div/div[2]/form/div[14]/div[3]/div/div/div/ul/li[2]/span/button[1]")).click();
			int i = 0;
			driver.findElement(By.xpath("/html/body/div/div/div[2]/form/div[14]/div[4]/div/div/span/button")).click();
			do{
			driver.findElement(By.xpath("/html/body/div/div/div[2]/form/div[14]/div[4]/div/div/div/ul/li[1]/div/table/thead/tr[1]/th[3]/button/i")).click();
			i++;
			} while (i >= 12);
			driver.wait(10000);
			driver.findElement(By.xpath("//*[@id=\"datepicker-2918-9372-4\"]/button/span")).click();
			
			
		}
		
		

}
