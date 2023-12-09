package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.SearchPage;
import pages.SingleProductPage;

public class SearchByAutoSuggestionTest extends TestBase {

	SearchPage searchObject;
	String productName = "Nokia Lumia 1020";
	String partialproductname = "Lum";
	SingleProductPage singleProductObject;

	@Test
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
}
