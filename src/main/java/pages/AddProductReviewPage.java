package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddProductReviewPage extends PageBase {

	public AddProductReviewPage(WebDriver driver) {
		super(driver);
	}
	
	private By reviewTitletxt = By.id("AddProductReview_Title");
	private By reviewMsgtxt = By.id("AddProductReview_ReviewText");
	private By radioBtn = By.id("addproductrating_4");
	private By submitReviewBtn = By.cssSelector("button.button-1.write-product-review-button");
	private By reviewSuccessMsg = By.cssSelector("div.result");

	
	
	public void addProductReview(String reviewTitle, String ReviewMsg)
	{
		clearBox(driver.findElement(reviewTitletxt));
		settxtElementTxt(driver.findElement(reviewTitletxt), reviewTitle);
		clearBox(driver.findElement(reviewMsgtxt));
		settxtElementTxt(driver.findElement(reviewMsgtxt), ReviewMsg);
		clickButton(driver.findElement(radioBtn));
		clickButton(driver.findElement(submitReviewBtn));
	}
	
	public String getSubmitReviewTxt()
	{
		return driver.findElement(submitReviewBtn).getText();
	}
	
	public String getReviewSuccessMsg()
	{
		return driver.findElement(reviewSuccessMsg).getText();
	}	
}
