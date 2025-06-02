package com.comcast.crm.emailtest;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import baseUtility.BaseClass;
import generic_utility.WebDriverUtility;
import object_reprository.Email;

public class ComposeEmailTest extends BaseClass{
	@Test
	public void ComposeEmail() throws IOException {
      
//getting data from excel file
	      
	     String orgName =  fUtil.getDataFromExcelFile("org", 3, 3);
		
// webdriver utility
		
		WebDriverUtility wdUtil = new WebDriverUtility (driver);
		
// compose Email
		Email e = new Email(driver);
		e.getClickOnEmail().click();
		e.getClickOnCompose().click();
		
// window handle
		
		 String parentid = driver.getWindowHandle();                  // get parent window id
		  Set<String> childid = driver.getWindowHandles();            // get child and parent window id
		  System.out.println(childid);
	      childid.remove(parentid);                                     // remove parent id
		  
		   
		  
// click on plus button 
		  
		  e.getClickOnPlusBtn().click();
		  Set<String> childid1 = driver.getWindowHandles();
		  System.out.println(childid1);
		  childid1.remove(childid);
		  for(String id1 : childid1) {
			  driver.switchTo().window(id1);
			  
		  }
		  
// create KeyBoard Actions method
		  
		  Actions act = new Actions(driver);
	
		  for(int i=0;i<10;i++) {
			  
			act.keyDown(Keys.TAB).build().perform(); 
			act.keyUp(Keys.TAB).build().perform();
			
		  }
		    act.keyDown(Keys.ENTER).build().perform();
			act.keyUp(Keys.ENTER).build().perform();
		
// now switch into child window
			
		//	driver.switchTo().window(childid);
			
			e.getPassText().sendKeys("this is compose");
			
			
	}

}
