package tests;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.Helper;

public class TestBase {

	public static WebDriver driver;
	
	@SuppressWarnings("deprecation")
	@BeforeSuite
	@Parameters({"browser"})
	public void startDriver(@Optional("chrome") String browserName)
	{
		if (browserName.equalsIgnoreCase("chrome")) 
		{
			//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if (browserName.equalsIgnoreCase("firefox")) 
		{
			//System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\Drivers\\geckodriver.exe");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		
		else if (browserName.equalsIgnoreCase("edge")) 
		{
			//System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"\\Drivers\\edgedriver.exe");
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.navigate().to("https://demo.nopcommerce.com/");
		//System.out.println(System.getProperty("user.dir"));
	}
	
	@AfterSuite
	public void stopDriver()
	{
		//driver.quit();
	}
	
	//Take screenshot when test case fails and add it in the screenshot folder.
	@AfterMethod
	public void screenshotOnFailure(ITestResult result)
	{
		if (result.getStatus() == ITestResult.FAILURE) 
		{
			System.out.println("Failed");
			System.out.println("Taking screenshot.....");
			Helper.captureScreenshot(driver, result.getName());
		}
	}
}
