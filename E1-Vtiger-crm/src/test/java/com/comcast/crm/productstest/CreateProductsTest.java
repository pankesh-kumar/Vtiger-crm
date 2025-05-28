package com.comcast.crm.productstest;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.http.WebSocket;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.math3.stat.descriptive.summary.Product;
import org.openqa.selenium.By;
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
import object_reprository.Products;
import object_reprository.SignOut;

public class CreateProductsTest {
	@Test
	
	public void CreateProducts() throws IOException {

		
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
	
	driver.manage().window().maximize();                                // maximize window
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));  // apply implicit wait 
	
	driver.get("http://localhost:8888/");                               // pass vtiger url
	
	
// login into vtiger crm
	
	driver.get(URL);                                                       // pass vtiger url
	
	LoginPage lp = new LoginPage(driver);
	lp.getUsername().sendKeys("admin");                        // pass username of vtiger
	lp.getPassword().sendKeys("admin");                        // pass password of vtiger
	lp.getLoginbutton().submit();                               // click on login button
	
	
// Create Products	
	
	Products p = new Products(driver);
	p.getClickOnProduct().click();                                   // click on product module
	
	p.getClickOnPlus().click();                                      // click on plus icon and add products
	
	p.getPassProductName().sendKeys("juci mango");                   // pass product name 
	
	p.getClickOnSaveBtn().click();                                   // click on save button 
	

// log out
	SignOut so = new SignOut(driver);
	
	 WebElement hoverOnProfile = so.getProfile();       // hover on profile
	                    
	 wdUtil.hover(hoverOnProfile);                       // to scroll target element
	 
	 so.getSignout().click();                           // inspect logout by using freeze method, f8 button use to freez.
	 
// close browser
	 
	 wdUtil.closingBrowser();  // close entire browser & terminate webdrive session
	 

	}

}
