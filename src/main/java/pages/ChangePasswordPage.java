package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ChangePasswordPage extends PageBase {

	public ChangePasswordPage(WebDriver driver) {
		super(driver);
	}
	
	private By myAcountTitle = By.xpath("//h1[text()='My account - Customer info']");
	private By changePasswordLink = By.linkText("Change password");
	private By mypasswordTitle = By.xpath("//h1[text()='My account - Change password']");
	private By oldPasswordtxt = By.id("OldPassword");
	private By newPasswordtxt = By.id("NewPassword");
	private By confirmNewPasswordtxt = By.id("ConfirmNewPassword");
	private By changePasswordBtn = By.cssSelector("button.button-1.change-password-button");
	private By changePasswordSuccessMsg = By.xpath("//*[@id='bar-notification']/div/p");
	private By closeMSg = By.cssSelector("span.close");
	
	
	
	public String getMyAcountTitletxt()
	{
		 return driver.findElement(myAcountTitle).getText();
	}

	public void openChangePasswordPage()
	{
		clickButton(driver.findElement(changePasswordLink));
	}
	
	public String getMyPasswordTitletxt()
	{
		 return driver.findElement(mypasswordTitle).getText();
	}
	
	public void changepassword(String oldpassword, String newpassword)
	{
		clearBox(driver.findElement(oldPasswordtxt));
		settxtElementTxt(driver.findElement(oldPasswordtxt), oldpassword);
		
		clearBox(driver.findElement(newPasswordtxt));
		settxtElementTxt(driver.findElement(newPasswordtxt), newpassword);
		
		clearBox(driver.findElement(confirmNewPasswordtxt));
		settxtElementTxt(driver.findElement(confirmNewPasswordtxt), newpassword);
		
		clickButton(driver.findElement(changePasswordBtn));
	}
	
	public String getchangePasswordSuccessMsg()
	{
		return driver.findElement(changePasswordSuccessMsg).getText();
	}
	
	public void closeChangePasswordMsg()
	{
		clickButton(driver.findElement(closeMSg));
	}
}
