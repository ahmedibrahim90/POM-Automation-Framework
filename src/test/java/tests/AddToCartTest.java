package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AddToCartPage;
import pages.SearchPage;
import pages.SingleProductPage;

public class AddToCartTest extends TestBase {

	SearchPage searchObject;
	String productName = "Nokia Lumia 1020";
	String partialproductname = "Lum";
	SingleProductPage singleProductObject;
	AddToCartPage CartObject;

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
	public void userCanAddProductToCartAndOpenCartPage() 
	{
		singleProductObject.OpenCartPage();
		CartObject = new AddToCartPage(driver);
		Assert.assertTrue(CartObject.getCartPageTitle().contains("Shopping cart"));
	}
	
	@Test(priority = 3)
	public void userCanUpdateQty() 
	{
		CartObject.updateQty("4");
		Assert.assertTrue(CartObject.getotalValue().contains("1,396.00"));
	}
	
	@Test(priority = 4)
	public void userRemoveProductsFromCart() 
	{
		CartObject.removeProductsFromCart();
		Assert.assertTrue(CartObject.getremoveSuccessMsgText().contains("Your Shopping Cart is empty!"));
	}
}
