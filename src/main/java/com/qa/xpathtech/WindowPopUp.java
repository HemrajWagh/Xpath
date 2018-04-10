package com.qa.xpathtech;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowPopUp {
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//driver.manage().window().maximize();
		//driver.manage().deleteAllCookies();
		
		
		//Dynamic wait
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("http://popuptest.com/goodpopups.html");
		driver.findElement(By.xpath("//a[contains(text(),'Good PopUp #3')]")).click();
		Set<String> handler=driver.getWindowHandles();
		Iterator<String>it=handler.iterator();
		String parentwindowid=it.next();
		System.out.println("Parent window id "+parentwindowid);
		String childwindowid=it.next();
		System.out.println("Parent window id "+childwindowid);
		driver.switchTo().window(childwindowid);
		Thread.sleep(3000);
		System.out.println("child window pop up title" +driver.getTitle());
		driver.close();
		driver.switchTo().window(parentwindowid);
		Thread.sleep(3000);
		System.out.println("parent window title" +driver.getTitle());
	}

}
