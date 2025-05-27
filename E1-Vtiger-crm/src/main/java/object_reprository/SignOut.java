package object_reprository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignOut {
      WebDriver driver;
      
      public SignOut(WebDriver driver) {
    	  this.driver = driver;
    	  PageFactory.initElements(driver, this);
      }
      
      @FindBy(css = "img[src='themes/softed/images/user.PNG']")
  	WebElement profile;
  	
  	@FindBy(linkText = "Sign Out")
  	WebElement signout;

	
  	
	public WebElement getProfile() {
		return profile;
	}

	public WebElement getSignout() {
		return signout;
	}
  	
  	
  	
}
