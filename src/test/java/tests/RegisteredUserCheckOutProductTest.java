package tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddToCartPage;
import pages.CheckOutPage;
import pages.HomePage;
import pages.LoginPage;
import pages.SearchPage;
import pages.SingleProductPage;
import pages.UserRegistrationPage;

public class RegisteredUserCheckOutProductTest extends TestBase {

	HomePage homeObject;
	UserRegistrationPage RegistrationObject;
	LoginPage loginObject;
	String ActualsuccessMsg = "Your registration completed";
	SearchPage searchObject;
	String productName = "Nokia Lumia 1020";
	String partialproductname = "Lum";
	SingleProductPage singleProductObject;
	AddToCartPage CartObject;
	CheckOutPage checkoutObject;
	String expectedCity = "cairo";
	String expectedAddress1 = "14 sherman";
	String expectedzipcode = "L8K 2L7";
	String expectedPhone = "2896809700";
	String expectedholderName = "Alex";
	String expectedcardNumber = "1111-2222-3333-4444";
	String expectedcardCode = "123";

	
	

	
	@Test(priority = 1, alwaysRun = true)
	public void userCanRegisrerSuccessfully()
	
	{
		homeObject = new HomePage(driver);
		homeObject.openRegisterPage();
		RegistrationObject = new UserRegistrationPage(driver);
		RegistrationObject.userRegister("Ahmed", "Saba", "emailg4@gmail.com", "companyName", "123456", "123456");
		Assert.assertTrue(RegistrationObject.getRegisterSuccessMessage().contains(ActualsuccessMsg));
//		Assert.assertEquals(ActualsuccessMsg, RegistrationObject.getRegisterSuccessMessage());
//		SoftAssert softAssert = new SoftAssert();
//		softAssert.assertEquals(ActualsuccessMsg, RegistrationObject.getRegisterSuccessMessage());
//		softAssert.assertAll();
	}
	
	@Test(priority = 2)
	public void UserCanLogin()
	{
		RegistrationObject.openLoginPage();
		loginObject = new LoginPage(driver);
		loginObject.userLogin("emailg4@gmail.com", "123456");
		homeObject = new HomePage(driver);
		Assert.assertTrue(homeObject.getLogoutTxts().contains("Log out"));
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
	
	@Test(priority = 6)
	public void userCanCheckOutProduct() 
	{
		CartObject.OpenCheckOutPage();	
	}
	
	
	@Test(priority = 7)
	public void userCanPurchaseOrderByEnterAllNeededInfo() 
	{
		checkoutObject = new CheckOutPage(driver);
		Assert.assertTrue(checkoutObject.getcheckOutpageTitle().contains("Checkout"));
		checkoutObject.CompleteBillingAddress(expectedCity, expectedAddress1, expectedzipcode, expectedPhone);
		checkoutObject.selectShippingMethod();
		checkoutObject.selectPaymentMethod();
		checkoutObject.enterPaymentInfo(expectedholderName, expectedcardNumber, expectedcardCode);
		checkoutObject.confirmPayment();
		Assert.assertTrue(checkoutObject.getorderSuccessMsg().contains("Your order has been successfully processed!"));
		Assert.assertTrue(driver.getCurrentUrl().contains("completed"));
	}
}
