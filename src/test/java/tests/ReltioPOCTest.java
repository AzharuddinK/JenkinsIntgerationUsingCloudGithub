package tests;
import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import configFactory.CONFIG;
import driverfactory.DriverFactory;
import driverfactory.DriverManager;
import driverfactory.TestUtil;
import managers.ExtentTestManager;

public class ReltioPOCTest extends TestBase {

	@BeforeTest
	public void setup(){
		DriverManager.setWebDriver(DriverFactory.createWebDriverInstance("Browserstack"));
	}
	@Test(priority = 1,dataProvider="ExcelDP1",dataProviderClass=TestUtil.class)
	public void reltioPOC(Hashtable<String, String> data) throws Exception {
		page.BasePage().navigateToApplication("http://www.google.com");
		ExtentTestManager.getTest().log(LogStatus.INFO, "Navigating to Google.com");
		ExtentTestManager.getTest().log(LogStatus.INFO, "Statement 1");
		ExtentTestManager.getTest().log(LogStatus.INFO, "Statement 1");
		ExtentTestManager.getTest().log(LogStatus.INFO, "Statement 1");
		/*page.loginPage().LogintoApplication(data.get("bfoUser"), data.get("bfoPassword"));
		page.AccountsPage().createAccount(data.get("AcountName"), data.get("Address"), data.get("SelectAddress"),
				data.get("ClassificationLevel"), data.get("MarketSegment"), data.get("SubMarketSegment"));
		page.AccountsPage().clickOnAccountsLink();
		String accountName = page.AccountsPage().AccountCreation();
		String bfoId = page.AccountsPage().getbfoID();
		
        page.AccountsPage().openNewTab();
        page.BasePage().navigateToApplication(config.getProperty("Reltio_URL", CONFIG.APPLICATION));
        page.loginPage().LogintoReltioApplication(data.get("CDLUser"), data.get("CDLPassword"));
        page.ReltioProfilePage().verifybfoUserCreation(bfoId,accountName, data.get("ClassificationLevel"), data.get("MarketSegment"), data.get("SubMarketSegment"));*/
	}

	@Test(priority = 2,dataProvider="ExcelDP1",dataProviderClass=TestUtil.class)
	public void reltioPOC1(Hashtable<String, String> data) throws Exception {
		page.BasePage().navigateToApplication("http://www.google.com");
		ExtentTestManager.getTest().log(LogStatus.INFO, "Navigating to Google.com");
		ExtentTestManager.getTest().log(LogStatus.INFO, "Statement 1");
		ExtentTestManager.getTest().log(LogStatus.INFO, "Statement 1");
		ExtentTestManager.getTest().log(LogStatus.INFO, "Statement 1");
		/*page.loginPage().LogintoApplication(data.get("bfoUser"), data.get("bfoPassword"));
		page.AccountsPage().createAccount(data.get("AcountName"), data.get("Address"), data.get("SelectAddress"),
				data.get("ClassificationLevel"), data.get("MarketSegment"), data.get("SubMarketSegment"));
		page.AccountsPage().clickOnAccountsLink();
		String accountName = page.AccountsPage().AccountCreation();
		String bfoId = page.AccountsPage().getbfoID();
		
        page.AccountsPage().openNewTab();
        page.BasePage().navigateToApplication(config.getProperty("Reltio_URL", CONFIG.APPLICATION));
        page.loginPage().LogintoReltioApplication(data.get("CDLUser"), data.get("CDLPassword"));
        page.ReltioProfilePage().verifybfoUserCreation(bfoId,accountName, data.get("ClassificationLevel"), data.get("MarketSegment"), data.get("SubMarketSegment"));*/
	}

}
