package tests;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baseinterfaces.IAction.clickType;
import driverfactory.DriverFactory;
import driverfactory.DriverManager;
import pages.ManhattanLoginPage;

public class Manhattan_POC extends TestBase {

	@BeforeTest
	public void setup(){
		DriverManager.setWebDriver(DriverFactory.createWebDriverInstance("Chrome"));
	}
	@Test(priority = 1)
	public void reltioPOC() throws Exception {
		page.BasePage().navigateToApplication("https://qathenswmos-vip.mop.se.com/manh/index.html");
		page.getPage(ManhattanLoginPage.class).LogintoManhattanApplication("ADM386388","ADM386388");
		Thread.sleep(45000);
		page.getPage(ManhattanLoginPage.class).clickonMenu();
		page.getPage(ManhattanLoginPage.class).enterTextToSearch("Distribution Orders");
		page.getPage(ManhattanLoginPage.class).selectValueFromList("Distribution Orders (Distribution)");
		Thread.sleep(45000);
		WebElement element =DriverManager.getDriver().findElement(By.cssSelector("div>img.x-tool-img.x-tool-maximize"));
		element.click();
		Thread.sleep(15000);
		DriverManager.getDriver().findElement(By.xpath("//label[text()='Primary Fields']/following-sibling::div/div/div/div/div/div/div/input")).sendKeys("Fulfillment Status");
		Thread.sleep(10000);
		DriverManager.getDriver().findElement(By.xpath("//label[text()='Primary Fields']/parent::div/div/div/div/div[2]/div/div/div/input")).sendKeys("=");
		Thread.sleep(10000);
		DriverManager.getDriver().findElement(By.xpath("//label[text()='Primary Fields']/following-sibling::div/div/div/div/div/div/div/div/div/div/div/div/input")).sendKeys("Re");
 		Thread.sleep(6000);
 		List<WebElement> primaryStatus= DriverManager.getDriver().findElements(By.cssSelector("div[id*='boundlist']>ul[id*='listEl']>li[role='option']"));
 		System.out.println("primary field released status"+primaryStatus.size());
 		page.getPage(ManhattanLoginPage.class).selectValueFromList("Released");
 		Thread.sleep(10000);
 		DriverManager.getDriver().findElement(By.xpath("//label[text()='Optional Fields']/parent::div/div[3]/div/div/div/div/div/div/input")).click();
 		DriverManager.getDriver().findElement(By.xpath("//label[text()='Optional Fields']/parent::div/div[3]/div/div/div/div/div/div/input")).sendKeys("Route Type 2");
 		page.getPage(ManhattanLoginPage.class).selectValueFromList("Route Type 2");
 		Thread.sleep(10000);
 		DriverManager.getDriver().findElement(By.xpath("//label[text()='Optional Fields']/parent::div/div[3]/div/div/div[2]/div/div/div/input")).sendKeys("=");
		Thread.sleep(10000);
		DriverManager.getDriver().findElement(By.xpath("//label[text()='Optional Fields']/parent::div/div[3]/div/div/div[3]/div/div/div/div/div/div/div/div/input")).sendKeys("SEFL");
		Thread.sleep(5000);
		 JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
		 js.executeScript("arguments[0].click();", DriverManager.getDriver().findElement(By.xpath("//span[text()='Apply']")));
         Thread.sleep(15000);
         DriverManager.getDriver().findElement(By.cssSelector(" div[class='x-grid-item-container']>table>tbody>tr>td:nth-child(1)")).click();
         List<WebElement> lists= DriverManager.getDriver().findElements(By.cssSelector("div[id*='mpsactionbar']>div>div>a>span>span>span:nth-child(2)"));
  		for(int i=0;i<lists.size();i++){
  			if(lists.get(i).getText().equalsIgnoreCase("More")){
  				lists.get(i).click();
  				break;
  			}
  		}
  		
  	  Thread.sleep(15000);
  		lists= DriverManager.getDriver().findElements(By.cssSelector("div[id*='menuitem']>a[id*='menuitem']>span"));
  		for(int i=0;i<lists.size();i++){
  			if(lists.get(i).getText().equalsIgnoreCase("Wave")){
  				lists.get(i).click();
  				break;
  			}
  		}
  	  Thread.sleep(10000);
  	  DriverManager.getDriver().switchTo().frame(DriverManager.getDriver().findElement(By.xpath("//iframe[contains(@id,'uxiframe')]")));
  	  DriverManager.getDriver().findElement(By.cssSelector("input[id='dataForm:listView:filterId:field10value1']")).sendKeys("SEFL");
  	 Thread.sleep(5000);
  	 DriverManager.getDriver().findElement(By.cssSelector("input[id='dataForm:listView:filterId:filterIdapply']")).click();
  	Thread.sleep(5000);
  	DriverManager.getDriver().findElement(By.xpath("//table[@id='dataForm:listView:dataTable_body']/tbody/tr[2]/td[1]/input[1]")).click();
   	Thread.sleep(3000);
   	DriverManager.getDriver().findElement(By.cssSelector("input[value='Run Wave']")).click();
    Thread.sleep(5000);
    DriverManager.getDriver().findElement(By.cssSelector("input[value='Submit']")).click();
    Thread.sleep(10000);
	}
	
	
	public void SelectFromListByVisibleText(List<WebElement> elements,clickType type, String text) {
		for (int i = 0; i < elements.size(); i++) {
			System.out.println(elements.get(i).getText());
			if (elements.get(i).getText().equalsIgnoreCase(text)) {
				elements.get(i).click();
				break;
			}
		}

	}


}