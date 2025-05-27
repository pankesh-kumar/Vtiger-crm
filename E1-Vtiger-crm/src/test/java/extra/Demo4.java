package extra;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Demo4 {
	
	@Test(groups = "smoke")
	public void case1() {
		Reporter.log("smoke group");
	}
	
	@Test(groups = "regration")
	public void case2() {
		Reporter.log("regration group");
	}
	
	@Test(groups = "regration")
	public void case3() {
		Reporter.log("regration group");
	}
	
	@Test(groups = "smoke")
	public void case4() {
		Reporter.log("smoke group");
		
	}
	
	@Test(groups = "regration")
	public void case5() {
		Reporter.log("regration group");
	}
}
