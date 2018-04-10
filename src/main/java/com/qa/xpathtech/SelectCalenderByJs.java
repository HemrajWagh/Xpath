package com.qa.xpathtech;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//handle Calendat DataPicker using JavaScir 
public class SelectCalenderByJs {
	
	private static final JavascriptExecutor JavascriptExecutor = null;

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//driver.manage().window().maximize();
		//driver.manage().deleteAllCookies();
		
		
		//Dynamic wait
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("http://www.spicejet.com/");
		
		WebElement date = driver.findElement(By.id("ctl00_mainContent_view_date1"));
		 String dateValue = "30-12-2017";
		selectDateByJs(driver, date, dateValue);
	
	}

	private static void selectDateByJs(WebDriver driver,WebElement element,String dateValue) 
	{
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments(0).setAttribute('value',"+dateValue+");", element);
		
	}

}
