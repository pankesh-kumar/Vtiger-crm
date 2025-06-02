package baseUtility;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.bidi.module.Browser;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import generic_utility.FileUtility;
import object_reprository.HomePage;
import object_reprository.LoginPage;

public class BaseClass {

		 
			 
	public FileUtility fUtil = new FileUtility();
	 public WebDriver driver;
		 
		@Parameters("browser")		 
		 @BeforeClass
		 
		public void openBrowser(@Optional("chrome") String browser) throws IOException {
			
     	String BROWSER = browser;
     	
     	
		if(BROWSER.equals("chrome")) {
				driver = new ChromeDriver();
			}
			else if(BROWSER.equals("edge")) {
				driver = new EdgeDriver();
			}else if(BROWSER.equals("firefox")) {
				driver = new FirefoxDriver();
			}else {
				driver = new ChromeDriver();
			}
			
			
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
		 
		 @BeforeMethod
		 
		 public void login() throws IOException {
			 LoginPage lp = new LoginPage(driver);
			 lp.login();
		 }
		 
		 
		 @AfterMethod
		 
		 public void logout() {
			 
			 HomePage hp = new HomePage(driver);
			 hp.logout();
		 }
		 
		 @AfterClass
		 
		 public void closeBrowser() throws InterruptedException {
			 Thread.sleep(3000);
			 driver.close();
		 }
		 
		 
}

  
