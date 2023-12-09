package utilities;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

public class Helper {

	//Method to take screenshot when the test case fails.
	public static void captureScreenshot(WebDriver driver, String screenshotname)
	{
		Path dest = Paths.get("./Screenshots", screenshotname+".png");
		try {
			FileOutputStream out = new FileOutputStream(dest.toString());
			try {
				out.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
				out.close();
			} catch (WebDriverException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("Execption while takingScreenshot"+e.getMessage());
		}
	}
}
