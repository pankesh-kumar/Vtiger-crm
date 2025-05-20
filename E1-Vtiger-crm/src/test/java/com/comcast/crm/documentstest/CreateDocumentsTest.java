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

import generic_utility.FileUtility;
import generic_utility.WebDriverUtility;

public class CreateDocumentsTest {

	public static void main(String[] args) throws IOException {
		
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
		driver.findElement(By.name("user_name")).sendKeys("admin");    
		driver.findElement(By.name("user_password")).sendKeys("admin");
		
		driver.findElement(By.cssSelector("input[type='submit']")).submit();
		
// Create Documents
		
		driver.findElement(By.linkText("Documents")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		driver.findElement(By.xpath("//input[@name='notes_title']")).sendKeys("operation-sindoor");
		
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
		
		driver.findElement(By.cssSelector("input[type='submit']")).click();
		
// log out
		
		WebElement profile = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
		wdutil.hover(profile);
		
		driver.findElement(By.linkText("Sign Out")).click();
		
		
// close the browser		
		
		
		wdutil.closingBrowser();
		
		
				

	}

}
