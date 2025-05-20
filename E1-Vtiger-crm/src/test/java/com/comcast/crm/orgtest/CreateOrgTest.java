package com.comcast.crm.orgtest;

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

import generic_utility.FileUtility;
import generic_utility.WebDriverUtility;

public class CreateOrgTest {
public static void main(String[] args) throws InterruptedException, IOException {
	

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
	 WebElement uname = driver.findElement(By.name("user_name"));
	uname.sendKeys("admin");
	
	WebElement password = driver.findElement(By.name("user_password"));
	password.sendKeys("admin");
	
	Actions act = new Actions(driver);
	
	act.keyDown(Keys.ENTER).build().perform();
	act.keyUp(Keys.ENTER).build().perform();
	
	Thread.sleep(30000);	
	
	
	//creating organisation
	
	driver.findElement(By.linkText("Organizations")).click();
	
	driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
	
	//generating organization name with random number
	      
	     WebElement orgField = driver.findElement(By.name("accountname"));
	     
     	 String apple = "monkey"+ (int) (Math.random()* 999);
		 
		 orgField.sendKeys(apple);
		 
		 //clicking on save button
		 
		 WebElement savebtn = driver.findElement(By.name("button"));
		 savebtn.click();
		 
   // verification of organization name
		 
		 WebElement header = driver.findElement(By.className("dvHeaderText"));
		 String actualOrgName = header.getText();
		 
		 if(actualOrgName.contains(apple)) {
			 System.out.println("created organization successfully");
			 
		 }else {
			 System.out.println("failed!!!");
		 }
		 
//   Logout
		 
		 WebElement profile = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
		 wdUtil.hover(profile);
		 
		 driver.findElement(By.linkText("Sign Out")).click();
		 
// close the browser
		 
		 Thread.sleep(5000);
		 wdUtil.closingBrowser();
				 
}   

}
