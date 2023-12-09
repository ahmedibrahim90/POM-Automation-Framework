package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;



public class PharmacyRegistrationPage extends PageBase {

	public PharmacyRegistrationPage(WebDriver driver) {
		super(driver);

	}

	//@FindBy(name="name")
	//WebElement fullNametxt;
	private By fullNametxt = By.name("name");

	//@FindBy(name="email")
	//WebElement emailtxt;
	private By emailtxt = By.name("email");

	//@FindBy(name="phone")
	//WebElement phonetxt;
	private By phonetxt = By.name("phone");

	//@FindBy(name="password")
	//WebElement passwordtxt;
	private By passwordtxt = By.name("password");

	//@FindBy(name="password_confirmation")
	//WebElement confirmPasswordtxt;
	private By confirmPasswordtxt = By.name("password_confirmation");

	//@FindBy(xpath="//*[@id=\"formAccept\"]/button")
	//WebElement registerBtn;
	private By registerBtn = By.xpath("//*[@id=\"formAccept\"]/button");

	//@FindBy(xpath="//*[@id=\"messageEmail\"]/div")
	//public WebElement registerSuccessMsg;
	private By registerSuccessMsg = By.xpath("//*[@id=\"messageEmail\"]/div");
	
	



	//	public void pharmacyRegistration(String fullName, String email, String phone, String password, String confirmpassword)
	//	{
	//		fullNametxt.clear();
	//		fullNametxt.sendKeys(fullName);
	//		emailtxt.clear();
	//		emailtxt.sendKeys(email);
	//		phonetxt.clear();
	//		phonetxt.sendKeys(phone);
	//		passwordtxt.clear();
	//		passwordtxt.sendKeys(password);
	//		confirmPasswordtxt.clear();
	//		confirmPasswordtxt.sendKeys(confirmpassword);
	//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	//		wait.until(ExpectedConditions.elementToBeClickable(registerBtn));
	//		
	//		JavascriptExecutor js = (JavascriptExecutor) driver;
	//		js.executeScript("arguments[0].click();", registerBtn);
	//		
	//	}


	public void pharmacyRegistration1(String fullName, String email, String phone, String password, String confirmpassword)
	{
		driver.findElement(fullNametxt).clear();
		driver.findElement(fullNametxt).sendKeys(fullName);

		driver.findElement(emailtxt).clear();
		driver.findElement(emailtxt).sendKeys(email);

		driver.findElement(phonetxt).clear();
		driver.findElement(phonetxt).sendKeys(phone);

		driver.findElement(passwordtxt).clear();
		driver.findElement(passwordtxt).sendKeys(password);

		driver.findElement(confirmPasswordtxt).clear();
		driver.findElement(confirmPasswordtxt).sendKeys(confirmpassword);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", driver.findElement(registerBtn));

	}
	
	public String getMessage()
	{
		return driver.findElement(registerSuccessMsg).getText();
	}
	
	
	
}
