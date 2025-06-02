package com.comcast.crm.moretest;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import baseUtility.BaseClass;
import generic_utility.WebDriverUtility;
import object_reprository.AddMore;

public class AddMoreTest extends BaseClass {
	@Test
	
	public void AddMore() throws IOException {

			      
//getting data from excel file
			      
			     String orgName =  fUtil.getDataFromExcelFile("org", 3, 3);
		
// webdriver utility
	
				WebDriverUtility wdUtil = new WebDriverUtility (driver);	
			
	

// click on more module
	AddMore am = new AddMore(driver);
	
	WebElement more =am.getHoverOnMore();
	wdUtil.hover(more);
	
// click on invoice element
	
	am.getClickOnInvoice().click();
	
// click on plus button to  add invoice
	
	am.getClickOnPlusBtn().click();
	
    am.getPassSubject().sendKeys("cancle invoice");
    am.getBillingAdd().sendKeys("andheri,mumbai");              // billing address 
    am.getShpingAdd().sendKeys("noida,sector-16,qspider");      // shipping address 
    
 // for orgination name , use window handles
    
    am.getClickOnImg().click();
    String parentid = driver.getWindowHandle();
    Set<String> ids = driver.getWindowHandles();
 
    
    for(String id : ids) {
    	driver.switchTo().window(id);
    }
    
    am.getPassText().sendKeys("so5");
    am.getClickOnSearch().click();
    am.getClickOnSovent().click();
    driver.switchTo().window(parentid);
    
  
	}

}
