package object_reprository;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import generic_utility.FileUtility;

public class LoginPage {


	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "user_name")
	WebElement username;

	@FindBy(name = "user_password")
	WebElement password;

	@FindBy(css = "input[type='submit']")
	WebElement loginbutton;
	
	

	public WebElement getUsername() {
		return username;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLoginbutton() {
		return loginbutton;
	}
	
	
	public void login() throws IOException {
		FileUtility fUtil = new FileUtility();
		
		
//	      String BROWSER = fUtil.getDataFromPropertiesFile("browser");
	      String URL = fUtil.getDataFromPropertiesFile("url");
	      String USERNAME = fUtil.getDataFromPropertiesFile("username");
	      String PASSWORD = fUtil.getDataFromPropertiesFile("password");
	      
	      
		
	      driver.get(URL);
	      getUsername().sendKeys("admin");
	      getPassword().sendKeys("admin");
	      getLoginbutton().click();
		
	}

	}


