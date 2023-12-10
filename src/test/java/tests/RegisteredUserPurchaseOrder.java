package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AddToCartPage;
import pages.HomePage;
import pages.LoginPage;
import pages.SearchPage;
import pages.SingleProductPage;
import pages.UserRegistrationPage;

public class RegisteredUserPurchaseOrder extends TestBase {

	HomePage homeObject;
	UserRegistrationPage RegistrationObject;
	LoginPage loginObject;
	String ActualsuccessMsg = "Your registration completed";
	SearchPage searchObject;
	String productName = "Nokia Lumia 1020";
	String partialproductname = "Lum";
	SingleProductPage singleProductObject;
	AddToCartPage CartObject;
	
	
	@Test(priority = 1, alwaysRun = true)
	public void userCanRegisrerSuccessfully()
	
	{
		homeObject = new HomePage(driver);
		homeObject.openRegisterPage();
		RegistrationObject = new UserRegistrationPage(driver);
		RegistrationObject.userRegister("Ahmed", "Saba", "email24@gmail.com", "companyName", "123456", "123456");
		Assert.assertTrue(RegistrationObject.getRegisterSuccessMessage().contains(ActualsuccessMsg));
//		Assert.assertEquals(ActualsuccessMsg, RegistrationObject.getRegisterSuccessMessage());
//		SoftAssert softAssert = new SoftAssert();
//		softAssert.assertEquals(ActualsuccessMsg, RegistrationObject.getRegisterSuccessMessage());
//		softAssert.assertAll();
	}
	
	@Test(priority = 2)
	public void UserCanOpenLoginPage()
	{
		RegistrationObject.openLoginPage();
	}
	
	@Test(priority = 3)
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

	@Test(priority = 4)
	public void userCanAddProductToCartAndOpenCartPage() 
	{
		singleProductObject.OpenCartPage();
		CartObject = new AddToCartPage(driver);
		Assert.assertTrue(CartObject.getCartPageTitle().contains("Shopping cart"));
	}
	
	@Test(priority = 5)
	public void userCanUpdateQty() 
	{
		CartObject.updateQty("4");
		Assert.assertTrue(CartObject.getotalValue().contains("1,396.00"));
	}
	
	@Test(priority = 5)
	public void userCanCheckOutProduct() 
	{
		CartObject.OpenCheckOutPage();
		
	}
}
