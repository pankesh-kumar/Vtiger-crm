package com.comcast.crm.calendartest;

import java.awt.Desktop.Action;
import java.awt.event.ActionEvent;
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
import org.testng.annotations.Test;

import generic_utility.FileUtility;
import generic_utility.WebDriverUtility;
import object_reprository.Calendar;
import object_reprository.LoginPage;
import object_reprository.SignOut;

public class CreatCalendarTest {
	@Test
	
	public void CreateCalendar() throws IOException {

		
// get data from property file
		
	FileUtility futil = new FileUtility();
	
	 String BROWSER =	futil.getDataFromPropertiesFile("browser");
	 String URL = futil.getDataFromPropertiesFile("url");
	 String USERNAME = futil.getDataFromPropertiesFile("username");
	 String PASSWORD = futil.getDataFromPropertiesFile("password");
	 
// get data from excel file
	 
	 String calendar = futil.getDataFromExcelFile("calendar", 3, 3);
	 

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
		
		
//  webdriverutility
		
		WebDriverUtility wdutil = new WebDriverUtility(driver);
		
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		
		
				
// login vtiger crm
		
		 driver.get(URL);
		 
		 LoginPage lp = new LoginPage(driver);
		 
		  WebElement username = lp.getUsername();
		  username.sendKeys("admin");
		  
		   WebElement password = lp.getPassword();
		   password.sendKeys("admin");
		   
		   WebElement loginbutton = lp.getLoginbutton();
		   loginbutton.click();
		 
				 
// create calendar
		   
		   Calendar cl = new Calendar(driver);
		   
		   WebElement clickOnCalendar = cl.getClickOnCalendar();
		   clickOnCalendar.click();
		 
		 WebElement selectDay = cl.getSelectDay();
		 selectDay.click();
		 
// hover on add button
		 
		 WebElement hoverOnAddBtn = cl.getHoverOnAddBtn();		 
		 wdutil.hover(hoverOnAddBtn);
		 
// click on ToDo button
		 
		  WebElement clickOnToDoBtn = cl.getClickOnToDoBtn();
		  clickOnToDoBtn.click();
				 
// create To Do		 
		 WebElement toDoFiled = cl.getToDoField();
		 		 
// generate random number
		 
		 String todoName = "DailyRoutine" +(int) (Math.random()*9999);
		 toDoFiled.sendKeys(calendar);
         
// select date, time & save To Do
       WebElement selectCalendar =  cl.getSelectCalendar();
       selectCalendar.click();
         WebElement selectDate = cl.getSelectDate();
         selectDate.click();
          WebElement saveToDo = cl.getSaveToDo();
          saveToDo.click();
                 
 // verification of To Do
           WebElement clickOnAllEvents = cl.getClickOnAllEventsAndToDo();
           clickOnAllEvents.click();
         WebElement clickOnDailyRoutine = cl.getClickOnDailyRoutine();
         clickOnDailyRoutine.click();
         WebElement inspectHeader = cl.getInspectHeader();         
         
        String actualToDOName = inspectHeader.getText();
        System.out.println(actualToDOName);
            
        	
// logout
        	SignOut so = new SignOut(driver);
        	WebElement profile = so.getProfile();      	
        	wdutil.hover(profile);
        	WebElement signout = so.getSignout();
        	signout.click();
        	
// close the browser
        	
        	wdutil.closingBrowser();
        	

        }
		 
		 

	}


