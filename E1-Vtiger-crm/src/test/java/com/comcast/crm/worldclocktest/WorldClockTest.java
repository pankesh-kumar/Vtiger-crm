package com.comcast.crm.worldclocktest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import baseUtility.BaseClass;
import generic_utility.WebDriverUtility;
import object_reprository.ClockTime;

public class WorldClockTest extends BaseClass{
	@Test
	public void WorldClock() throws IOException {

   
 // click on clock
	
	WebDriverUtility wdutil = new WebDriverUtility(driver);
	
   
	ClockTime ct =new  ClockTime(driver);
   
   ct.getClickOnWorldClock().click();
   WebElement country =ct.getCountry();
  
  wdutil.selectByVisibleText(country,"Bulgaria");

  
// WebDriver worldclock = ct.getInspectWorldClock();
// WebElement orders = ct.getOrders();
//  
//  
//  wdutil.dragAndDrop(worldclock, orders);                               // dragAndDrop method use 
  
  
      
		

	}

}
