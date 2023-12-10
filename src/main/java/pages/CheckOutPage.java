package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckOutPage extends PageBase {

	public CheckOutPage(WebDriver driver) {
		super(driver);
	}

	private By checkOutpageTitle = By.cssSelector("div.page-title");
	//	private By fnTxt = By.id("div.page-title");
	//	private By lnTxt = By.id("div.page-title");
	//	private By emailTxt = By.id("div.page-title");
	private By countryList = By.id("BillingNewAddress_CountryId");
	private By StateList = By.id("BillingNewAddress_StateProvinceId");
	private By cityTxt = By.id("BillingNewAddress_City");
	private By address1Txt = By.id("BillingNewAddress_Address1");
	private By zipCodeTxt = By.id("BillingNewAddress_ZipPostalCode");
	private By phoneTxt = By.id("BillingNewAddress_PhoneNumber");
	private By continueBtn1 = By.cssSelector("button.button-1.new-address-next-step-button");
	private By shipMethodRadioBtn = By.id("shippingoption_1");
	private By continueShippingBtn = By.cssSelector("button.button-1.shipping-method-next-step-button");
	private By paymentMethodRadioBtn = By.id("paymentmethod_1");
	private By continuePaymentBtn = By.cssSelector("button.button-1.payment-method-next-step-button");
	private By ccList = By.id("CreditCardType");
	private By cardHolderTxt = By.id("CardholderName");
	private By cardNumTxt = By.id("CardNumber");
	private By expiryMonthList = By.id("ExpireMonth");
	private By expiryYearList = By.id("ExpireYear");
	private By cardCodeTxt = By.id("CardCode");
	private By continueInfoBtn = By.cssSelector("button.button-1.payment-info-next-step-button");
	private By confirmBtn = By.cssSelector("button.button-1.confirm-order-next-step-button");
	private By orderSuccessMsg = By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div/div[1]/strong");
	
	
	public String getcheckOutpageTitle()
	{
		return driver.findElement(checkOutpageTitle).getText();
	}

	public void CompleteBillingAddress(String city, String addresOne, String zipcode, String Phone)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(countryList)));
		selectOptionByVisibleTxt(driver.findElement(countryList), "United States");
		selectOptionByVisibleTxt(driver.findElement(StateList), "Florida");
		settxtElementTxt(driver.findElement(cityTxt), city);
		settxtElementTxt(driver.findElement(address1Txt), addresOne);
		settxtElementTxt(driver.findElement(zipCodeTxt), zipcode);
		settxtElementTxt(driver.findElement(phoneTxt), Phone);
		clickButton(driver.findElement(continueBtn1));
	}

	public void selectShippingMethod()
	{
		clickButton(driver.findElement(shipMethodRadioBtn));
		clickButton(driver.findElement(continueShippingBtn));
	}

	public void selectPaymentMethod()
	{
		clickButton(driver.findElement(paymentMethodRadioBtn));
		clickButton(driver.findElement(continuePaymentBtn));
	}

	public void enterPaymentInfo(String holderName, String cardNumber, String cardCode)
	{		
		selectOptionByVisibleTxt(driver.findElement(ccList), "Master card");
		settxtElementTxt(driver.findElement(cardHolderTxt), holderName);
		settxtElementTxt(driver.findElement(cardNumTxt), cardNumber);
		selectOptionByVisibleTxt(driver.findElement(expiryMonthList), "10");
		selectOptionByVisibleTxt(driver.findElement(expiryYearList), "2030");
		settxtElementTxt(driver.findElement(cardCodeTxt), cardCode);
		clickButton(driver.findElement(continueInfoBtn));
	}
	
	public void confirmPayment()
	{
		clickButton(driver.findElement(confirmBtn));
	}
	
	public String getorderSuccessMsg()
	{
		return driver.findElement(orderSuccessMsg).getText();
	}

}
