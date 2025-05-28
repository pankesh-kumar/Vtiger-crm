package com.comcast.crm.moretest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.Alert;
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
import object_reprository.DeleteMore;
import object_reprository.LoginPage;
import object_reprository.SignOut;

public class DeleteMoreTest {
	@Test
	public void DeleteMore() throws IOException {

		
// get data from property file
		
		FileUtility fUtil = new FileUtility();
		
		
	      String BROWSER = fUtil.getDataFromPropertiesFile("browser");
	      String URL = fUtil.getDataFromPropertiesFile("url");
	      String USERNAME = fUtil.getDataFromPropertiesFile("username");
	      String PASSWORD = fUtil.getDataFromPropertiesFile("password");
	      
//getting data from excel file
	      
	     String orgName =  fUtil.getDataFromExcelFile("org", 3, 3);
		
// OPEN BROWSER
		
		WebDriver driver = null;
		
		if(BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		}else if(BROWSER.equals("edge")) {
			driver = new EdgeDriver();
					
		}else if(BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
					
		}else if(BROWSER.equals("safari")) {
			driver = new SafariDriver();
		}else {
			driver = new ChromeDriver();
		}
		
		
// webdriver utility
		
		WebDriverUtility wdUtil = new WebDriverUtility (driver);
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		
// login into vtiger-crm
		
		driver.get(URL);
		LoginPage lp = new LoginPage(driver);
		lp.getUsername().sendKeys("admin");
		lp.getPassword().sendKeys("admin");
		lp.getLoginbutton().click();
		
// hover on more module
		DeleteMore dm = new DeleteMore(driver);
		WebElement more = dm.getClickOnMore();     // inspect more module
		more.click();                                                
		wdUtil.hover(more);                                 // perform hover on more module
		
//  click on FAQ element 
		
		dm.getClickOnFAQ().click();       // inspect ->source->freez(F8 button)->element->write xpath.
		
// click on check box
		
		dm.getClickOnCheckBox().click();
// delete select element
		
		dm.getDeleteElement().click();
		
// handle popup
		
		wdUtil.alert();
		
// log out
		
		SignOut so = new SignOut(driver);
	      WebElement hoverOnProfile = so.getProfile();
		  wdUtil.hover(hoverOnProfile);
		  so.getSignout().click();
		  
// close window
		  
		  wdUtil.closingBrowser();
	}

}
