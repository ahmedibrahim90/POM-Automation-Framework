package pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ComparePage extends PageBase {

	public ComparePage(WebDriver driver) {
		super(driver);
	}

	private By compareTitle = By.cssSelector("div.page-title");
	private By compareTable = By.cssSelector("table.compare-products-table");

	@FindBy(tagName = "tr")
	public List<WebElement> allRows ;
	@FindBy(tagName = "td")
	public List<WebElement> allCols ;
	//private By allRows = By.linkText("tr");
	//private By allCols = By.linkText("td");
	private By clearListBtn = By.cssSelector("a.clear-list");
	private By compareNoDataMsg = By.cssSelector("div.no-data");

	public String getcompareTitle()
	{
		return driver.findElement(compareTitle).getText();
	}

	public void compareProducs()
	{
		//Get all Rows
		driver.findElement(compareTable);
		System.out.println(allRows.size());
		// Get Data from each Row
		for(WebElement row : allRows)
		{
			System.out.println(row.getText()+"\t");
			for(WebElement col: allCols)
			{
				System.out.println(col.getText()+"\t");
			}
		}
	}
	
	public void clearcomparisonProducts()
	{
		clickButton(driver.findElement(clearListBtn));
	}
	
	public String getcompareNoDataMsg()
	{
		return driver.findElement(compareNoDataMsg).getText();
	}
}
