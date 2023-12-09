package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SearchPage;
import pages.SingleProductPage;

public class ChangeCurrencyTest extends TestBase {

	HomePage homeObject;
	SingleProductPage singleProductObject;
	
	SearchPage searchObject;
	String productName = "Nokia Lumia 1020";
	String partialproductname = "Lum";
	
	
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
	public void userCanChangeCurrency()
	{
		homeObject = new HomePage(driver);
		homeObject.changeCurrency();
		singleProductObject = new SingleProductPage(driver);
		Assert.assertTrue(singleProductObject.getcurrencyLabel().contains("€"));
	}
}
