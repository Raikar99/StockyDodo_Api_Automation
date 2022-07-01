package com.admin.utilities;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.admin.testcases.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


   public class genericFunctions extends TestBase {

	   public static String sTestDataFile= TestBase.sDirPath+"\\Testdata.xlsx";
	   
	public static  JSONObject jsonObject() 
	{
		JSONObject requestParams = new JSONObject();
        return requestParams;
     
	}
	
	
	public static Method method(String methodname) {
		switch (methodname.toUpperCase()) {
		case "POST":
			return Method.POST;
		
		case "PUT":
			return Method.PUT;

		case "GET":
			return Method.GET;

		case "DELETE":
			return Method.DELETE;

		default:
			break;
		}
		return null;
	}
	
	public static String[] toReadExcelData(String sSheet,String sTestCaseID) throws EncryptedDocumentException, InvalidFormatException, IOException {
        
	    String[] sData=null;
	    FileInputStream fis=new FileInputStream(sTestDataFile);
	    Workbook wb =WorkbookFactory.create(fis);
	    Sheet sht= wb.getSheet(sSheet);
	    int rowNum=sht.getLastRowNum();
	    
	    for(int i=1;i<=rowNum;i++) {
	        
	    if(sht.getRow(i).getCell(0).toString().equals(sTestCaseID))
	    {
	        
	    int cellNum=sht.getRow(i).getLastCellNum();
	    sData=new String[cellNum];
	    
	    for(int j=0;j<cellNum;j++) {
	        
	        sData[j]=sht.getRow(i).getCell(j).getStringCellValue();
	        
	    }
	    break;  
	    }
	        
	    
	        
	    }
	    return sData;
	        
	    }
	
	
		public static  Map<String, String> toReadExcelDataForTestCase(String sSheet,String sTestCaseID) 
											throws EncryptedDocumentException, InvalidFormatException, IOException 
		{
        
	   // String[] sData=null;
	    
	    Map<String,String> map=new HashMap<>();
	    
	    FileInputStream fis=new FileInputStream(sTestDataFile);
	    Workbook wb =WorkbookFactory.create(fis);
	    Sheet sht= wb.getSheet(sSheet);
	    int rowNum=sht.getLastRowNum();
	    
	    for(int i=1;i<=rowNum;i++) {
	        
	    if(sht.getRow(i).getCell(0).toString().equals(sTestCaseID))
	    {
	        
	    int cellNum=sht.getRow(i).getLastCellNum();
	    //sData=new String[cellNum];
	    
	    for(int j=0;j<cellNum;j++) {
	        
	        //sData[j]=sht.getRow(i).getCell(j).getStringCellValue();
	        
	        map.put("Param"+j, sht.getRow(i).getCell(j).getStringCellValue());
	        
	    }
	    break;  
	    }
	        
	        
	        
	    }
	    return map;
	        
	    }
		public static RequestSpecification httpsRequest() 
		{
			   
			   Properties prop = getproperties();
		    
			//	public static RequestSpecification httpsRequest;
		
				RestAssured.baseURI = prop.getProperty("StagingURL");
		
				// Request Object
			 	httpsRequest = RestAssured.given();
			 	return httpsRequest;
			  
		}


		public static Properties getproperties() 
			{
				File file = new File(sDirPath + "config.properties");
				  
			FileInputStream fileInput = null;
			try {
				fileInput = new FileInputStream(file);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			Properties prop = new Properties();
			
			//load properties file
			try {
				prop.load(fileInput);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return prop;
			}
			
	
	//response Method validations

///////////////////////////////////////////////////////////////////////////////////////////
		
		    public static void checkResponseBody(Response response)
			{
		
		    	String responseBody = response.getBody().asString();
		    	System.out.println("Response Body Is:" +responseBody);
		    	Assert.assertTrue(responseBody!=null);
		    	
			}
		    
		    
		    
		    public static void checkContentEncodeing(Response response, String headerName, String headerValue)
			{
		
			String  ContentEncodeing = response.header(headerName);
			Assert.assertEquals(ContentEncodeing, headerValue);
	 		System.out.println("Content Encoded Formate is ==>" +ContentEncodeing);

			}
		
		    public static void checkSuccessCode(Response response, String SuccessCode, String expSuccessValue)
			{
		    	String actSuccessCode = response.jsonPath().getString(SuccessCode);
				Assert.assertEquals(actSuccessCode, expSuccessValue); 
		 		System.out.println("Status Code is ==>" +actSuccessCode);

			}
		
		    public static void checkResponseTime(Response response, long expResponseValue)
		 	{
		 		long  responseTime = response.getTime();
		 		Assert.assertTrue(responseTime < expResponseValue );
		 		System.out.println("Response Time is ==>" +responseTime);
		 	}
		    
		    public static void PrintContentType(Response response)
		 			{
		 		
		 			String  ContentType = response.header("Content-Type");
			    	System.out.println("Content Type is ==>" +ContentType);
					Assert.assertEquals(ContentType, "application/json; charset=utf-8");

		 			}
		    
		
		    public static void printContentLength(Response response)
		    {
		    	
		    	String actualContentLength = response.header("Content-Length");
		    	System.out.println("Content Length is ==>" +actualContentLength);
		 		
		 	
		    }	
		 		
		 	
		 	  
		  
 }