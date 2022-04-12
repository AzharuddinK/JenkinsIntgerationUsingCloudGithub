package driverfactory;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirefoxDriverManager extends DriverManager  {
   RemoteWebDriver driver;
	@Override
	public RemoteWebDriver createDriver() {
		WebDriverManager.firefoxdriver().arch64().setup();
		//System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"/Executables/geckodriver.exe");
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        FirefoxOptions options = new FirefoxOptions();
        FirefoxProfile ffprofile=new FirefoxProfile();
        ffprofile.setPreference("browser.autofocus", true);
        capabilities.setCapability(FirefoxDriver.PROFILE, ffprofile);
        capabilities.setCapability("marionette", true);
        return driver = new FirefoxDriver(options);
	}
	
	

}
