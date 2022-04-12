package driverfactory;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeDriverManager extends DriverManager  {
   RemoteWebDriver driver;
	@Override
	public RemoteWebDriver createDriver() {
		// TODO Auto-generated method stub
		if(System.getProperty("os.name").contains("window")) 
		{
		WebDriverManager.chromedriver().setup();	
			
		//System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/Executables/chromedriver.exe");
		
		}else{
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/drivers/chromedriver.exe");
		}
		return driver= new ChromeDriver(BrowserOptions.getChromeOptions());
	}
	
	

}
