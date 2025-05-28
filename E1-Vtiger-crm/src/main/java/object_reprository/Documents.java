package object_reprository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Documents {
  
	WebDriver driver;
	public Documents (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(linkText = "Documents")
	WebElement clickOnDocuments;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	WebElement clickOnPlus;
	
	@FindBy(xpath = "//input[@name='notes_title']")
	WebElement titleField;
	
	@FindBy(css = "input[type='submit']")
	WebElement clickOnSubmitBtn;
	
	
	public WebElement getClickOnDocuments() {
		return clickOnDocuments;
	}

	public WebElement getClickOnPlus() {
		return clickOnPlus;
	}

	public WebElement getTitleField() {
		return titleField;
	}

	public WebElement getClickOnSubmitBtn() {
		return clickOnSubmitBtn;
	}
}
