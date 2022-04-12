package listeners;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.relevantcodes.extentreports.LogStatus;
import driverfactory.DriverManager;
import managers.ExtentTestManager;

public class TestngTestListeners implements ITestListener {

	@Override
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext arg0) {
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stu
	}

	@Override
	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
	}

	public static String addScreenshot() {
		File scrFile = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
		String encodedBase64 = null;
		FileInputStream fileInputStreamReader = null;
		try {
			fileInputStreamReader = new FileInputStream(scrFile);
			byte[] bytes = new byte[(int) scrFile.length()];
			fileInputStreamReader.read(bytes);
			encodedBase64 = new String(Base64.encodeBase64(bytes));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			ExtentTestManager.getTest().log(LogStatus.FAIL, e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
			
		}
		return "data:image/png;base64," + encodedBase64;
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		if(result.getStatus()==ITestResult.FAILURE){
			 //  System.out.println("The name of the testcase failed is :"+result.getName());
			ExtentTestManager.getTest().log(LogStatus.FAIL,ExtentTestManager.getTest().addScreenCapture(addScreenshot()));
			ExtentTestManager.getTest().log(LogStatus.FAIL,result.getThrowable().fillInStackTrace());  
			 	
		}
	}
}
