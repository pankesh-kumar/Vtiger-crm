package com.comcast.crm.documentstest;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import baseUtility.BaseClass;
import generic_utility.WebDriverUtility;
import object_reprository.Documents;

public class CreateDocumentsTest extends BaseClass{
	@Test
	
	public void CreateDocuments() throws IOException {

		
		
// get data from excel file
		
		 String document = fUtil.getDataFromExcelFile("org", 1, 1);
		
		
		
// webdriver utility
		
		WebDriverUtility wdutil = new WebDriverUtility(driver);
	
		
// Create Documents
		Documents dc = new Documents(driver);
		
		dc.getClickOnDocuments().click();
		dc.getClickOnPlus().click();
		dc.getTitleField().sendKeys("operation-sindoor");
		
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
		
		dc.getClickOnSubmitBtn().click();
		
				

	}

}
