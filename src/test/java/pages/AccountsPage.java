package pages;
import java.util.List;
import java.util.regex.Pattern;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import baseinterfaces.IAction.clickType;
import core.BasePage;
import driverfactory.DriverManager;
import utility.TimeUtility;

public class AccountsPage extends BasePage {

	public AccountsPage(RemoteWebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	@FindBy(xpath = "//a/span[text() = 'Accounts']")
	private WebElement accountsLink;

	@FindBy(xpath = "//div[@title='New']")
	private WebElement newButton;

	@FindBy(xpath = "//button[contains(text(),'Continue')]")
	private WebElement continueButton;

	@FindBy(xpath = "//div[contains(text(),'New Account')]")
	private WebElement newAccountText;

	@FindBy(xpath = "(//span[contains(text(),'Account Name')]//parent::label//preceding-sibling::input[@type='text'])[1]")
	private WebElement accountNameTextBox;

	@FindBy(xpath = "//label[contains(@class,'search-placeholder')]//preceding-sibling::input[@type='text']")
	private WebElement addressTextBox;

	@FindBy(xpath = "//span[contains(text(),'Classification Level 1 And 2')]//..//preceding-sibling::input[@type='text']")
	private WebElement classificationLevelTextBox;

	@FindBy(xpath = "//span[contains(text(),'Market Segment And Sub Segment')]//..//preceding-sibling::input[@type='text']")
	private WebElement marketSegmentTextBox;

	@FindBy(xpath = "//span[contains(text(),'Market Sub Segment')]//..//preceding-sibling::input[@type='text']")
	private WebElement subMarketSegmentTextBox;

	@FindBy(xpath = "//button[contains(text(),'Save')]")
	private WebElement saveButton;

	@FindBy(xpath = "//span[@class='toastMessage slds-text-heading--small forceActionsText']")
	private WebElement successMessage;

	WebDriverWait wait = new WebDriverWait(driver, 90);

	Actions action = new Actions(driver);

	public void clickOnAccountsLink() {
		uiAction.click(accountsLink, clickType.JS_CLICK);
		extentLogger.addInfo("User clicked on Accounts");
	}

	public void clickOnNewButton() {
		uiAction.click(newButton, clickType.JS_CLICK);
		extentLogger.addInfo("User clicked on New Button");

	}

	private void clickOnContinueButton() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(continueButton));
			uiAction.click(continueButton, clickType.JS_CLICK);
			extentLogger.addInfo("User clicked on Continue Button");
			try{
				waitForWebElementload(By.xpath("//div[contains(text(),'New Account')]"));
				}catch(Exception e)
				{
				waitForWebElementload(By.xpath("//div[contains(text(),'New Account')]"));	
				}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void enterAccountName(String accountName) throws Exception {
		accountName=TimeUtility.getTimewithTimeStamp(accountName);
		System.out.println(accountName);
		WebElement element = waitForElement(By.xpath("(//span[contains(text(),'Account Name')]//parent::label//preceding-sibling::input[@type='text'])[1]"));
		uiAction.click(element, clickType.JS_CLICK);
		element.sendKeys(accountName);
		//uiAction.typeText(accountNameTextBox, accountName);
		extentLogger.addInfo("User entered Account Name as: " + accountName);
	}

	private void enterAddress(String address) {
		uiAction.typeText(addressTextBox, address);
		extentLogger.addInfo("User entered Address as: " + address);
	}

