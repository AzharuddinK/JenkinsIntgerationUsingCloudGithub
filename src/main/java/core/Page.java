package core;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.relevantcodes.extentreports.ExtentTest;
import configFactory.ProjectConfig;
import configFactory.ProjectConfigType;
import configFactory.ProjectFactory;

public class Page {
	public static ProjectConfig config = ProjectFactory.getConfig(ProjectConfigType.INITCONFIG);
	  public RemoteWebDriver driver;
	    public WebDriverWait wait;
	    public ExtentTest test;
	    //Constructor
	    public Page(RemoteWebDriver driver){
	        this.driver = driver;
	        PageFactory.initElements(driver, this); 
	       // PageFactory.initElements(new AjaxElementLocatorFactory(driver, 60), this);
	    }
	    
	    //JAVA Generics to Create and return a New Page
	    public  <TPage extends BasePage> TPage getPage (Class<TPage> pageClass) {
	        try {
	            return pageClass.getDeclaredConstructor(RemoteWebDriver.class).newInstance(this.driver);
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        }
	    }
	    
	 

}
