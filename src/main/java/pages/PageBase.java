package pages;

import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PageBase {

	protected WebDriver driver;
	public JavascriptExecutor js;
	//public Actions action;
	
	// Create Constractor
	public PageBase(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	protected static void clickButton(WebElement button)
	{
		button.click();
	}
	
	protected static void clearBox(WebElement clearTxt)
	{
		clearTxt.clear();
	}
	
	protected static void settxtElementTxt(WebElement setTxt, String value)
	{
		setTxt.sendKeys(value);
	}
	
	protected static void selectfromSuggestedList(List<WebElement> list, int value)
	{
		WebElement element = list.get(value);
	    element.click();
	}
	
	protected static void selectOptionByVisibleTxt(WebElement dropdownElement, String value)
	{
		Select select = new Select(dropdownElement);
		select.selectByVisibleText(value);
	}
	
	protected static void actionPerform(WebDriver driver, WebElement element)
	{
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();	
	}
	
	protected static void actionToMoveToElemnet(WebDriver driver, WebElement element)
	{
		Actions action = new Actions(driver);
		action.moveToElement(element).moveToElement(element).build().perform();
		
	}
	
	protected static void scrollToElement(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
}
