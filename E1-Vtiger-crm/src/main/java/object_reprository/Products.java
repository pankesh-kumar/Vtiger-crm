package object_reprository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Products {
      WebDriver driver;
       public  Products(WebDriver driver) {
    	   this.driver = driver;
    	   PageFactory.initElements(driver, this);
		
	}
       
       @FindBy(linkText = "Products")
       WebElement clickOnProduct;
       
       @FindBy(css = "img[src='themes/softed/images/btnL3Add.gif']")
       WebElement clickOnPlus;
       
       @FindBy(name = "productname")
       WebElement passProductName;
       
       @FindBy(css = "input[title='Save [Alt+S]'")
       WebElement clickOnSaveBtn;
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getClickOnProduct() {
		return clickOnProduct;
	}

	public WebElement getClickOnPlus() {
		return clickOnPlus;
	}

	public WebElement getPassProductName() {
		return passProductName;
	}

	public WebElement getClickOnSaveBtn() {
		return clickOnSaveBtn;
	}
       
}
