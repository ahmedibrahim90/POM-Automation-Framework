package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class HomePage extends PageBase {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	private By registerLink = By.linkText("Register");
	private By logOutLink = By.linkText("Log out");
	private By myAccountLink = By.linkText("My account");
	private By loginLink = By.linkText("Log in");
	private By contactusLink = By.linkText("Contact us");
	private By currencyList = By.id("customerCurrency");
	private By computersLink = By.linkText("Computers");
	private By notebooksLink = By.linkText("Notebooks");
	public By wishListQty = By.cssSelector("span.wishlist-qty");

	public void openRegisterPage()
	{
		//driver.findElement(registerLink).click();
		clickButton(driver.findElement(registerLink));
	}

	public void openLoginPage()
	{
		//driver.findElement(registerLink).click();
		clickButton(driver.findElement(loginLink));
	}

	public String getLogoutTxts()
	{
		return driver.findElement(logOutLink).getText();
	}

	public void openMyAccountPage()
	{
		//driver.findElement(myAccountLink).click();
		clickButton(driver.findElement(myAccountLink));
	}

	public void logOut()
	{
		//driver.findElement(logOutLink).click();
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(0));
		//wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(logOutLink)));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", driver.findElement(logOutLink));
		//clickButton(driver.findElement(logOutLink));
	}

	public void openContactusPage()
	{
		scrollToElement(driver, driver.findElement(contactusLink));
		clickButton(driver.findElement(contactusLink));
	}

	public void changeCurrency()
	{
		selectOptionByVisibleTxt(driver.findElement(currencyList), "Euro");
	}

	public void hoveronComputerLink()
	{
		actionToMoveToElemnet(driver, driver.findElement(computersLink));
		actionToMoveToElemnet(driver, driver.findElement(notebooksLink));
	}

	public void openSubMenuElement()
	{
		actionPerform(driver, driver.findElement(notebooksLink));
		clickButton(driver.findElement(notebooksLink));
	}

	public int getWishListQty(int Qty)
	{
		driver.findElement(wishListQty).getSize();
		return Qty;
	}
	//	//@FindBy(css="span.nav-line-2")
	//	//WebElement registerSection;
	//	private By registerSection = By.cssSelector("span.nav-line-2");
	//	
	//	//@FindBy(linkText ="تسجيل حساب صيدلية")
	//	//WebElement registerLink;
	//	private By registerLink = By.linkText("تسجيل حساب صيدلية");
	//	
	//	public void openRegistrationPge()
	//	{
	//		//Actions action = new Actions(driver);
	//		//action.moveToElement(registerSection)
	//	     //  .click(registerSection).perform();
	//		//registerLink.click();
	//		
	//		Actions action = new Actions(driver);
	//		action.moveToElement(driver.findElement(registerSection)).click(driver.findElement(registerSection)).perform();
	//		driver.findElement(registerLink).click();
	//	}

}
