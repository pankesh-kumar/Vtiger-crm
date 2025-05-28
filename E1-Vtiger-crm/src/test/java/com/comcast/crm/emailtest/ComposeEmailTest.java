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
import org.testng.annotations.Test;

import generic_utility.FileUtility;
import generic_utility.WebDriverUtility;
import object_reprository.Email;
import object_reprository.LoginPage;
import object_reprository.SignOut;

public class ComposeEmailTest {
	@Test
	public void ComposeEmail() throws IOException {

			
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
		LoginPage lp = new LoginPage(driver);
		lp.getUsername().sendKeys("admin");
		lp.getPassword().sendKeys("admin");
		lp.getLoginbutton().click();
		
// compose Email
		Email e = new Email(driver);
		e.getClickOnEmail().click();
		e.getClickOnCompose().click();
		
// window handle
		
		 String parentid = driver.getWindowHandle();                  // get parent window id
		  Set<String> childid = driver.getWindowHandles();            // get child and parent window id
		  System.out.println(childid);
	      childid.remove(parentid);                                     // remove parent id
		  
		   
		  
// click on plus button 
		  
		  e.getClickOnPlusBtn().click();
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
			
			e.getPassText().sendKeys("this is compose");
			
			
// log out
			
			    SignOut so = new SignOut(driver);
			    WebElement hoverOnProfile =	so.getProfile();
			  
			    wdUtil.hover(hoverOnProfile);
			
// close the browser
			
			wdUtil.closingBrowser();

	}

}
