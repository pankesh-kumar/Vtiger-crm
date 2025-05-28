package object_reprository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Organization {

	  WebDriver driver;
	  
	  public  Organization(WebDriver driver) {
		  this.driver = driver;
		  PageFactory.initElements(driver, this);
		
	}
	  @FindBy(linkText = "Organizations")
	  WebElement clickOnOrg;
	  
	  @FindBy(xpath = "//img[@title='Create Organization...']")
	  WebElement createOrg;
	  
	  @FindBy(name = "accountname")
	  WebElement orgField;
	  
	  @FindBy(name = "button")
	  WebElement clickOnSaveBtn;
	  
	  @FindBy(className = "dvHeaderText")
	  WebElement header;

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getClickOnOrg() {
		return clickOnOrg;
	}

	public WebElement getCreateOrg() {
		return createOrg;
	}

	public WebElement getOrgField() {
		return orgField;
	}

	public WebElement getClickOnSaveBtn() {
		return clickOnSaveBtn;
	}

	public WebElement getHeader() {
		return header;
	}
	  
	  
}
