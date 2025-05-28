package com.comcast.crm.moretest;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Driver;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

import generic_utility.FileUtility;
import generic_utility.WebDriverUtility;
import object_reprository.AddMore;
import object_reprository.LoginPage;
import object_reprository.SignOut;

public class AddMoreTest {
	@Test
	
	public void AddMore() throws IOException {

// get data from property file
		
				FileUtility fUtil = new FileUtility();
				
				
			      String BROWSER = fUtil.getDataFromPropertiesFile("browser");
			      String URL = fUtil.getDataFromPropertiesFile("url");
			      String USERNAME = fUtil.getDataFromPropertiesFile("username");
			      String PASSWORD = fUtil.getDataFromPropertiesFile("password");
			      
//getting data from excel file
			      
			     String orgName =  fUtil.getDataFromExcelFile("org", 3, 3);
		
// open browser
		
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
	
	
// click on more module
	AddMore am = new AddMore(driver);
	
	WebElement more =am.getHoverOnMore();
	wdUtil.hover(more);
	
// click on invoice element
	
	am.getClickOnInvoice().click();
	
// click on plus button to  add invoice
	
	am.getClickOnPlusBtn().click();
	
    am.getPassSubject().sendKeys("cancle invoice");
    am.getBillingAdd().sendKeys("andheri,mumbai");              // billing address 
    am.getShpingAdd().sendKeys("noida,sector-16,qspider");      // shipping address 
    
 // for orgination name , use window handles
    
    am.getClickOnImg().click();
    String parentid = driver.getWindowHandle();
    Set<String> ids = driver.getWindowHandles();
 
    
    for(String id : ids) {
    	driver.switchTo().window(id);
    }
    
    am.getPassText().sendKeys("so5");
    am.getClickOnSearch().click();
    am.getClickOnSovent().click();
    driver.switchTo().window(parentid);
    
 // log out
      SignOut so = new SignOut(driver);
      WebElement hoverOnProfile = so.getProfile();
	  wdUtil.hover(hoverOnProfile);
	  so.getSignout().click();
	  
// close window
	  
	  wdUtil.closingBrowser(); 
    
    
    
	
		

	}

}
