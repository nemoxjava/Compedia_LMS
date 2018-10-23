package com.italam.data;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;

import com.framework.utility.ExcelUtils;
import com.framework.utility.GeneralUtility;
import com.italam.utility.Utility;



public class DataProviders {

	private static final Logger log = LogManager.getLogger(DataProviders.class.getName());

	
static String workDir = GeneralUtility.getUserDir(System.getProperty("user.dir"));
	
	
	public static String[] returnConnectionParams() throws IOException {
	
		String environment = Utility.getProperty("environment");
		String[] connectionDetails = new String[15];
		switch (environment) {
		
		
		case "test": {
			
			connectionDetails[0] = Utility.getProperty("testConnStringTest"); // TEST
			connectionDetails[1] = Utility.getProperty("testConnStringUserTest");
			connectionDetails[2] = Utility.getProperty("testConnStringPassTest");
			

			
			break;
		}
		case "testBackend": {
			
			connectionDetails[0] = Utility.getProperty("testConnStringTest"); // TEST
			connectionDetails[1] = Utility.getProperty("testConnStringUserTest");
			connectionDetails[2] = Utility.getProperty("testConnStringPassTest");
			

			
			break;
		}
		case "production": {
			
			
			break;
		}
		default:
			log.error("No proper environment was found");
			throw new SkipException("No proper Environment in crm xml...");
			

		}
		return connectionDetails;
	}
	
	
	@DataProvider(name = "GetToken_DataXls")
	public Object[][] getNextCustomerDataXls() throws Exception {
		String sExcelPath = GeneralUtility.getUserDir(System.getProperty("user.dir")) + Utility.getProperty("excelDoc");
		String sExcelSheet = Utility.getProperty("excelDocsheet1");
		log.info("Provide data from Next Excel to the test");
		GeneralUtility.sendReporter("Provide data from Next Excel to the test");
		//Will provide data from Excel sheet to the test
		return ExcelUtils.getTableArray(sExcelPath, sExcelSheet);
		
	}
		
	
	@DataProvider(name = "iteration")
	public Object[][] iteration() {
		// return new Object[][] { { 1 }, { 2 }, { 3 }, { 4 }, { 5 }, { 6 }, { 7 }, { 8
		// }, { 9 }, { 10 }, { 11 }, { 12 }, { 13 }, { 14 }, { 15 }, { 16 }, { 17 }, {
		// 18 }, { 19 } };
		// return new Object[][] { { 1 }, { 2 }, { 3 }, { 4 }, { 5 }, { 6 }, { 7 }, { 8
		// }, { 9 } };
		//return new Object[][] { { 1 }, { 2 }, { 3 }};
		 return new Object[][] { { 1 } };
	}

	@DataProvider(name = "iteration_2")
	public Object[][] iteration_2() {
		return new Object[][] { { 1 }, { 2 } };
	}

	@DataProvider(name = "iteration_3")
	public Object[][] iteration_3() {
		return new Object[][] { { 1 }, { 2 }, { 3 } };
	}

	
	
	
	
	
	// // ��� ���� ����� ������
	// @DataProvider(name = "getDataFromDB_AdvancedSearchClients")
	// public Object[][] getDataFromDB_AdvancedSearchClients() throws Exception {
	// String[][] tabArray = null;
	//
	// String sSqlQueryCustomer = Constant.getsSqlQueryCustomer();
	// tabArray = DBUtils.getDataFromDB_AdvancedSearchUtil(sSqlQueryCustomer,
	// GeneralUtility.getProperty("crmconnectionstringsolqa2"),
	// GeneralUtility.getProperty("crmconnectionusersolqa2"),
	// GeneralUtility.getProperty("crmconnectionpasssolqa2"));
	// return tabArray;
	// }
}
