package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SearchPage;
import pages.SingleProductPage;

public class SearchTest extends TestBase {

	SearchPage searchObject;
	String productName = "Nokia Lumia 1020";
	SingleProductPage singleProductObject;
	
	@Test
	public void userCanSearchForProducts() 
	{
		searchObject = new SearchPage(driver);
		searchObject.searchForProduct(productName);
		Assert.assertTrue(searchObject.getresultproductName().equalsIgnoreCase(productName));
		Assert.assertEquals(searchObject.getresultproductName(), productName);
		searchObject.openSingleProductPage();
		singleProductObject = new SingleProductPage(driver);
		Assert.assertTrue(singleProductObject.getbreadcrumbProductNameTxt().equalsIgnoreCase(productName));
		Assert.assertTrue(singleProductObject.getdisplayedImg());
		Assert.assertEquals(singleProductObject.getbreadcrumbProductNameTxt(), productName);
	}
}
