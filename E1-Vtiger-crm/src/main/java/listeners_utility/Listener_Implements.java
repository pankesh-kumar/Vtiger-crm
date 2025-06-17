package listeners_utility;

import java.security.cert.Extension;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Listener_Implements implements ITestListener, ISuiteListener{
	
	ExtentReports report = new ExtentReports();
	ExtentTest test;
	
	@Override
	public void onStart(ISuite suite) {
		
//  ExtentsparkReporter class
		
		ExtentSparkReporter spark = new ExtentSparkReporter("C:\\Users\\panke\\git\\vtiger-crm\\E1-Vtiger-crm\\AdvanceReport\\adRep1.html");
		
		spark.config().setDocumentTitle("E1-vtiger-CRM-List");
		spark.config().setReportName("second report");
		spark.config().setTheme(Theme.DARK);
		
//   ExtentReports class
		
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("os", "linux");
		report.setSystemInfo("ATE", "panku");
		report.setSystemInfo("Browser", "chrome");
	}
	
	@Override
	
	public void onTestStart(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test = report.createTest(methodName);
		
	}
	
	@Override
	
	public void onTestSuccess(ITestResult result) {
		System.out.println("yes.....it got passed....");
		test.log(Status.PASS, "this is passing purpose...");
		
	}
	
	@Override
	
	public void onTestFailure(ITestResult result) {
		System.out.println("no!! no!! ....it got failed...");
		test.log(Status.FAIL, "this is failing purpose....");
		
	}
	
	@Override
	
	public void onTestSkipped (ITestResult result) {
		System.out.println("skipped....");
		test.log(Status.SKIP,"this is skipping purpose ");
		
	}
	 @Override
	public void onFinish(ISuite suite) {
		report.flush();
	}
	
	
	
	

}
