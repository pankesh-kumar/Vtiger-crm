package object_reprository;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

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
	
	
	
	
	
	
	
	
	
	

//	public static void main(String[] args) {
//		
//	 
//		
//		WebDriver driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//
//		driver.get("http://localhost:8888/");
//		
//		LoginPage lp = new LoginPage(driver);
//		WebElement username = lp.getUsername();
//		username.sendKeys("admin");
//	}

}
