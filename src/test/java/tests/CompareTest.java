package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ComparePage;
import pages.SearchPage;
import pages.SingleProductPage;

public class CompareTest extends TestBase {

	
	SearchPage searchObject;
	String FirstproductName = "Nokia Lumia 1020";
	String SecondproductName = "Apple MacBook Pro 13-inch";
	String firstpartialproductname = "Lum";
	String secondpartialproductname = "MacBook";
	SingleProductPage singleProductObject;
	ComparePage compareObject;
	
	@Test(priority = 1)
	public void productsComparison()
	{
		searchObject = new SearchPage(driver);
		searchObject.searchForProduct(FirstproductName);
		singleProductObject = new SingleProductPage(driver);
		singleProductObject.addProductToComparePage();
		searchObject.searchForProduct(SecondproductName);
		singleProductObject.addProductToComparePage();
		singleProductObject.OpenComparePage();
		compareObject = new ComparePage(driver);
		Assert.assertTrue(compareObject.getcompareTitle().contains("Compare products"));
		compareObject.compareProducs();
	}
	
	@Test(priority = 2)
	public void clearProductsComparison()
	{
		compareObject.clearcomparisonProducts();
		Assert.assertTrue(compareObject.getcompareNoDataMsg().contains("You have no items to compare."));
	}
}
