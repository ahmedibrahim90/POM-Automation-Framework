package tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import pages.EmailToFriendPage;
import pages.HomePage;
import pages.LoginPage;
import pages.SearchPage;
import pages.SingleProductPage;
import pages.UserRegistrationPage;

public class EmailToFriendTest extends TestBase {

	HomePage homeObject;
	UserRegistrationPage userRegistrationObject;
	LoginPage loginObject;
	SearchPage searchObject;
	SingleProductPage singleProductObject;
	EmailToFriendPage emailToFriendObject;


	String ActualsuccessMsg = "Your registration completed";
	String fName = "Ahmed";
	String lName = "hassan";
	String eemail = "as4@gmail.com";
	String comName = "Company";
	String pass = "123456";
	String confirmpPass = "123456";

	String productName = "Nokia Lumia 1020";
	String partialproductname = "Lum";
	
	String friendEmail = "friend@gmail.com";
	String MsgSentToFriend = "I recommend that product to u as i believe u will like it";



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
	public void registerUserCanemailProductToFriend()
	{
		singleProductObject.openEmailToFriendPage();
		emailToFriendObject = new EmailToFriendPage(driver);
		Assert.assertTrue(emailToFriendObject.presentRegisteredEmailAddressValue());
		//Assert.assertTrue(driver.getTitle().contains("productemailafriend"));
		emailToFriendObject.emailProductToFriend(friendEmail, MsgSentToFriend);
		Assert.assertTrue(emailToFriendObject.getemailToFriendsuccessMsg().equalsIgnoreCase("Your message has been sent."));	
	}
}

