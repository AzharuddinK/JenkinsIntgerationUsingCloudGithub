package browserutils;
import java.util.HashMap;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.safari.SafariOptions;


public class Browser_Options {
	
	private static synchronized ChromeOptions setChromeOptions() {
		ChromeOptions options = new ChromeOptions();
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.prompt_for_download", false);
		chromePrefs.put("download.default_directory", System.getProperty("user.dir")+"/Downloads");
		options.addArguments("--disable-notifications");
		options.addArguments("--lang=en");
		options.addArguments("--disable-popup-blocking");
		options.addArguments("--no-sandbox");
        options.addArguments("--start-maximized");
        options.addArguments("--disable-web-security");
        options.addArguments("--allow-running-insecure-content");
        options.addArguments("disable-infobars"); 
        options.setExperimentalOption("prefs", chromePrefs);
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		return options;
	}
	
	private static synchronized FirefoxOptions setFirefoxOptions() {
		FirefoxOptions options = new FirefoxOptions();
        FirefoxProfile profile = new FirefoxProfile();
        //Accept Untrusted Certificates
        profile.setAcceptUntrustedCertificates(true);
        profile.setAssumeUntrustedCertificateIssuer(false);
        //Use No Proxy Settings
        profile.setPreference("network.proxy.type", 0);
        //Set Firefox profile to capabilities
        options.setCapability(FirefoxDriver.PROFILE, profile);
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        return options;
	}
	
	private static synchronized InternetExplorerOptions setIEOptions() {
		InternetExplorerOptions options = new InternetExplorerOptions();
		 options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		return options;
	}
	
	
	private static synchronized SafariOptions setSafariOptions() {
		SafariOptions options = new SafariOptions();
		return options;
	}
	
	private static synchronized EdgeOptions setEdgeOptions() {
		EdgeOptions options = new EdgeOptions();
		return options;
	}

	
	public static synchronized ChromeOptions getChromeOptions() {
		return setChromeOptions();
	}
	
	public static synchronized FirefoxOptions getFirefoxOptions() {
		return setFirefoxOptions();
	}
	
	public static synchronized EdgeOptions getEdgeOptions() {
		return setEdgeOptions();
	}
	
}
