package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddToCartPage extends PageBase {

	public AddToCartPage(WebDriver driver) {
		super(driver);
	}

	private By CartPageTitle = By.cssSelector("div.page-title");
	private By qtyTxt = By.cssSelector("input.qty-input");
	private By updateCartBtn = By.id("updatecart");
	private By totalValue = By.cssSelector("span.product-subtotal");
	private By removeBtn = By.cssSelector("button.remove-btn");
	private By removeSuccessMsgText = By.cssSelector("div.no-data");
	private By termsRadioBtn = By.id("termsofservice");
	private By checkOutBtn = By.id("checkout");
	
	
	public void updateQty(String QtyValue)
	{
		clearBox(driver.findElement(qtyTxt));
		settxtElementTxt(driver.findElement(qtyTxt), QtyValue);
		clickButton(driver.findElement(updateCartBtn));
	}
	
	public void removeProductsFromCart()
	{
		clickButton(driver.findElement(removeBtn));
	}
	
	public String getCartPageTitle()
	{
		return driver.findElement(CartPageTitle).getText();
	}
	
	public String getotalValue()
	{
		return driver.findElement(totalValue).getText();
	}
	
	public String getremoveSuccessMsgText()
	{
		return driver.findElement(removeSuccessMsgText).getText();
	}
	
	public void OpenCheckOutPage()
	{
		clickButton(driver.findElement(termsRadioBtn));
		clickButton(driver.findElement(checkOutBtn));
	}
}
