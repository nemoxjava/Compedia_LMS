package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Throwables;

public class TemplatesPage extends HomePage {
	
	@FindBy(css = "[id = #nav-drawer > nav.list-group.m-t-1 > a > div]")
	private WebElement adminBtn;
	
	@FindBy(css = "[id = #region-main > div > div > ul > li:nth-child(5) > a]")
	private WebElement linkModules;
	
	@FindBy(css = "[id = #linkmodules > div > div > div > div:nth-child(17) > div.col-sm-9 > ul > li:nth-child(2) > a]")
	private WebElement linkModulesLink;
	
	@FindBy(css = "[id = #single_button5b9cce1dc78db291]")
	private WebElement addTemplateBtn;
	
	@FindBy(css = "[id = #id_name]")
	private WebElement idName;
	
	@FindBy(css = "[id = #id_visible]")
	private WebElement idVisible;
	
	@FindBy(css = "[id = #id_canbelocked]")
	private WebElement canBeLocked;
	
	@FindBy(css = "[id = #id_shortname__text]")
	private WebElement shortnameText;
	
	@FindBy(css = "[id = #id_shortnameavaliablefor]")
	private WebElement shortnameavaliablefor;
	
	@FindBy(css = "[id = #id_description__textarea]")
	private WebElement descriptionTextArea;
	
	@FindBy(css = "[id = #id_descriptionavaliablefor]")
	private WebElement descriptionavaliablefor;
	
	@FindBy(css = "[id = #id_activitypicture__filepicker]")
	private WebElement activityPictureFilepicker;
	
	@FindBy(css = "[id = #id_activitypictureavaliablefor]")
	private WebElement activitypictureavaliablefor;
	
	@FindBy(css = "[id = #id_activityicon__singleselect]")
	private WebElement activityIconSingleSelect;
	
	@FindBy(css = "[id = #id_activityiconavaliablefor]")
	private WebElement activityiconavaliablefor;
	
	@FindBy(css = "[id = #id_custom1__textarea]")
	private WebElement custom1TextArea;
	
	@FindBy(css = "[id = #id_custom1avaliablefor]")
	private WebElement custom1avaliablefor;
	
	@FindBy(css = "[id = #id_custom1name]")
	private WebElement custom1name;
	
	@FindBy(css = "[id = #id_custom2__textarea]")
	private WebElement custom2TextArea;
	
	@FindBy(css = "[id = #id_custom2avaliablefor]")
	private WebElement custom2avaliablefor;
	
	@FindBy(css = "[id = #id_custom2name]")
	private WebElement custom2name;
	
	@FindBy(css = "[id = #id_custom3__singleselect]")
	private WebElement custom3SingleSelect;
	
	@FindBy(css = "[id = #id_custom3avaliablefor]")
	private WebElement custom3avaliablefor;
	
	@FindBy(css = "[id = #id_custom3name]")
	private WebElement custom3name;
	
	@FindBy(css = "[id = #id_custom3options]")
	private WebElement custom3options;
	
	@FindBy(css = "[id = #id_custom4__singleselect]")
	private WebElement custom4SingleSelect;
	
	@FindBy(css = "[id = #id_custom4avaliablefor]")
	private WebElement custom4avaliablefor;
	
	@FindBy(css = "[id = #id_custom4name]")
	private WebElement custom4name;
	
	@FindBy(css = "[id = #id_custom4options]")
	private WebElement custom4options;
	
	@FindBy(css = "[id = #id_custom5__singleselect]")
	private WebElement custom5SingleSelect;
	
	@FindBy(css = "[id = #id_custom5avaliablefor]")
	private WebElement custom5avaliablefor;
	
	@FindBy(css = "[id = #id_custom4name]")
	private WebElement custom5name;
	
	@FindBy(css = "[id = #id_custom4options]")
	private WebElement custom5options;
	
	@FindBy(css = "[id = id_submitbutton]")
	private WebElement submitbutton;
	
	public TemplatesPage (WebDriver driver, WebDriverWait wait) {
		super(driver,wait);
	}
	
	// go to Site administration
				public void siteAdministration() {
					goHomePage();
					doLogin();
					adminBtn.click();
				}
				
		//go to Manage course templates page
				public void manageCourseTemplates() {
					siteAdministration();
					linkModules.click();
					linkModulesLink.click();
				}
				
				//Add Course Template button
				public void addCourseTemplateButton () {
					addTemplateBtn.click();
					
				}
				
				//Add Course Template Name+Visible
				public <select> void addCourseTemplate (String name, int i) throws Exception {
					writeText(idName, name);
					selectMulti(idVisible, i);
					
				}
				
				//Activities Setting
				public void checkBox() throws Exception {
					canBeLocked.click();
				}
				
				public <select> void shortName (int i, int b) throws Exception {
					selectMulti(shortnameText, i);
					selectMulti(shortnameavaliablefor, i);
				}
				
				public <select> void description (int i, int b) throws Exception {
					selectMulti(descriptionTextArea, i);
					selectMulti(descriptionavaliablefor, i);
				}
				
				public <select> void activityPicture (int i, int b) throws Exception {
					selectMulti(activityPictureFilepicker, i);
					selectMulti(activitypictureavaliablefor, i);
				}
				
				public <select> void activityIcon(int i, int b) throws Exception {
					selectMulti(activityIconSingleSelect, i);
					selectMulti(activityiconavaliablefor, i);
				}
				
				//Custom fields
				public <select> void customFieldsOne (int i, int b, String freeTextField) throws Exception {
					selectMulti(custom1TextArea, i);
					selectMulti(custom1avaliablefor, i);
					writeText(custom1name, freeTextField);
				}
				
				public <select> void customFieldsTwo (int i, int b, String freeTextField) throws Exception {
					selectMulti(custom2TextArea, i);
					selectMulti(custom2avaliablefor, i);
					writeText(custom2name, freeTextField);
				}
				
				//Customizable field - single select
				public <select> void customFieldSingle (int i, int b, String fieldName, String option) throws Exception {
					selectMulti(custom3SingleSelect, i);
					selectMulti(custom3avaliablefor, i);
					writeText(custom3name, fieldName);
					writeText(custom3options, option);
				}
				
				//Customizable field - multi select
				public <select> void customFieldMultySelectOne (int i, int b, String fieldName, String option) throws Exception {
					selectMulti(custom4SingleSelect, i);
					selectMulti(custom4avaliablefor, i);
					writeText(custom4name, fieldName);
					writeText(custom4options, option);
				}
				
				//Customizable field - multi select (2)
				public <select> void customFieldMultySelectTwo (int i, int b, String fieldName, String option) throws Exception {
					selectMulti(custom5SingleSelect, i);
					selectMulti(custom5avaliablefor, i);
					writeText(custom5name, fieldName);
					writeText(custom5options, option);
				}
				
				//Save changes
				public void saveChanges() throws Exception {
					click(submitbutton);
				}

}
