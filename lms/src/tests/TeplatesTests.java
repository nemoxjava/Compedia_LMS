package tests;

import org.testng.annotations.Test;

import pages.TemplatesPage;

  public class TeplatesTests extends BaseTest {
	  

	@Test (priority = 2)
	  
	  public void goToTemplates () throws Exception {
		
		  TemplatesPage templatePage = new TemplatesPage(driver,wait);
		  templatePage.manageCourseTemplates();
		  templatePage.addCourseTemplateButton();
		  templatePage.addCourseTemplate("testPavel", 0);
		  templatePage.checkBox();
		  templatePage.shortName(2, 3);
		  templatePage.description(2, 3);
		  templatePage.activityIcon(1, 2);
		  templatePage.activityIcon(1, 3);
		  templatePage.customFieldsOne(2, 3, "testPavelFreeTextFieldOne");
		  templatePage.customFieldsTwo(2, 2, "testPavelFreeTextFieldTwo");
		  templatePage.customFieldSingle(2, 3, "fieldNameTestPavel", "option1" + "," + "option2");
		  templatePage.customFieldMultySelectOne(2, 3, "fieldNameTestPavelMultySelect", "option1" + "," + "option2");
		  templatePage.customFieldMultySelectTwo(2, 3, "fieldNameTestPavelMultySelectTwo", "option1" + "," + "option2");
		  templatePage.saveChanges();
	  }
	
	
	
	  
  }

	


