package com.qa.googlesearch;
import java.lang.reflect.Field;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import UtilityLibrarory.Utility;

public class GoogleSearchTest {
	
	WebDriver driver;                        
		
	@BeforeTest
	public void setUp() 
	{
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		 driver = new ChromeDriver();
		//driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
		
	@Test
	public void search()
	{
		driver.get("http://www.google.com");
		driver.findElement(By.id("lst-ib")).sendKeys("java");
		Utility.captureScreenshot(driver, "FieldEntered");
		List<WebElement> list = driver.findElements(By.xpath("//ul[@role='listbox']//li/descendant::div[@class='sbqs_c']"));
		System.out.println("total no of sugesstion in search box :: "+ list.size());
		
		for (int i =0 ; i<=list.size();i++) 
		{
			System.out.println(list.get(i).getText());
			
			if(list.get(i).getText().contains("java tutorial")) 
			{
				list.get(i).click();
				break;
			}
			
		} 
	}
	
	@AfterMethod
	public void tearDown(ITestResult result)
	{
		if (ITestResult.FAILURE==result.getStatus())
		{
			Utility.captureScreenshot(driver, "failedTest");
		}
	}
}
