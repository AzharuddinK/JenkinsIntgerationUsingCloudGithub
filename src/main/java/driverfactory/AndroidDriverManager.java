package driverfactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;


public abstract class AndroidDriverManager {
	
	public static ThreadLocal<AndroidDriver<MobileElement>> mobileDriver = new ThreadLocal<AndroidDriver<MobileElement>>();
	protected abstract AndroidDriver<MobileElement> createDriver(); 
   
	public static AndroidDriver<MobileElement> getDriver() {
        return mobileDriver.get();
    }
 
    public static void setWebDriver(AndroidDriver<MobileElement> driver) {
    	mobileDriver.set(driver);
    }
}
