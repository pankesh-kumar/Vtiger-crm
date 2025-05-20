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

import generic_utility.FileUtility;
import generic_utility.WebDriverUtility;

public class CreateOpportunitiesTest {
public static void main(String[] args) throws InterruptedException, IOException {
	
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
	WebElement userName = driver.findElement(By.name("user_name"));
	userName.sendKeys("admin");
	
	WebElement password = driver.findElement(By.name("user_password"));
	password.sendKeys("admin");
	
	WebElement loginBtn = driver.findElement(By.id("submitButton"));
	loginBtn.submit();
	
// create opportunities 
	
	 WebElement clickOnOpportunities = driver.findElement(By.linkText("Opportunities"));
	 clickOnOpportunities.click();
	 
	  WebElement createOpportunities = driver.findElement(By.cssSelector("img[src='themes/softed/images/btnL3Add.gif']"));
	  createOpportunities.click();
	  
	  
	  
// generate random number 
	  
	  String opportunityInfo = "cucumber"+ (int) (Math.random()*9999);
	  
	  WebElement opportunityName = driver.findElement(By.name("potentialname"));
	  opportunityName.sendKeys(opportunityInfo);
	  
	  WebElement relatedTo = driver.findElement(By.cssSelector("img[src='themes/softed/images/select.gif']"));
	  relatedTo.click();
	  
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
     
	 WebElement search =  driver.findElement(By.id("search_txt"));
	 search.sendKeys("apple");
	  
	 
	 driver.findElement(By.name("search")).click();
	driver.findElement(By.linkText("apple")).click();

// now switch into the parent window	
	
	driver.switchTo().window(homeid);
	  
	  WebElement saveBtn = driver.findElement(By.cssSelector("input[title='Save [Alt+S]']"));
	  saveBtn.click();
	  
// log out
	  
	  WebElement profile =  driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
	  
	  	  wdUtil.hover(profile);
	  
// how to freez profile and inspect , inspect -> go to the source -> press F8 button 
//	  for freez element , now wright xpath.	  
	
	  driver.findElement(By.linkText("Sign Out")).click();
	
// close the browser
	
	wdUtil.closingBrowser();
	
	
}
}
