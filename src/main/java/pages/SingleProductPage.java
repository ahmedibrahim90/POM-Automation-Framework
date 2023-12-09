package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SingleProductPage extends PageBase {

	public SingleProductPage(WebDriver driver) {
		super(driver);
	}
	
	private By breadcrumbproduct = By.cssSelector("strong.current-item");
	private By productImg = By.id("main-product-img-20");
	private By emailFriendBtnOpen = By.cssSelector("button.button-2.email-a-friend-button");
	private By currencyLabel = By.id("price-value-20");
	private By addReviewLink = By.linkText("Be the first to review this product");
	private By addToWishListBtn = By.id("add-to-wishlist-button-20");
	private By addToWishListRedirectionLink = By.linkText("wishlist");
	private By addToCompareBtn = By.cssSelector("button.button-2.add-to-compare-list-button");
	private By comparePageLink = By.linkText("product comparison");
	private By addToCartBtn = By.id("add-to-cart-button-20");
	private By cartPageLink = By.linkText("shopping cart");
	
	
	
	
	
	
	public String getbreadcrumbProductNameTxt()
	{
		return driver.findElement(breadcrumbproduct).getText();
	}

	public boolean getdisplayedImg()
	{
		return driver.findElement(productImg).isDisplayed();
	}
	
	public void openEmailToFriendPage()
	{
		clickButton(driver.findElement(emailFriendBtnOpen));
	}
	public String getcurrencyLabel()
	{
		return driver.findElement(currencyLabel).getText();
	}
	
	public void openAddReviewPage()
	{
		clickButton(driver.findElement(addReviewLink));
	}
	
	public void openWishListPage()
	{
		clickButton(driver.findElement(addToWishListBtn));
		clickButton(driver.findElement(addToWishListRedirectionLink));
	}
	
	public void addProductToComparePage()
	{
		clickButton(driver.findElement(addToCompareBtn));
	}
	
	public void OpenComparePage()
	{
		clickButton(driver.findElement(comparePageLink));
	}
	
	public void OpenCartPage()
	{
		clickButton(driver.findElement(addToCartBtn));
		clickButton(driver.findElement(cartPageLink));
	}
	
}
