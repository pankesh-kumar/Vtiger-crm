package object_reprository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
      WebDriver driver;
      
      public HomePage(WebDriver driver) {
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
  	
  	
	public void logout() {
		Actions act = new Actions(driver);
		act.moveToElement(getProfile()).build().perform();
		act.click(signout).build().perform();
	}
  	
}
