package com.comcast.crm.opportunitiestest;

import java.awt.Desktop.Action;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.bidi.module.Browser;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import generic_utility.FileUtility;
import generic_utility.WebDriverUtility;
import object_reprository.LoginPage;
import object_reprository.Opportunities;
import object_reprository.SignOut;

public class CreateOpportunitiesTest {
	@Test
	
	public void CreateOpportunities() throws IOException {

	
// get data from property file
	
			FileUtility fUtil = new FileUtility();
			
			
		      String BROWSER = fUtil.getDataFromPropertiesFile("browser");
		      String URL = fUtil.getDataFromPropertiesFile("url");
		      String USERNAME = fUtil.getDataFromPropertiesFile("username");
		      String PASSWORD = fUtil.getDataFromPropertiesFile("password");
		      
//getting data from excel file
		      
		     String orgName =  fUtil.getDataFromExcelFile("org", 3, 3);
	
// opening browser
	
     WebDriver driver = null;
     
     if(BROWSER.equals("chrome")) {
    	 driver = new ChromeDriver();
     }else if(BROWSER.equals("edge")) {
    	 driver = new EdgeDriver();
     }else if(BROWSER.equals("firefox")) {
        driver = new FirefoxDriver();
     }else {
         driver = new ChromeDriver();
     }
     
   
// webdriver utility
		
  		WebDriverUtility wdUtil = new WebDriverUtility (driver);  
  		
	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	
	
	 	
	
// login into vtiger crm
	
	driver.get(URL);
	LoginPage lp = new LoginPage(driver);
	lp.getUsername().sendKeys("admin");
	lp.getPassword().sendKeys("admin");
	lp.getLoginbutton().click();
	
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
	 	  
// log out
	  
	  SignOut so = new SignOut(driver);
	    WebElement hoverOnProfile =	so.getProfile();
	  
	  	  wdUtil.hover(hoverOnProfile);
	  
// how to freez profile and inspect , inspect -> go to the source -> press F8 button 
//	  for freez element , now wright xpath.	  
	
	  	so.getSignout().click();
	
// close the browser
	
	wdUtil.closingBrowser();
	
	
}
}
