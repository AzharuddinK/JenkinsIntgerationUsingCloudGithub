package pageObjects;
import tests.TestBase;

public class Test extends TestBase {
	
	public void test(){
		page.getPage(QuoteInformationPage.class)
		.setQuoteName("spaType")
		.setSPAType("")
		.setQuoteName("")
		.setSPAType("");
	}


}
