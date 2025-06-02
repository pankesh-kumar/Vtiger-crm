package com.comcast.crm.opportunitiestest;

import java.io.IOException;
import java.util.Set;

import org.testng.annotations.Test;

import baseUtility.BaseClass;
import generic_utility.WebDriverUtility;
import object_reprository.Opportunities;

public class CreateOpportunitiesTest extends BaseClass {
	@Test
	
	public void CreateOpportunities() throws IOException {
	      
//getting data from excel file
		      
		     String orgName =  fUtil.getDataFromExcelFile("org", 3, 3);
 
// webdriver utility
		
  		WebDriverUtility wdUtil = new WebDriverUtility (driver);  
  
// create opportunities 
	
	Opportunities opp = new Opportunities(driver);
	 opp.getClickOnOpportunity().click();
	 
	  opp.getCreateOpportunity().click();
	  
// generate random number 
	  
	  String opportunityInfo = "cucumber"+ (int) (Math.random()*9999);
	  opp.getOpportunityName().sendKeys("opportunityInfo");
	  opp.getClickOnRelatedTo().click();
	  
	  
// use window handles
	  
     String homeid = driver.getWindowHandle();
     System.out.println("parent "+homeid);
     
     Set<String>childid = driver.getWindowHandles();
     System.out.println(childid);
     childid.remove(homeid);
     
     for(String id : childid) {
    	 driver.switchTo().window(id);
     }
 
// pass value to child window     
     
	 opp.getSearchText().sendKeys("apple");
	 opp.getClickOnSearch().click();
	opp.getClickOnApple().click();

// now switch into the parent window	
	
	driver.switchTo().window(homeid);
	  
	  opp.getClickOnSaveBtn().click();
	 	  
	
}
}
