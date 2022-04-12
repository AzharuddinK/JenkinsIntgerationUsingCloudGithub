package driverfactory;
import org.openqa.selenium.remote.RemoteWebDriver;

public abstract class DriverManager {

	protected static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<RemoteWebDriver>();
	protected abstract RemoteWebDriver createDriver(); 
    public static RemoteWebDriver getDriver() {
        return driver.get();
    }
 
    public static void setWebDriver(RemoteWebDriver driver_) {
        driver.set(driver_);
    }
	
}
