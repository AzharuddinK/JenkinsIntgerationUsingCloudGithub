package baseinterfaces;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import baseinterfaces.IAction.SelectType;
/**
 * Common Actions(Web/Mobile)
 * @author SESA443020
 *
 */
public interface IAction{
	 enum ScrollType 
	 { 
	     HOME, PAGE_UP, PAGE_DOWN,END,ENTER; 
	 } 
	 public enum clickType{
		 NORMAL_CLICK,JS_CLICK,ACTION_CLICK,KEY_ENTER
	 }
	 enum Type{
		 SENDKEYS,JAVSSCRIPT
	 }
	 enum Options{
		 GET_TEXT,GET_ATTRIBUTE
	 }
	 enum SelectType{
		 BY_VISIBLE_TEXT,BY_VALUE
	 }
    /**Actions on Web Elements*/
	void click(WebElement element,clickType clickType);
	void click(List<WebElement> element,clickType clickType,String options);
	void doubleClick(WebElement element);
	void doubleClick(List<WebElement>elements,String options);
	void rightClick(WebElement element);
	void rightClick(List<WebElement> elements,String options);
	void mouseHover(WebElement element);
	void mouseHover(List<WebElement> elements,String options);
	void inputText(WebElement element,Type type,String text);
	void selectDropDownValue(WebElement element,SelectType type,String value);
	void selectDropDownValue(WebElement element,int index);
	void SelectFromListByVisibleText(List<WebElement> elements,clickType type,String text);
	void acceptAlert();
	void dismissAlert();
	String getTextFromAlert();
	String getTextFromElement(WebElement element,Options options,String... value);
	String getElementValueUsingJSByID(String id);
	String getElementValueUsingJSByName(String name);
	void scrollPage(ScrollType type);
	void dragNDrop(WebElement source,WebElement destination);
	
}
