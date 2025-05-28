package object_reprository;

import java.security.PublicKey;
import java.time.temporal.WeekFields;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Calendar {

	WebDriver driver;
	
	public Calendar(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	} 
	@FindBy(linkText = "Calendar")
	WebElement clickOnCalendar;
	
	@FindBy(linkText = "Day")
	WebElement selectDay;
	
	@FindBy(className = "calAddButton")
	WebElement hoverOnAddBtn;
	
	@FindBy(linkText = "To Do")
	WebElement clickOnToDoBtn;
	
	@FindBy(name = "task_subject")
	WebElement toDoField;
	
//  select date, time & save todo
	
	@FindBy(id = "jscal_trigger_task_date_start")
	WebElement selectCalendar;
	
	@FindBy(xpath = "//td[text()='9']")
	WebElement selectDate;
	
	@FindBy(name = "todosave")
	WebElement saveToDo;
	
//   verification of todo
	
	@FindBy(linkText = "All Events & Todos")
	WebElement clickOnAllEventsAndToDo;
	
	@FindBy(linkText = "DailyRoutine")
     WebElement clickOnDailyRoutine;
	
	@FindBy(className = "lvtHeaderText")
	WebElement inspectHeader;

	
// getters 
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getClickOnCalendar() {
		return clickOnCalendar;
	}

	public WebElement getSelectDay() {
		return selectDay;
	}

	public WebElement getHoverOnAddBtn() {
		return hoverOnAddBtn;
	}

	public WebElement getClickOnToDoBtn() {
		return clickOnToDoBtn;
	}

	public WebElement getToDoField() {
		return toDoField;
	}

	public WebElement getSelectCalendar() {
		return selectCalendar;
	}

	public WebElement getSelectDate() {
		return selectDate;
	}

	public WebElement getSaveToDo() {
		return saveToDo;
	}

	public WebElement getClickOnAllEventsAndToDo() {
		return clickOnAllEventsAndToDo;
	}

	public WebElement getClickOnDailyRoutine() {
		return clickOnDailyRoutine;
	}

	public WebElement getInspectHeader() {
		return inspectHeader;
	}
	
}




