package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ChangePasswordPage;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class ChangePasswordTest extends TestBase {

	HomePage homeObject;
	UserRegistrationPage RegistrationObject;
	LoginPage loginObject;
	ChangePasswordPage changePasswordObject;
	String ActualsuccessMsg = "Your registration completed";
	String oldpassword = "123456";
	String newpassword = "123456789";
	String fName = "Ahmed";
	String lName = "saba";
	String email = "saba7@gmail.com";
	String comName = "companyName";
	
	
	@Test(priority = 1, alwaysRun = true)
	public void userCanRegisrerSuccessfully()
	
	{
		homeObject = new HomePage(driver);
		homeObject.openRegisterPage();
		RegistrationObject = new UserRegistrationPage(driver);
		RegistrationObject.userRegister(fName, lName, email, comName, oldpassword, oldpassword);
		Assert.assertTrue(RegistrationObject.getRegisterSuccessMessage().contains(ActualsuccessMsg));
//		Assert.assertEquals(ActualsuccessMsg, RegistrationObject.getRegisterSuccessMessage());
//		SoftAssert softAssert = new SoftAssert();
//		softAssert.assertEquals(ActualsuccessMsg, RegistrationObject.getRegisterSuccessMessage());
//		softAssert.assertAll();
	}
	
	@Test(priority = 2)
	public void registeredUserCanOpenLoginPageSuccessfully() 
	{
		homeObject.openLoginPage();
	}
	
	@Test(priority = 3)
	public void registeredUserCanLoginSuccessfully() 
	{
		loginObject = new LoginPage(driver);
		loginObject.userLogin(email, oldpassword);
		homeObject = new HomePage(driver);
		Assert.assertTrue(homeObject.getLogoutTxts().contains("Log out"));
	}
	
	
	@Test(priority = 4)
	public void userCanOpenAccountPage()
	{
		homeObject.openMyAccountPage();
		changePasswordObject = new ChangePasswordPage(driver);
		Assert.assertTrue(changePasswordObject.getMyAcountTitletxt().contains("My account"));
	}
	
	@Test(priority = 5)
	public void userCanOpenChangePasswordPage()
	{
		changePasswordObject.openChangePasswordPage();
		Assert.assertTrue(changePasswordObject.getMyPasswordTitletxt().contains("Change password"));
	}
	
	@Test(priority = 6)
	public void userCanChangePassword()
	{
		changePasswordObject.changepassword(oldpassword, newpassword);
		Assert.assertTrue(changePasswordObject.getchangePasswordSuccessMsg().contains("Password was changed"));
		changePasswordObject.closeChangePasswordMsg();
	}
	
	@Test(priority = 7)
	public void userCanLogout()
	{
		homeObject.logOut();
		
	}
	
	@Test(priority = 8)
	public void userCanOpenLoginPage()
	{
		homeObject.openLoginPage();
	}
	
	@Test(priority = 9)
	public void userCanNOTLoginWithOldPassword()
	{
		loginObject.userLogin(email, oldpassword);
		Assert.assertTrue(loginObject.getloginInvalidationMsg().contains("Login was unsuccessful"));
	}
	
	@Test(priority = 10)
	public void userCanLoginWithNewPassword()
	{
		loginObject.userLogin(email, newpassword);
		Assert.assertTrue(homeObject.getLogoutTxts().contains("Log out"));
	}
}
