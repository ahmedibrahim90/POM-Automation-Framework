package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class LoginTest extends TestBase {

	HomePage homeObject;
	UserRegistrationPage RegistrationObject;
	LoginPage loginObject;
	
	
	
	@Test(priority = 3)
	public void registeredUserCanLoginSuccessfully() 
	{
		loginObject = new LoginPage(driver);
		loginObject.userLogin("email24@gmail.com", "123456");
		homeObject = new HomePage(driver);
		Assert.assertTrue(homeObject.getLogoutTxts().contains("Log out"));
	}
}
