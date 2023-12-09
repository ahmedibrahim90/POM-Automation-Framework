package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AddProductToWishlistPage;
import pages.HomePage;
import pages.SearchPage;
import pages.SingleProductPage;

public class AddProductToWishlistTest extends TestBase {

	HomePage homeObject;
	SearchPage searchObject;
	SingleProductPage singleProductObject;
	AddProductToWishlistPage addToWishlistObject;
	
	String productName = "Nokia Lumia 1020";
	String partialproductname = "Lum";
	int beforeWishlistproductQty = 0;
	int afterWishlistproductQty = 1;
	
	@Test(priority = 1)
	public void userCanSearchForProductsByAutoSuggestion() 
	{
		try {
			searchObject = new SearchPage(driver);
			searchObject.searchForProductUsingSuggestions(partialproductname);
			singleProductObject = new SingleProductPage(driver);
			Assert.assertTrue(singleProductObject.getbreadcrumbProductNameTxt().equalsIgnoreCase(productName));
			Assert.assertEquals(singleProductObject.getbreadcrumbProductNameTxt(), productName);
			Assert.assertTrue(singleProductObject.getdisplayedImg());
		} catch (Exception e) {
			System.out.println("Error Ocurred: "+e.getMessage());
		}
	}
	
	@Test(priority = 2)
	public void userCanAddProductToWishlistPage()
	{
		singleProductObject.openWishListPage();
		Assert.assertTrue(driver.getCurrentUrl().contains("wishlist"));
		addToWishlistObject = new AddProductToWishlistPage(driver);
		addToWishlistObject.getProductName().equalsIgnoreCase(productName);
		homeObject = new HomePage(driver);
		Assert.assertEquals(1, homeObject.getWishListQty(afterWishlistproductQty));
	}
		
	
	@Test(priority = 3)
	public void userCanRemoveProductFromWishlistPage()
	{
		addToWishlistObject = new AddProductToWishlistPage(driver);
		addToWishlistObject.removeProductFromWishlistPage();
		Assert.assertTrue(addToWishlistObject.getRemoveFromWishlistSuccessMsg().equalsIgnoreCase("The wishlist is empty!"));
		Assert.assertEquals(0, homeObject.getWishListQty(beforeWishlistproductQty));
	}
}


