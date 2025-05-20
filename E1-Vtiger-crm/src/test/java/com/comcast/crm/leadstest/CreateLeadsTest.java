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

import generic_utility.FileUtility;
import generic_utility.WebDriverUtility;

public class CreateLeadsTest {
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
		 WebElement uname = driver.findElement(By.name("user_name"));
		uname.sendKeys("admin");
		
		WebElement password = driver.findElement(By.name("user_password"));
		password.sendKeys("admin");
		
	WebElement loginbtn =	driver.findElement(By.cssSelector("input[type='submit']"));
	loginbtn.submit();
	

// create leads
	
	driver.findElement(By.linkText("Leads")).click();
	WebElement plusbtn = driver.findElement(By.cssSelector("img[src='themes/softed/images/btnL3Add.gif']"));
	plusbtn.click();
	
	 WebElement leadNameField = driver.findElement(By.name("lastname"));
	String lastName = "pankesh"+ (int) (Math.random() * 9999);
	 leadNameField.sendKeys("lastName");
	 
	 WebElement companyName = driver.findElement(By.name("company"));
	 companyName.sendKeys("QA_Automation");
	 
	 WebElement saveBtn = driver.findElement(By.cssSelector("input[title=\"Save [Alt+S]\"]"));
	 saveBtn.click();
	 
//   verification of leads
	 
	 WebElement header = driver.findElement(By.className("dvHeaderText"));
	   String actualleadName  =header.getText();
	   
	   if(actualleadName.equals(lastName)) {
		   System.out.println("created leads successfully.....");
		   
	   }
	   
// logout
	  
	  WebElement profile = driver.findElement(By.cssSelector("img[src=\"themes/softed/images/user.PNG\"]"));
	  
	  
	  wdUtil.hover(profile);
	  
	  driver.findElement(By.linkText("Sign Out")).click();
	  
// close the browser
	  
	  Thread.sleep(5000);
	  wdUtil.closingBrowser();
}
}
