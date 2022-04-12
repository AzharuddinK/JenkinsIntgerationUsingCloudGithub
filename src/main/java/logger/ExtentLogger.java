package logger;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentLogger {
	
	protected ExtentTest test;
	public ExtentLogger(ExtentTest test) {
		this.test = test;
	}
	
	public void addInfo(String info) {
		test.log(LogStatus.INFO, info);
	}
	
	public void addInfo(String info,String screenshot) {
		test.log(LogStatus.INFO,test.addScreenCapture(screenshot));
	}
	public void addFail(String info) {
		test.log(LogStatus.FAIL, info);
	}
	
	public void addFail(String info,String screenshot) {
		test.log(LogStatus.FAIL,test.addScreenCapture(screenshot));
	}
	
	public void addWarning(String info) {
		test.log(LogStatus.WARNING, info);
	}
	
	public void addError(String info) {
		test.log(LogStatus.ERROR, info);
	}
	public void addPass(String info) {
		test.log(LogStatus.PASS, info);
	}

	public void addPass(String info,String screenshot) {
		test.log(LogStatus.PASS,test.addScreenCapture(screenshot));
	}

}
