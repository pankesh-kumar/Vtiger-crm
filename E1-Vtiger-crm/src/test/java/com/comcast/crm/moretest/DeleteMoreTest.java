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

import generic_utility.FileUtility;
import generic_utility.WebDriverUtility;

public class DeleteMoreTest {

	public static void main(String[] args) throws IOException {
		
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
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.cssSelector("input[type='submit']")).submit();
		
// hover on more module
		
		WebElement more = driver.findElement(By.linkText("More"));     // inspect more module
		more.click();
		                                                    
		wdUtil.hover(more);                                 // perform hover on more module
		
//  click on FAQ element 
		
		driver.findElement(By.linkText("FAQ")).click();       // inspect ->source->freez(F8 button)->element->write xpath.
		
// click on check box
		
		driver.findElement(By.name("selected_id")).click();
// delete select element
		
		driver.findElement(By.cssSelector("input[value='Delete']")).click();
		
// handle popup
		
		
		wdUtil.alert();
		
// log out
		
		WebElement profile = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		  wdUtil.hover(profile);
		  driver.findElement(By.linkText("Sign Out")).click();
		  
// close window
		  
		  wdUtil.closingBrowser();
	}

}
