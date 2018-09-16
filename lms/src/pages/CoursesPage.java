package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Factory;

public class CoursesPage extends HomePage {
	@FindBy(css ="[#id_fullname]")
	private WebElement fullName;
	
	@FindBy(css = "[#id_shortname]")
	private WebElement shortNameEl;
	
	@FindBy(css = "[#id_category]")
	private WebElement catCourse;
	
	@FindBy (css = "[#id_visible]")
	private WebElement catVisible;
	
	@FindBy(css = "[#yui_3_17_2_1_1536910169631_985 > div]")
	private WebElement siteAdmin;
	
	@FindBy(partialLinkText="prod_category")
	private WebElement prodCat;
	
	@FindBy(partialLinkText="Courses")
	private WebElement Courses;
	
	@FindBy(partialLinkText="Manage courses and categories")
	private WebElement manageCaC;
	
	@FindBy(partialLinkText="Create new course")
	private WebElement newCourse;
	
	@FindBy(css ="[id = #id_startdate_day]")
	private WebElement day;
	
	@FindBy(css ="[id = #id_startdate_month]")
	private WebElement month;
	
	@FindBy(css ="[id = #id_startdate_year]")
	private WebElement year;
	
	@FindBy(css ="[id = #id_enddate_day]")
	private WebElement dayEnd;
	
	@FindBy(css ="[id = #id_enddate_month]")
	private WebElement monthEnd;
	
	@FindBy(css ="[id = #id_enddate_year]")
	private WebElement yearEnd;
	
	@FindBy(css = "[id = #id_idnumber]")
	private WebElement idnumber;
	
	@FindBy(css = "[id = #id_summary_editoreditable]")
	private WebElement addDescription;
	
	@FindBy(linkText="Course format")
	private WebElement courseFormat;
	
	@FindBy(css = "[id = #id_format]")
	private WebElement idFormat;
	
	@FindBy(css = "[id = #id_numdiscussions]")
	private WebElement numdiscussions;
	
	@FindBy(partialLinkText="Appearance")
	private WebElement Appearance;
	
	@FindBy(css = "[id = #id_lang]")
	private WebElement idLang;
	
	@FindBy(css = "[id = #id_showgrades]")
	private WebElement showGrades;
	
	@FindBy(css = "[id = #id_showreports]")
	private WebElement showReport;
	
	@FindBy(partialLinkText="Files and uploads")
	private WebElement filesUploads;
	
	@FindBy(css = "[id = #id_maxbytes]")
	private WebElement maxUpSize;
	
	@FindBy(partialLinkText="Completion tracking")
	private WebElement compTrack;
	
	@FindBy(css="[id=#id_enablecompletion]")
	private WebElement enablecompletion;
	
	@FindBy(partialLinkText="Groups")
	private WebElement Groups;
	
	@FindBy(css="[id=#id_groupmode]")
	private WebElement groupmode;
	
	@FindBy(css="[id=#id_groupmodeforce]")
	private WebElement groupmodeforce;
	
	@FindBy(css="[id=#id_defaultgroupingid]")
	private WebElement defaultgroupingid;
	
	@FindBy(css="[id=#id_saveanddisplay]")
	private WebElement saveanddisplay;

	public CoursesPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}
	
	//go to Site Administration
	public void siteAdministration() {
		goHomePage();
		doLogin();
		siteAdmin.click();
	}
	
	//go to courses page
	public void manageCoursesCategories() {
		siteAdministration();
		Courses.click();
		manageCaC.click();
	}
	
	//select category
	public void selectCategory() {
		prodCat.click();
	}
	
	//create new course
	public void createCourse() {
		newCourse.click();
	}
	
	//add a new course || general || name, short name, category, visibility
	public void general(String name, String shortName, int i, int b ) throws Exception {
		writeText(fullName, name);
		writeText(shortNameEl, shortName);
		selectMulti(catCourse, i);
		selectMulti(catVisible, i);
	}
	
	// add new course || general || start date
	public <select> void courseDate(int i, int b, int c) throws Exception {
		selectMulti(day, i);
		selectMulti(month, b);
		selectMulti(year, c);
		
	}
	
	//add new course || general ||  end date, course number
	public <select> void courseDateEnd(int i, int b, int c, String idNumber ) throws Exception {
		selectMulti(dayEnd, i);
		selectMulti(monthEnd, b);
		selectMulti(yearEnd, c);
		writeText(idnumber, idNumber);
	}
	
	//description
	public void description(String descText) throws Exception {
		writeText(addDescription, descText);
	}
	
	//Course format link open
	public void courseFormatLink() {
		courseFormat.click();
	}
	
	//Course format link || format, template, design
	public void courseFormat(int i, String text ) throws Exception {
		selectMulti(idFormat, i);
		selectByText(numdiscussions, text);
	}
	
	//Appearance link open
	public void openAppearance() {
		Appearance.click();
	}
	
	//Appearance |\ language(i), Number of announcements(b), Show gradebook to students(c), Show activity reports(a)
	public void Appearance (int i, int c, int a) throws Exception {
		selectMulti(idLang, i);
		selectMulti(showGrades, c);
		selectMulti(showReport, a);
	}
	
	
	//Files and uploads link open
	public void openFilesAndUpload() {
		filesUploads.click();
	}
	
	//Files and uploads || Maximum upload size
	public void maximumUploadSize(int i) throws Exception {
		selectMulti(maxUpSize, i);
	}
	
	//Completion tracking link open
	public void openCompletionTracking() {
		compTrack.click();
	}
	
	//Completion tracking || Enable completion tracking
	public void enableCompletionTracking(int i) throws Exception {
		selectMulti(enablecompletion, i);
	}
	
	//Groups link open
	public void openGroups() {
		Groups.click();
	}
	
	//Groups || group mode(i), force group mode(b), default grouping
	public void Groups( int i, int b, int c) throws Exception {
		selectMulti(groupmode, i);
		selectMulti(groupmodeforce, b);
		selectMulti(defaultgroupingid, c);
	}
	
	//Save and display
	public void clickSave() {
		saveanddisplay.click();
	}
	
	

}
