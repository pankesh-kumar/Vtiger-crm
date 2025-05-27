package extra;

import org.checkerframework.common.util.count.report.qual.ReportCall;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Demo1 {
	@Test
	public void add() throws InterruptedException {
		
//public static void main(String[] args) {
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	Thread.sleep(2000);
	driver.close();
	
	Reporter.log("hi john",true);
		
	}
}

