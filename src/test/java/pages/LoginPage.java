package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import baseinterfaces.IAction.clickType;
import core.BasePage;

public class LoginPage extends BasePage{
	public LoginPage(RemoteWebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	@FindBy(name="username")
	private WebElement username;

	@FindBy(id="password")
	private WebElement password;

	@FindBy(id="Login")
	private WebElement logIn;
	
	@FindBy(name="password")
	private WebElement reltioPassword;

	@FindBy(xpath="//*[text() = 'Log in']")
	private WebElement reltioLogIn;

	//Enter username 
	public  void Enter_username(String uname)
	{ 
		Assert.assertEquals(true,isElementVisible(username));
		uiAction.typeText(username, uname);
		extentLogger.addInfo("Enter username: "+uname);
	}
	
		
	public  void Enter_password(String pwd)
	{
	
		uiAction.typeText(password, pwd);
		extentLogger.addInfo("Enter Password: "+pwd);
	}
	public  void enterReltiopassword(String pwd)
	{
		uiAction.typeText(reltioPassword,pwd);
		extentLogger.addInfo("Enter Password for Reltio "+pwd);
	}
	public void clickOnLogInButton(){
		try{
			uiAction.click(logIn,clickType.NORMAL_CLICK);
		}catch(Exception ex)
		{
			extentLogger.addFail("Login Failed");
			Assert.fail("Login failed");
	}
			
	}
	public void clickOnReltioLogInButton(){
		try{
			uiAction.click(reltioLogIn,clickType.NORMAL_CLICK);
			extentLogger.addInfo("User clicked on Log In Button");
		}catch(Exception ex)
		{
			extentLogger.addFail("Failed to click on Login Button.");
			Assert.fail("Login failed");
	}
			
	}
	
		public void LogintoApplication(String uname,String pwd)
		{
			try{
			this.Enter_username(uname);
			this.Enter_password(pwd);
			this.clickOnLogInButton();
			
			}catch(Exception ex)
			{
				ex.printStackTrace();
				extentLogger.addFail("Login Failed");
				Assert.fail("Login failed");
				
			}
	    }
		public void LogintoReltioApplication(String uname,String pwd)
		{
			try{
			this.Enter_username(uname);
			this.enterReltiopassword(pwd);
			this.clickOnReltioLogInButton();
			
			}catch(Exception ex)
			{
				ex.printStackTrace();
				extentLogger.addFail("Login Failed");
				Assert.fail("Login failed");
				
			}
	    }
		
}
