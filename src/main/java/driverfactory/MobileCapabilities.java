package driverfactory;

import org.openqa.selenium.remote.DesiredCapabilities;

public class MobileCapabilities {
	static DesiredCapabilities caps ;
	static GenreralCapabilitiesPojo genCaps = new GenreralCapabilitiesPojo();
	
	//Apply Data table or hash Map as an argument
	public static DesiredCapabilities setGenralCapabilities(String platformName,String platformVersion,String deviceName,String automationName,String appPath){
		caps = new DesiredCapabilities();
		genCaps.setPlatformName("platformName");
		genCaps.setPlatformVersion("platformVersion");
		//caps.setCapability(genCaps.getPlatformName(),platformName);
		//caps.setCapability(genCaps.getPlatformVersion(), platformVersion);
		//caps.setCapability(genCaps.getDeviceName(),deviceName);
		//caps.setCapability(genCaps.getAutomationName(), automationName);
		//caps.setCapability(genCaps.getApp(),appPath);
		caps.setBrowserName("chrome");
		caps.setCapability(genCaps.getPlatformName(),"Android");
		caps.setCapability(genCaps.getPlatformVersion(),"8.1.0");
		caps.setCapability("deviceName", "Android 8");
		caps.setCapability("udid","emulator-5554");
		//caps.setCapability("appPackage","com.android.calculator2");
		//caps.setCapability("appActivity","com.android.calculator2.Calculator");
		return caps;
	}

	public static void setAndroidSpecificCapabilities() {
		// TODO Auto-generated method stub
		
	}

	public static void setIOSSpecificCapabilities() {
		// TODO Auto-generated method stub
		
	}

}
