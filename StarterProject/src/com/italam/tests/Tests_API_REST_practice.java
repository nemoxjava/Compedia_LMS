package com.italam.tests;


import java.io.IOException;
import java.net.URLEncoder;

import org.testng.Assert;
import org.testng.ITestResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.framework.utility.GeneralUtility;
import com.framework.utility.RestUtils;
import com.italam.data.EnumDBsConnDetails;
import com.italam.data.Constant;
import com.italam.data.DataProviders;
import com.italam.utility.Utility;

public class Tests_API_REST_practice {

	private static final Logger log = LogManager.getLogger(Tests_API_REST_practice.class.getName());
	private static final String ESCAPE_PROPERTY = "org.uncommons.reportng.escape-output";

	private WebDriver driver;
	
	private String baseUrl;
	String environment, sUser;
	String[] connectionsDetails;
	String[] connectionsDBDetails;

	String connectionString, connectionUser, connectionPass;
	String[][] tabArray;

	@BeforeClass(alwaysRun = true)
	public void Test_prepration() throws Exception {
		System.setProperty(ESCAPE_PROPERTY, "false");
		
		environment = Utility.getProperty("environment");
		log.info("Environment: " + environment);

		connectionsDetails = Utility.returnLoginParams();
		

		baseUrl = connectionsDetails[2];
		//driver = GeneralUtility.getWebDriver(UtilityNext.getProperty("browser"), baseUrl);
		
		connectionsDBDetails = DataProviders.returnConnectionParams();
		connectionString = connectionsDBDetails[EnumDBsConnDetails.TEST_CONN_STRING.getValue()];
		connectionUser = connectionsDBDetails[EnumDBsConnDetails.TEST_USER.getValue()];
		connectionPass = connectionsDBDetails[EnumDBsConnDetails.TEST_PASS.getValue()];

		tabArray = null;
		GeneralUtility.sendReporter("Start tests on: " + baseUrl);

	}
	
	
	@Test(enabled = true, dataProvider = "GetToken_DataXls", dataProviderClass = DataProviders.class, priority = 1, groups = "sanity")
	public void apiTest_getOrganizationProfile(String userName, String	Password, String iterations)	throws Exception {
		GeneralUtility.startOfTestDelimiter("Start Test");
		String methodName =  "api test, getOrganizationProfile,  iteration: " + iterations;
		GeneralUtility.sendReporter("START " + methodName +", Environment: " + environment);
		log.info("Start " + methodName);

		
		
		try {
			
			log.info("data from excel: " + userName);
			//1. Get Admin token
			
			String json_args = Utility.getProperty("json_args_login");
			String https_url = baseUrl+"login&service_type=ums&args=" + URLEncoder.encode(json_args,"UTF-8");
			String token = RestUtils.restApiHttps(json_args,https_url);
			String results = token;
			results = results.replace("\"", "");
			Assert.assertTrue((results.contains("success:true")), "Could not generate the token from " + https_url);
			
			token = Utility.getToken(token);
			
			
		}
		catch (AssertionError ar) {
			log.error("Test result failed on assertion error: Please review log file");
			GeneralUtility.sendReporter("Test result failed on assertion error: ");
			//GeneralUtility.reportLogScreenshot(GeneralUtility.printScreen(driver, "Failed_Assert"));
			Reporter.getCurrentTestResult().setStatus(ITestResult.FAILURE);
			
			
		}
		catch (Exception ex) {
			log.error("Test result failed: For DB verifications");
			GeneralUtility.sendReporter("Test result failed: For code exception");
			//GeneralUtility.reportLogScreenshot(GeneralUtility.printScreen(driver, "Failed_assert_verification"));
			Reporter.getCurrentTestResult().setStatus(ITestResult.FAILURE);
			ex.printStackTrace();

		}

		log.info("Finish " + methodName);
		GeneralUtility.sendReporter("FINISH " + methodName + "  on Environment:" + environment);
	}
	
		
	@AfterMethod(alwaysRun = true)
	public void Exit_Clean_After_Test() throws Exception {
		GeneralUtility.Sleep(1);
		log.info("After method ...");

	}

	@AfterClass(alwaysRun = true)
	public void End_Exectuion() throws IOException, InterruptedException {
		log.info("After Class ...");
	}

}
