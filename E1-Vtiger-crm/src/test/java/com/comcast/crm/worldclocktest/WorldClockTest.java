package com.comcast.crm.worldclocktest;

import java.io.IOException;
import java.nio.channels.SelectableChannel;
import java.sql.Driver;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import generic_utility.FileUtility;
import generic_utility.WebDriverUtility;

public class WorldClockTest {

	public static void main(String[] args) throws IOException {
		
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
   driver.findElement(By.name("user_name")).sendKeys("admin");
   driver.findElement(By.name("user_password")).sendKeys("admin");
   driver.findElement(By.cssSelector("input[type='submit']")).submit();
   
 // click on clock
   
   driver.findElement(By.cssSelector("img[title=\"Show World Clock...\"]")).click();
  WebElement country  = driver.findElement(By.id("clockcity"));
  
  wdutil.selectByVisibleText(country,"Bulgaria");

  
 WebElement worldclock = driver.findElement(By.xpath("//b[text()='World Clock']"));
 WebElement orders =  driver.findElement(By.id("headerrow_12"));
  
  
  wdutil.dragAndDrop(worldclock, orders);                               // dragAndDrop method use 
  
  
 // log out 
  
  WebElement profile = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
  wdutil.hover(profile);
  driver.findElement(By.linkText("Sign Out")).click();
  
// close browser 
  wdutil.closingBrowser();
      
		

	}

}
