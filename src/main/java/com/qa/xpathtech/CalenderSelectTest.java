package com.qa.xpathtech;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CalenderSelectTest {
	
	public static void main(String[] args) 	{
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//driver.manage().window().maximize();
		//driver.manage().deleteAllCookies();
		
		
		//Dynamic wait
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://www.freecrm.com");
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("HemrajWagh");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Nokian");
		driver.findElement(By.xpath("//input[@type='submit' and @value='Login']")).click();
		driver.switchTo().frame("mainpanel");
		String date = "18-September-2017"; //(18,September,2017)
		String dateArray [] = date.split("-");
		String day = dateArray[0];
		String month = dateArray[1];
		String year = dateArray[2];
		
		Select select = new Select(driver.findElement(By.name("slctMonth")));
		select.selectByVisibleText(month);
		
		Select select1 = new Select(driver.findElement(By.name("slctYear"))) ;
		select1.selectByVisibleText(year);
		
		
		
		//*[@id="crmcalendar"]/table/tbody/tr[2]/td/table/tbody/tr[2]/td[1]
		//*[@id="crmcalendar"]/table/tbody/tr[2]/td/table/tbody/tr[2]/td[2]
		
		String beforeXpath = "//*[@id=\"crmcalendar\"]/table/tbody/tr[2]/td/table/tbody/tr[";
		String afterXpath = "]/td[";
		final int totalWeekDays = 7;
		boolean flag = false;
		 String dayValue;
		for(int rowNum=2;rowNum<=6;rowNum++)
			
			for(int colNum=1;colNum<=totalWeekDays;colNum++)
				
			{
				try {
					dayValue = driver.findElement(By.xpath(beforeXpath+rowNum+afterXpath+colNum+"]")).getText(); 
				}catch (NoSuchElementException e) {
					System.out.println("Plaese enter a correct date value");	
					flag = false;
					break;
				}
				 System.out.println(dayValue);
				 
				 if (dayValue.equals(day))
				 {
					 driver.findElement(By.xpath(beforeXpath+rowNum+afterXpath+colNum+"]")).click();
					 flag= true;
					 break;
				 }
				 if(flag)
				 {
					 break;
				 }
			}
		

		
	}
	

}
