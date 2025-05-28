package com.comcast.crm.dashboardtest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import generic_utility.FileUtility;
import generic_utility.WebDriverUtility;
import object_reprository.LoginPage;
import object_reprository.SignOut;

public class ShowDashBoardTest {
	@Test
	public void ShowDashBoard() throws IOException, InterruptedException {
	
//  get the data from property file
		
		FileUtility futil = new FileUtility();
		
		
		String BROWSER = futil.getDataFromPropertiesFile("browser");
		String URL = futil.getDataFromPropertiesFile("url");
		String USERNAME = futil.getDataFromPropertiesFile("username");
		String PASSWORD = futil.getDataFromPropertiesFile("password");
		
		
// get the data from excel file
		
		 String dashbord = futil.getDataFromExcelFile("org", 2, 1);
		
// opening browser
		
		WebDriver driver = null;
		
		if(BROWSER.equals("Chrome")) {
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
		

// webdriver util
		
		WebDriverUtility wdutil = new WebDriverUtility(driver);
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
// login into vtiger-crm
		
		driver.get(URL);
		LoginPage lp = new LoginPage(driver);
		lp.getUsername().sendKeys("admin");
		lp.getPassword().sendKeys("admin");
		lp.getLoginbutton().click();
		
// click on dashboard 
		
		driver.findElement(By.linkText("Dashboard")).click();
		
// click on dropdown
		
		 WebElement dashboard = driver.findElement(By.id("dashboard_combo"));
		 Select seldashboard = new Select(dashboard);
		  Boolean status = seldashboard.isMultiple();                           // check is multiple dropdown or not
		  System.out.println(status);
		  
	       List<WebElement>  dashboards= seldashboard.getOptions();            // print all dropdown 
	       for(WebElement i : dashboards) {
	    	   System.out.println(i.getText());
	       }
		  seldashboard.selectByVisibleText("Leads By Source");                 //select drop down by visible text 
		  
		  seldashboard.selectByVisibleText("Sales by Organizations");
		  
		  Actions a = new Actions(driver);
		  WebElement selectpiechart = driver.findElement(By.cssSelector("area[shape='polygon']"));
		  a.scrollToElement(selectpiechart).perform();
		  Thread.sleep(3000);
	
		  selectpiechart.click();
		  
		  
// logout 
		  SignOut so = new SignOut(driver);
			 WebElement hoverOnProfile = so.getProfile();
			 wdutil.hover(hoverOnProfile);
			
			 wdutil.hover(hoverOnProfile);
		  
// close browser
		  
		  driver.close();
		  driver.quit();

	}

}
