package tests;
import org.openqa.selenium.remote.SessionId;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import configFactory.ProjectConfig;
import configFactory.ProjectConfigType;
import configFactory.ProjectFactory;
import driverfactory.DriverFactory;
import driverfactory.DriverManager;
import managers.ExtentTestManager;
import pages.Pages;
import utility.MyScreenRecorder;
import utility.Xls_Reader;

public class TestBase {
	SoftAssert softAssert= new SoftAssert();
	String quoteStatus ="";
	public static ProjectConfig config = ProjectFactory.getConfig(ProjectConfigType.INITCONFIG);
	
	public ExtentTest test;
	public Pages page;
	public Xls_Reader xls_reader = null;
	
	SessionId sessionId ;
	
	/*@BeforeTest
	public void setUpBrowser(){
		System.out.println("Before Test");
		DriverManager.setWebDriver(DriverFactory.createWebDriverInstance("chrome"));
		sessionId =DriverManager.getDriver().getSessionId();
		System.out.println(sessionId.toString());
	}*/
	
	
	
	@BeforeClass
	public void setup(ITestContext context) throws Exception {
		System.out.println("Before Class");
		ExtentTestManager.startTest(context.getAllTestMethods()[0].getInstance().getClass().getSimpleName());
		page = new Pages(DriverManager.getDriver());
		MyScreenRecorder.startRecording(context.getAllTestMethods()[0].getInstance().getClass().getSimpleName());
	}

	@AfterTest(alwaysRun=true)
	public void tearDown() throws Exception {
		System.out.println("After All Tests");
		MyScreenRecorder.stopRecording();
		DriverManager.getDriver().quit(); 
		ExtentTestManager.getTest().log(LogStatus.INFO,"Closed Session.");
		ExtentTestManager.endTest();
	}

	@AfterSuite
	public void publishreport() {
		ExtentTestManager.publishReport();
		//System.out.println(sessionId.toString());//update test result to cloud[Browserstack]
		// some other activities
		// JIRA bug raised[optional]
		// read testng results.xml file for Teams notification[maven surefirereports]
		// xray-test cycle update[TestRail]
		// elastic search
	}
	
	public void closeBrowser(){
		DriverManager.getDriver().close();
		ExtentTestManager.getTest().log(LogStatus.INFO, "Browser Closed");
	}
	
	public void openBrowser(String browserName){
		DriverManager.setWebDriver(DriverFactory.createWebDriverInstance(browserName));
	}
}
