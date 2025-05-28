package object_reprository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Leads {
   WebDriver driver;
   
   public Leads(WebDriver driver) {
	   this.driver = driver;
	   PageFactory.initElements(driver, this);
   }
   
   @FindBy(linkText = "Leads")
   WebElement clickOnLeads;
   
   @FindBy(css = "img[src='themes/softed/images/btnL3Add.gif']")
   WebElement clickOnPlusBtn;
   
   @FindBy(name = "lastname")
   WebElement leadFieldName;
   
   @FindBy(name = "company")
   WebElement companyName;
   
   @FindBy(css = "input[title=\"Save [Alt+S]\"]")
   WebElement clickOnSaveBtn;
   
   @FindBy(className = "dvHeaderText")
   WebElement header;

public WebElement getClickOnLeads() {
	return  clickOnLeads;
}

public WebElement getClickOnPlusBtn() {
	return clickOnPlusBtn;
}

public WebElement getLeadFieldName() {
	return leadFieldName;
}

public WebElement getCompanyName() {
	return companyName;
}

public WebElement getClickOnSaveBtn() {
	return clickOnSaveBtn;
}

public WebElement getHeader() {
	return header;
}


}
