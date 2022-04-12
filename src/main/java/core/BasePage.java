package core;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.function.Function;

import javax.imageio.ImageIO;
import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.relevantcodes.extentreports.LogStatus;
import logger.ExtentLogger;
import managers.ExtentTestManager;
import utility.MyScreenRecorder;
import actions.UiAction;
import baseinterfaces.IAction.ScrollType;
import configFactory.CONFIG;
import driverfactory.DriverManager;

public class BasePage extends Page {
	//public static Logger logger = Logger.getLogger(BasePage.class.getName());
	public  String quoteTotalPriceFromUI="";
	protected UiAction uiAction;
	protected ExtentLogger extentLogger;
	protected WebDriverWait wait;

	public BasePage(RemoteWebDriver driver) {
		super(DriverManager.getDriver());
		this.wait = new WebDriverWait(DriverManager.getDriver(), 120);
		this.uiAction = new UiAction(DriverManager.getDriver());
		this.extentLogger = new ExtentLogger(ExtentTestManager.getTest());
		//PropertyConfigurator.configure("log4j.properties");
	}

	public void navigateToApplication() {
		DriverManager.getDriver().get(config.getProperty("applicationUrl", CONFIG.APPLICATION));
		extentLogger.addInfo("Open Application URL :" + config.getProperty("applicationUrl", CONFIG.APPLICATION));
		//logger.info("Open Application URL :" + config.getProperty("applicationUrl", CONFIG.APPLICATION));
		// LOGGER.logInfo("LoginPage", "Open Application URL :"+
		// config.getProperty("applicationUrl", CONFIG.APPLICATION));
	}

	public void navigateToApplication(String url) {
		DriverManager.getDriver().get(url);
		extentLogger.addInfo("Open Application URL :" +url);
		//logger.info("Open Application URL :" +url);
	}

