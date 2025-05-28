package object_reprository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddMore {

	WebDriver driver;
	public AddMore (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(linkText = "More")
	WebElement hoverOnMore;
	
	@FindBy(linkText = "Invoice")
	WebElement clickOnInvoice;
	
	@FindBy(css = "img[src='themes/softed/images/btnL3Add.gif']")
	WebElement clickOnPlusBtn;
	
	@FindBy(name = "subject")
	WebElement passSubject;
	
	@FindBy(css = "textarea[name=\"bill_street\"]")
	WebElement billingAdd;
	
	@FindBy(css = "textarea[name=\"ship_street\"]")
	WebElement shpingAdd;
	
	@FindBy(css = "img[src=\"themes/softed/images/select.gif\"]")
	WebElement clickOnImg;
	
	@FindBy(css = "input[type=\"text\"]")
	WebElement passText;
	
	@FindBy(name = "search")
	WebElement clickOnSearch;
	
	@FindBy(linkText = "SO_vendtl")
	WebElement  clickOnSovent;
	
	
	
	public WebElement getHoverOnMore() {
		return hoverOnMore;
	}

	public WebElement getClickOnInvoice() {
		return clickOnInvoice;
	}

	public WebElement getClickOnPlusBtn() {
		return clickOnPlusBtn;
	}

	public WebElement getPassSubject() {
		return passSubject;
	}

	public WebElement getBillingAdd() {
		return billingAdd;
	}

	public WebElement getShpingAdd() {
		return shpingAdd;
	}

	public WebElement getClickOnImg() {
		return clickOnImg;
	}

	public WebElement getPassText() {
		return passText;
	}

	public WebElement getClickOnSearch() {
		return clickOnSearch;
	}

	public WebElement getClickOnSovent() {
		return clickOnSovent;
	}
	
	
}