	private void selectAddress(String selectAddress) throws Exception {
		WebElement element = waitForWebElementload(By.xpath("//div[@class='addr-block']//div[contains(text(),'" + selectAddress + "')]"));
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) DriverManager.getDriver();
		javascriptExecutor.executeScript("arguments[0].dispatchEvent(new MouseEvent('mouseover', {'bubbles': true }));", element);
	//	uiAction.click(element, clickType.JS_CLICK);
		extentLogger.addInfo("Select address as: " + element.getText());
		wait(25000);
		try {
			wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath(
					"//div[@class='proposed-address-block']//span[@class='refresh-proposed'][contains(text(),'0')]"))));
		} catch (Exception e) {
		}
	}

	private void clickOnClassificationLevelTextBox() {
		
		uiAction.click(classificationLevelTextBox, clickType.NORMAL_CLICK);
		extentLogger.addPass("User Clicked on Classification Level 1 and 2 TextBox");
	}

	private void selectClassificationLevel(String classificationLevel) {
		try {
			WebElement element = waitForWebElementload(By.xpath("//div[contains(text(),'" + classificationLevel + "')]"));
			//JavascriptExecutor javascriptExecutor = (JavascriptExecutor) DriverManager.getDriver();
			//javascriptExecutor.executeScript("arguments[0].focus(); arguments[0].click()", element);
			uiAction.click(element, clickType.ACTION_CLICK);
			extentLogger.addPass("User selected Classification Level as: " + classificationLevel);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void clickOnMarketSegmentTextBox() {
		wait(15000);
		uiAction.click(marketSegmentTextBox, clickType.NORMAL_CLICK);
		extentLogger.addPass("User Clicked on Market Segment TextBox");
	}

	private void selectMarketSegment(String marketSegment) {
		try {
			WebElement element = waitForWebElementload(By.xpath("//div[contains(text(),'" + marketSegment + "')]"));
			JavascriptExecutor javascriptExecutor = (JavascriptExecutor) DriverManager.getDriver();
			javascriptExecutor.executeScript("arguments[0].focus(); arguments[0].click()", element);
			extentLogger.addPass("User selected Market Segment as: " + marketSegment);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void clickOnSubMarketSegmentTextBox() {
		uiAction.click(subMarketSegmentTextBox, clickType.NORMAL_CLICK);
		extentLogger.addPass("User Clicked on Sub Market Segment TextBox");
	}

	private void selectSubMarketSegment(String subMarketSegment) {
		try {
			WebElement element = waitForWebElementload(By.xpath("//div[contains(text(),'" + subMarketSegment + "')]"));
			JavascriptExecutor javascriptExecutor = (JavascriptExecutor) DriverManager.getDriver();
			javascriptExecutor.executeScript("arguments[0].focus(); arguments[0].click()", element);
			extentLogger.addPass("User selected Sub Market Segment as: " + subMarketSegment);
			extentLogger.addInfo("Screenshot", addScreenshot());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void clickOnSaveButton() {
		uiAction.click(saveButton, clickType.JS_CLICK);
		extentLogger.addPass("User clicked on Save Button");
	}

	private void successMessageValidation(String AccountName) {
		try{
			wait.until(ExpectedConditions.visibilityOf(successMessage));
			System.out.println(successMessage.getText());
		if (successMessage.getText().contains("Account " + AccountName + " has been created")) {
			Thread.sleep(20000);
			extentLogger.addPass("Screenshot",addScreenshot());
		}
	   } catch(Exception ex) {
		   extentLogger.addFail("Screenshot",addScreenshot());
			Assert.fail();
		}
	}
	
	public String getbfoID(){
		//https://se--sitbfo21.lightning.force.com/lightning/r/Account/0011b00000xG2JXAA0/view
		String url= driver.getCurrentUrl();
		String[] subUrl1 = url.split(Pattern.quote("lightning/r/Account/"));
		String subUrl2 = subUrl1[1];
		System.out.println(subUrl2);
		String[] subUrl = subUrl2.split(Pattern.quote("/view"));
		String bfoID = subUrl[0];
		System.out.println(bfoID);
		return bfoID;
	}

	public void openNewTab() throws Exception{
		uiAction.openNewTab();
		//launchUrl(CONFIG.getProperty("Reltio_URL"));		
	}
	public void createAccount(String accountName, String address, String selectAddress, String classificationLevel,
			String marketSegment, String subMarketSegment) throws Exception {
		clickOnAccountsLink();
		clickOnNewButton();
		clickOnContinueButton();
		enterAccountName(accountName);
		enterAddress(address);
		selectAddress(selectAddress);
		clickOnClassificationLevelTextBox();
		selectClassificationLevel(classificationLevel);
		clickOnMarketSegmentTextBox();
		selectMarketSegment(marketSegment);
		clickOnSubMarketSegmentTextBox();
		selectSubMarketSegment(subMarketSegment);
		clickOnSaveButton();
		successMessageValidation(accountName);
		
	}
	
	
	public String AccountCreation() throws Exception
	{ 
		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 30);
		Actions action = new Actions(DriverManager.getDriver());
		WebElement btnNew = waitForWebElementload(By.xpath("//div[@title='New']"));
		JavaScriptClick(btnNew);
		extentLogger.addPass("Click on New Button.");
		WebElement btnContinue = waitForWebElementload(By.xpath("//button[contains(text(),'Continue')]"));
		JavaScriptClick(btnContinue);
		extentLogger.addPass("Click on Continue Button.");
		try{
			waitForWebElementload(By.xpath("//div[contains(text(),'New Account')]"));
			}catch(Exception e)
			{
			waitForWebElementload(By.xpath("//div[contains(text(),'New Account')]"));	
			}
		
		String AccountName = "BFO_Reltio" +System.currentTimeMillis();
		WebElement btnName = waitForWebElementload(By.xpath("(//span[contains(text(),'Account Name')]//parent::label//preceding-sibling::input[@type='text'])[1]"));
	     JavaScriptClick(btnName);
	     btnName.sendKeys(AccountName);
	 	extentLogger.addPass("Enter Account Name as "+AccountName);
	    	 WebElement btnSearch = waitForWebElementload(By.xpath("//label[contains(@class,'search-placeholder')]//preceding-sibling::input[@type='text']"));
		     JavaScriptClick(btnSearch);
		     btnSearch.sendKeys("Bangalore Road,635126 hosur");
		     extentLogger.addPass("Enter Address as Bangalore Road,635126 hosur");
			WebElement ele = waitForWebElementload(By.xpath("//div[@class='addr-block']//div[contains(text(),'Bangalore Road')]"));
			System.out.println(" Value "+ele.isDisplayed());
			List<WebElement> lists = DriverManager.getDriver().findElementsByXPath("//div[@class='addr-block']//div[contains(text(),'Bangalore Road')]");
			System.out.println(lists.size()+" List Size");
			lists.get(0).click();
			 extentLogger.addPass("Select Address as "+"Bangalore Road");
			wait(20000);
			try{
			wait.until(ExpectedConditions.invisibilityOf(DriverManager.getDriver().findElement(By.xpath("//div[@class='proposed-address-block']//span[@class='refresh-proposed'][contains(text(),'0')]"))));
			}catch(Exception e){}
			
			
	     WebElement drpclassLevel = waitForWebElementload(By.xpath("//span[contains(text(),'Classification Level 1 And 2')]//..//preceding-sibling::input[@type='text']"));
	     drpclassLevel.click();
	     extentLogger.addPass("Click on classification Level ");
		WebElement selectclassLevel = waitForWebElementload(By.xpath("//div[contains(text(),'IT Solution Provider')]"));
		selectclassLevel.click();
		extentLogger.addPass("Select Classification Level as "+"IT Solution Provider");
		//action.moveToElement(selectclassLevel).click(selectclassLevel).build().perform();
		
		WebElement drpMarketSegment = waitForWebElementload(By.xpath("//span[contains(text(),'Market Segment And Sub Segment')]//..//preceding-sibling::input[@type='text']"));
	     drpMarketSegment.click();
	 	extentLogger.addPass("Click on Market Segment ");
		WebElement selectMarketSegment = waitForWebElementload(By.xpath("//div[contains(text(),'Automotive & E-Mobility')]"));
		selectMarketSegment.click();
		extentLogger.addPass("Select Market Segment as  Level as "+"Automotive & E-Mobility");
		//action.moveToElement(selectMarketSegment).click(selectMarketSegment).build().perform();
        
		WebElement drpSubMarketSegment = waitForWebElementload(By.xpath("//span[contains(text(),'Market Sub Segment')]//..//preceding-sibling::input[@type='text']"));
	    drpSubMarketSegment.click();
	    extentLogger.addPass("Click on Market Sub Segment ");
		WebElement selectSubMarketSegment = waitForWebElementload(By.xpath("//div[contains(text(),'Automotive Manufacturers')]"));
		selectSubMarketSegment.click();
		//action.moveToElement(selectSubMarketSegment).click(selectSubMarketSegment).build().perform();
		extentLogger.addPass("Select Market Sub Segment as "+"Automotive Manufacturers");
    	WebElement btnSave = waitForWebElementload(By.xpath("//button[contains(text(),'Save')]"));
	     JavaScriptClick(btnSave);
	     extentLogger.addPass("Click on Save Button.");
        String strAccountName = null;
		 try{
		     WebElement lblAccount = waitForWebElementload(By.xpath("//span[@class='custom-truncate uiOutputText']"));
		     strAccountName = lblAccount.getText();
		 }
		     catch(Exception e)
		     {
		    	 WebElement lblAccount = waitForWebElementload(By.xpath("//h1//div[contains(text(),'Account')]"));
		    	 strAccountName = lblAccount.getText();
		     }
		 extentLogger.addInfo("Screenshot",addScreenshot());
		 return strAccountName;
	}
	
	public void JavaScriptClick(WebElement element) throws Exception {
		try {
			if (element.isEnabled() && element.isDisplayed()) {
				System.out.println("Clicking on element with using java script click");

				((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].click();", element);
			} else {
				System.out.println("Unable to click on element");
			}
		} catch (StaleElementReferenceException e) {
			System.out.println("Element is not attached to the page document "+ e.getStackTrace());
		} catch (NoSuchElementException e) {
			System.out.println("Element was not found in DOM "+ e.getStackTrace());
		} catch (Exception e) {
			System.out.println("Unable to click on element "+ e.getStackTrace());
		}
	}

	
	public void clickOnExistingAccount(String acccount) {
		try{
			By accountname = By.cssSelector("a[title='"+acccount+"']");
			WebElement element = waitForElement(accountname);
			uiAction.click(element, clickType.NORMAL_CLICK);
			extentLogger.addPass("Click on Account name"+acccount+ " Link to open an account");
		}catch(Exception ex){
			
		}
		
	}
}
