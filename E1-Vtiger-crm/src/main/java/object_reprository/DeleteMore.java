package object_reprository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteMore {
    
	WebDriver driver;
	public DeleteMore (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(linkText = "More")
	WebElement clickOnMore;
	
	@FindBy(linkText = "FAQ")
	WebElement clickOnFAQ;
	
	@FindBy(name = "selected_id")
	WebElement clickOnCheckBox;
	
	@FindBy(css = "input[value='Delete']")
	WebElement deleteElement;
	
	
	public WebElement getClickOnMore() {
		return clickOnMore;
	}

	public WebElement getClickOnFAQ() {
		return clickOnFAQ;
	}

	public WebElement getClickOnCheckBox() {
		return clickOnCheckBox;
	}

	public WebElement getDeleteElement() {
		return deleteElement;
	}
	
	
}
