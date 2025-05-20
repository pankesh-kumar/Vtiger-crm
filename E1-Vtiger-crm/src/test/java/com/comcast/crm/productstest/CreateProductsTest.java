package com.comcast.crm.productstest;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.http.WebSocket;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import generic_utility.FileUtility;
import generic_utility.WebDriverUtility;

public class CreateProductsTest {

	public static void main(String[] args) throws IOException {
		
		
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
	driver.findElement(By.name("user_name")).sendKeys("admin");            // pass username of vtiger
	driver.findElement(By.name("user_password")).sendKeys("admin");        // pass password of vtiger
	driver.findElement(By.cssSelector("input[type='submit']")).submit();   // click on login button
	
	
// Create Products	
	
	driver.findElement(By.linkText("Products")).click();                                        // click on product module
	
	driver.findElement(By.cssSelector("img[src='themes/softed/images/btnL3Add.gif']")).click(); // click on plus icon and add products
	
	driver.findElement(By.name("productname")).sendKeys("s-400-missile");                      // pass product name 
	
	driver.findElement(By.cssSelector("input[title='Save [Alt+S]'")).click();                  // click on save button 
	

// log out
	
	 WebElement profile = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']")); // hover on profile
	 
	                       
	 wdUtil.hover(profile);                                      // to scroll target element
	 
	 driver.findElement(By.linkText("Sign Out")).click();       // inspect logout by using freeze method, f8 button use to freez.
	 
// close browser
	 
	 wdUtil.closingBrowser();  // close entire browser & terminate webdrive session
	 

	}

}
