package UtilityLibrarory;

import java.io.File;

import javax.swing.plaf.FileChooserUI;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utility {

	public static void captureScreenshot(WebDriver driver, String screenshotName)
	{
		try 
		{
		TakesScreenshot ts	=(TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./ScreenShots/"+screenshotName+".png"));
		}catch (Exception e) {
			System.out.println("Exception while taking screenshots "+e.getMessage());
		}
	}
}
