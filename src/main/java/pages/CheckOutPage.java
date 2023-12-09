package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
	private By continueBtn = By.cssSelector("button.button-1.new-address-next-step-button");
	
	
//	public String getcheckOutpageTitle()
//	{
//		return driver.findElement(checkOutpageTitle).getText();
//	}
}
