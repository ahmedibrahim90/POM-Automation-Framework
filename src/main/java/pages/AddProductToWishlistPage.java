package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddProductToWishlistPage extends PageBase {

	public AddProductToWishlistPage(WebDriver driver) {
		super(driver);
	}
	private By productNameAddedToWishList = By.cssSelector("a.product-name");
	private By removeBtn = By.cssSelector("button.remove-btn");
	private By removeFromWishlistSuccessMsg = By.cssSelector("div.no-data");
	
	public void removeProductFromWishlistPage()
	{
		clickButton(driver.findElement(removeBtn));
	}
	
	public String getProductName()
	{
		return driver.findElement(productNameAddedToWishList).getText();
	}

	public String getRemoveFromWishlistSuccessMsg()
	{
		return driver.findElement(removeFromWishlistSuccessMsg).getText();
	}
}
