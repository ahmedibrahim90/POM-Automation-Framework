package tests;

import org.testng.Assert;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class PharmacyRegistrationTest extends TestBase {

	HomePage homeObject;
	UserRegistrationPage RegistrationObject;
	LoginPage loginObject;
	String ActualsuccessMsg = "Your registration completed";
	
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
	
}
