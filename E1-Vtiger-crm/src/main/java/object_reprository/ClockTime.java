package object_reprository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class ClockTime {
      
	WebDriver driver;
	public  ClockTime(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "img[title=\"Show World Clock...\"]")
	WebElement clickOnWorldClock;
	
	@FindBy(id = "clockcity")
	WebElement country;
	
	@FindBy(xpath = "//b[text()='World Clock']")
	WebElement inspectWorldClock;
	
	@FindBy(id = "headerrow_12")
	WebElement orders;
	
	
	

	public WebElement getClickOnWorldClock() {
		return clickOnWorldClock;
	}

	public WebElement getCountry() {
		return country;
	}

	public WebElement getInspectWorldClock() {
		return inspectWorldClock;
	}

	public WebElement getOrders() {
		return orders;
	}
	
	
}
