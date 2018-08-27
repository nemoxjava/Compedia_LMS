package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {
	
	//Constructor
	public HomePage (WebDriver driver, WebDriverWait wait) {
		super(driver,wait);
	}
	
	//Page Variables
	String baseURL = "https://backend.compedia.net/lms/login/index.php";
	
	//Go to HomePage
	public void goHomePage() {
		driver.get(baseURL);
	}
	
	//Do Login
	public void doLogin() {
		goHomePage();
		driver.findElement(By.id("username")).sendKeys("admin"); //user name
		driver.findElement(By.id("password")).sendKeys("Compedia123!"); //password
		driver.findElement(By.id("loginbtn")).click();
		String expectedTitle = "Moodle Compedia";
		String actualTitle = driver.getTitle();
		if (actualTitle.contentEquals(expectedTitle)) {
			System.out.println("opens LMS page");
		} else {
			System.out.println("something wrong with login");
		}
		
	}

	
}
