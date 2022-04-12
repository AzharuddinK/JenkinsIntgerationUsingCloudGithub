package driverfactory;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class DriverFactory {

	public static RemoteWebDriver createWebDriverInstance(String browser) {
		RemoteWebDriver driver = null;
		switch (browser) {
		case "Chrome":
			ChromeDriverManager chromeDriver = new ChromeDriverManager();
			driver = chromeDriver.createDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			break;
		case "Firefox":
			FirefoxDriverManager firefoxDriverManager = new FirefoxDriverManager();
			driver = firefoxDriverManager.createDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			break;
		case "IE":
			IEDriverManager IEDriver = new IEDriverManager();
			driver = IEDriver.createDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			break;
		case "Edge":
			break;
		case "Safari":
			SafariDriverManager safari = new SafariDriverManager();
			driver = safari.createDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			break;
		case "Lambdatest":
			LambdaTestDriverManager lambtatest = new LambdaTestDriverManager();
			driver = lambtatest.createDriver();
			break;
		case "Browserstack":
			BrowserstackDriverManager browserstack = new BrowserstackDriverManager();
			driver = browserstack.createDriver();
			break;
		case "Saucelab":
			SaucelabDriverManager saucelab = new SaucelabDriverManager();
			driver = saucelab.createDriver();
			break;
		case "AWS":
			break;
		case "Azure":
			break;
		case "GoogleCloud":
			
			break;
		case "LocalGrid":
			break;
		default:
			chromeDriver = new ChromeDriverManager();
			driver = chromeDriver.createDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			break;
		}

		return driver;
	}

	public static WebDriver createRemoteWebDriverInstance(DriverType type) {
		WebDriver driver = null;
		switch (type) {
		case SAUCELABS:
			break;
		case BROWSERSTACK:
			break;
		default:

			break;
		}
		return driver;
	}

	public static AndroidDriver<MobileElement> createMobileInstance(DriverType type) {
		AndroidDriver<MobileElement> mobileDriver = null;
		switch (type) {
		case ANDROID:
			ANDROID_DRIVER androidDriver = new ANDROID_DRIVER();
			mobileDriver = androidDriver.createDriver();
		default:

			break;
		}
		return mobileDriver;
	}
}
