package driverfactory;
import org.openqa.selenium.remote.DesiredCapabilities;

public class MobileOptions {
		static DesiredCapabilities caps;
	public static DesiredCapabilities androidCapabilities(String platformName,String platformVersion, String deviceName,String automationName,String appPath){
		MobileCapabilities.setGenralCapabilities(platformName,platformVersion,deviceName,automationName,appPath);
		//MobileCapabilities.setAndroidSpecificCapabilities();
		return caps;
	}
	
	public static void iosCapabilities(String platformName,String platformVersion, String deviceName,String automationName,String appPath){
		MobileCapabilities.setGenralCapabilities(platformName,platformVersion,deviceName,automationName,appPath);
		MobileCapabilities.setIOSSpecificCapabilities();
	}
	
	
}
