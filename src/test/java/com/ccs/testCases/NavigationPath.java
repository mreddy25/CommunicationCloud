package com.ccs.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.ccs.pageObjects.LoginPage;

public class NavigationPath extends BaseClass {
	
	@Test
	public void NavigationPath() throws InterruptedException, IOException
	{
		
		driver.get(baseURL);
		logger.info("URL is opened: "+baseURL);
		//here LoginPage- pageObject class
		//LoginPage lp = new LoginPage(driver);
		Thread.sleep(3000);

	driver.findElement(By.cssSelector("[aria-label=expand]")).click();
	logger.info("cliked on expanded");
	Thread.sleep(3000);

	driver.findElement(By.xpath("//span[text()='Content']")).click();
	logger.info("selected content");
	Thread.sleep(20000);
	
	driver.findElement(By.cssSelector("[aria-label=expand]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//span[text()='Document']")).click();
	logger.info("selected Document");
	Thread.sleep(10000);
	
	driver.findElement(By.cssSelector("[aria-label=expand]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//span[text()='Fonts']")).click();
	logger.info("selected Fonts");
	Thread.sleep(10000);
	
	driver.findElement(By.cssSelector("[aria-label=expand]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//span[text()='Layout']")).click();
	logger.info("selected Layout");
	Thread.sleep(3000);
	
	driver.findElement(By.cssSelector("[aria-label=expand]")).click();
	driver.findElement(By.xpath("//span[text()='Package']")).click();
	logger.info("selected Package");
	Thread.sleep(3000);
	
	driver.findElement(By.cssSelector("[aria-label=expand]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//span[text()='Roles']")).click();
	logger.info("selected Roles");
	Thread.sleep(3000);

	driver.findElement(By.cssSelector("[aria-label=expand]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//span[text()='Styles']")).click();
	logger.info("selected Styles");
	Thread.sleep(3000);

	driver.findElement(By.xpath("//oj-button[@id='[['clearButton']]']")).click();
	logger.info("selected clearButton");
	Thread.sleep(3000);
	
	driver.findElement(By.xpath("//oj-button[@id='[['magnify']]']")).click();
	logger.info("selected magnify/search Icon");
	Thread.sleep(3000);

			driver.findElement(By.id("landingFilterSearch_SearchBox|input")).sendKeys("cc");
	logger.info("entered value in searchbox");
	Thread.sleep(3000);	
	
	driver.findElement(By.id("btnViewAll")).click();
	logger.info("selected viewAll");
	Thread.sleep(5000);	

}


}
