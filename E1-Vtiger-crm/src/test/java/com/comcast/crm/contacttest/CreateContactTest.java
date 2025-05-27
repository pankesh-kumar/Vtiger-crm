package com.comcast.crm.contacttest;

import java.awt.Desktop.Action;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import generic_utility.WebDriverUtility;
import object_reprository.ContactPlusBtn;
import object_reprository.LoginPage;
import object_reprository.SignOut;

public class CreateContactTest {
	
	@Test
	
	public void CreateContactTest() throws InterruptedException {

//	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("http://localhost:8888/");

// login into vtiger-crm
		
		
		LoginPage lp = new LoginPage(driver);
		WebElement username = lp.getUsername();
		username.sendKeys("admin");
		WebElement password = lp.getPassword();
		password.sendKeys("admin");
		 WebElement loginbutton = lp.getLoginbutton();
		 loginbutton.click();
		
		
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
		 

		
//  sign out
		
		SignOut so = new SignOut(driver);
		
		
		WebDriverUtility wdUtil = new WebDriverUtility (driver);

         WebElement profile = so.getProfile();
         wdUtil.hover(profile);
         
         WebElement signout = so.getSignout();
         signout.click();


		
// window close		
		
		Thread.sleep(50000);
		
	    wdUtil.closingBrowser();
		
		
	
		
		
	}

}
