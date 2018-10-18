package tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

public class BaseTest {
	public WebDriver driver;
	public WebDriverWait wait;
	
	@BeforeClass
	public void setup() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\automation\\drivers\\chromedriver.exe");
		driver = new ChromeDriver(); //All test and page classes use this driver
		wait = new WebDriverWait(driver,15); //All test and page classes use this wait
		driver.manage().window().maximize(); //maximize test window
	}
	
	/*@AfterClass
	
	public void teardown() {
		
		driver.quit();
	}*/

}
