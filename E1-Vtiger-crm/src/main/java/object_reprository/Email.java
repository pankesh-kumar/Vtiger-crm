package object_reprository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Email {

	 WebDriver driver;
	 public  Email(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	 
	 @FindBy(linkText = "Email")
	 WebElement clickOnEmail;
	 
	 @FindBy(linkText = "Compose")
	 WebElement clickOnCompose;
	 
	 @FindBy(css = "img[src=\"themes/softed/images/select.gif\"]")
	 WebElement clickOnPlusBtn;
	 
	 @FindBy(css = "input[type='text']")
	 WebElement passText;
	 
	 
	public WebElement getClickOnEmail() {
		return clickOnEmail;
	}

	public WebElement getClickOnCompose() {
		return clickOnCompose;
	}

	public WebElement getClickOnPlusBtn() {
		return clickOnPlusBtn;
	}

	public WebElement getPassText() {
		return passText;
	}
}
