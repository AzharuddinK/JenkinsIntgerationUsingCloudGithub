package driverfactory;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class ANDROID_DRIVER extends AndroidDriverManager {

	AndroidDriver<MobileElement> driver=null;
	DesiredCapabilities Caps=null;
	@Override
	protected AndroidDriver<MobileElement> createDriver() {
		// TODO Auto-generated method stub
		Caps=MobileCapabilities.setGenralCapabilities("", "", "", "", "");
		URL url = null ;
		    	try {
				  url = new URL("http://0.0.0.0:4723/wd/hub");
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
      return driver= new AndroidDriver<MobileElement>(url,Caps);
	}
	

}
