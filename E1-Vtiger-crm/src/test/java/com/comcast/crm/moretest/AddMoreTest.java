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

import generic_utility.FileUtility;
import generic_utility.WebDriverUtility;

public class AddMoreTest {

	public static void main(String[] args) throws IOException {
		
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
	driver.findElement(By.name("user_name")).sendKeys("admin");
	driver.findElement(By.name("user_password")).sendKeys("admin");
	driver.findElement(By.cssSelector("input[type='submit']")).submit();
	
	
// click on more module
	
	WebElement more = driver.findElement(By.linkText("More"));
	
	
	wdUtil.hover(more);
	
// click on invoice element
	
	driver.findElement(By.linkText("Invoice")).click();
	
// click on plus button to  add invoice
	
	driver.findElement(By.cssSelector("img[src='themes/softed/images/btnL3Add.gif']")).click();
	
    driver.findElement(By.name("subject")).sendKeys("cancle invoice");
    driver.findElement(By.cssSelector("textarea[name=\"bill_street\"]")).sendKeys("noida,sector-16,qspider"); // billing address 
    driver.findElement(By.cssSelector("textarea[name=\"ship_street\"]")).sendKeys("new delhi, vivek vihar");  // shipping address 
    
 // for orgination name , use window handles
    
    driver.findElement(By.cssSelector("img[src=\"themes/softed/images/select.gif\"]")).click();
    String parentid = driver.getWindowHandle();
    Set<String> ids = driver.getWindowHandles();
 
    
    for(String id : ids) {
    	driver.switchTo().window(id);
    }
    
    driver.findElement(By.cssSelector("input[type=\"text\"]")).sendKeys("so5");
    driver.findElement(By.name("search")).click();
    driver.findElement(By.linkText("SO_vendtl")).click();
    driver.switchTo().window(parentid);
    
 // log out
    WebElement profile = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	 wdUtil.hover(profile);
	  driver.findElement(By.linkText("Sign Out")).click();
	  
// close window
	  
	  wdUtil.closingBrowser(); 
    
    
    
	
		

	}

}
