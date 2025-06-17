package extra;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import generic_utility.WebDriverUtility;
import object_reprository.ClockTime;



@Listeners(listeners_utility.Listener_Implements.class)
public class AdvanceReporting {

	@Test
	
	public void case1() {
		System.out.println("add method");
	   Assert.assertTrue(false);

	}
	
	@Test
	public void case2() {
		System.out.println("multi method");
		Assert.assertTrue(false);
		
	}
	
	@Test
	
	public void case3() {
		System.out.println("reverse string");
		Assert.assertTrue(true);
		
	}
	
	@Test
	public void case4() {
		System.out.println("factorial method");
		Assert.assertTrue(true);
		
	}
	
	@Test
	public void case5() {
		System.out.println("prime no method");
		Assert.assertTrue(true);
	}
	@Test
	public void WorldClock() throws IOException {

		WebDriver driver = null;
		   
		 // click on clock
			
			WebDriverUtility wdutil = new WebDriverUtility(driver);
			
		   
			ClockTime ct =new  ClockTime(driver);
		   
		   ct.getClickOnWorldClock().click();
		   WebElement country =ct.getCountry();
		  
		  wdutil.selectByVisibleText(country,"Bulgaria");
     	  Assert.assertTrue(false);
}
}