package com.admin.testcases;

import java.io.IOException;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.admin.utilities.HtmlReportListener;
import com.admin.utilities.genericFunctions;

public class assetClassDetails extends TestBase {

	public static Map<String, String> dataMap;

	/*
	 * @BeforeTest void setup122() throws InterruptedException {
	 * 
	 * System.out.println("from setup123");
	 * 
	 * }
	 */

	@Test
	void getAssetClassDetails_SDD_001_Admin_Post_assetClassDetails() throws EncryptedDocumentException, 
																	InvalidFormatException, IOException
		{
		
			HtmlReportListener.test=HtmlReportListener.extent.createTest("getAssetClassDetails_SDD_001_Admin_Post_assetClassDetails","to verify assetClassDetails is displayed");

			dataMap=HtmlReportListener.testdataMap;

		//	test = report.startTest(" Displaying checkResponseBody-2");
			// test.log(LogStatus.PASS, "Navigated to the specified URL2");
		//	System.out.println("Displaying");
    	 
		//dataMap = genericFunctions.toReadExcelDataForTestCase("getAssetClassDetails", "SDD_001_Admin_Post_assetClassDetails");
			
			
	    	logger.info("*****************StockyDODO ADmin Rest API's Logs*********************");

			System.out.println(dataMap.get("Param1"));
		 
			JSONObject requestParams = genericFunctions.jsonObject();
			

			httpsRequest.header(dataMap.get("Param7"), dataMap.get("Param8"));
			
			httpsRequest.body(dataMap.get("Param5")); //Attach above data to the request
		
	        response = httpsRequest.request(genericFunctions.method(dataMap.get("Param4")), dataMap.get("Param3"));

		
	        
	    	genericFunctions.checkResponseBody(response);
	    	
	    	
	    	
	    	
	    	long expectedTime = Long.parseLong(dataMap.get("Param12"));
	    	genericFunctions.checkResponseTime(response, expectedTime);
	    	
	    	
	    	logger.info("*****************StockyDODO ADmin Rest API's Logs*********************");

	    	
	    	

	    	genericFunctions.checkSuccessCode(response, dataMap.get("Param9"), dataMap.get("Param6"));
	    	
	    	
	    		logger.info("*****************StockyDODO ADmin Rest API's Logs*********************");


	    	    genericFunctions.checkContentEncodeing(response, dataMap.get("Param10"), dataMap.get("Param11"));
	    		}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * 
	 * 
	 * //@Test(priority=1)
	 * 
	 * @Test(priority=1) void SDD_002_Admin_Post_assetClassDetails() throws
	 * EncryptedDocumentException, InvalidFormatException, IOException { //
	 * JSONObject requestParams = new JSONObject();
	 * 
	 * dataMap=HtmlReportListener.testdataMap;
	 * HtmlReportListener.test=HtmlReportListener.extent.createTest(
	 * "assetClassDetails","to verify assetClassDetails is displayed");
	 * 
	 * /* test = report.startTest("checkResponseBody-2"); test.log(LogStatus.PASS,
	 * "Navigated to the specified URL2");
	 * 
	 * 
	 * //String[] Data = genericFunctions.toReadExcelData("getAssetClassDetails",
	 * "SDD_002");
	 * 
	 * 
	 * dataMap = genericFunctions.toReadExcelDataForTestCase("getAssetClassDetails",
	 * "SDD_002");
	 * 
	 * System.out.println(dataMap.get("Param1"));
	 * 
	 * JSONObject requestParams = genericFunctions.jsonObject();
	 * //requestParams.put("asset_class_id", "617a5a3811d0368d24d3f1b0"); //
	 * requestParams.put("page", 0); // requestParams.put("size", 10); //
	 * requestParams.put("query", ""); // requestParams.put("type", "");
	 * 
	 * 
	 * httpsRequest.header(dataMap.get("Param7"), dataMap.get("Param8"));
	 * 
	 * httpsRequest.body(dataMap.get("Param5")); //Attach above data to the request
	 * 
	 * 
	 * //Response object // response = httpsRequest.request(Method.POST,
	 * "/getAllAssetClasses"); response =
	 * httpsRequest.request(genericFunctions.method(dataMap.get("Param4")),
	 * dataMap.get("Param3"));
	 * 
	 * 
	 * //Print response in console window
	 * 
	 * String responseBody = response.getBody().asString();
	 * System.out.println("Response Body Is:" +responseBody);
	 * Assert.assertTrue(responseBody!=null);
	 * 
	 * genericFunctions.checkResponseBody(response);
	 * 
	 * 
	 * 
	 * 
	 * 
	 * long responseTime = response.getTime(); long expectedTime =
	 * Long.parseLong(dataMap.get("Param12")); Assert.assertTrue(responseTime <
	 * expectedTime );
	 * 
	 * long expectedTime = Long.parseLong(dataMap.get("Param12"));
	 * 
	 * genericFunctions.checkResponseTime(response, expectedTime);
	 * 
	 * 
	 * logger.
	 * info("*****************StockyDODO ADmin Rest API's Logs*********************"
	 * );
	 * 
	 * 
	 * //Success Code Validation // String SuccessCode =
	 * response.jsonPath().getString("status_code"); //
	 * Assert.assertEquals(SuccessCode, dataMap.get("Param6")); //null value
	 * 
	 * 
	 * // genericFunctions.checkContentEncodeing(response, dataMap.get("Param10"),
	 * dataMap.get("Param11"));
	 * 
	 * genericFunctions.checkSuccessCode(response, dataMap.get("Param9"),
	 * dataMap.get("Param6"));
	 * 
	 * 
	 * logger.
	 * info("*****************StockyDODO ADmin Rest API's Logs*********************"
	 * );
	 * 
	 * 
	 * genericFunctions.checkContentEncodeing(response, dataMap.get("Param10"),
	 * dataMap.get("Param11")); }
	 * 
	 */

}
