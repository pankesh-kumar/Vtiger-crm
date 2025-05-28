package com.comcast.crm.documentstest;

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
import org.testng.annotations.Test;

import generic_utility.FileUtility;
import generic_utility.WebDriverUtility;
import object_reprository.Documents;
import object_reprository.LoginPage;
import object_reprository.SignOut;

public class CreateDocumentsTest {
	@Test
	
	public void CreateDocuments() throws IOException {

		
// get the data from property file
		
		FileUtility futil = new FileUtility();
		
		String BROWSER = futil.getDataFromPropertiesFile("browser");
		String URL = futil.getDataFromPropertiesFile("url");
		String USERNAME = futil.getDataFromPropertiesFile("username");
		String PASSWORD = futil.getDataFromPropertiesFile("password");
		
// get data from excel file
		
		 String document = futil.getDataFromExcelFile("org", 1, 1);
		
// opening browser
		
	
		WebDriver driver = null;
		
		if(BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		}else if(BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		}else if(BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		}else {
			driver = new ChromeDriver();
		}
		
		
// webdriver utility
		
		WebDriverUtility wdutil = new WebDriverUtility(driver);
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
// login into vtiger crm
		driver.get(URL);
		LoginPage lp = new LoginPage(driver);
		lp.getUsername().sendKeys("admin");
		lp.getPassword().sendKeys("admin");
		lp.getLoginbutton().click();
		
// Create Documents
		Documents dc = new Documents(driver);
		
		dc.getClickOnDocuments().click();
		dc.getClickOnPlus().click();
		dc.getTitleField().sendKeys("operation-sindoor");
		
		Actions act = new Actions(driver);
		act.keyDown(Keys.TAB).build().perform();
		act.keyUp(Keys.TAB).build().perform();
		
		act.keyDown(Keys.TAB).build().perform();
		act.keyUp(Keys.TAB).build().perform();
		
		act.keyDown(Keys.TAB).build().perform();
		act.keyUp(Keys.TAB).build().perform();
		
		act.keyDown(Keys.TAB).build().perform();
		act.keyUp(Keys.TAB).build().perform();
		
		act.keyDown(Keys.TAB).build().perform();
		act.keyUp(Keys.TAB).build().perform();
		
				
		act.sendKeys("Operation Sindoor highlights: 12 civilians and one soldier killed in Pak shelling in J&K’s Poonch;"
				+ " Govt calls all-party meet on May 8").build().perform();
		
		dc.getClickOnSubmitBtn().click();
		
// log out
		
		 SignOut so = new SignOut(driver);
		 WebElement hoverOnProfile = so.getProfile();
		 wdutil.hover(hoverOnProfile);
		
		 so.getSignout().click();
		
		
// close the browser		
		
		
		wdutil.closingBrowser();
		
		
				

	}

}
