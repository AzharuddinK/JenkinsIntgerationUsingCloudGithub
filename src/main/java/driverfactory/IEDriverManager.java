package driverfactory;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IEDriverManager extends DriverManager  {
   RemoteWebDriver driver;
	@Override
	public RemoteWebDriver createDriver() {
		System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+"/drivers/IEDriverServer32.exe");
		//WebDriverManager.iedriver().arch32().setup();
		DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
		capabilities.setJavascriptEnabled(true);
		capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		capabilities.setCapability(InternetExplorerDriver.ENABLE_ELEMENT_CACHE_CLEANUP, true);
		capabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
		capabilities.setCapability(InternetExplorerDriver.UNEXPECTED_ALERT_BEHAVIOR,"accept");
		capabilities.setCapability("ignoreZoomSetting", true);
		capabilities.setCapability("nativeEvents", false);  
		driver=new InternetExplorerDriver();
		driver.manage().deleteAllCookies();
		return driver;
	}
	
	

}
