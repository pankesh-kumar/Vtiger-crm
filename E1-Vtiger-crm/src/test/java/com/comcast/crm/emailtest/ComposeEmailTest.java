package com.comcast.crm.emailtest;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;

import generic_utility.FileUtility;
import generic_utility.WebDriverUtility;

public class ComposeEmailTest {

	public static void main(String[] args) throws AWTException, IOException {
		
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
		
// compose Email
		
		driver.findElement(By.linkText("Email")).click();
		driver.findElement(By.linkText("Compose")).click();
		
// window handle
		
		 String parentid = driver.getWindowHandle();                  // get parent window id
		  Set<String> childid = driver.getWindowHandles();            // get child and parent window id
		  System.out.println(childid);
	      childid.remove(parentid);                                     // remove parent id
		  
		   
		  
// click on plus button 
		  
		  driver.findElement(By.cssSelector("img[src='themes/softed/images/select.gif']")).click();
		  Set<String> childid1 = driver.getWindowHandles();
		  System.out.println(childid1);
		  childid1.remove(childid);
		  for(String id1 : childid1) {
			  driver.switchTo().window(id1);
			  
		  }
		  
// create KeyBoard Actions method
		  
		  Actions act = new Actions(driver);
	
		  for(int i=0;i<10;i++) {
			  
			act.keyDown(Keys.TAB).build().perform(); 
			act.keyUp(Keys.TAB).build().perform();
			
		  }
		    act.keyDown(Keys.ENTER).build().perform();
			act.keyUp(Keys.ENTER).build().perform();
		
// now switch into child window
			
		//	driver.switchTo().window(childid);
			
			driver.findElement(By.cssSelector("input[type='text']")).sendKeys("khkty");
			
			
// log out
			
			WebElement profile = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
			wdUtil.hover(profile);
			
			driver.findElement(By.linkText("Sign Out")).click();
			
// close the browser
			
			wdUtil.closingBrowser();

	}

}
