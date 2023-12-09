package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactusPage extends PageBase {

	public ContactusPage(WebDriver driver) {
		super(driver);
	}
	
	private By contactInfotitle = By.cssSelector("div.topic-block-body");
	private By name = By.className("fullname");
	private By email = By.id("Email");
	private By enquiry = By.id("Enquiry");
	private By submitBtn = By.cssSelector("button.button-1.contact-us-button");
	private By successMsg = By.cssSelector("div.result");
	
	public void contactus(String fullName, String emailAddress, String message)
	{
		clearBox(driver.findElement(name));
		settxtElementTxt(driver.findElement(name), fullName);
		clearBox(driver.findElement(email));
		settxtElementTxt(driver.findElement(email), emailAddress);
		clearBox(driver.findElement(enquiry));
		settxtElementTxt(driver.findElement(enquiry), message);
		clickButton(driver.findElement(submitBtn));
	}
	
	public String getContactUsPagetitle()
	{
		return driver.findElement(contactInfotitle).getText();
	}
	
	public String getcontactUsSuccessMsg()
	{
		return driver.findElement(successMsg).getText();
	}

}
