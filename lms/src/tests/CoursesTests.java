package tests;

import org.testng.annotations.Test;

import pages.CoursesPage;

public class CoursesTests extends BaseTest{

	@Test (priority = 0)
	
	public void goToCoursesPage () throws Exception {
		CoursesPage coursesPage = new CoursesPage(driver, wait);
		coursesPage.manageCoursesCategories();
		coursesPage.selectCategory();
		coursesPage.createCourse();
		coursesPage.general("testPavel", "tstPvl", 1, 1);
		coursesPage.courseDate(8, 7, 118);
		coursesPage.courseDateEnd(8, 7, 119, "1515");
		coursesPage.description("test Pavel automation");
		coursesPage.courseFormatLink();
		coursesPage.courseFormat(0, "testPavel", 0);
		coursesPage.openAppearance();
		coursesPage.Appearance(1, 0, 1, 0);
		coursesPage.openFilesAndUpload();
		coursesPage.maximumUploadSize(0);
		coursesPage.openCompletionTracking();
		coursesPage.enableCompletionTracking(1);
		coursesPage.openGroups();
		coursesPage.Groups(1, 0, 0);
		coursesPage.clickSave();
		
	}

}
