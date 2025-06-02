package com.comcast.crm.dashboardtest;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import baseUtility.BaseClass;
import generic_utility.WebDriverUtility;

public class ShowDashBoardTest extends BaseClass {
	@Test
	public void ShowDashBoard() throws IOException, InterruptedException {
	
		
// get the data from excel file
		
		 String dashbord = fUtil.getDataFromExcelFile("org", 2, 1);

// webdriver util
		
		WebDriverUtility wdutil = new WebDriverUtility(driver);
		
		
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
		  
		  
	}

}
