package pageObjects;

import org.openqa.selenium.remote.RemoteWebDriver;

public class QuoteInformationPage extends QuoteInformationPageObjects implements QuoteInformation {

	public QuoteInformationPage(RemoteWebDriver driver) {
		super(driver);
	}

	@Override
	public QuoteInformationPage setQuoteName(String quoteName) {
		try{
			uiAction.typeText(quoteNameTextbox, quoteName);
		}catch(Exception ex){
			
		}
		return this;
	}

	@Override
	public QuoteInformationPage setSPAType(String spaType) {
		try{
			uiAction.typeText(quoteNameTextbox, spaType);
		}catch(Exception ex){
			
		}
		return this;
	}

}
