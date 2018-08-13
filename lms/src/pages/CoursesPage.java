package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CoursesPage extends HomePage {

	public CoursesPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}
	
	//go to Site Administration
	public void siteAdministration() {
		goHomePage();
		doLogin();
		driver.findElement(By.xpath("//*[@id=\"nav-drawer\"]/nav[2]/a/div")).click();
	}
	
	//go to courses page
	public void manageCoursesCategories() {
		siteAdministration();
		driver.findElement(By.partialLinkText("Courses")).click();
		driver.findElement(By.partialLinkText("Manage courses and categories")).click();
	}
	
	//select category
	public void selectCategory() {
		driver.findElement(By.partialLinkText("prod_category")).click();
	}
	
	//create new course
	public void createCourse() {
		driver.findElement(By.partialLinkText("Create new course")).click();
	}
	
	//add a new course || general || name, short name, category, visibility
	public void general(String name, String shortName, int i, int b ) throws Exception {
		writeText(By.xpath("//*[@id=\"id_fullname\"]"), name);
		writeText(By.xpath("//*[@id=\"id_shortname\"]"), shortName);
		selectMulti(By.xpath("//*[@id=\"id_category\"]"), i);
		selectMulti(By.xpath("//*[@id=\"id_visible\"]"), i);
	}
	
	// add new course || general || start date
	public <select> void courseDate(int i, int b, int c) throws Exception {
		selectMulti(By.xpath("//*[@id=\"id_startdate_day\"]"), i);
		selectMulti(By.xpath("//*[@id=\"id_startdate_month\"]"), b);
		selectMulti(By.xpath("//*[@id=\"id_startdate_year\"]"), c);
		
	}
	
	//add new course || general ||  end date, course number
	public <select> void courseDateEnd(int i, int b, int c, String idNumber ) throws Exception {
		selectMulti(By.xpath("//*[@id=\"id_enddate_day\"]"), i);
		selectMulti(By.xpath("//*[@id=\"id_enddate_month\"]"), b);
		selectMulti(By.xpath("//*[@id=\"id_enddate_year\"]"), c);
		writeText(By.xpath("//*[@id=\"id_idnumber\"]"), idNumber);
	}
	
	//description
	public void description(String descText) throws Exception {
		writeText(By.xpath("//*[@id=\"id_summary_editoreditable\"]"), descText);
	}
	
	//Course format link open
	public void courseFormatLink() {
		driver.findElement(By.linkText("Course format")).click();
	}
	
	//Course format link || format, template, design
	public void courseFormat(int i, String text, int c ) throws Exception {
		selectMulti(By.xpath("//*[@id=\"id_format\"]"), i);
		selectByText(By.xpath("//*[@id=\"id_compediacoursetemplate\"]"), text);
		selectMulti(By.xpath("//*[@id=\"id_compediacoursedesign\"]"), c);
	}
	
	//Appearance link open
	public void openAppearance() {
		driver.findElement(By.partialLinkText("Appearance")).click();
	}
	
	//Appearance |\ language(i), Number of announcements(b), Show gradebook to students(c), Show activity reports(a)
	public void Appearance (int i, int b, int c, int a) throws Exception {
		selectMulti(By.xpath("//*[@id=\"id_lang\"]"), i);
		selectMulti(By.xpath("//*[@id=\"id_newsitems\"]"), b);
		selectMulti(By.xpath("//*[@id=\"id_showgrades\"]"), c);
		selectMulti(By.xpath("//*[@id=\"id_showreports\"]"), a);
	}
	
	
	//Files and uploads link open
	public void openFilesAndUpload() {
		driver.findElement(By.partialLinkText("Files and uploads")).click();
	}
	
	//Files and uploads || Maximum upload size
	public void maximumUploadSize(int i) throws Exception {
		selectMulti(By.xpath("//*[@id=\"id_maxbytes\"]"), i);
	}
	
	//Completion tracking link open
	public void openCompletionTracking() {
		driver.findElement(By.partialLinkText("Completion tracking")).click();
	}
	
	//Completion tracking || Enable completion tracking
	public void enableCompletionTracking(int i) throws Exception {
		selectMulti(By.xpath("//*[@id=\"id_enablecompletion\"]"), i);
	}
	
	//Groups link open
	public void openGroups() {
		driver.findElement(By.partialLinkText("Groups")).click();
	}
	
	//Groups || group mode(i), force group mode(b), default grouping
	public void Groups( int i, int b, int c) throws Exception {
		selectMulti(By.xpath("//*[@id=\"id_groupmode\"]"), i);
		selectMulti(By.xpath("//*[@id=\"id_groupmodeforce\"]"), b);
		selectMulti(By.xpath("//*[@id=\"id_defaultgroupingid\"]"), c);
	}
	
	//Save and display
	public void clickSave() {
		driver.findElement(By.xpath("//*[@id=\"id_saveanddisplay\"]")).click();
	}
	
	

}
