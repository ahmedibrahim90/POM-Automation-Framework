package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage extends PageBase {

	public SearchPage(WebDriver driver) {
		super(driver);
	}

	private By searchtxtBox = By.id("small-searchterms");
	private By searchBtn = By.cssSelector("button.button-1.search-box-button");
	private By productNameSearchResult = By.linkText("Nokia Lumia 1020");
	private By productList = By.id("ui-id-1");
			

	public void searchForProduct(String productName)
	{
		clearBox(driver.findElement(searchtxtBox));
		settxtElementTxt(driver.findElement(searchtxtBox), productName);
		clickButton(driver.findElement(searchBtn));
	}

	public void openSingleProductPage()
	{
		clickButton(driver.findElement(productNameSearchResult));
	}

	public String getresultproductName()
	{
		return driver.findElement(productNameSearchResult).getText();
	}

	public void searchForProductUsingSuggestions(String partialproductname)
	{
		clearBox(driver.findElement(searchtxtBox));
		settxtElementTxt(driver.findElement(searchtxtBox), partialproductname);
		selectfromSuggestedList(driver.findElements(productList), 0);
		
	}

}
