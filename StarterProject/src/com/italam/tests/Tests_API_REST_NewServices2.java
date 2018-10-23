///*package com.italam.tests;
//
//import java.io.IOException;
//import java.net.URLEncoder;
//
//import org.testng.Assert;
//import org.testng.ITestResult;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.testng.Reporter;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//import com.framework.utility.GeneralUtility;
//import com.framework.utility.RestUtils;
//import com.italam.data.EnumDBsConnDetails;
//import com.italam.data.DataProviders;
//import com.italam.utility.Utility;
//
//public class Tests_API_REST_NewServices2 {
//
//	private static final Logger log = LogManager.getLogger(Tests_API_REST_NewServices2.class.getName());
//	private static final String ESCAPE_PROPERTY = "org.uncommons.reportng.escape-output";
//
//	// private WebDriver driver;
//
//	private String baseUrl;
//	String environment, sUser;
//	String[] connectionsDetails;
//	String[] connectionsDBDetails;
//
//	String connectionString, connectionUser, connectionPass;
//	String[][] tabArray;
//
//	@BeforeClass(alwaysRun = true)
//	public void Test_prepration() throws Exception {
//		System.setProperty(ESCAPE_PROPERTY, "false");
//
//		environment = Utility.getProperty("environment");
//		log.info("Environment: " + environment);
//
//		connectionsDetails = Utility.returnLoginParams();
//		baseUrl = connectionsDetails[2];
//
//		*//*** If need SELENIUM ***//*
//		// driver = GeneralUtility.getWebDriver(UtilityNext.getProperty("browser"),
//		// baseUrl);
//
//		*//*** If need extra DB connection details ***//*
//		connectionsDBDetails = DataProviders.returnConnectionParams();
//		connectionString = connectionsDBDetails[EnumDBsConnDetails.TEST_CONN_STRING.getValue()];
//		connectionUser = connectionsDBDetails[EnumDBsConnDetails.TEST_USER.getValue()];
//		connectionPass = connectionsDBDetails[EnumDBsConnDetails.TEST_PASS.getValue()];
//
//		tabArray = null;
//		GeneralUtility.sendReporter("Start tests on: " + baseUrl);
//
//	}
//
//	// test 3
//	@Test(enabled = false, dataProvider = "iteration", dataProviderClass = DataProviders.class, priority = 1, groups = "sanity")
//	public void apiTestGetAllCourses(int iterations) throws Exception {
//		GeneralUtility.startOfTestDelimiter("Start Test");
//
//		String methodName = "apiTestTestgetCourses,  iteration: " + iterations;
//		GeneralUtility.sendReporter("START " + methodName + ", Environment: " + environment);
//		log.info("Start " + methodName);
//		String json_args = "";
//		String https_url = "";
//		String results = "";
//
//		try {
//			// 3. Get courses data:
//
//			json_args = Utility.getProperty("json_args_getCourse");
//			https_url = baseUrl + "getCourses&service_type=ums&args=" + URLEncoder.encode(json_args, "UTF-8");
//			String getCourses = RestUtils.restApiHttps(json_args, https_url);
//			log.info("getCourses: " + getCourses);
//			results = getCourses.replace("\"", "");
//			Assert.assertTrue((results.contains("success:true")), "Could not sucessfully send the rest: " + https_url);
//
//			GeneralUtility.startOfTestDelimiter("End Test");
//		} catch (AssertionError ar) {
//			log.error("Test result failed on assertion error: Please review log file");
//			GeneralUtility.sendReporter("Test result failed on assertion error: ");
//			// GeneralUtility.reportLogScreenshot(GeneralUtility.printScreen(driver,
//			// "Failed_Assert"));
//			Reporter.getCurrentTestResult().setStatus(ITestResult.FAILURE);
//
//		} catch (Exception ex) {
//			log.error("Test result failed: For DB verifications");
//			GeneralUtility.sendReporter("Test result failed: For code exception");
//			// GeneralUtility.reportLogScreenshot(GeneralUtility.printScreen(driver,
//			// "Failed_assert_verification"));
//			Reporter.getCurrentTestResult().setStatus(ITestResult.FAILURE);
//			ex.printStackTrace();
//
//		}
//
//		log.info("Finish " + methodName);
//		GeneralUtility.sendReporter("FINISH " + methodName + "  on Environment:" + environment);
//	}
//
//	// test 1111111
//	@Test(enabled = true, dataProvider = "iteration", dataProviderClass = DataProviders.class, priority = 1, groups = "sanity")
//	public void apiTestGetOrganizationLicensing(int iterations) throws Exception {
//		GeneralUtility.startOfTestDelimiter("Start Test");
//
//		String methodName = "apiTestGetOrganizationLicensing,  iteration: " + iterations;
//		GeneralUtility.sendReporter("START " + methodName + ", Environment: " + environment);
//		log.info("Start " + methodName);
//		String json_args = "";
//		String https_url = "";
//		String results = "";
//
//		try {
//
//			// 1. Get  token
//			String randomNumber  =  GeneralUtility.randomNumber(7);
//			json_args = Utility.getProperty("json_args_login_4createOrganization");
//			json_args = json_args.replace("###", randomNumber);
//			https_url = baseUrl + "createOrganization&service_type=ums&args=" + URLEncoder.encode(json_args, "UTF-8");
//		
//			String userName = "mymail###@test.com".replace("###", randomNumber);
//			
//			String token = RestUtils.restApiHttps(json_args, https_url);
//			
//			results = token;
//			results = results.replace("\"", "");
//			Assert.assertTrue((results.contains("success:true")), "Could not generate the token from " + https_url);
//
//			String password = Utility.getPassword2(results);
//		
//			
//			
//			
//			
//			
//			// 2. Create Organization and Get user and password
//
//			json_args = Utility.getProperty("json_args_createorganization_backend");
//			json_args = json_args.replace("##Param1##",randomNumber);
//			https_url = baseUrl + "createOrganization&service_type=ums&args="+ URLEncoder.encode(json_args,"UTF-8");
//			String organization_data = RestUtils.restApiHttps(json_args,https_url);
//			
//			log.info("Received following organization_data: " + organization_data);
//			results = organization_data.replace("\"", "");
//			log.info("assert for organization data.........");
//			Assert.assertTrue((results.contains("success:true")), "Could not sucessfully send the rest: " + https_url);
//
//			String name = "test" + randomNumber;
//			log.info("Received following name :" + name);
//
//			String email = "test1" + randomNumber + "@test.me";
//			log.info("Received following email :" + email);
//
//			String description = "test" + randomNumber;
//			log.info("Received following description :" + description);
//
//			String organization_id = Utility.organization_id(organization_data);
//			log.info("Received following organization_data: " + organization_id);
//
//			//String password = UtilityNext.getPassword(organization_data);
//			log.info("Received following organization_data: " + password);
//
//			json_args = Utility.getProperty("json_args_loginParameter");
//			json_args = json_args.replace("##Param1##", email);
//			json_args = json_args.replace("##Param2##", password);
////			json_args = json_args.replace("##Param1##", "admin");
////			json_args = json_args.replace("##Param2##", "Compedia123!");
////			https_url = baseUrl + "login&service_type=ums&args=" + URLEncoder.encode(json_args, "UTF-8");
////			token = RestUtils.restApiHttps(json_args, https_url);
////			token = UtilityNext.getToken(token);
////			System.out.println("token 2: " + token);
//			
//			
//			
//			
//			
//
//			
//			
//			// 3. Get Course token
//
//			json_args = Utility.getProperty("json_args_login_backend");
//			json_args = json_args.replace("###user###", userName);
//			json_args = json_args.replace("###password###", password);
//			https_url = baseUrl + "login&service_type=ums&args=" + URLEncoder.encode(json_args, "UTF-8");
//			token = RestUtils.restApiHttps(json_args, https_url);
//			results = token;
//			results = results.replace("\"", "");
//			Assert.assertTrue((results.contains("success:true")), "Could not generate the token from " + https_url);
//			token = Utility.getToken(token);
//	
//			System.out.println("token 1: " + token);
//			
//
//			json_args = Utility.getProperty("getOrganizationLicensing");
//			
//			
//			json_args = json_args.replace("###token###", token);
//			//json_args = json_args.replace("###courseID###", token);
//			https_url = baseUrl + "getOrganizationLicensing&service_type=ums&args=" + URLEncoder.encode(json_args, "UTF-8");
//			token = RestUtils.restApiHttps(json_args, https_url);
//			results = token;
//			results = results.replace("\"", "");
//			Assert.assertTrue((results.contains("success:true")), "Could not generate the token from " + https_url);
//			//token = UtilityNext.getToken(token);
//			
//			
//			
//			
//			
//					
//			
//			
//			 * //3. Update organization licensing:
//			 * 
//			 * json_args = UtilityNext.getProperty("json_args_getCourse"); // json_args =
//			 * json_args.replace("##token##",token); // json_args =
//			 * json_args.replace("##id##",organization_id); // json_args =
//			 * json_args.replace("##license##","100"); https_url = baseUrl +
//			 * "getCourses&service_type=ums&args="+ URLEncoder.encode(json_args,"UTF-8");
//			 * String getCourses = RestUtils.restApiHttps(json_args,https_url);
//			 * log.info("getCourses: " + getCourses); results = getCourses.replace("\"",
//			 * ""); Assert.assertTrue((results.contains("success:true")),
//			 * "Could not sucessfully send the rest: " + https_url);
//			 
//
//			GeneralUtility.startOfTestDelimiter("End Test");
//		} catch (AssertionError ar) {
//			log.error("Test result failed on assertion error: Please review log file");
//			GeneralUtility.sendReporter("Test result failed on assertion error: ");
//			// GeneralUtility.reportLogScreenshot(GeneralUtility.printScreen(driver,
//			// "Failed_Assert"));
//			Reporter.getCurrentTestResult().setStatus(ITestResult.FAILURE);
//
//		} catch (Exception ex) {
//			log.error("Test result failed: For DB verifications");
//			GeneralUtility.sendReporter("Test result failed: For code exception");
//			// GeneralUtility.reportLogScreenshot(GeneralUtility.printScreen(driver,
//			// "Failed_assert_verification"));
//			Reporter.getCurrentTestResult().setStatus(ITestResult.FAILURE);
//			ex.printStackTrace();
//
//		}
//
//		log.info("Finish " + methodName);
//		GeneralUtility.sendReporter("FINISH " + methodName + "  on Environment:" + environment);
//	}
//
//	// ===============================
//	// test 1
//	@Test(enabled = false, dataProvider = "iteration", dataProviderClass = DataProviders.class, priority = 1, groups = "sanity")
//	public void apiTest_AllCases(int iterations) throws Exception {
//		GeneralUtility.startOfTestDelimiter("Start Test");
//
//		String methodName = "apiTest_AllCases,  iteration: " + iterations;
//		GeneralUtility.sendReporter("START " + methodName + ", Environment: " + environment);
//		log.info("Start " + methodName);
//
//		try {
//
//			// 2. Get Course token
//
//			String json_args = Utility.getProperty("json_args_login_backend");
//			String https_url = baseUrl + "login&service_type=ums&args=" + URLEncoder.encode(json_args, "UTF-8");
//			String token = RestUtils.restApiHttps(json_args, https_url);
//			String results = token;
//			results = results.replace("\"", "");
//			Assert.assertTrue((results.contains("success:true")), "Could not generate the token from " + https_url);
//
//			token = Utility.getToken(token);
//
//			*//*** Random number for getting unique details ***//*
//			String randomNumber = GeneralUtility.randomNumber(7);
//
//			// 2. Create Organization and Get user and password
//
//			json_args = Utility.getProperty("json_args_createorganization");
//			json_args = json_args.replace("##Param1##", randomNumber);
//			https_url = baseUrl + "createOrganization&service_type=ums&args=" + URLEncoder.encode(json_args, "UTF-8");
//			String organization_data = RestUtils.restApiHttps(json_args, https_url);
//
//			log.info("Received following organization_data: " + organization_data);
//			results = organization_data.replace("\"", "");
//			Assert.assertTrue((results.contains("success:true")), "Could not sucessfully send the rest: " + https_url);
//
//			String name = "test" + randomNumber;
//			log.info("Received following name :" + name);
//
//			String email = "test" + randomNumber + "@test.me";
//			log.info("Received following email :" + email);
//
//			String description = "test" + randomNumber;
//			log.info("Received following description :" + description);
//
//			String organization_id = Utility.organization_id(organization_data);
//			log.info("Received following organization_data: " + organization_id);
//
//			String password = Utility.getPassword(organization_data);
//			log.info("Received following organization_data: " + password);
//
//			json_args = Utility.getProperty("json_args_loginParameter");
//			json_args = json_args.replace("##Param1##", email);
//			json_args = json_args.replace("##Param2##", password);
//			https_url = baseUrl + "login&service_type=ums&args=" + URLEncoder.encode(json_args, "UTF-8");
//			token = RestUtils.restApiHttps(json_args, https_url);
//			token = Utility.getToken(token);
//
//			// 3. Update organization licensing:
//
//			json_args = Utility.getProperty("json_args_updateorganizationlicensing");
//			json_args = json_args.replace("##token##", token);
//			json_args = json_args.replace("##id##", organization_id);
//			json_args = json_args.replace("##license##", "100");
//			https_url = baseUrl + "updateorganizationlicensing&service_type=ums&args="
//					+ URLEncoder.encode(json_args, "UTF-8");
//			String organization_newLicense = RestUtils.restApiHttps(json_args, https_url);
//			log.info("organization new License: " + organization_newLicense);
//			results = organization_newLicense.replace("\"", "");
//			Assert.assertTrue((results.contains("success:true")), "Could not sucessfully send the rest: " + https_url);
//
//			// 4. get Organization Profile:
//
//			json_args = Utility.getProperty("json_args_getOrganizationProfile");
//			json_args = json_args.replace("##token##", token);
//			https_url = baseUrl + "getOrganizationProfile&service_type=ums&args="
//					+ URLEncoder.encode(json_args, "UTF-8");
//			String organization_profile = RestUtils.restApiHttps(json_args, https_url);
//			log.info("organization profile: " + organization_profile);
//			results = organization_profile.replace("\"", "");
//			Assert.assertTrue((results.contains("success:true")), "Could not sucessfully send the rest: " + https_url);
//
//			// 5. Update email:
//
//			json_args = Utility.getProperty("json_args_updateOrganizationProfile");
//			json_args = json_args.replace("##token##", token);
//			json_args = json_args.replace("##id##", organization_id);
//			json_args = json_args.replace("##name##", name);
//			json_args = json_args.replace("##email##", "2" + email);
//			json_args = json_args.replace("##description##", description);
//			https_url = baseUrl + "updateOrganizationProfile&service_type=ums&args="
//					+ URLEncoder.encode(json_args, "UTF-8");
//			String update_profile_email = RestUtils.restApiHttps(json_args, https_url);
//			log.info("organization profile: " + update_profile_email);
//			results = update_profile_email.replace("\"", "");
//			Assert.assertTrue((results.contains("success:true")), "Could not sucessfully send the rest: " + https_url);
//
//			// 6. get org admin:
//
//			json_args = Utility.getProperty("json_args_getorgadmin");
//			json_args = json_args.replace("##token##", token);
//			https_url = baseUrl + "getorgadmin&service_type=ums&args=" + URLEncoder.encode(json_args, "UTF-8");
//			String getOrgadmin = RestUtils.restApiHttps(json_args, https_url);
//			log.info("organization admin: " + getOrgadmin);
//			results = getOrgadmin.replace("\"", "");
//			Assert.assertTrue((results.contains("success:true")), "Could not sucessfully send the rest: " + https_url);
//
//			// 7. update Org Admin:
//
//			json_args = Utility.getProperty("json_args_updateOrgAdmin");
//			json_args = json_args.replace("##token##", token);
//			json_args = json_args.replace("##email##", email);
//			json_args = json_args.replace("##password##", password);
//			json_args = json_args.replace("##newpassword##", password + 1);
//
//			https_url = baseUrl + "updateOrgAdmin&service_type=ums&args=" + URLEncoder.encode(json_args, "UTF-8");
//			String updateOrgAdmin = RestUtils.restApiHttps(json_args, https_url);
//			log.info("organization admin: " + updateOrgAdmin);
//			results = updateOrgAdmin.replace("\"", "");
//			Assert.assertTrue((results.contains("success:true")), "Could not sucessfully send the rest: " + https_url);
//
//			// 8. getInitialData:
//
//			https_url = baseUrl + "getInitialData&service_type=ums";
//			String getInitialData = RestUtils.restApiHttps(json_args, https_url);
//			log.info("getInitialData : " + getInitialData);
//			results = getInitialData.replace("\"", "");
//			Assert.assertTrue((results.contains("success:true")), "Could not sucessfully send the rest: " + https_url);
//
//			GeneralUtility.startOfTestDelimiter("End Test");
//		} catch (AssertionError ar) {
//			log.error("Test result failed on assertion error: Please review log file");
//			GeneralUtility.sendReporter("Test result failed on assertion error: ");
//			// GeneralUtility.reportLogScreenshot(GeneralUtility.printScreen(driver,
//			// "Failed_Assert"));
//			Reporter.getCurrentTestResult().setStatus(ITestResult.FAILURE);
//
//		} catch (Exception ex) {
//			log.error("Test result failed: For DB verifications");
//			GeneralUtility.sendReporter("Test result failed: For code exception");
//			// GeneralUtility.reportLogScreenshot(GeneralUtility.printScreen(driver,
//			// "Failed_assert_verification"));
//			Reporter.getCurrentTestResult().setStatus(ITestResult.FAILURE);
//			ex.printStackTrace();
//
//		}
//
//		log.info("Finish " + methodName);
//		GeneralUtility.sendReporter("FINISH " + methodName + "  on Environment:" + environment);
//	}
//
//	// test 2
//	@Test(enabled = false, dataProvider = "iteration", dataProviderClass = DataProviders.class, priority = 1, groups = "sanity")
//	public void apiTest_CreateOrganization(int iterations) throws Exception {
//		GeneralUtility.startOfTestDelimiter("Start Test");
//
//		String methodName = "apiTest_CreateOrganizationGetPassword,  iteration: " + iterations;
//		GeneralUtility.sendReporter("START " + methodName + ", Environment: " + environment);
//		log.info("Start " + methodName);
//
//		try {
//
//			// 1. Get Admin token
//
//			String json_args = Utility.getProperty("json_args_login");
//			String https_url = baseUrl + "login&service_type=ums&args=" + URLEncoder.encode(json_args, "UTF-8");
//			String token = RestUtils.restApiHttps(json_args, https_url);
//			String results = token;
//			results = results.replace("\"", "");
//			Assert.assertTrue((results.contains("success:true")), "Could not generate the token from " + https_url);
//
//			token = Utility.getToken(token);
//			String randomNumber = GeneralUtility.randomNumber(7);
//
//			// 2. Create Organization and Get user and password
//
//			json_args = Utility.getProperty("json_args_createorganization");
//			json_args = json_args.replace("##Param1##", randomNumber);
//			https_url = baseUrl + "createOrganization&service_type=ums&args=" + URLEncoder.encode(json_args, "UTF-8");
//			String organization_data = RestUtils.restApiHttps(json_args, https_url);
//
//			log.info("Received following organization_data: " + organization_data);
//			results = organization_data.replace("\"", "");
//			Assert.assertTrue((results.contains("success:true")), "Could not sucessfully send the rest: " + https_url);
//
//			String name = "test" + randomNumber;
//			log.info("Received following name :" + name);
//
//			String email = "test" + randomNumber + "@test.me";
//			log.info("Received following email :" + email);
//
//			String description = "test" + randomNumber;
//			log.info("Received following description :" + description);
//
//			String organization_id = Utility.organization_id(organization_data);
//			log.info("Received following organization_data: " + organization_id);
//
//			String password = Utility.getPassword(organization_data);
//			log.info("Received following organization_data: " + password);
//
//			json_args = Utility.getProperty("json_args_loginParameter");
//			json_args = json_args.replace("##Param1##", email);
//			json_args = json_args.replace("##Param2##", password);
//			https_url = baseUrl + "login&service_type=ums&args=" + URLEncoder.encode(json_args, "UTF-8");
//			token = RestUtils.restApiHttps(json_args, https_url);
//			token = Utility.getToken(token);
//
//			GeneralUtility.startOfTestDelimiter("End Test");
//		} catch (AssertionError ar) {
//			log.error("Test result failed on assertion error: Please review log file");
//			GeneralUtility.sendReporter("Test result failed on assertion error: ");
//			// GeneralUtility.reportLogScreenshot(GeneralUtility.printScreen(driver,
//			// "Failed_Assert"));
//			Reporter.getCurrentTestResult().setStatus(ITestResult.FAILURE);
//
//		} catch (Exception ex) {
//			log.error("Test result failed: For DB verifications");
//			GeneralUtility.sendReporter("Test result failed: For code exception");
//			// GeneralUtility.reportLogScreenshot(GeneralUtility.printScreen(driver,
//			// "Failed_assert_verification"));
//			Reporter.getCurrentTestResult().setStatus(ITestResult.FAILURE);
//			ex.printStackTrace();
//
//		}
//
//		log.info("Finish " + methodName);
//		GeneralUtility.sendReporter("FINISH " + methodName + "  on Environment:" + environment);
//	}
//
//	@AfterMethod(alwaysRun = true)
//	public void Exit_Clean_After_Test() throws Exception {
//		GeneralUtility.Sleep(1);
//		log.info("After method ...");
//
//	}
//
//	@AfterClass(alwaysRun = true)
//	public void End_Exectuion() throws IOException, InterruptedException {
//		log.info("After Class ...");
//	}
//
//}
//*/