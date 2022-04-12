package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import baseinterfaces.IAction.clickType;
import core.BasePage;

public class ManhattanLoginPage extends BasePage {

	public ManhattanLoginPage(RemoteWebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(name="j_username")
	private WebElement username;

	@FindBy(id="password")
	private WebElement password;

	@FindBy(id="loginButton")
	private WebElement logIn;
	

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
	
	public void clickOnLogInButton(){
		try{
			uiAction.click(logIn,clickType.NORMAL_CLICK);
		}catch(Exception ex)
		{
			extentLogger.addFail("Login Failed");
			Assert.fail("Login failed");
	}
			
	}

	
		public void LogintoManhattanApplication(String uname,String pwd)
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


		@FindBy(id="button-1013-btnIconEl")
		private WebElement menuIcon;
		public void clickonMenu() {
			try{
				uiAction.click(menuIcon, clickType.NORMAL_CLICK);
			}catch(Exception ex){
				extentLogger.addFail(ex.getMessage());
			}
			
		}
	
		@FindBy(id="mps_menusearch-1081-inputEl")
		private WebElement searchInputBox;
		
		public void enterTextToSearch(String text) {
			try{
				isElementVisible(searchInputBox);
				isElementInteractable(searchInputBox);
				uiAction.typeText(searchInputBox, text);
				wait(5000);
			}catch(Exception ex){
				extentLogger.addFail(ex.getMessage());
			}
			
		}
		@FindBy(css="div[id*='boundlist']>ul[id*='listEl']>li[role='option']")
		List<WebElement> lists;
		public void selectValueFromList(String value){
			try{
				uiAction.SelectFromListByVisibleText(lists, clickType.JS_CLICK, value);
			}catch(Exception ex){
				extentLogger.addFail(ex.getMessage());
			}
		}
	
}
