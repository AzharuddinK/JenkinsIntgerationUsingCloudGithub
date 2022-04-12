package driverfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

public class SafariDriverManager extends DriverManager {

	RemoteWebDriver driver;
	static DesiredCapabilities caps =null;
	
	@Override
	protected RemoteWebDriver createDriver() {
		SafariOptions options = new SafariOptions();
		caps = DesiredCapabilities.safari();
		 options.setUseTechnologyPreview(true);
		 options.merge(caps);
		return this.driver=new SafariDriver(options);
	}

}
