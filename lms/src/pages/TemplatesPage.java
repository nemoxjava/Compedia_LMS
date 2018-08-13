package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Throwables;

public class TemplatesPage extends HomePage {
	
	public TemplatesPage (WebDriver driver, WebDriverWait wait) {
		super(driver,wait);
	}
	
	// go to Site administration
				public void siteAdministration() {
					goHomePage();
					doLogin();
					driver.findElement(By.xpath("//*[@id=\"nav-drawer\"]/nav[2]/a/div")).click();
				}
				
		//go to Manage course templates page
				public void manageCourseTemplates() {
					siteAdministration();
					driver.findElement(By.xpath("//*[@href=\"#linkmodules\"]")).click();
					driver.findElement(By.xpath("//*[@id=\"linkmodules\"]/div/div/div/div[9]/div[2]/ul/li[2]/a")).click();
				}
				
				//Add Course Template button
				public void addCourseTemplateButton () {
					driver.findElement(By.className("singlebutton")).click();
					
				}
				
				//Add Course Template Name+Visible
				public <select> void addCourseTemplate (String name, int i) throws Exception {
					writeText(By.id("id_name"), name);
					//By by = By.id("id_visible");
					//selectMulti(By.id("id_visible"), 0);
					selectMulti(By.xpath("//*[@id=\"id_visible\"]"), i);
					
				}
				
				//Activities Setting
				public void checkBox() throws Exception {
					driver.findElement(By.id("id_canbelocked")).click();
				}
				
				public <select> void shortName (int i, int b) throws Exception {
					selectMulti(By.xpath("//*[@id=\"id_shortname__text\"]"), i);
					selectMulti(By.xpath("//*[@id=\"id_shortnameavaliablefor\"]"), i);
				}
				
				public <select> void description (int i, int b) throws Exception {
					selectMulti(By.xpath("//*[@id=\"id_description__textarea\"]"), i);
					selectMulti(By.xpath("//*[@id=\"id_descriptionavaliablefor\"]"), i);
				}
				
				public <select> void activityPicture (int i, int b) throws Exception {
					selectMulti(By.xpath("//*[@id=\"id_activitypicture__filepicker\"]"), i);
					selectMulti(By.xpath("//*[@id=\"id_activitypictureavaliablefor\"]"), i);
				}
				
				public <select> void activityIcon(int i, int b) throws Exception {
					selectMulti(By.xpath("//*[@id=\"id_activityicon__singleselect\"]"), i);
					selectMulti(By.xpath("//*[@id=\"id_activityiconavaliablefor\"]"), i);
				}
				
				//Custom fields
				public <select> void customFieldsOne (int i, int b, String freeTextField) throws Exception {
					selectMulti(By.xpath("//*[@id=\"id_custom1__textarea\"]"), i);
					selectMulti(By.xpath("//*[@id=\"id_custom1avaliablefor\"]"), i);
					writeText(By.xpath("//*[@id=\"id_custom1name\"]"), freeTextField);
				}
				
				public <select> void customFieldsTwo (int i, int b, String freeTextField) throws Exception {
					selectMulti(By.xpath("//*[@id=\"id_custom2__textarea\"]"), i);
					selectMulti(By.xpath("//*[@id=\"id_custom2avaliablefor\"]"), i);
					writeText(By.xpath("//*[@id=\"id_custom2name\"]"), freeTextField);
				}
				
				//Customizable field - single select
				public <select> void customFieldSingle (int i, int b, String fieldName, String option) throws Exception {
					selectMulti(By.xpath("//*[@id=\"id_custom3__singleselect\"]"), i);
					selectMulti(By.xpath("//*[@id=\"id_custom3avaliablefor\"]"), i);
					writeText(By.xpath("//*[@id=\"id_custom3name\"]"), fieldName);
					writeText(By.xpath("//*[@id=\"id_custom3options\"]"), option);
				}
				
				//Customizable field - multi select
				public <select> void customFieldMultySelectOne (int i, int b, String fieldName, String option) throws Exception {
					selectMulti(By.xpath("//*[@id=\"id_custom4__multiselect\"]"), i);
					selectMulti(By.xpath("//*[@id=\"id_custom4avaliablefor\"]"), i);
					writeText(By.xpath("//*[@id=\"id_custom4name\"]"), fieldName);
					writeText(By.xpath("//*[@id=\"id_custom4options\"]"), option);
				}
				
				//Customizable field - multi select (2)
				public <select> void customFieldMultySelectTwo (int i, int b, String fieldName, String option) throws Exception {
					selectMulti(By.xpath("//*[@id=\"id_custom5__multiselect\"]"), i);
					selectMulti(By.xpath("//*[@id=\"id_custom5avaliablefor\"]"), i);
					writeText(By.xpath("//*[@id=\"id_custom5name\"]"), fieldName);
					writeText(By.xpath("//*[@id=\"id_custom5options\"]"), option);
				}
				
				//Save changes
				public void saveChanges() throws Exception {
					click(By.xpath("//*[@id=\"id_submitbutton\"]"));
				}

}
