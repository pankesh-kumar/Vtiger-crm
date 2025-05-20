package com.comcast.crm.troubleticketstest;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Driver;
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

public class GenerateTroubleTicketsTest {

	public static void main(String[] args) throws IOException, InterruptedException {
		
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
		
// click on trouble tickets and generate tickets
		
		driver.findElement(By.linkText("Trouble Tickets")).click();
		driver.findElement(By.cssSelector("img[src='themes/softed/images/btnL3Add.gif']")).click();  // click on plus icon
		driver.findElement(By.name("ticket_title")).sendKeys("sindoor operation ");                 // send value in title field
		driver.findElement(By.cssSelector("input[title='Save [Alt+S]']")).click();                  // click on save button
		
// logout
		
		WebElement profile = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		
		
		wdUtil.hover(profile);
		
		driver.findElement(By.linkText("Sign Out")).click();
		
// close the browser
		
		wdUtil.closingBrowser();
				
		
		

	}

}
