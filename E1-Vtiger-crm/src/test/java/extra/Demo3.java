package extra;

import org.checkerframework.common.util.count.report.qual.ReportCall;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Demo3 {
	
	@Test

	public void sub() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.close();
		Reporter.log("hy ram",true);
		
	}
}
