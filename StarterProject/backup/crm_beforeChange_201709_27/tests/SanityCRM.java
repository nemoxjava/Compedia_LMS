package com.crm.tests;

import java.io.IOException;
//import java.sql.ResultSet;
//import java.sql.ResultSetMetaData;
//import java.sql.SQLException;

import org.testng.Assert;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.data.Constant;
import com.crm.pages.CRMBillPage;
import com.crm.pages.CRMCustomerPage;
import com.crm.pages.CRMHomePage;
import com.crm.pages.CRMLogin;
import com.crm.pages.CRMSitePage;
import com.hotportal.utility.DBUtils;
import com.hotportal.utility.ExcelUtils;
import com.hotportal.utility.GeneralUtility;

public class SanityCRM {

	private static final Logger log = LogManager.getLogger(SanityCRM.class.getName());

	private static final String ESCAPE_PROPERTY = "org.uncommons.reportng.escape-output";

	private WebDriver driver;
	private CRMLogin cl;
	private CRMHomePage hp;
	private CRMCustomerPage ccp;
	private CRMSitePage csp;
	private CRMBillPage cbp;

	@BeforeClass
	public void Test_prepration() throws IOException, InterruptedException {

		driver = GeneralUtility.getWebDriver("ie", GeneralUtility.getProperty("crm"));
		cl = new CRMLogin(driver);
		hp = new CRMHomePage(driver);
		ccp = new CRMCustomerPage(driver);
		csp = new CRMSitePage(driver);
		cbp = new CRMBillPage(driver);
		System.setProperty(ESCAPE_PROPERTY, "false");
		try {
			Assert.assertTrue(cl.login(GeneralUtility.getProperty("usercrm"), GeneralUtility.getProperty("passcrm")),
					"Could not get the expected page after login");
		} catch (AssertionError err) {
			log.error("Test result failed: " + "Login failed");
			System.exit(1);
		}

	}

	@Test(dataProvider = "getDataFromDB_AdvancedSearchClients", priority = 1, enabled = true)
	public void קריאת_שירות_פדקס_תסריט(String sClientNumber) throws Exception {
		String methodName = "קריאת_שירות_פדקס";
		log.info("Start " + methodName);
		try {

			Assert.assertTrue(hp.searchSite(sClientNumber), "Could not get the expected page");
			Assert.assertTrue(ccp.goToTSRMASTER(), "Could not get the expected objects or page in site page");
			Assert.assertTrue(csp.setDirection(), "Could not get the expected object or page in direction page");
			Assert.assertTrue(csp.goToScenario(), "Could not get the expected object or page in direction page");
			Assert.assertTrue(csp.goToScenarioStages(), "Could not get the expected object or page in direction page");
			Assert.assertTrue(csp.StagesQuestions(), "Could not get the expected object or page in direction page");
			Assert.assertTrue(csp.StagesQuestions2(), "Could not get the expected object or page in direction page");
			Assert.assertTrue(csp.FedexQuestions(), "Could not get the expected object or page in direction page");
			Assert.assertTrue(csp.FedexQuestions2(), "Could not get the expected object or page in direction page");
			Assert.assertTrue(csp.FedexQuestions3(), "Could not get the expected object or page in direction page");

			log.info("Start: " + " שליחת פקע פדקס מול מסד נתונים " + " Using data from DB");

			String sSqlTransaction = Constant.getSqlFDXQueryCustomer();
			sSqlTransaction = sSqlTransaction.replace("FFFFFFFF", sClientNumber);
			String connectionString = GeneralUtility.getProperty("crmconnectionstring");
			String connectionUser = GeneralUtility.getProperty("crmconnectionuser");
			String connectionPass = GeneralUtility.getProperty("crmconnectionpass");

			String qMessage = DBUtils.getValueFromDb_SetDB(sSqlTransaction, "MESSAGE", connectionString, connectionUser,
					connectionPass);

			log.info("Start: " + " שליחת פקע פדקס מול מסד נתונים " + " Using data from DB");

			log.info("Run query for " + qMessage);
			Reporter.log("SQL Query which was executed: " + sSqlTransaction);
			Reporter.log("SQL Query Result: : " + sSqlTransaction);

			System.out.println("Content of the message: " + qMessage);
			Assert.assertTrue(qMessage.contains("FDX"),
					"Could not get the expected Message from DB after creating FEDEX pka");
			
			String sSqlTransactionWizard = Constant.getSqlFDXQueryCustomerWizard();
			sSqlTransactionWizard = sSqlTransactionWizard.replace("WWWWWWWW", sClientNumber);
			
			System.out.println("Content of the SQL: " + sSqlTransactionWizard);
			
			connectionString = GeneralUtility.getProperty("crmconnectionstringsolqa2");
			connectionUser = GeneralUtility.getProperty("crmconnectionusersolqa2");
			connectionPass = GeneralUtility.getProperty("crmconnectionpasssolqa2");
			String qMessageWizard = DBUtils.getValueFromDb_SetDB(sSqlTransactionWizard, "CALENDAR_ID", connectionString,
					connectionUser, connectionPass);
			
			
			log.info("Run query for " + qMessageWizard);
			Reporter.log("SQL Query which was executed: " + sSqlTransaction);
			Reporter.log("SQL Query Result: : " + qMessageWizard);

			System.out.println("Content of the message: " + qMessageWizard);
						
			Assert.assertTrue(qMessageWizard.contains("FDX"),
					"Could not get the expected Message from DB after creating FEDEX pka");

		} catch (AssertionError err) {
			log.error("נכשל ביצוע פקע פדקס");
			GeneralUtility.reportLogScreenshot(GeneralUtility.printScreen(driver, "Failed assert"));
			Reporter.getCurrentTestResult().setStatus(ITestResult.FAILURE);
			err.printStackTrace();
			Reporter.log(" נכשל ביצוע פקע פדקס");
			//System.exit(1);
			
		} catch (Exception ex) {
			log.error("Test result failed for checking DB ");
			GeneralUtility.reportLogScreenshot(GeneralUtility.printScreen(driver, "Failed assert"));
			Reporter.getCurrentTestResult().setStatus(ITestResult.FAILURE);
			ex.printStackTrace();
			Reporter.log(" נכשל ביצוע פקע פדקס");
			//System.exit(1);

		}
	
		System.out.println("data from excel: " + sClientNumber);
		log.info("Finish " + methodName);
	}

