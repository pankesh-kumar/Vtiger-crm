package com.comcast.crm.contacttest;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import baseUtility.BaseClass;
import object_reprository.ContactPlusBtn;

public class CreateContactTest extends BaseClass {
	
	@Test
	
	public void CreateContactTest() throws InterruptedException {
		
// click on contact and plus button
		 
		 ContactPlusBtn cpb = new ContactPlusBtn(driver);
		 
		  WebElement ClickOnContact = cpb.getContact();
		  ClickOnContact.click();
		  
		   WebElement ClickOnPlusBtn = cpb.getPlus();
		   ClickOnPlusBtn.click();
		   
		  WebElement LastNameTextField =  cpb.getNametextfield();
		  LastNameTextField.sendKeys("kumar");
		  
		  WebElement ClickOnSaveBtn = cpb.getSavebtn();
		  ClickOnSaveBtn.click();
		
		
	}

}
