package com.comcast.crm.orgtest;

import java.beans.Transient;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import generic_utility.FileUtility;
import generic_utility.WebDriverUtility;
import object_reprository.LoginPage;
import object_reprository.Organization;
import object_reprository.SignOut;

public class CreateOrgTest {
	
	@Test

	public void CreateOrganization() throws IOException, InterruptedException {
	

// getting the data from property file
	
	FileUtility fUtil = new FileUtility();
	
	
	      String BROWSER = fUtil.getDataFromPropertiesFile("browser");
	      String URL = fUtil.getDataFromPropertiesFile("url");
	      String USERNAME = fUtil.getDataFromPropertiesFile("username");
	      String PASSWORD = fUtil.getDataFromPropertiesFile("password");
	      
// getting data from excel file
	      
	     String orgName =  fUtil.getDataFromExcelFile("org", 3, 3);
	      
//  opening browser
	      
	    		  
	WebDriver driver = null;
	
	if(BROWSER.equals("chrome")) {
		driver = new ChromeDriver();
	}
	else if(BROWSER.equals("edge")) {
		driver = new EdgeDriver();
	}else if(BROWSER.equals("firefox")) {
		driver = new FirefoxDriver();
	}else {
		driver = new ChromeDriver();
	}
	
	
	WebDriverUtility wdUtil = new WebDriverUtility (driver);
	
	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	
	
	
	// login into vtiger crm
	
	driver.get(URL);
	
	LoginPage lp = new LoginPage(driver);
	WebElement username =  lp.getUsername();
	username.sendKeys("admin");
	WebElement password = lp.getPassword();
	password.sendKeys("admin");
	WebElement clickOnLoginBtn =lp.getLoginbutton();
	clickOnLoginBtn.click();
	 	
	
	//creating organisation
	
	Organization org = new Organization(driver);
	WebElement clickOnOrg =org.getClickOnOrg();
	clickOnOrg.click();
	WebElement clickOnCreateOrg =org.getCreateOrg();
	clickOnCreateOrg.click();
	
			
	//generating organization name with random number
	      
	    WebElement orgField = org.getOrgField();
	        
     	 String apple = "monkey"+ (int) (Math.random()* 999);
		 
		 orgField.sendKeys(apple);
		 
//		 clicking on save button
		 
		 WebElement clickOnSaveBtn = org.getClickOnSaveBtn();
		 clickOnSaveBtn.click();
				 
   // verification of organization name
		 
		 WebElement header =org.getHeader();
		 String actualOrgName = header.getText();
		 
		 if(actualOrgName.contains(apple)) {
			 System.out.println("created organization successfully");
			 
		 }else {
			 System.out.println("failed!!!");
		 }
		 
//   Logout
		 SignOut so = new SignOut(driver);
		 WebElement hoverOnProfile  =so.getProfile();
		 wdUtil.hover(hoverOnProfile);
		 WebElement clickOnSignOut = so.getSignout();
		 clickOnSignOut.click();
		 
		 	 
// close the browser
		 
		 Thread.sleep(5000);
		 wdUtil.closingBrowser();
				 
}   

}
