package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import baseinterfaces.IAction.clickType;
import core.BasePage;


public class ReltioProfilePage extends BasePage {

	public ReltioProfilePage(RemoteWebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//*[@type = 'search']")
	private WebElement searchBox;

	@FindBy(xpath = "(//*[@data-reltio-id= 'reltio-new-profile-band']/div/div[2]/div)[1]")
	private WebElement userNameText;
	
	@FindBy(xpath = "//span[text() = 'Customer Classification Level 1 ']/..")
	private WebElement customerClassificationValue;
	
	@FindBy(xpath="//span[contains(text(),'Reltio Golden Id')]/..")
	private WebElement reltioGoldenID;
	 
	@FindBy(xpath = "(//*[@data-reltio-id = 'reltio-composite-show-more-container-with-button']/div)[1]")
	private WebElement showMore;
	
	@FindBy(xpath = "//span[text() = 'Market Segment ']/..")
	private WebElement marketSegment;
	
	@FindBy(xpath = "//span[text() = 'Market Sub-Segment ']/..")
	private WebElement marketSubSegment;
	
	@FindBy(xpath = "//span[text() = 'Organization Role ']/..")
	private WebElement organizationRole;
	
	@FindBy(xpath = "//span[text() = 'Organization Name ']/..")
	private WebElement organizationName;
	
	WebDriverWait wait = new WebDriverWait(driver, 90);

	Actions action = new Actions(driver);

	private void enterbfoID(String id) {

		wait.until(ExpectedConditions.visibilityOf(searchBox));
		uiAction.typeText(searchBox, id);
		extentLogger.addPass("User entered BFO ID as: " + id);
	}

	private void selectUser(String user) {
		try {
			wait.until(ExpectedConditions.visibilityOf(driver
					.findElement(By.xpath("//*[@class = 'reltio-search-list-item']/div[contains(text() , '" + user + "')]"))));
			WebElement selectResults = driver
					.findElement(By.xpath("//*[@class = 'reltio-search-list-item']/div[contains(text() , '" + user + "')]"));

			action.moveToElement(selectResults).click(selectResults).build().perform();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void verifyUserName(String user) {
		wait.until(ExpectedConditions.visibilityOf(userNameText));
		extentLogger.addInfo("");
		Assert.assertEquals(userNameText.getText(), user);
		
	}
	
	
	private void verifyAccountname(String accountname) {
		wait.until(ExpectedConditions.visibilityOf(userNameText));
		Assert.assertEquals(userNameText.getText(), accountname);
		extentLogger.addPass("Account name: "+userNameText.getText());
	}
	
	private void verifyCustomerClassification(String classification) {
		wait.until(ExpectedConditions.visibilityOf(customerClassificationValue));
		System.out.println(customerClassificationValue.getText());
		Assert.assertTrue(customerClassificationValue.getText().contains(classification));
		extentLogger.addPass("Customer Classification is: "+customerClassificationValue.getText());
		uiAction.click(showMore,clickType.NORMAL_CLICK);
		extentLogger.addInfo("User clicked On Show More");
		extentLogger.addPass("Screenshot",addScreenshot());
	}
	
	private void verifyMarketSegment(String marketsegment) {
		wait.until(ExpectedConditions.visibilityOf(marketSegment));
		System.out.println(marketSegment.getText());
		Assert.assertTrue(marketSegment.getText().contains(marketsegment));
		extentLogger.addPass("Market Segment is: "+marketSegment.getText());
	}
	
	private void verifyMarketSubSegment(String marketsubsegment) {
		wait.until(ExpectedConditions.visibilityOf(marketSubSegment));
		System.out.println(marketSubSegment.getText());
		Assert.assertTrue(marketSubSegment.getText().contains(marketsubsegment));
		extentLogger.addPass("Market Sub-Segment is: "+marketSubSegment.getText());
	}
	private void verifyOrganizationRole() {
		
		wait.until(ExpectedConditions.visibilityOf(organizationRole));
		System.out.println(organizationRole.getText());
		Assert.assertTrue(organizationRole.getText().contains("Prospect"));
		extentLogger.addPass(organizationRole.getText());
	}
	
	
	private void verifyGoldenID(String goldenID) {
		wait.until(ExpectedConditions.visibilityOf(reltioGoldenID));
		System.out.println(reltioGoldenID.getText());
		Assert.assertTrue(reltioGoldenID.getText().contains(goldenID));
		extentLogger.addPass(reltioGoldenID.getText());
	}
	
	private void verifyOrgnizationName(String orgName){
		wait.until(ExpectedConditions.visibilityOf(organizationName));
		System.out.println(organizationName.getText());
		Assert.assertTrue(organizationName.getText().contains(orgName));
		extentLogger.addPass(organizationName.getText());
	}
	
	public void verifybfoUserCreation(String id, String user,String classification,String marketsegment, String marketsubsegment) {
		enterbfoID(id);
		selectUser(user);
		verifyUserName(user);
		verifyCustomerClassification(classification);
		verifyMarketSegment(marketsegment);
		verifyMarketSubSegment(marketsubsegment);
		verifyOrganizationRole();
	}
	
	public void verifyCustomerSalesViewCreation(String customerNumber, String accountname,String goldenID) {
		enterbfoID(customerNumber);
		selectUser(accountname);
		verifyAccountname(accountname);
		verifyGoldenID(goldenID);
	}

	public void clickOnCrossIcon() {
		String loc="//a[@data-reltio-id='com.reltio.plugins.DummyAction8']";
		WebElement element = waitForElement(By.xpath(loc));
		uiAction.click(element, clickType.NORMAL_CLICK);
		extentLogger.addPass("Click on Cross Icon");
	}
}
