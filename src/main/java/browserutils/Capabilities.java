package browserutils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import configFactory.CONFIG;
import configFactory.ProjectConfig;
import configFactory.ProjectConfigType;
import configFactory.ProjectFactory;
import utility.TimeUtility;


public class Capabilities {
	private static DesiredCapabilities capabilities;
	private static ProjectConfig config = ProjectFactory.getConfig(ProjectConfigType.INITCONFIG);
	private String platform;
	private String browserName;
	private String version;
	private String name;
	private String os;
	private String osVersion;
	
	public String getOSVersion() {
		this.osVersion = config.getProperty("osVersion", CONFIG.CLOUDBROWSERS);
		return osVersion;
	}


	public String getOS() {
		this.os = config.getProperty("os", CONFIG.CLOUDBROWSERS);
		return os;
	}

	public String getPlatform() {
		this.platform = config.getProperty("platform", CONFIG.CLOUDBROWSERS);
		return platform;
	}

	public String getBrowserName() {
		this.browserName = config.getProperty("browserName", CONFIG.CLOUDBROWSERS);
		return browserName;
	}
	
	public String getBrowserVersion() {
		this.version = config.getProperty("version", CONFIG.CLOUDBROWSERS);
		return version;
	}


	public String getName() {
		this.name =config.getProperty("name", CONFIG.CLOUDBROWSERS);
		return name;
	}
	
	
	
	public synchronized DesiredCapabilities getCapabilities() {
		
		ChromeOptions options = new ChromeOptions();
		   HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
			chromePrefs.put("profile.default_content_settings.popups", 0);
			chromePrefs.put("download.default_directory", System.getProperty("user.dir")+"\\Downloads");
			chromePrefs.put("plugins.always_open_pdf_externally", true);
		   LoggingPreferences logPrefs = new LoggingPreferences();
	       logPrefs.enable(LogType.BROWSER, Level.ALL);
	      
			options.addArguments("--disable-notifications");
			options.addArguments("--lang=en");
			options.addArguments("--disable-popup-blocking");
			options.addArguments("--no-sandbox");
	       options.addArguments("--start-maximized");
	       options.addArguments("--disable-web-security");
	       options.addArguments("--allow-running-insecure-content");
	       options.addArguments("disable-infobars"); 
	       options.addArguments("--disable-features=VizDisplayCompositor");
	       options.setExperimentalOption("prefs", chromePrefs);
		   //this argument should not hard coded
		    options.addArguments("test-type");
		capabilities=new DesiredCapabilities();
		 capabilities.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		capabilities.setCapability("os",getOS());
		capabilities.setCapability("osVersion",getOSVersion());
		capabilities.setCapability("browserName", getBrowserName());
		capabilities.setCapability("version", getBrowserVersion());
		capabilities.setCapability("resolution", "1920x1080");
		final String strupdated = new SimpleDateFormat("dd-MM-yyyyHH:mm").format(new Date());
		capabilities.setCapability("build",TimeUtility.getTimewithTimeStamp("CPQ"));
		capabilities.setCapability("name", getName());
		return capabilities;
		
		
		/*DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("browserName", "Chrome");
		capabilities.setCapability("browserVersion", "latest");
		HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
		browserstackOptions.put("os", "OS X");
		browserstackOptions.put("osVersion", "Big Sur");
		browserstackOptions.put("local", "false");
		capabilities.setCapability("bstack:options", browserstackOptions);
		return capabilities;*/
	}
	
	public synchronized DesiredCapabilities getSauceLabCapabilities() {
		capabilities=new DesiredCapabilities();
		capabilities.setCapability("platform","Windows 10");
		//capabilities.setCapability("osVersion",getOSVersion());
		capabilities.setCapability("browserName", getBrowserName());
		capabilities.setCapability("version", getBrowserVersion());
		capabilities.setCapability("name", getName());
		return capabilities;
		
		
		/*DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("browserName", "Chrome");
		capabilities.setCapability("browserVersion", "latest");
		HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
		browserstackOptions.put("os", "OS X");
		browserstackOptions.put("osVersion", "Big Sur");
		browserstackOptions.put("local", "false");
		capabilities.setCapability("bstack:options", browserstackOptions);
		return capabilities;*/
	}

	

}
