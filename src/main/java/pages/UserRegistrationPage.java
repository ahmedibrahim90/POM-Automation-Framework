package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class UserRegistrationPage extends PageBase {

	public UserRegistrationPage(WebDriver driver) {
		super(driver);
	}

	private By maleSelect = By.id("gender-male");

	private By firstNametxt = By.id("FirstName");

	private By lastNametxt = By.id("LastName");

	private By birthDay = By.name("DateOfBirthDay");
	private By birthMonth = By.name("DateOfBirthMonth");
	private By birthYear = By.name("DateOfBirthYear");

	private By emailtxt = By.name("Email");

	private By companyNametxt = By.name("Company");

	private By passwordtxt = By.name("Password");

	private By confirmPasswordtxt = By.name("ConfirmPassword");

	private By registerBtn = By.name("register-button");

	private By expectedRegisterSuccessMsg = By.cssSelector("div.result");
	
	private By loginLink = By.linkText("Log in");
	
	
	public void userRegister(String firstName, String lastName, String email, String companyName, String password, String confirmPasswrod)
	{

		//driver.findElement(maleSelect).click();
		clickButton(driver.findElement(maleSelect));
		
		//driver.findElement(firstNametxt).sendKeys(firstName);
		clearBox(driver.findElement(firstNametxt));
		settxtElementTxt(driver.findElement(firstNametxt), firstName);
		
		//driver.findElement(lastNametxt).sendKeys(lastName);
		clearBox(driver.findElement(lastNametxt));
		settxtElementTxt(driver.findElement(lastNametxt), lastName);
		
		//Select selectDay = new Select(driver.findElement(birthDay));
		//selectDay.selectByValue("6");
		selectOptionByVisibleTxt(driver.findElement(birthDay),"6");
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//wait.until(ExpectedConditions.elementToBeClickable(birthMonth));
		//Select selectMonth = new Select(driver.findElement(birthMonth));
		//selectMonth.selectByVisibleText("October");
		selectOptionByVisibleTxt(driver.findElement(birthMonth), "October");
		
		//Select selectYear = new Select(driver.findElement(birthYear));
		//selectYear.selectByVisibleText("1990");
		selectOptionByVisibleTxt(driver.findElement(birthYear), "1990");
		
		//driver.findElement(emailtxt).sendKeys(email);
		clearBox(driver.findElement(emailtxt));
		settxtElementTxt(driver.findElement(emailtxt), email);
		
		//driver.findElement(companyNametxt).sendKeys(companyName);
		clearBox(driver.findElement(companyNametxt));
		settxtElementTxt(driver.findElement(companyNametxt), companyName);
		
		//driver.findElement(passwordtxt).sendKeys(password);
		clearBox(driver.findElement(passwordtxt));
		settxtElementTxt(driver.findElement(passwordtxt), password);
		
		//driver.findElement(confirmPasswordtxt).sendKeys(confirmPasswrod);
		clearBox(driver.findElement(confirmPasswordtxt));
		settxtElementTxt(driver.findElement(confirmPasswordtxt), confirmPasswrod);
		
		//driver.findElement(registerBtn).click();
		clickButton(driver.findElement(registerBtn));
	}
	
	public String getRegisterSuccessMessage()
	{
		return driver.findElement(expectedRegisterSuccessMsg).getText();
		
	}
	
	public void openLoginPage()
	{
		clickButton(driver.findElement(loginLink));
	}

}
