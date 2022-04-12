package actions;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;

import baseinterfaces.IAction;
import driverfactory.DriverManager;
import managers.ExtentTestManager;

public class UiAction implements IAction {
	RemoteWebDriver driver;
	JavascriptExecutor jsExecutor;
	Actions actions;

	public UiAction(RemoteWebDriver driver) {
		this.driver = driver;
		jsExecutor = ((JavascriptExecutor) driver);
		actions = new Actions(driver);
	}

	/***
	 * @Date:17/03/2021
	 * @author SESA443020 Azharuddin Khan
	 * @param element
	 * @param text
	 * @Description: This Method used to interact with textbox using javascript
	 *               executor
	 */
	public void enterTextUsingJavaScript(WebElement element, String text) {
		jsExecutor.executeScript("arguments[0].value='" + text + "';", element);
	}

	/*****
	 * @Date 17/03/2021
	 * @author SESA443020 Azharuddin Khan
	 * @param element
	 * @param Choice
	 * @Description: This method is to use to perform click on element by using
	 *               element and type of click eg: Normal Click, JSClick, Action
	 *               Click using action class
	 */
	public void click(WebElement element, String Choice) {

		switch (Choice) {
		case "Normal Click":
			element.click();
			break;
		case "JSClick":
			jsExecutor.executeScript("arguments[0].click();", element);
			break;
		case "ActionClick":
			actions.moveToElement(element).click().build().perform();
			break;

		default:
			element.click();
		}

	}

	/**
	 * @Date: 17/03/2021
	 * @author SESA443020 Azharuddin Khan
	 * @description : This method used to refresh the active page.
	 */
	public void refreshPage() {
		driver.navigate().refresh();

	}

