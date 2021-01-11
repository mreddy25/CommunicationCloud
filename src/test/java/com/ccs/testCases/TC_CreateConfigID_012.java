package com.ccs.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ccs.pageObjects.ContentPage;
import com.ccs.pageObjects.LoginPage;
import com.ccs.utilities.XLUtils;

public class TC_CreateConfigID_012 extends BaseClass {

	@Test
	public void createCinfigID() throws InterruptedException, IOException {
		TC_LoginTest_001 signIn = new TC_LoginTest_001();
		signIn.signInTest();


		if (driver.findElement(By.xpath("//span[text()='Config ID']")).isEnabled()) {
			driver.findElement(By.xpath("//span[text()='Config ID']")).click();
			logger.info("Clicked on Config Id");
			Thread.sleep(3000);
		}else {
			captureScreen(driver, "ConfigIdDialog_TC012");
			Assert.assertTrue(false);
			logger.info("Config dialog is not displayed");
		}

		
		Thread.sleep(7000);



		
		if(driver.findElement(By.xpath("//span[text()='Yes']")).isDisplayed())
		{
			driver.findElement(By.xpath("//span[text()='Yes']")).click();
			logger.info("Clicked on Yes1");
			Thread.sleep(3000);
		}else
		{
	
			driver.findElement(By.xpath("//span[text()='Yes' and @class='oj-button-text']")).click();
			logger.info("Clicked on Yes2");
			Thread.sleep(3000);
			}

		//select radio button
		if(driver.findElement(By.id("Existing|rb")).isEnabled())
		{
			driver.findElement(By.id("Existing|rb")).click();
			logger.info("Existing\rb bution is enabled and selected");
		}
		
		//continue
		
		if (driver.findElement(By.xpath("//span[text()='Continue']")).isDisplayed()) {
			driver.findElement(By.xpath("//span[text()='Continue']")).click();
			logger.info("Clicked on 'continue' in Dialog Box");
			Thread.sleep(18000);
		}
		
		if (driver.findElement(By.xpath("//input[text()='Search Text']")).isDisplayed()) {
			driver.findElement(By.xpath("//span[text()='Search Text']")).sendKeys("Blitz1");
			logger.info("Clicked on 'Search Text' in Dialog Box");
			Thread.sleep(8000);
		}else
		{
		
			driver.findElement(By.xpath("//*[starts-with(@id,'SearchBox')]")).sendKeys("Blitz1");
			logger.info("Clicked on 'Search Text 2' in Dialog Box");
			Thread.sleep(8000);
		}
		
		if (driver.findElement(By.xpath("//*[contains(@title, 'Magnifier\r\n" + 
				"      ')]")).isDisplayed())
		{
			driver.findElement(By.xpath("//*[contains(@title, 'Magnifier\r\n" + 
					"      ')]")).click();
			logger.info("Clicked on 'magnifier' icon");
			Thread.sleep(8000);
		}else {
			
				driver.findElement(By.xpath("//span[text()='Magnifier\r\n" + 
						"      ']")).click();
				logger.info("Clicked on 'magnifier2' in Dialog Box");
				Thread.sleep(8000);
			
		}

		
	}

}
