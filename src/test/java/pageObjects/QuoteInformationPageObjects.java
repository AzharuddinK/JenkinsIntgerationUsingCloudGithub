package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import core.BasePage;

public class QuoteInformationPageObjects extends BasePage {

	public QuoteInformationPageObjects(RemoteWebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	@FindBy(name="quoteInformation")
	protected WebElement quoteNameTextbox;
	
}
