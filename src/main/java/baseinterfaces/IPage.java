package baseinterfaces;
import org.openqa.selenium.WebElement;

public interface IPage {
	boolean isPageLoaded(WebElement element);
	void waitForElementToBeClickable(WebElement element);
	void waitForElementToBeVisible(WebElement element);
	void navigateToUrl(String url);
	void refreshPage();
	void moveNext();
	void movePrevious();
}
