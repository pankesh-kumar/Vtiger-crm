package com.comcast.crm.moretest;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import baseUtility.BaseClass;
import generic_utility.WebDriverUtility;
import object_reprository.DeleteMore;

public class DeleteMoreTest extends BaseClass {
	@Test
	public void DeleteMore() throws IOException {

//getting data from excel file
	      
	     String orgName =  fUtil.getDataFromExcelFile("org", 3, 3);
		
// webdriver utility
		
		WebDriverUtility wdUtil = new WebDriverUtility (driver);
		
// hover on more module
		DeleteMore dm = new DeleteMore(driver);
		WebElement more = dm.getClickOnMore();     // inspect more module
		more.click();                                                
		wdUtil.hover(more);                                 // perform hover on more module
		
//  click on FAQ element 
		
		dm.getClickOnFAQ().click();       // inspect ->source->freez(F8 button)->element->write xpath.
		
// click on check box
		
		dm.getClickOnCheckBox().click();
// delete select element
		
		dm.getDeleteElement().click();
		
// handle popup
		
		wdUtil.alert();
		
	}

}
