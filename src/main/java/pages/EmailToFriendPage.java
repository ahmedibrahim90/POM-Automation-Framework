package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EmailToFriendPage extends PageBase {

	public EmailToFriendPage(WebDriver driver) {
		super(driver);
	}

	private By emailFriendtxt = By.id("FriendEmail");
	private By personalMsgtxt = By.id("PersonalMessage");
	private By sendEmailBtn = By.cssSelector("button.button-1.send-email-a-friend-button");
	private By registeredEmailAddress = By.name("YourEmailAddress");
	private By emailToFriendsuccessMsg = By.cssSelector("div.result");

	public void emailProductToFriend(String emailFriend, String personalMsg)
	{
		clearBox(driver.findElement(emailFriendtxt));
		settxtElementTxt(driver.findElement(emailFriendtxt), emailFriend);
		clearBox(driver.findElement(personalMsgtxt));
		settxtElementTxt(driver.findElement(personalMsgtxt), personalMsg);
		clickButton(driver.findElement(sendEmailBtn));
	}

	public String getemailToFriendsuccessMsg()
	{
		return driver.findElement(emailToFriendsuccessMsg).getText();
	}

	public boolean presentRegisteredEmailAddressValue()
	{
		return driver.findElement(registeredEmailAddress).isDisplayed();
	}

}
