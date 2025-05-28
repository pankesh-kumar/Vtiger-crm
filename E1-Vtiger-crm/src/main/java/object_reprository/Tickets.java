package object_reprository;

import java.awt.print.PageFormat;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Tickets {
     WebDriver driver;
     
     public Tickets(WebDriver driver) {
    	 this.driver = driver;
    	 PageFactory.initElements(driver, this);
		
	}
     
     @FindBy(linkText = "Trouble Tickets")
     WebElement clickOnTroubleTicket;
     
     @FindBy(css = "img[src='themes/softed/images/btnL3Add.gif']")
     WebElement clickOnPlus;
     
     @FindBy(name = "ticket_title")
     WebElement titleName;
     
     @FindBy(css = "input[title='Save [Alt+S]']")
     WebElement clickOnSaveBtn;

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getClickOnTroubleTicket() {
		return clickOnTroubleTicket;
	}

	public WebElement getClickOnPlus() {
		return clickOnPlus;
	}

	public WebElement getTitleName() {
		return titleName;
	}

	public WebElement getClickOnSaveBtn() {
		return clickOnSaveBtn;
	}
     
}
