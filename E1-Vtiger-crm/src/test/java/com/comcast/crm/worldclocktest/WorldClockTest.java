package com.comcast.crm.worldclocktest;

import java.io.IOException;
import java.nio.channels.SelectableChannel;
import java.sql.Driver;
import java.time.Clock;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import generic_utility.FileUtility;
import generic_utility.WebDriverUtility;
import object_reprository.ClockTime;
import object_reprository.LoginPage;
import object_reprository.SignOut;

public class WorldClockTest {
	@Test
	public void WorldClock() throws IOException {

		
// featch the datd from property file
		
		FileUtility futil = new FileUtility();
		 
		  String BROWSER =futil.getDataFromPropertiesFile("browser");
		  String URL = futil.getDataFromPropertiesFile("url");
		String USERNAME = futil.getDataFromPropertiesFile("username");
		String PASSWORD = futil.getDataFromPropertiesFile("password");
		

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
		
		
// WEBDRIVER UTILITY
		
		WebDriverUtility wdutil = new WebDriverUtility(driver);
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		
// login into vtiger-crm
    driver.get(URL);
    LoginPage lp = new LoginPage(driver);
	lp.getUsername().sendKeys("admin");
	lp.getPassword().sendKeys("admin");
	lp.getLoginbutton().click();
   
 // click on clock
   
//	ClockTime ct =new  ClockTime(driver);
//   
//   ct.getClickOnWorldClock().click();
//   WebElement country =ct.getCountry();
//  
//  wdutil.selectByVisibleText(country,"Bulgaria");
//
//  
// WebDriver worldclock = ct.getInspectWorldClock();
// WebElement orders = ct.getOrders();
//  
//  
//  wdutil.dragAndDrop(worldclock, orders);                               // dragAndDrop method use 
  
  
 // log out 
  
    SignOut so = new SignOut(driver);
    WebElement hoverOnProfile =	so.getProfile();
    wdutil.hover(hoverOnProfile);
    so.getSignout().click();
  
// close browser 
  wdutil.closingBrowser();
      
		

	}

}
