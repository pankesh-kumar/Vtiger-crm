package extra;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

//@Listeners(listeners_utility.Listener_Implements.class)
public class AdvanceReporting {

	ExtentReports report = new ExtentReports();

	@BeforeSuite
	public void configRep() {
//		ExtentSparkReporter class
		ExtentSparkReporter spark = new ExtentSparkReporter(
				"C:\\Users\\panke\\git\\vtiger-crm\\E1-Vtiger-crm\\AdvanceReport\\adRep1.html");
		spark.config().setDocumentTitle("E1-Vtiger-CRM-FW");
		spark.config().setReportName("First Report");
		spark.config().setTheme(Theme.DARK);

//		ExtentReports class
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Linux");
		report.setSystemInfo("ATE", "Ranaji");
		report.setSystemInfo("Browser", "Chrome");

	}

	@Test
	public void extentTest1() {

//		ExtentTest class
		ExtentTest test = report.createTest("extentTest1");
		test.log(Status.INFO,"this is just like that purpose....");
		test.log(Status.SKIP, "this is skipping purpose....");
		test.log(Status.PASS, "this is passing purpose....");
		test.log(Status.WARNING, "this is warning purpose....");
		test.log(Status.FAIL, "this is failing purpose....");
	}

	@AfterSuite
	public void repBackup() {
		report.flush();

	}
}