	@Test(dataProvider = "getDataFromDB_AdvancedSearchClients", priority = 1, enabled = false)
	public void Product360(String sClientNumber) throws InterruptedException, IOException {
		String methodName = "Product360";
		log.info("Start " + methodName);
		try {
			Assert.assertTrue(hp.searchSite(sClientNumber), "Could not get the expected page");
			Assert.assertTrue(ccp.goToSite(sClientNumber), "Could not get the expected objects or page in site page");
			Assert.assertTrue(csp.getProduct360(sClientNumber),
					"Could not get the expected object or page in direction page");
			Reporter.log(" בוצע בהצלחה ביצוע מוצר 360");

		} catch (AssertionError err) {
			log.error("Test result failed: " + methodName);
			GeneralUtility.reportLogScreenshot(GeneralUtility.printScreen(driver, "Failed assert"));
			Reporter.getCurrentTestResult().setStatus(ITestResult.FAILURE);
			err.printStackTrace();
			Reporter.log(" נכשל ביצוע מוצר 360");
		}

		System.out.println("data from DB: " + sClientNumber);
		log.info("Finish " + methodName);
	}

	@Test(dataProvider = "getDataFromExcel_AdvancedSearch", priority = 1, enabled = false)
	public void שליחת_דף_מקדים(String sAccountNumber) throws InterruptedException, IOException {
		String methodName = "שליחת_דף_מקדים";
		log.info("Start " + methodName);
		try {
			driver.quit();
			driver = GeneralUtility.getWebDriver(GeneralUtility.getProperty("browser2"),
					GeneralUtility.getProperty("crm"));
			cl = new CRMLogin(driver);
			hp = new CRMHomePage(driver);
			ccp = new CRMCustomerPage(driver);
			csp = new CRMSitePage(driver);
			cbp = new CRMBillPage(driver);
			System.setProperty(ESCAPE_PROPERTY, "false");
			try {
				Assert.assertTrue(
						cl.login(GeneralUtility.getProperty("usercrm"), GeneralUtility.getProperty("passcrm")),
						"Could not get the expected page after login");
			} catch (AssertionError err) {
				log.error("Test result failed: " + "Login failed");
				System.exit(1);
			}
			Assert.assertTrue(hp.searchSite(sAccountNumber), "Could not get the expected page");
			Assert.assertTrue(ccp.goToSite(sAccountNumber), "Could not get the expected page site page");
			Assert.assertTrue(csp.verifyMailExist(sAccountNumber), "Could not fill the mail address");
			Assert.assertTrue(csp.sendBill(sAccountNumber), "Could not get the expected send bill process");
			Assert.assertTrue(cbp.approveSendBill(sAccountNumber), "Could not get the expected bill approval process");
			Reporter.log(" בוצע בהצלחה בדיקה מול אתר סי.אר.אמ לשליחת מכתב מקדים");

		} catch (AssertionError err) {
			log.error("Test result failed: " + methodName);
			GeneralUtility.reportLogScreenshot(GeneralUtility.printScreen(driver, "Failed assert"));
			Reporter.getCurrentTestResult().setStatus(ITestResult.FAILURE);
			err.printStackTrace();
		}

		System.out.println("data from excel: " + sAccountNumber);
		log.info("Finish " + methodName);
	}

