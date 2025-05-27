package generic_utility;

import java.lang.classfile.ClassFile.Option;
import java.time.temporal.WeekFields;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WebDriverUtility {
       
	   WebDriver driver;
	   Actions act ;
	   Select dropDown;
	   
	   
	   public WebDriverUtility(WebDriver driver) {
		   this.driver = driver;            // this key word define the current object
		   this.act = new Actions(driver);
//		   this.sel = new Select(dropdown);
	   }

	   
//  closing browser
	   
	  public void closingBrowser() {
//		  driver.close();
		  driver.quit();
	  }
	  
// Actions class method: hover, right click, dragAndDrop, doubleClick
	  
	  public void hover(WebElement element) {
		  act.moveToElement(element).build().perform();
	  }
	  
	  
	  public void rightClick(WebElement element) {
		  act.contextClick(element).build().perform();
		  
	  }
	  
	  
	  public void dragAndDrop(WebElement source,WebElement target) {
		  act.dragAndDrop(source, target).build().perform();
	  }
	  
	  public void doubleClick(WebElement element) {
		  act.doubleClick(element).build().perform();
	  }
	  

// switchTo method
	  
	  public void switchToWindow(String ids) {
		  driver.switchTo().window(ids);
	  }
	  
	  
	  public void switchToFrame(int index) {
		  driver.switchTo().frame(index);
	  }
	  
	  
	  public void switchToFrame(String idorName) {
		  driver.switchTo().frame(idorName);
	  }
	  
	  
	  public void switchToFrame(WebElement element) {
		  driver.switchTo().frame(element);
		  
	  }
	  
	  
	  public void manage(Option maximizeOption) {
		  driver.manage().window().maximize();
	  }

// navigate method : refresh, back, forward	  
	  
	  public void navigateRefresh() {
		  driver.navigate().refresh();
	  }
	  
	  public void navigateBack() {
		  driver.navigate().back();
	  }
	  
	  
	  public void navigateForward() {
		  driver.navigate().forward();
	  }
	  
	  
// select class method : drop down by visible text, index
	  
	  public void selectByVisibleText(WebElement dropDownElement,String visibleText) {
//		  	 Select dropDown = new Select(dropDownElement); 
		  	dropDown = new Select(dropDownElement);
		dropDown.selectByVisibleText(visibleText);
		  
	  }
	  
	  public void selectByIndex(int index) {
		  dropDown.selectByIndex(index);
	  }
	  
	  public void deselectByVisibleText(String visibleText) {
		  dropDown.deselectByVisibleText(visibleText);
	  }
	  
	  public void deselectByIndex(int index) {
		 dropDown.deselectByIndex(index);
	  }
	  
	  
//PopUps method : alert 
	  
	  public void alert() {
		  Alert ale = driver.switchTo().alert();
		  ale.accept();
	  }
	  
	  
	  
	  
	  
}
