package com.comcast.crm.calendartest;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import baseUtility.BaseClass;
import generic_utility.WebDriverUtility;
import object_reprository.Calendar;

public class CreatCalendarTest extends BaseClass {
	@Test
	
	public void CreateCalendar() throws IOException {
	 
// get data from excel file
	 
	 String calendar = fUtil.getDataFromExcelFile("calendar", 3, 3);
	 

		
//  webdriverutility
		
		WebDriverUtility wdutil = new WebDriverUtility(driver);
				 
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
            
        	
       	

        }
		 
		 

	}