	public String addScreenshot() {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String encodedBase64 = null;
		FileInputStream fileInputStreamReader = null;
		try {
			fileInputStreamReader = new FileInputStream(scrFile);
			byte[] bytes = new byte[(int) scrFile.length()];
			fileInputStreamReader.read(bytes);
			encodedBase64 = new String(Base64.encodeBase64(bytes));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			test.log(LogStatus.FAIL, e.getMessage());
			extentLogger.addFail(e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
			extentLogger.addFail(e.getMessage());
		}
		return "data:image/png;base64," + encodedBase64;
	}

	public boolean waitForElementToBeDisplayed(WebElement element) {
		return wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
	}

	public boolean waitForElementToBeClickable(WebElement element) {
		return wait.until(ExpectedConditions.elementToBeClickable((element))).isEnabled();
	}

	public boolean isPageLoaded(WebElement element) {
		return wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed()
				&& wait.until(ExpectedConditions.elementToBeClickable((element))).isEnabled();
	}
	
	public boolean isPageLoaded(WebElement element,int timeout) {
		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), timeout);
		return wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed()
				&& wait.until(ExpectedConditions.elementToBeClickable((element))).isEnabled();
	}

	public boolean isElementInteractable(WebElement element) {
		return wait.until(ExpectedConditions.elementToBeClickable((element))).isEnabled();
	}

	public boolean isElementVisible(WebElement element) {
		return wait.until(ExpectedConditions.visibilityOf((element))).isDisplayed();
	}

	public List<WebElement> isAllElementVisible(List<WebElement> elements) {
		return wait.until(ExpectedConditions.visibilityOfAllElements((elements)));
	}
	
	public boolean isListOfelementsVisible(List<WebElement> elements) {
		wait.until(ExpectedConditions.visibilityOfAllElements((elements)));
		return elements.size()>0;
	}

	public void waitForProgress() {
		WebElement ele =null;
		
		try {
			ele = DriverManager.getDriver()
			.findElement(By.xpath("//oj-progress[@role='progressbar'][@type='circle']"));
			while (ele.isDisplayed()) {
				if (ele.getAttribute("title").equals("Completed")) {
					System.out.println(ele.getAttribute("title"));
					break;
				} else {
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		} catch (StaleElementReferenceException ex) {
			ele = DriverManager.getDriver().findElement(By.xpath("//oj-progress[@role='progress'][@type='circle']"));
			String value = ele.getAttribute("title");
			System.out.println("Value " + value);
		}
	}

	public void refreshPage() {
		DriverManager.getDriver().navigate().refresh();
		try {
			Thread.sleep(15000);
		} catch (Exception ex) {

		}
	}
	
	public void wait(int miliseconds){
		try{
			Thread.sleep(miliseconds);
		}catch(Exception ex){
			
		}
	}
	
	public  void waitPageToBeLoaded() throws InterruptedException{
		uiAction.waitPageToBeLoaded();
	
	}
	
	public void switchFrame(String frameId){
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameId));
	}
	
	public void switchFrame1(String frameId){
		uiAction.switchToFrameById(frameId);
	}
	
	public void switchFrame(By locator){
		locator=By.cssSelector("iframe[name*='iFrameTabs_']");
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
	}
	
	public void switchToDefaultContent(){
		DriverManager.getDriver().switchTo().defaultContent();
	}
	
	public void switchToParent(){
		DriverManager.getDriver().switchTo().parentFrame();
	}
	
	public String getQuoteStatus(){
		String quoteStatus=null;
		if(quoteStatus==null){
			quoteStatus = uiAction.getElementValueUsingJSByID("status_quote");
			extentLogger.addInfo("Quote Status: "+quoteStatus);
			//logger.info("Quote Status"+quoteStatus);
		}
		return quoteStatus;
	}
	
	public String getQuoteNumber(){
		String quoteNumber = null;
		if(quoteNumber==null){
			quoteNumber = uiAction.getElementValueUsingJSByID("quoteNumber_quote");
			extentLogger.addInfo("Quote Number"+quoteNumber);
			//logger.info("Quote Number"+quoteNumber);
		}
		return quoteNumber;
	}

	public String getCurrentwindow(){
		return uiAction.getParentWindow();
	}
	
	public void switchToNewWindow(String currentWindow){
		uiAction.switchToNewWindow(currentWindow);
		driver.manage().window().maximize();
	}
	
	public void switchBackToMainWindow(String currentWindow){
		uiAction.switchToParentWindow(currentWindow);
		extentLogger.addInfo("Screen", addScreenshot());
	}
	
	public  String addScreenShotUsingRobotClass(String screenshotName) {
		String encodedBase64 = null;
		FileInputStream fileInputStreamReader = null;
		try {
			Toolkit tool = Toolkit.getDefaultToolkit();
			Dimension d = tool.getScreenSize();
			Rectangle rect = new Rectangle(d);
			Robot robot = new Robot();
			Thread.sleep(2000);
			// File f = new File("screenshot.png");
			File f = new File(System.getProperty("user.dir") + "\\RobotScreenshot\\"+screenshotName+".png");
			BufferedImage img = robot.createScreenCapture(rect);
			ImageIO.write(img, "png", f);
			fileInputStreamReader = new FileInputStream(f);
			byte[] bytes = new byte[(int) f.length()];
			fileInputStreamReader.read(bytes);
			encodedBase64 = new String(Base64.encodeBase64(bytes));
			tool.beep();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "data:image/png;base64," + encodedBase64;

	}

	public void scrollToHome(){
		uiAction.scrollPage(ScrollType.HOME);
	}
	public void scrollToEND(){
		uiAction.scrollPage(ScrollType.END);
	}
	
	public void startRecording(String filename){
		try {
			MyScreenRecorder.startRecording(filename);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void stopRecording(){
		try {
			MyScreenRecorder.stopRecording();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void switchToParentDefaultContent(){
		switchToDefaultContent();
		switchToParent();
		switchToDefaultContent();
	}
	
	By childFrame = By.cssSelector("iframe[name*='iFrameTabs_']");
	public void switchToChildFrame(){
		switchFrame(childFrame);
	}
	
	public void closeBrowser(){
		DriverManager.getDriver().close();
		extentLogger.addInfo("Closed Broswer but session active.");
	}
	
	public WebElement waitForElement(By by) {
		return waitForElement(by, 180, 1);
	}
	
	
	public WebElement waitForElements(By by) {
		return waitForElement(by, 180, 1);
	}

	protected WebElement waitForElement(By by, int timeOut, int pollingTime) {

		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverManager.getDriver()).withTimeout(Duration.ofSeconds(timeOut))
				.pollingEvery(Duration.ofSeconds(pollingTime)).ignoring(NoSuchElementException.class);

		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(by);
			}
		});
		return element;
	}
	
	public WebElement waitForWebElementload(By by) throws Exception
	{
		WebElement element;
		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 90);
		try{
		wait.until(ExpectedConditions.visibilityOf(DriverManager.getDriver().findElement(by)));
		}catch(Exception e){}
		wait.until(ExpectedConditions.elementToBeClickable(DriverManager.getDriver().findElement(by)));
		element = DriverManager.getDriver().findElement(by);
		return element;
	}
	
	public List<WebElement>  waitForWebElementsload(By by) throws Exception
	{
		List<WebElement> element=null;
		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 90);
		try{
		wait.until(ExpectedConditions.visibilityOfAllElements(DriverManager.getDriver().findElements(by)));
		element = DriverManager.getDriver().findElements(by);
		}catch(Exception e){}


		return element;
	}
}
