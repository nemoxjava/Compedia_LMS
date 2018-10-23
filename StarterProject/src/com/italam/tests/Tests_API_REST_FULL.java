package com.italam.tests;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.testng.Assert;
import org.testng.ITestResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.framework.utility.GeneralUtility;
import com.framework.utility.RestUtils;
import com.italam.data.DataProviders;
import com.italam.utility.Utility;

public class Tests_API_REST_FULL {

	private static final Logger log = LogManager.getLogger(Tests_API_REST_FULL.class.getName());
	private static final String ESCAPE_PROPERTY = "org.uncommons.reportng.escape-output";

	// private WebDriver driver;

	private String baseUrl;
	private String environmemt;

	@BeforeClass(alwaysRun = true)
	public void Test_prepration() throws Exception {
		System.setProperty(ESCAPE_PROPERTY, "false");

		baseUrl = "https://backend.compedia.net/lms/local/compedia_services/mainservice.php?action=";
		environmemt ="Backend";
		/*** If need SELENIUM ***/
		// driver = GeneralUtility.getWebDriver(UtilityNext.getProperty("browser"),
		// baseUrl);

		
		GeneralUtility.sendReporter("Start tests on: " + baseUrl);

	}

	
	// test 1
	@Test(enabled = true, dataProvider = "iteration", dataProviderClass = DataProviders.class, priority = 1, groups = "sanity")
	public void apiTestGetOrganizationLicensing(int iterations) throws Exception {
		String methodName = "All REST tests";
		GeneralUtility.startOfTestDelimiter("Start Test: " + methodName);

		
		try {
				String param="", request = "", results="";
				
				//Create Organization
				
				log.info("=================================");
				log.info("Create Organization");
				log.info("=================================");
			
				String randName = "pavel_" + GeneralUtility.randomNumber(4);
				String userName = randName+"@test.com";
				String password, organization, token, id, name;

	
	
				baseUrl = "https://backend.compedia.net/lms/local/compedia_services/mainservice.php?action=createOrganization&service_type=ums&args=";
				param = "{\"name\":\"" + randName + "\",\"idnumber\":\"1234567\",\"country\":\"IL\",\"city\":\"tlv\",\"address\":\"TLV\",\"email\":\"" + randName + "@test.com\",\"timezone\":\"America/New_York\",\"phone\":\"123123\",\"description\":\"\",\"zipcode\":\"123123\",\"licensetype\":\"1\",\"curriculum\":{\"curriculumid\":\"Liberal%20North\",\"bundles\":[{\"bundleid\":\"3\",\"licenses\":\"55\",\"courses\":[{\"courseid\":\"29\"}]}]}}";
				request = baseUrl+param;
				log.info(request);
				
				results = RestUtils.restApiHttps(request);
				results = results.replace("\"", "");
				Assert.assertTrue((results.contains("success:true")), "Could not generate the token from " + request);
	
			
			
			//License 1 = Organization
			log.info("=================================");
			log.info("License 1 = Organization");
			log.info("=================================");
		
		
		
			randName = "pavel_" + GeneralUtility.randomNumber(4);
			baseUrl = "https://backend.compedia.net/lms/local/compedia_services/mainservice.php?action=createOrganization&service_type=ums&args=";
			param = "{\"name\":\"matan1231\",\"idnumber\":\"1231231\",\"country\":\"IL\",\"city\":\"sfdsfe\",\"address\":\"TLV\",\"email\":\""+randName+"@test.com\",\"timezone\":\"America/New_York\",\"phone\":\"123123\",\"description\":\"\",\"zipcode\":\"123123\",\"licensetype\":\"1\",\"curriculum\":{\"curriculumid\":\"Liberal%20North\",\"bundles\":[{\"bundleid\":\"3\",\"licenses\":\"55\",\"courses\":[{\"courseid\":\"29\"}]}]}}";
			request = baseUrl+param;
			log.info(request);
			results = RestUtils.restApiHttps(request);
			results = results.replace("\"", "");
			Assert.assertTrue((results.contains("success:true")), "Could not License 1 = Organization " + request);
			
			
			/*	*/
			
			//LICENSE 2 = PRIVATE
			log.info("=================================");
			log.info("LICENSE 2 = PRIVATE");
			log.info("=================================");
			
			randName = "pavel_" + GeneralUtility.randomNumber(4);
			baseUrl = "https://backend.compedia.net/lms/local/compedia_services/mainservice.php?action=createOrganization&service_type=ums&args=";
			param = "{\"name\":\"matan1231\",\"idnumber\":\"1231231\",\"country\":\"IL\",\"city\":\"tlv\",\"address\":\"TLV\",\"email\":\""+randName+"@test.com\",\"timezone\":\"America/New_York\",\"phone\":\"123123\",\"description\":\"\",\"zipcode\":\"123123\",\"licensetype\":\"2\",\"curriculum\":{\"curriculumid\":\"Liberal%20North\",\"bundles\":[{\"bundleid\":\"3\",\"licenses\":\"55\",\"courses\":[{\"courseid\":\"29\"}]}]}}";
			request = baseUrl+param;
			log.info(request);
			results = RestUtils.restApiHttps(request);
			results = results.replace("\"", "");
			log.info(results);
			Assert.assertTrue((results.contains("success:true")), "Could not LICENSE 2 = PRIVATE " + request);
			userName = randName+"@test.com";
			password = extractRegExpFromString("password:","}",results,1);
			organization = extractRegExpFromString("organization_id:","}",results,1);
			log.info("Oraganization: " + organization + ", user:" +userName + ", password: " + password);
			
			
			//Get Login token
			log.info("=================================");
			log.info("Get Login token");
			log.info("=================================");
			
			baseUrl = "https://backend.compedia.net/lms/local/compedia_services/mainservice.php?action=login&service_type=ums&args=";
			param = "{\"username\":\""+userName +"\",\"password\":\""+password +"\"}";
			request = baseUrl+param;
			log.info(request);
			results = RestUtils.restApiHttps(request);
			results = results.replace("\"", "");
			log.info(results);
			Assert.assertTrue((results.contains("success:true")), "Could not Get Login token " + request);
			token = extractRegExpFromString("token:","}",results,1);
			log.info("Oragnization " + organization +  " token: " + token);
	
			
			//Get Organization licensing (admin token of the same organization)
			log.info("=================================");
			log.info("Get Organization licensing");
			log.info("=================================");
			
			baseUrl = "https://backend.compedia.net/lms/local/compedia_services/mainservice.php?action=getOrganizationLicensing&service_type=ums&args="; 
			param = "{\"token\":\""+token+"\",\"courses\": [{\"courseid\": \"29\",\"coursename \": \"TEST1111\",\"licenses\": \"\",\"summary_file_url\": \"\",\"startdate\":\"\",\"enddate \":\"\"}]}";
			request = baseUrl+param;
			log.info(request);
			results = RestUtils.restApiHttps(request);
			results = results.replace("\"", "");
			log.info(results);
			Assert.assertTrue((results.contains("success:true")), "Could not Get Organization licensing " + request);
			
			
			//updateOrganizationProfile
			log.info("=================================");
			log.info("updateOrganizationProfile");
			log.info("=================================");
			
			id = GeneralUtility.randomNumber(4)+"@test.com";
			//updateOrganizationProfile
			baseUrl = "https://backend.compedia.net/lms/local/compedia_services/mainservice.php?action=updateOrganizationProfile&service_type=ums&args="; 
			param = "{\"token\":\""+token+"\",\"id\": \""+organization+"\",\"name\": \"name\",\"licensetype\": \"2\",\"country\": \"IL\",\"zipcode\":\"1231237\",\"city\":\"TLV\",\"address\":\"address\",\"email\":\""+id+"\",\"description\":\"test\",\"timezone\":\"America/New_York\",\"byod\":\"\"}";
			request = baseUrl+param;
			log.info(request);
			results = RestUtils.restApiHttps(request);
			results = results.replace("\"", "");
			log.info(results);
			Assert.assertTrue((results.contains("success:true")), "Could not updateOrganizationProfile " + request);
			
			log.info("=================================");
			log.info("Create Individual user profile");
			log.info("=================================");
			
			String idMail = GeneralUtility.randomNumber(4)+"@test.com";
			name = GeneralUtility.randomString(5);
			//updateOrganizationProfile
			baseUrl = "https://backend.compedia.net/lms/local/compedia_services/mainservice.php?action=createIndividualUserProfile&service_type=ums&args="; 
			param = "{\"firstname\":\""+name+"\",\"lastname\":\""+name+"\",\"email\":\""+idMail+"\",\"gender\":\"f\",\"role\":\"student\",\"id\":\""+organization+"\"}";
			request = baseUrl+param;
			log.info(request);
			results = RestUtils.restApiHttps(request);
			results = results.replace("\"", "");
			log.info(results);
			Assert.assertTrue((results.contains("success:true")), "Could not Create Individual user profile " + request);
	
			
			log.info("=================================");
			log.info("getIndividualUserLicensing");
			log.info("=================================");
			
			baseUrl = "https://backend.compedia.net/lms/local/compedia_services/mainservice.php?action=login&service_type=ums&args="; 
			param = "{\"username\":\"admin\",\"password\":\"Compedia123!\"}";
			request = baseUrl+param;
			log.info(request);
			results = RestUtils.restApiHttps(request);
			results = results.replace("\"", "");
			String adminToken = extractRegExpFromString("token:","}",results,1);
			
			baseUrl = "https://backend.compedia.net/lms/local/compedia_services/mainservice.php?action=getIndividualUserLicensing&service_type=ums&args="; 
			param = "{\"token\":\""+adminToken+"\"}";
			request = baseUrl+param;
			log.info(request);
			results = RestUtils.restApiHttps(request);
			results = results.replace("\"", "");
			
			log.info(results);
			Assert.assertTrue((results.contains("success:true")), "Could not getIndividualUserLicensing " + request);
	
			

			log.info("=================================");
			log.info("Update Individual user profile");
			log.info("=================================");
			
			idMail = GeneralUtility.randomNumber(4)+"@test.com";
			baseUrl = "https://backend.compedia.net/lms/local/compedia_services/mainservice.php?action=updateIndividualUserProfile&service_type=ums&args="; 
			param = "{\"token\":\""+token+"\",\"username\":\""+idMail+"\",\"firstname\":\"testPavelAPI\",\"lastname\":\"testAPI\",\"gender\":\"m\",\"oldpassword\":\""+password+"\",\"newpassword\":\"1234\",\"newpasswordverify\":\"1234\"}";
			request = baseUrl+param;
			log.info(request);
			results = RestUtils.restApiHttps(request);
			results = results.replace("\"", "");
			Assert.assertTrue((results.contains("success:true")), "Could not gUpdate Individual user profile " + request);
		
			
			
			log.info("=================================");
			log.info("resetUserPassword");
			log.info("=================================");
			
			baseUrl = "https://backend.compedia.net/lms/local/compedia_services/mainservice.php?action=resetUserPassword&service_type=ums&args="; 
			param = "{ \"username\":\"hagai4@test.com\",\"email\":\"hagai3@test.com\"}";
			request = baseUrl+param;
			log.info(request);
			results = RestUtils.restApiHttps(request);
			results = results.replace("\"", "");
			String newPassword = extractRegExpFromString("newpassword:","}",results,1);;
			log.info("New password: " + newPassword);
			Assert.assertTrue((results.contains("success:true")), "Could not resetUserPassword " + request);
			
			
			
			log.info("=================================");
			log.info("createIndividualUserLicensing");
			log.info("=================================");
			String courseID="111";
			baseUrl = "https://backend.compedia.net/lms/local/compedia_services/mainservice.php?action=createIndividualUserLicensing&service_type=ums&args="; 
			param = "{\"token\":\""+token+"\",\"courses\":[{\"courseid\": \""+courseID+"\",\"startdate\":\"01/01/2019\",\"enddate\":\"01/02/2019\",\"ula\":\"1\"}]}";
			request = baseUrl+param;
			log.info(request);
			results = RestUtils.restApiHttps(request);
			results = results.replace("\"", "");
		
			log.info("New password: " + newPassword);
			Assert.assertTrue((results.contains("success:true")), "Could not createIndividualUserLicensing  " + request);
		
			
			log.info("=================================");
			log.info("updateIndividualUserLicensing");
			log.info("=================================");
			 courseID="111";
			baseUrl = "https://backend.compedia.net/lms/local/compedia_services/mainservice.php?action=updateIndividualUserLicensing&service_type=ums&args="; 
			param = "{\"token\":\""+token+"\",\"courses\":[{\"courseid\": \""+courseID+"\",\"startdate\":\"01/01/2019\",\"enddate\":\"01/02/2020\",\"ula\":\"1\"}]}";
			request = baseUrl+param;
			log.info(request);
			results = RestUtils.restApiHttps(request);
			results = results.replace("\"", "");
			log.info("Response content: " + results);
			Assert.assertTrue((results.contains("success:true")), "Could not updateIndividualUserLicensing " + request);
			
			log.info("=================================");
			log.info("getUlaValues");
			log.info("=================================");
			 courseID="111";
			baseUrl = "https://backend.compedia.net/lms/local/compedia_services/mainservice.php?action=getUlaValues&service_type=ums"; 
			param = "";
			request = baseUrl+param;
			log.info(request);
			results = RestUtils.restApiHttps(request);
			results = results.replace("\"", "");
			log.info("Response content: " + results);
			Assert.assertTrue((results.contains("success:true")), "Could not getUlaValues " + request);
	
			
			GeneralUtility.startOfTestDelimiter("End Test");
		} catch (AssertionError ar) {
			log.error("Test result failed on assertion error: Please review log file");
			GeneralUtility.sendReporter("Test result failed on assertion error: ");
			// GeneralUtility.reportLogScreenshot(GeneralUtility.printScreen(driver,
			// "Failed_Assert"));
			Reporter.getCurrentTestResult().setStatus(ITestResult.FAILURE);

		} catch (Exception ex) {
			log.error("Test result failed: For response verifications");
			GeneralUtility.sendReporter("Test result failed: For code exception");
			// GeneralUtility.reportLogScreenshot(GeneralUtility.printScreen(driver,
			// "Failed_assert_verification"));
			Reporter.getCurrentTestResult().setStatus(ITestResult.FAILURE);
			ex.printStackTrace();

		}

		log.info("Finish " + methodName);
		GeneralUtility.sendReporter("FINISH " + methodName + "  on Environment:" + environmemt);
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

	
	public static String extractRegExpFromString(String LB, String RB, String data, int count_num) {
		Pattern pattern = Pattern.compile(LB + "(.*?)" + RB);
		Matcher matcher = pattern.matcher(data);
		String ans;
		int count = 1;
		while (matcher.find()) {
			ans = matcher.group(1);
			if (count == count_num)
				return ans;

			count++;

		}
		return null;
	}
}
