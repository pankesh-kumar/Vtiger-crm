package object_reprository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPlusBtn {
	
     WebDriver driver;
     
     public ContactPlusBtn(WebDriver driver) {
    	 
    	 this.driver = driver;
    	 PageFactory.initElements(driver, this);
     }
     
     @FindBy(linkText = "Contacts")                                         // click on contact element
     WebElement contact;
     
     @FindBy(css = "img[src=\"themes/softed/images/btnL3Add.gif\"]")      // click on plus img
     WebElement plus;
     
     @FindBy(name = "lastname")                                              // click on last name text field
     WebElement nametextfield;
     
     @FindBy(css = "input[title=\"Save [Alt+S]\"]")                     // click on save button
     WebElement savebtn;

//  create getters 	

	public WebElement getContact() {
		return contact;
	}

	public WebElement getPlus() {
		return plus;
	}

	public WebElement getNametextfield() {
		return nametextfield;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}
     
     
     
}
