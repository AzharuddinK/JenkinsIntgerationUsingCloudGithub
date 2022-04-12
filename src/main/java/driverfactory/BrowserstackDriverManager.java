package driverfactory;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;

import browserutils.Capabilities;
import configFactory.CONFIG;
import configFactory.ProjectConfig;
import configFactory.ProjectConfigType;
import configFactory.ProjectFactory;


public class BrowserstackDriverManager extends DriverManager {
	RemoteWebDriver driver;
	private static ProjectConfig config = ProjectFactory.getConfig(ProjectConfigType.INITCONFIG);
	String URL ="https://" + config.getProperty("USERNAME", CONFIG.BROWSERSTACK) + ":" + config.getProperty("AUTOMATE_KEY", CONFIG.BROWSERSTACK) +config.getProperty("URL", CONFIG.BROWSERSTACK);

	@Override
	protected RemoteWebDriver createDriver() {
		// TODO Auto-generated method stub
		try {
			driver= new RemoteWebDriver(new URL(URL),new Capabilities().getCapabilities());
			driver.setFileDetector(new LocalFileDetector());
			driver.manage().window().maximize();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return driver;
	}
}
