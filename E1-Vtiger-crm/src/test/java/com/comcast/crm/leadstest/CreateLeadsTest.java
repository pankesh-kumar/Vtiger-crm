package com.comcast.crm.leadstest;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import baseUtility.BaseClass;
import generic_utility.WebDriverUtility;
import object_reprository.Leads;

public class CreateLeadsTest extends BaseClass{
	@Test
	public void CreateLeads() throws IOException, InterruptedException {

//getting data from excel file
		      
		     String orgName =  fUtil.getDataFromExcelFile("org", 3, 3);

// webdriver utility
	
			WebDriverUtility wdUtil = new WebDriverUtility (driver);	

// create leads
	
		Leads le = new Leads(driver);
	    le.getClickOnLeads().click();
	
	   le.getClickOnPlusBtn().click();
	
	  le.getLeadFieldName().sendKeys("lastName");
	  String lastName = "pankesh"+ (int) (Math.random() * 9999);
	
	 
	 le.getCompanyName().sendKeys("QA_Automation");
	 le.getClickOnSaveBtn().click();
	 
//   verification of leads
	 
	 WebElement header = le.getHeader();
	   String actualleadName  =header.getText();
	   
	   if(actualleadName.equals(lastName)) {
		   System.out.println("created leads successfully.....");
		   
	   }
	   
}
}
