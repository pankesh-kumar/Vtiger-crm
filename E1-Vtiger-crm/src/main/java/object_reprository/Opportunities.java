package object_reprository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Opportunities {

	WebDriver driver;
	public  Opportunities(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(linkText = "Opportunities")
	WebElement clickOnOpportunity;
	
	@FindBy(css = "img[src='themes/softed/images/btnL3Add.gif']")
	WebElement createOpportunity;
	
	@FindBy(name = "potentialname")
	WebElement opportunityName;
	
	@FindBy(css = "img[src='themes/softed/images/select.gif']")
	WebElement clickOnRelatedTo;
	
	@FindBy(id = "search_txt")
	WebElement searchText;
	
	@FindBy(name = "search")
	WebElement clickOnSearch;
	
	@FindBy(linkText = "apple")
	WebElement clickOnApple;
	
	@FindBy(css = "input[title='Save [Alt+S]']")
	WebElement clickOnSaveBtn;
	
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getClickOnOpportunity() {
		return clickOnOpportunity;
	}

	public WebElement getCreateOpportunity() {
		return createOpportunity;
	}

	public WebElement getOpportunityName() {
		return opportunityName;
	}

	public WebElement getClickOnRelatedTo() {
		return clickOnRelatedTo;
	}

	public WebElement getSearchText() {
		return searchText;
	}

	public WebElement getClickOnSearch() {
		return clickOnSearch;
	}

	public WebElement getClickOnApple() {
		return clickOnApple;
	}

	public WebElement getClickOnSaveBtn() {
		return clickOnSaveBtn;
	}
}
