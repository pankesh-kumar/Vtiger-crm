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

import generic_utility.FileUtility;
import generic_utility.WebDriverUtility;

public class CreatCalendarTest {

	public static void main(String[] args) throws InterruptedException, IOException {
		
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
		 
		 WebElement userName= driver.findElement(By.name("user_name"));
		 userName.sendKeys("admin");
		 
		 WebElement userPassword = driver.findElement(By.name("user_password"));
		 userPassword.sendKeys("admin");
		 
		 WebElement loginBtn= driver.findElement(By.id("submitButton"));
		 loginBtn.click();
		 
		 
// create calendar
		 
		 WebElement clickOnCalendar = driver.findElement(By.linkText("Calendar"));
		 clickOnCalendar.click();
		 
		 WebElement selectDay = driver.findElement(By.linkText("Day"));
		 selectDay.click();

// hover on add button
		  WebElement addBtn= driver.findElement(By.className("calAddButton"));
		 
		wdutil.hover(addBtn);
		 
// click on ToDo button
		 
		 WebElement clickOnTodoBtn  = driver.findElement(By.linkText("To Do"));
		 clickOnTodoBtn.click();
		 
// create To Do		 
		 
		 WebElement todoField = driver.findElement(By.name("task_subject"));
		 
// generate random number
		 
		 String todoName = "DailyRoutine" +(int) (Math.random()*9999);
         todoField.sendKeys(calendar);
         
// select date, time & save To Do
        
         WebElement selectCalendar = driver.findElement(By.id("jscal_trigger_task_date_start"));
         selectCalendar.click();
         
         WebElement setDate= driver.findElement(By.xpath("//td[text()='9']"));
         setDate.click();
         
         WebElement toDoSave = driver.findElement(By.name("todosave"));
         toDoSave.click();
         
 // verification of To Do
         driver.findElement(By.linkText("All Events & Todos")).click();
         driver.findElement(By.linkText("DailyRoutine")).click();
         
         WebElement header = driver.findElement(By.className("lvtHeaderText"));
         
        String actualToDOName =  header.getText();
        System.out.println(actualToDOName);
        
      //  if(actualToDOName.equals(todoName)) {
      //  	System.out.println("successfuly created!!!!!");
        
        	
// logout
        	
        	WebElement profile = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
        	
        	wdutil.hover(profile);
        	driver.findElement(By.linkText("Sign Out")).click();
        	
        	
// close the browser
        	
        	wdutil.closingBrowser();
        	

        }
		 
		 

	}


