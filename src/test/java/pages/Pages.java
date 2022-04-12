package pages;

import org.openqa.selenium.remote.RemoteWebDriver;
import core.BasePage;

public class Pages extends BasePage {
	public enum QUOTE_HEADER_BUTTON{
		SAVE,SAVE_PRICE,SUBMIT,CREATE_ORDER,FULL_ORDER,REVISE,RETURN_TO_OPPORTUNITY
	}
	public Pages(RemoteWebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public AccountsPage ApprovalsPage(){
		return getPage(AccountsPage.class);
	}
	
	public BasePage BasePage(){
		return getPage(BasePage.class);
	}
	
	public LoginPage loginPage(){
		return getPage(LoginPage.class);
	}
	public AccountsPage AccountsPage(){
		return getPage(AccountsPage.class);
	}
	
	public ReltioProfilePage ReltioProfilePage(){
		return getPage(ReltioProfilePage.class);
	}
}