	/**
	 * @Date 17/03/2021
	 * @author SESA443020 Azharuddin Khan
	 * @param element
	 * @param text
	 * @description: This Method is used to type text into textbox or textarea
	 *               using sendKeys Selenium API
	 */
	public void typeText(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);
	}
	
	/**
	 * @Date 4/05/2021
	 * @param element
	 * @param text
	 * @description: This Method is used to sendKeys Selenium API to choose file for <input type=file/>
	 */
	public void fileChooseUsingSendkeys(WebElement element, String text) {
		element.sendKeys(text);
	}

	/*****
	 * @Date 17/03/2021
	 * @author SESA443020 Azharuddin Khan
	 * @param element
	 * @param Choice
	 * @Description: This method is to use to perform click on element by using
	 *               element and type of click
	 *
	 */
	@Override
	public void click(WebElement element, clickType clickType) {
		// TODO Auto-generated method stub
		switch (clickType) {
		case NORMAL_CLICK:
			element.click();
			break;
		case JS_CLICK:
			jsExecutor.executeScript("arguments[0].click();", element);
			break;
		case ACTION_CLICK:
			actions.moveToElement(element).click().build().perform();
			break;
		default:
			element.click();
		}
	}

	/****
	 * @Date 17/03/2021
	 * @author SESA443020 Azharuddin
	 * @param elements,
	 *            clickType, value
	 * @description This method is used to click on element from list of
	 *              elements with help of getText by using click type as Normal
	 *              or JS CLick or Action Click
	 */
	@Override
	public void click(List<WebElement> elements, clickType clickType, String value) {
		for (WebElement element : elements) {
			if (element.getText().equalsIgnoreCase(value)) {
				click(element, clickType);
				break;
			}
		}
	}

	/****
	 * @Date 17/03/2021
	 * @author SESA443020 Azharuddin
	 * @param elements,
	 *            clickType, attribute,value
	 * @description This method is used to click on element from list of
	 *              elements with help of getAttribute API by using click type
	 *              as Normal or JS CLick or Action Click and value
	 */
	public void click(List<WebElement> elements, clickType clickType, String attribute, String value) {

		for (WebElement element : elements) {
			if (element.getAttribute(attribute).equalsIgnoreCase(value)) {
				click(element, clickType);
				break;
			}
		}
	}

	/****
	 * @Date 17/03/2021
	 * @author SESA443020 Azharuddin
	 * @param element
	 * @description This method is used to double click on element with help of
	 *              Actions Class
	 */
	@Override
	public void doubleClick(WebElement element) {
		actions.moveToElement(element).doubleClick().build().perform();

	}

	/****
	 * @Date 17/03/2021
	 * @author SESA443020 Azharuddin
	 * @param element
	 *            ,text
	 * @description This method is used to double click on element from list of
	 *              elements using Actions Class
	 */
	@Override
	public void doubleClick(List<WebElement> elements, String text) {
		for (WebElement element : elements) {
			if (element.getText().equalsIgnoreCase(text)) {
				actions.moveToElement(element).doubleClick().build().perform();
				break;
			}
		}
	}

	/****
	 * @Date 17/03/2021
	 * @author SESA443020 Azharuddin
	 * @param element
	 *            ,text
	 * @description This method is used to double click on element from list of
	 *              elements using Actions Class with help of attribute and
	 *              value
	 */
	public void doubleClick(List<WebElement> elements, String attribute, String value) {
		for (WebElement element : elements) {
			if (element.getAttribute(attribute).equalsIgnoreCase(value)) {
				actions.moveToElement(element).doubleClick().build().perform();
				break;
			}
		}
	}

	/****
	 * @Date 17/03/2021
	 * @author SESA443020 Azharuddin
	 * @param element
	 * @description This method is used to perform right click on element
	 */
	@Override
	public void rightClick(WebElement element) {
		actions.contextClick(element).build().perform();

	}

	/****
	 * @Date 17/03/2021
	 * @author SESA443020 Azharuddin
	 * @param elements,value
	 * @description This method is used to perform right click on element from
	 *              list of elements using getText API
	 */
	@Override
	public void rightClick(List<WebElement> elements, String value) {
		for (WebElement element : elements) {
			if (element.getText().equalsIgnoreCase(value)) {
				actions.contextClick(element).build().perform();
				break;
			}
		}

	}

	/****
	 * @Date 17/03/2021
	 * @author SESA443020 Azharuddin
	 * @param elements,attribute
	 *            ,value
	 * @description This method is used to perform right click on element from
	 *              list of elements using getAttribute with value
	 */
	public void rightClick(List<WebElement> elements, String attribute, String value) {
		for (WebElement element : elements) {
			if (element.getAttribute(attribute).equalsIgnoreCase(value)) {
				actions.contextClick(element).build().perform();
				break;
			}
		}

	}

	/****
	 * @Date 17/03/2021
	 * @author SESA443020 Azharuddin
	 * @param element
	 * @description This method is used to perform mouse hover on element
	 */
	@Override
	public void mouseHover(WebElement element) {
		actions.moveToElement(element).build().perform();

	}

	/****
	 * @Date 17/03/2021
	 * @author SESA443020 Azharuddin
	 * @param elements,value
	 * @description This method is used to perform mouse hover on element from
	 *              list of elements using getText
	 */
	@Override
	public void mouseHover(List<WebElement> elements, String value) {
		for (WebElement element : elements) {
			if (element.getText().equalsIgnoreCase(value)) {
				actions.moveToElement(element).build().perform();
				break;
			}
		}

	}

	/****
	 * @Date 17/03/2021
	 * @author SESA443020 Azharuddin
	 * @param elements,attribute,value
	 * @description This method is used to perform mouse hover on element from
	 *              list of elements using getAttribute and Value
	 */
	public void mouseHover(List<WebElement> elements, String attribute, String value) {
		for (WebElement element : elements) {
			if (element.getAttribute(attribute).equalsIgnoreCase(value)) {
				actions.moveToElement(element).build().perform();
				break;
			}
		}

	}

	/**
	 * @date 17/03/2021
	 * @author SESA443020 Azharuddin Khan
	 * @param element
	 * @param type
	 * @param text
	 * @description: This method is provides way to input text in
	 *               textbox/textarea by using SendKeys or By Using Javascript
	 *               executor
	 */
	@Override
	public void inputText(WebElement element, Type type, String text) {

		switch (type) {
		case SENDKEYS:
			typeText(element, text);
			break;
		case JAVSSCRIPT:
			enterTextUsingJavaScript(element, text);
		default:
			break;
		}
	}

	/**
	 * @date: 17/03/2021
	 * @author SESA443020 Azharuddin Khan
	 * @param element,index
	 * @description This method is used to select value from dropdown using
	 *              index
	 * 
	 */
	@Override
	public void selectDropDownValue(WebElement element, int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}

	/**
	 * @author SESA443020 Azharuddin Khan
	 * @param element,SelectType(enum),value
	 * @description This method is used to interact with dropdowns(select tag)
	 *              by using BY_VALUE,BY_VISIBLE_TEXT
	 */
	@Override
	public void selectDropDownValue(WebElement element, SelectType type, String value) {
		Select sel = new Select(element);
		switch (type) {
		case BY_VALUE:
			if (!sel.getFirstSelectedOption().getText().equals(value))
				sel.selectByValue(value);
			break;

		case BY_VISIBLE_TEXT:
			if (!sel.getFirstSelectedOption().getText().equals(value))
				sel.selectByVisibleText(value);
			break;

		default:
			if (!sel.getFirstSelectedOption().getText().equals(value))
				sel.selectByVisibleText(value);
			break;
		}
	}

	/**
	 * @date 17/03/2021
	 * @author SESA443020 Azharuddin Khan
	 * @param elements,clicktype,text
	 * @description This method is to select element from list of elements using
	 *              getText and Click operation
	 */
	@Override
	public void SelectFromListByVisibleText(List<WebElement> elements,clickType type, String text) {
	
		/*WebElement element = elements.stream().filter(ele -> ele.getText().equalsIgnoreCase(text)).
				collect(Collectors.toList()).get(0);
				click(element, type);
		*/
		for (int i = 0; i < elements.size(); i++) {
			System.out.println(elements.get(i).getText());
			if (elements.get(i).getText().equalsIgnoreCase(text)) {
				click(elements.get(i),type);
				break;
			}
		}

	}
	
	/**
	 * 
	 * @param elements
	 * @param type
	 * @param text
	 */
	public void SelectFromListByVisibleTextUsingContains(List<WebElement> elements,clickType type, String text) {
		WebElement element = elements.stream().filter(ele -> ele.getText().contains(text)).
		collect(Collectors.toList()).get(0);
		click(element, type);
/*		
		for (int i = 0; i < elements.size(); i++) {
			if(elements.get(i).getText().contains(text)){
				click(elements.get(i), type);
				break;
			}
		}

*/	}
	
	/**
	 * @author SESA443020
	 *@date 14/04/2021
	 *@description : This method is to use to click in list of elements based on html attribute and expected value
	 * @param elements
	 * @param type
	 * @param attribute
	 * @param value
	 */
	public void SelectFromListByAttribute(List<WebElement> elements,clickType type,String attribute,String value) {
		
		for (int i = 0; i < elements.size(); i++) {
			if(elements.get(i).getAttribute(attribute).equalsIgnoreCase(value)){
				click(elements.get(i), type);
				break;
			}
		}
		

	}

	/***
	 * @date 17/03/2021
	 * @author SESA443020 Azharuddin Khan
	 * @description This method is use to accept the alert popup
	 */
	@Override
	public void acceptAlert() {
		Alert alert = DriverManager.getDriver().switchTo().alert();
		alert.accept();
	}

	/***
	 * @date 17/03/2021
	 * @author SESA443020 Azharuddin Khan
	 * @description This method is use to dismiss the alert popup
	 */
	@Override
	public void dismissAlert() {
		Alert alert = DriverManager.getDriver().switchTo().alert();
		alert.dismiss();

	}

	/***
	 * @date 17/03/2021
	 * @author SESA443020 Azharuddin Khan
	 * @return
	 * @description This method is will return text from alert
	 */
	@Override
	public String getTextFromAlert() {
		Alert alert = DriverManager.getDriver().switchTo().alert();
		return alert.getText();
	}

	/**
	 * @author SESA443020 Azharuddin Khan
	 * @param element
	 * @param options
	 * @param value
	 * @return
	 * @description This method is used to get text from element using getText
	 *              or GetAttribute Selenium API
	 */
	@Override
	public String getTextFromElement(WebElement element, Options options, String...value) {
		String res = "";
		switch (options) {
		case GET_TEXT:
			res = element.getText().trim();
			break;
		case GET_ATTRIBUTE:
			res = element.getAttribute(value[0]);
			break;
		}
		return res;
	}
	
	/**
	 * @date 06/04/2021
	 * @author SESA443020 Azharuddin Khan
	 * @description This method is used to get text from list of web elements based matches with expected value,
	 * passing option as GetText or GetAttrbiute, 
	 * 
	 * @param elements
	 * @param options
	 * @param value (var arg parameter is used to pass multiple values ie. attribute , value
	 * @return
	 */
	public String getTextFromListofElements(List<WebElement> elements, Options options, String...data) {
		String res = "";
		switch (options) {
		case GET_TEXT:
			for(int i=0;i<elements.size();i++){
				if(elements.get(i).getText().equals(data[0])){
					res=elements.get(i).getText();
					break;
				}else{
					res=null;
				}
			}
			break;
		case GET_ATTRIBUTE:
			for(int i=0;i<elements.size();i++){
				System.out.println(elements.get(i).getAttribute(data[0]));
				if(elements.get(i).getAttribute(data[0]).equals(data[1])){
					res=elements.get(i).getAttribute(data[0]);
					break;
				}else{
					res=null;
				}
			}
			break;
		}
		return res;
	}
	

	/**
	 * @date 17/03/2021
	 * @author SESA443020 Azharuddin Khan
	 * @param name
	 * @return
	 * @descroiption This method is used to get text from element using
	 *               javascript by element id attribute
	 */
	@Override
	public String getElementValueUsingJSByID(String id) {
		// TODO Auto-generated method stub
		return jsExecutor.executeScript("return document.getElementById('" + id + "').value").toString();
	}

	/**
	 * @date 17/03/2021
	 * @author SESA443020 Azharuddin Khan
	 * @param name
	 * @return
	 * @descroiption This method is used to get text from element using
	 *               javascript by element name attribute
	 */
	@Override
	public String getElementValueUsingJSByName(String name) {
		return jsExecutor.executeScript("return document.getElementByName('" + name + "').value").toString();
	}

	/**
	 * @date 17/03/2021
	 * @author SESA443020
	 * @param type
	 * @description This method is used to perform some keyboard actions like
	 *              Scroll PageUP, PageDown,HOME,END,ENTER
	 */

	@Override
	public void scrollPage(ScrollType type) {
		WebElement element = null;
		switch (type) {
		case HOME:
			element = driver.findElement(By.cssSelector("body"));
			element.sendKeys(Keys.HOME);
			break;
		case END:
			element = driver.findElement(By.cssSelector("body"));
			element.sendKeys(Keys.END);
			break;
		case PAGE_UP:
			element = driver.findElement(By.cssSelector("body"));
			element.sendKeys(Keys.PAGE_UP);
			break;
		case PAGE_DOWN:
			element = driver.findElement(By.cssSelector("body"));
			element.sendKeys(Keys.PAGE_DOWN);
			break;
		case ENTER:
			element = driver.findElement(By.cssSelector("body"));
			element.sendKeys(Keys.ENTER);
			break;
		default:
			break;
		}

	}

	/**
	 * @author SESA443020 Azharuddin Khan
	 * @Date 14/05/2021
	 * @param window
	 * @description : This method will switch to new opened window , accepting
	 *              current window id as input
	 */
	public void switchToNewWindow(String window) {
		// Get handles of the windows
		Set<String> allWindowHandles = DriverManager.getDriver().getWindowHandles();
		Iterator<String> iterator = allWindowHandles.iterator();

		// Here we will check if child window has other child windows and will
		// fetch the heading of the child window
		while (iterator.hasNext()) {
			String ChildWindow = iterator.next();
			if (!window.equalsIgnoreCase(ChildWindow)) {
				DriverManager.getDriver().switchTo().window(ChildWindow);
				DriverManager.getDriver().manage().window().maximize();
			}
		}
	}

	/**
	 * @date 17/03/2021
	 * @author SESA443020 Azharuddin Khan
	 * @param window
	 * @description This Method is used to switch to parent window ,which
	 *              requires parent window id
	 */
	public void switchToParentWindow(String window) {
		DriverManager.getDriver().switchTo().window(window);
	}

	/***
	 * @Date 17/03/2021
	 * @author SESA443020 Azharuddin Khan
	 * @return
	 * @description : This Method is to use to get active window ID
	 */
	public String getParentWindow() {
		// TODO Auto-generated method stub
		return driver.getWindowHandle();
	}
	/**
	 * @date 19/03/2021
	 * @author SESA443020 Azharuddin Khan
	 * @throws InterruptedException 
	 * @description This method is used to wait for the page to be loaded
	 */
	public  void waitPageToBeLoaded() throws InterruptedException{
		new WebDriverWait(driver, 120).until(
				driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
		int count =0;
        if((Boolean) jsExecutor.executeScript("return window.jQuery != undefined")){
            while(!(Boolean) jsExecutor.executeScript("return jQuery.active == 0")){
                Thread.sleep(4000);
                if(count>4)
                    break;
                count++;
            }
        }
	
	}
	
	/**
	 * @author SESA443020
	 * @date 14/04/2021
	 * @description: This method is used to switch to any frame with frame id
	 * @param id
	 */
	public void switchToFrameById(String id){
		DriverManager.getDriver().switchTo().frame(id);
	}
	
	/**
	 * @author SESA443020
	 * @date 14/04/2021
	 * @description: This method is used to switch to any frame, using frame index
	 * @param index
	 */
	public void SwitchToFrameByIndex(int index){
		DriverManager.getDriver().switchTo().frame(index);
	}
	/**
	 * @author SESA443020
	 * @date 14/04/2021
	 * @description: This method is used to switch to any frame with WebElement (eg. iframe or frame Tag)
	 * @param element
	 */
	public void SwitchToFrameByWebelement(WebElement element){
		DriverManager.getDriver().switchTo().frame(element);
	}
	
	/**
	 * @author SESA443020
	 * @date 14/04/2021
	 * @description: This method is used to switch from all frames and focus to main page elements*/
	public void switchToDefault(){
		DriverManager.getDriver().switchTo().defaultContent();
	}
	
	/**
	 * @author SESA443020
	 * @date 14/04/2021
	 * @description: This method is used to come out from present frame,then we can access the elements outside that frame and not inside of that frame*/
	public void switchToParent(){
		DriverManager.getDriver().switchTo().parentFrame();
	}
	
	
	/**
	 * @author SESA443020
	 * @Date 14/05/2021
	 * @Description This Method used to select element by using Mouse and Control Key from Keyboard with help of Action Class
	 * @param element
	 */
	public void selectTableRowUsingMouseKeyAction(WebElement element){
		Actions builder = new Actions(DriverManager.getDriver());
		Action seriesOfActions = builder
				.moveToElement(element)
				.keyDown(Keys.CONTROL)
				.pause(2000)
				.click(element)
				.keyUp(Keys.CONTROL)
				.build();
		seriesOfActions.perform() ;
	}
	
	/**
	 * @author SESA443020
	 * @Date 14/05/2021
	 * @description : This Method used to filter list of elements and return single WebElement by passing List<WebElement> and String value
	 * @param elements
	 * @param value
	 * @return
	 */
	public WebElement getElementFromListsOfElements(List<WebElement> elements,String value){
		return elements.stream().filter(ele -> ele.getText().equals(value)).
		collect(Collectors.toList()).get(0);
	}
	
	public void uploadFileUsingSendkeys(WebElement browseFileButton,String filePath){
		browseFileButton.sendKeys(filePath);
	}

	@Override
	public void dragNDrop(WebElement source, WebElement destination) {
		Actions dragDropSignature = new Actions(driver);
		dragDropSignature.moveToElement(source).dragAndDrop(source, destination).build().perform();
	}

	/**
	 * 
	 */
	public void openNewTab() {
		try {
			String a = "window.open('about:blank','_blank');";
			((JavascriptExecutor) DriverManager.getDriver()).executeScript(a);
			ArrayList<String> tabs = new ArrayList<String>(DriverManager.getDriver().getWindowHandles());
			driver.switchTo().window(tabs.get(1));
			
		}

		catch (Exception e) {

			ExtentTestManager.getTest().log(LogStatus.FAIL,"New Tab Not Opened.");
		}
		
	}
	
	/**
	 * 
	 * @param n
	 */
	public static void switchToWindowOrTab(int n) {
		ArrayList<String> tabs = new ArrayList<String>(DriverManager.getDriver().getWindowHandles());
		DriverManager.getDriver().switchTo().window(tabs.get(n));
	}
	
}
