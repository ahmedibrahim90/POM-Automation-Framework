package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;

public class HoverElementTest extends TestBase {

	HomePage homeObject;
	
	@Test
	public void userCanHoverElementThenOpenLinkFromSubMenu()
	{
		homeObject = new HomePage(driver);
		homeObject.hoveronComputerLink();
		homeObject.openSubMenuElement();
		Assert.assertTrue(driver.getCurrentUrl().contains("notebooks"));
	}
}
