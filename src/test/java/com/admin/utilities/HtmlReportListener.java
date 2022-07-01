package com.admin.utilities;



import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.admin.testcases.TestBase;
import com.admin.utilities.genericFunctions;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class HtmlReportListener implements ITestListener  {

	public static String[] sDataGuest=null;
	public static Map<String,String> testdataMap;
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	
	@Override
	public void onTestStart(ITestResult result) {
		
	try {
	    System.out.println(result.getName()+" test case started");						
		//sDataGuest=GenericLibrary.toReadExcelData("GuestLogin_TestData", result.getName());
	    String[] sheetName = result.getName().split("_");
	    System.out.println("We are sreaching the testcase in sheet name = "+sheetName[0]);
	    
	    //testdataMap = genericFunctions.toReadExcelDataForTestCase("getAssetClassDetails", result.getName());
	    testdataMap = genericFunctions.toReadExcelDataForTestCase(sheetName[0], result.getName());
		
	} catch (EncryptedDocumentException|InvalidFormatException|IOException e) {
	 e.printStackTrace();
	
	}	
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.pass(MarkupHelper.createLabel(result.getName()+" has Passed", ExtentColor.GREEN));
	
	}

	@Override
	public void onTestFailure(ITestResult result) {
	
		try {
			test.fail(MarkupHelper.createLabel(result.getName()+"has failed due to following issue", ExtentColor.RED));
			 test.fail(result.getThrowable());
			 test.fail("Test Case failure screenshot is below");
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	 
	/* try {
		test.addScreenCaptureFromPath(GenericLibrary.getVisibleAreaScreenshot(TestBase.driver, result.getName()));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}*/
	 
	}

	@Override
	public void onTestSkipped(ITestResult result) {
	test.skip(MarkupHelper.createLabel(result.getName()+"has skipped due to following issues", ExtentColor.ORANGE));
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	@Override
	public void onStart(ITestContext context) {
	Date date = new Date();
	SimpleDateFormat sdf= new SimpleDateFormat("dd-MM-yyyy_hh_mm_ss");
	String sDate=sdf.format(date);
	
	htmlReporter=new ExtentHtmlReporter(new File(TestBase.sDirPath+"\\Reports\\"+sDate+"HtmlReport.html"));
	htmlReporter.setAppendExisting(true);
	extent=new ExtentReports();
	extent.attachReporter(htmlReporter);
	
	//System information
	extent.setSystemInfo("AuthorName", "Raikar");
	extent.setSystemInfo("OS","Windows 10");
	extent.setSystemInfo("PlatformName", "Chrome Web");
	extent.setSystemInfo("PlatformVersion", "102");
	extent.setSystemInfo("Build Name", "2.0");
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		// test case finished
	extent.flush();

	}

	
}

