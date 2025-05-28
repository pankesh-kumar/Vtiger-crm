package com.comcast.crm.leadstest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Test;

import generic_utility.FileUtility;
import generic_utility.WebDriverUtility;
import object_reprository.Leads;
import object_reprository.LoginPage;
import object_reprository.SignOut;

public class CreateLeadsTest {
	@Test
	public void CreateLeads() throws IOException, InterruptedException {
//public static void main(String[] args) throws InterruptedException, IOException {
	
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
	}else if(BROWSER.equals("safari")) {
		driver = new SafariDriver();
	}else{
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
	   
// logout
	  
	   SignOut so = new SignOut(driver);
	    WebElement hoverOnProfile =	so.getProfile();
	  
	  	  wdUtil.hover(hoverOnProfile);
	  
// close the browser
	  
	  Thread.sleep(5000);
	  wdUtil.closingBrowser();
}
}
