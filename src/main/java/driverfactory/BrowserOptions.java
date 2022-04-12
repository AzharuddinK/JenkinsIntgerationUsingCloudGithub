package driverfactory;

import java.util.HashMap;
import java.util.logging.Level;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariOptions;

public class BrowserOptions {
	static DesiredCapabilities capabilities = new DesiredCapabilities();	   
   public static ChromeOptions getChromeOptions(){
	   
	   
	   
	   
	   HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", System.getProperty("user.dir")+"\\Downloads");
		chromePrefs.put("plugins.always_open_pdf_externally", true);
		ChromeOptions options = new ChromeOptions();
		
	   LoggingPreferences logPrefs = new LoggingPreferences();
       logPrefs.enable(LogType.BROWSER, Level.ALL);
       capabilities.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
       //options.addArguments("user-data-dir=C:\\Users\\SESA443020\\AppData\\Roaming\\Google\\Chrome\\Automation\\");
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
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
	    return options.merge(capabilities);
   }
   
   
   
   public static ChromeOptions chromeWithExtension(){
	   return new ChromeOptions();
   }

  public static FirefoxOptions getFirefoxOptions(){
	  return new FirefoxOptions();
  }
  
  public static InternetExplorerOptions getIEOptions(){
	  return new InternetExplorerOptions();
  }
  
  public static SafariOptions getSafariOptions(){
	  SafariOptions options = new SafariOptions();
	  options.setCapability(SafariOptions.CAPABILITY, options);
	  
	  return new SafariOptions();
  }
   
  
  public static EdgeOptions getEdgeOptions(){
	  return new EdgeOptions();
  }
   
 public static OperaOptions getOperaOptions(){
	 return new OperaOptions();
 }
	
 
	
	
	
	
	
	
	
	
	
	
	

}
