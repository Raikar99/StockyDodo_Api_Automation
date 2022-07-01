package com.admin.testcases;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

/*import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
*/
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class TestBase {

	public static RequestSpecification httpsRequest;
	public static Response response;

	
	  
	public static FileInputStream fileInput = null;
	
	public static Properties prop = new Properties();

	public static Logger logger;

	public static String sDirPath = System.getProperty("user.dir");

	@BeforeClass
	void setup() throws InterruptedException, IOException {

		File file = new File(sDirPath+"\\config.properties");
		try {
			fileInput = new FileInputStream(file);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		prop.load(fileInput);
		
		
		logger = Logger.getLogger(TestBase.class);// added Logger
		//PropertyConfigurator.configure("C:\\Users\\USER\\Desktop\\Raikar\\Raikar\\New folder\\Dodo_Admin_API_Automation\\test-outputs\\log4j.properties"); // added
		PropertyConfigurator.configure(sDirPath+"\\test-outputs\\log4j.properties"); // added
																																// logger

		logger.info("*****************StockyDODO ADmin Rest API's Logs*********************");

		logger.info("****************Started SDD_002_Admin_getAllAssetClassDetails*****************");

		// Base URI
     //   RestAssured.baseURI = "https://ewnnpgsmed.execute-api.ap-south-1.amazonaws.com/qa/admin";

		RestAssured.baseURI =prop.getProperty("StagingURL");
		// Request Object
		httpsRequest = RestAssured.given();

		// Request payload sending along with post request

	}

	@AfterClass
	void tearDown() {
		logger.info("************** Finished the SDD_002_Admin_getAllAssetClassDetails ***********");
	}

	//static ExtentTest test;
//	static ExtentReports report;
	
	/*
	 * @BeforeTest public static void startTest() { //report = new
	 * ExtentReports(System.getProperty("user.dir")+"ExtentReportResults.html");
	 * report = new ExtentReports(sDirPath+"\\Reports\\ExtentReportResults.html");
	 * 
	 * 
	 * report .addSystemInfo("Host Name", "SoftwareTestingMaterial")
	 * .addSystemInfo("Environment", "Automation Testing")
	 * .addSystemInfo("User Name", "Rajkumar SM"); //loading the external xml file
	 * (i.e., extent-config.xml) which was placed under the base directory //You
	 * could find the xml file below. Create xml file in your project and copy past
	 * the code mentioned below report.loadConfig(new
	 * File(System.getProperty("user.dir")+"\\extent-config.xml")); //test =
	 * report.startTest("ExtentDemo"); }
	 */

	/*
	 * @Test public void extentReportsDemo() {
	 * System.setProperty("webdriver.chrome.driver",
	 * "D:SubmittalExchange_TFSQAAutomation3rdpartychromechromedriver.exe");
	 * WebDriver driver = new ChromeDriver();
	 * driver.get("https://www.google.co.in");
	 * if(driver.getTitle().equals("Google")) { test.log(LogStatus.PASS,
	 * "Navigated to the specified URL"); } else { test.log(LogStatus.FAIL,
	 * "Test Failed"); } }
	 */
	/*
	 * @AfterTest public static void endTest() { report.endTest(test);
	 * report.flush(); }
	 */
/*
	@BeforeTest
	public static void startTest() {
		// report = new
		// ExtentReports(System.getProperty("user.dir")+"ExtentReportResults.html");
		report = new ExtentReports(sDirPath + "\\Reports\\ExtentReportResults.html");

		report.addSystemInfo("Host Name", "SoftwareTestingMaterial").addSystemInfo("Environment", "Automation Testing")
				.addSystemInfo("User Name", "Rajkumar SM");
		// loading the external xml file (i.e., extent-config.xml) which was placed
		// under the base directory
		// You could find the xml file below. Create xml file in your project and copy
		// past the code mentioned below
		report.loadConfig(new File(System.getProperty("user.dir") + "\\extent-config.xml"));
	}

	@AfterTest
	public static void endTest()
	{

	
	report.endTest(test);
	report.flush();
	}

	
	
	  
	  @AfterMethod public void getResult(ITestResult result){ 
		  //test=report.startTest(result.getName());
		  
		  if(result.getStatus()	== ITestResult.SUCCESS){ 
		  test.log(LogStatus.PASS,  "Test Case Passed is "+result.getName());
		  
		  }
		 
		  else if(result.getStatus()
	  == ITestResult.FAILURE){ test.log(LogStatus.FAIL,
	  "Test Case Failed is "+result.getName()); test.log(LogStatus.FAIL,
	  "Test Case Failed is "+result.getThrowable()); }else if(result.getStatus() ==
	  ITestResult.SKIP){ test.log(LogStatus.SKIP,
	  "Test Case Skipped is "+result.getName()); }
	
}
*/
}