	@Test(dataProvider = "getDataFromExcel_AdvancedSearch", priority = 2, dependsOnMethods = {"שליחת_דף_מקדים" }, enabled = false)
	public void שליחת_דף_מקדים_בדיקה_מסד_נתונים(String sAccountNumber) throws Exception {
		String Transaction_id = "";
		String[][] tabArray = null;

		log.info("Start: " + " שליחת דף מקדים מול מסד נתונים " + " Using data from DB");

		try {
			String sSqltransaction_id = Constant.getsSqltransaction_id();
			sSqltransaction_id = sSqltransaction_id.replace("XXXXXX", sAccountNumber);
			Transaction_id = DBUtils.getValueFromDb_SetDB(sSqltransaction_id, "transaction_id",
					GeneralUtility.getProperty("crmconnectionstring"), GeneralUtility.getProperty("crmconnectionuser"),
					GeneralUtility.getProperty("crmconnectionpass"));
			Reporter.log(" בוצעה בדיקה מול מסד נתונים לבדיקת שליחת מכתב על פי טרנזקציה עכשיות");
			log.info("Run query for " + sAccountNumber + " and transaction id: " + Transaction_id);

		} catch (AssertionError e) {
			log.error("Test result failed for checking DB ");
			GeneralUtility.reportLogScreenshot(GeneralUtility.printScreen(driver, "Failed assert"));
			Reporter.getCurrentTestResult().setStatus(ITestResult.FAILURE);
			e.printStackTrace();

		} catch (Exception ex) {
			log.error("Test result failed for checking DB ");
			GeneralUtility.reportLogScreenshot(GeneralUtility.printScreen(driver, "Failed assert"));
			Reporter.getCurrentTestResult().setStatus(ITestResult.FAILURE);
			ex.printStackTrace();

		}

		try {
			String sSqlTransaction = Constant.getsSqlTransaction();
			sSqlTransaction = sSqlTransaction.replace("TTTTTT", Transaction_id);
			// Get the results
			tabArray = DBUtils.getDataFromDB_AdvancedSearchUtil(sSqlTransaction,
					GeneralUtility.getProperty("crmconnectionstring"), GeneralUtility.getProperty("crmconnectionuser"),
					GeneralUtility.getProperty("crmconnectionpass"));
			Assert.assertTrue(GeneralUtility.scanTableColumn(tabArray, 3, "OK"),
					"Could not get the expected results for table array from the query");
			log.info("Run query for " + sAccountNumber + " and transaction id: " + Transaction_id);

		} catch (

		AssertionError e) {
			log.error("Test result failed for checking DB ");
			GeneralUtility.reportLogScreenshot(GeneralUtility.printScreen(driver, "Failed assert"));
			Reporter.getCurrentTestResult().setStatus(ITestResult.FAILURE);
			e.printStackTrace();

		}

		log.info("Finish: Test " + " שליחת דף מקדים מול מסד נתונים ");
	}

	@DataProvider(name = "getDataFromDB_AdvancedSearchClients")
	public Object[][] getDataFromDB_AdvancedSearchClients() throws Exception {
		String[][] tabArray = null;

		String sSqlQueryCustomer = Constant.getsSqlQueryCustomer();
		tabArray = DBUtils.getDataFromDB_AdvancedSearchUtil(sSqlQueryCustomer,
				GeneralUtility.getProperty("crmconnectionstringsolqa2"),
				GeneralUtility.getProperty("crmconnectionusersolqa2"),
				GeneralUtility.getProperty("crmconnectionpasssolqa2"));
		return tabArray;
	}

	@DataProvider(name = "getDataFromExcel_AdvancedSearch")
	public Object[][] getDataFromExcel_AdvancedSearch() throws Exception {
		// Excel excel = new Excel();
		String sExcelPath = GeneralUtility.getProperty("excelcrm");
		String sExcelSheet = GeneralUtility.getProperty("excelsheetcrm1");
		// Return the data in cells for Excel sheet
		return ExcelUtils.getTableArray(sExcelPath, sExcelSheet);
	}

	@DataProvider(name = "getDataFromExcel_AdvancedSearchClients")
	public Object[][] getDataFromExcel_AdvancedSearchClients() throws Exception {
		// Excel excel = new Excel();
		String sExcelPath = GeneralUtility.getProperty("excelcrm");
		String sExcelSheet = GeneralUtility.getProperty("excelsheetcrm2");
		// Return the data in cells for Excel sheet
		return ExcelUtils.getTableArray(sExcelPath, sExcelSheet);
	}

	@AfterMethod
	public void Exit_Clean_After_Test() throws IOException, InterruptedException {
		driver.navigate().to(GeneralUtility.getProperty("crmmain"));
		log.info("After method ...");

	}

	@AfterClass
	public void End_Exectuion() throws IOException, InterruptedException {
		log.info("After Class ...");
		Thread.sleep(2000);
		GeneralUtility.tearDown(driver);
		// GeneralUtility.SendMail();
	}

}
