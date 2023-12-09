package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends PageBase {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	private By emailtxt = By.id("Email");
	private By passwordtxt = By.id("Password");
	private By loginBtn = By.cssSelector("button.button-1.login-button");
	private By loginInvalidationMsg = By.cssSelector("div.message-error.validation-summary-errors");
	
	
	
	public void userLogin(String registeredEmail, String password)
	{
		clearBox(driver.findElement(emailtxt));
		settxtElementTxt(driver.findElement(emailtxt), registeredEmail);
		clearBox(driver.findElement(passwordtxt));
		settxtElementTxt(driver.findElement(passwordtxt), password);
		clickButton(driver.findElement(loginBtn));
	}
	
	public String getloginInvalidationMsg()
	{
		return driver.findElement(loginInvalidationMsg).getText();
	}
}