package com.qa.xpathtech;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WebTable {
	
	
	public static void main(String [] args) throws InterruptedException {
	System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	//driver.manage().window().maximize();
	//driver.manage().deleteAllCookies();
	
	
	//Dynamic wait
	driver.manage().timeouts().pageLoadTimeout(300, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
	driver.get("https://www.freecrm.com");
	//Thread.sleep(5000);
	driver.findElement(By.xpath("//input[@type='text']")).sendKeys("HemrajWagh");
	driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Nokian");
	driver.findElement(By.xpath("//input[@type='submit']")).submit();

	driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();
	driver.findElement(By.xpath("//a[contains(text(),'David Talor')]"
			+ "//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']//input[@type='checkbox']")).click();
}
}