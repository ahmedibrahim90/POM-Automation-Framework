package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AddProductReviewPage;
import pages.HomePage;
import pages.LoginPage;
import pages.SearchPage;
import pages.SingleProductPage;
import pages.UserRegistrationPage;

public class AddProductReviewTest extends TestBase {

	UserRegistrationPage userRegistrationObject;
	LoginPage loginObject;
	HomePage homeObject;
	SingleProductPage singleProductObject;

	SearchPage searchObject;
	String productName = "Nokia Lumia 1020";
	String partialproductname = "Lum";

	String ActualsuccessMsg = "Your registration completed";
	String fName = "Ahmed";
	String lName = "hassan";
	String eemail = "as2@gmail.com";
	String comName = "Company";
	String pass = "123456";
	String confirmpPass = "123456";
	
	AddProductReviewPage addProductReviewObject;
	String reviewTitle = "This is the review title of product";
	String reviewMsg = "This is the review message of product";

	@Test(priority = 1, alwaysRun = true)
	public void userCanRegisterSuccessfully()
	{
		homeObject = new HomePage(driver);
		homeObject.openRegisterPage();
		userRegistrationObject = new UserRegistrationPage(driver);
		userRegistrationObject.userRegister(fName, lName, eemail, comName, pass, confirmpPass);
		Assert.assertTrue(userRegistrationObject.getRegisterSuccessMessage().contains(ActualsuccessMsg));
	}

	@Test(priority = 2)
	public void registerUserCanLoginSuccessfully()
	{
		homeObject = new HomePage(driver);
		homeObject.openLoginPage();
		loginObject = new LoginPage(driver);
		loginObject.userLogin(eemail, pass);
		//homeObject = new HomePage(driver);
		Assert.assertTrue(homeObject.getLogoutTxts().contains("Log out"));
	}
	@Test(priority = 3)
	public void registerUserCanSearchForProduct()
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
	public void registerUserCanAddProductReviewSuccessfully()
	{
		singleProductObject.openAddReviewPage();
		addProductReviewObject = new AddProductReviewPage(driver);
		Assert.assertTrue(addProductReviewObject.getSubmitReviewTxt().equalsIgnoreCase("Submit review"));
		addProductReviewObject.addProductReview(reviewTitle, reviewMsg);
		Assert.assertTrue(addProductReviewObject.getReviewSuccessMsg().equalsIgnoreCase("Product review is successfully added."));
	}

}
