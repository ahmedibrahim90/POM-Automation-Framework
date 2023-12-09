package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ContactusPage;
import pages.HomePage;

public class ContacusTest extends TestBase {

	HomePage homeObject;
	ContactusPage contactusObject;
	String customerName = "Ahmed";
	String coustomerEmail = "em@gmail.com";
	String customerEnquiry = "my enquiry is to how to reach out and track my order i did";
	
	@Test
	public void contactus()
	{
		homeObject = new HomePage(driver);
		homeObject.openContactusPage();
		contactusObject = new ContactusPage(driver);
		Assert.assertTrue(contactusObject.getContactUsPagetitle().contains("Put your contact information here"));
		contactusObject.contactus(customerName, coustomerEmail, customerEnquiry);
		Assert.assertTrue(contactusObject.getcontactUsSuccessMsg().contains("Your enquiry has been successfully sent to the store owner"));
		
	}
}
