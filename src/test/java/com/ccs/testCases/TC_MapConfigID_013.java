package com.ccs.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ccs.pageObjects.ContentPage;
import com.ccs.pageObjects.LoginPage;

public class TC_MapConfigID_013 extends BaseClass {

	@Test
	public void mapConfigID() throws InterruptedException, IOException {
		// calling SignIn method
		//TC_LoginTest_001 signIn = new TC_LoginTest_001();
		//signIn.signInTest();

		if (driver.findElement(By.xpath("//span[text()='Config ID']")).isEnabled()) {
			driver.findElement(By.xpath("//span[text()='Config ID']")).click();
			logger.info("Clicked on Config Id");
			Thread.sleep(3000);
		} else {
			captureScreen(driver, "ConfigIdDialog_TC012");
			Assert.assertTrue(false);
			logger.info("Config dialog is not displayed");
		}

		if (driver.findElement(By.xpath("//span[text()='Yes']")).isDisplayed()) {
			driver.findElement(By.xpath("//span[text()='Yes']")).click();
			logger.info("Clicked on 'Yes' Button");
			Thread.sleep(3000);
		}
		// select radio button
		if (driver.findElement(By.id("Existing|rb")).isEnabled()) {
			driver.findElement(By.id("Existing|rb")).click();
			logger.info("Existing Radio bution is enabled and selected");
		}

		// continue

		if (driver.findElement(By.xpath("//span[text()='Continue']")).isDisplayed()) {
			driver.findElement(By.xpath("//span[text()='Continue']")).click();
			logger.info("Clicked on 'continue' in Dialog Box");
			Thread.sleep(10000);
		}
		
		if (driver.findElement(By.xpath("//*[starts-with(@id,'SearchBox')]")).isDisplayed()) {

			driver.findElement(By.xpath("//*[starts-with(@id,'SearchBox')]")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[starts-with(@id,'SearchBox')]")).sendKeys(configID);
			logger.info("Clicked on 'Search Text Field and entered Config ID' in Dialog Box");	
		}

		if (driver.findElement(By.xpath("//*[contains(@title,'Search')]")).isDisplayed()) {
			driver.findElement(By.xpath("//*[contains(@title,'Search')]")).click();
			logger.info("Clicked on 'Search' icon");
			Thread.sleep(3000);
		}
/*		if (driver.findElement(By.xpath("//span[text()='Blitz1']")).isDisplayed()) {
			logger.info("Clicked on 'Blitz1' in Dialog Box");
			Thread.sleep(3000);
		}*/
		// clin on selected Radio button
		if (driver.findElement(By.className("oj-radiocheckbox-icon")).isDisplayed()) {
			driver.findElement(By.className("oj-radiocheckbox-icon")).click();
			logger.info("Clicked on 'rb button' in Dialog Box");
			Thread.sleep(3000);
		}
		// Continue
		if (driver.findElement(By.xpath("//span[text()='Continue']")).isDisplayed()) {
			driver.findElement(By.xpath("//span[text()='Continue']")).click();
			logger.info("Clicked on 'continue' in Dialog Box");
			Thread.sleep(3000);
		}

		// Done to complete
		if (driver.findElement(By.xpath("//span[text()='Done']")).isDisplayed()) {
			driver.findElement(By.xpath("//span[text()='Done']")).click();
			logger.info("Clicked on 'Done' button");
			Thread.sleep(18000);
		}
		// Done to complete
		if (driver.findElement(By.xpath("//span[text()='Proceed']")).isDisplayed()) {
			driver.findElement(By.xpath("//span[text()='Proceed']")).click();
			logger.info("Clicked on 'Proceed' button");
			Thread.sleep(3000);
		}
		// Validation Active
		// if (driver.findElement(By.xpath("//strong[text()='Active'] and
		// @class='[[activeConfigIdClass]]'")).isDisplayed()) {
		if (driver.findElement(By.xpath("//strong[text()='Active']")).isDisplayed()) {
			logger.info("Config ID is 'Activated' ");
			Thread.sleep(3000);
		} else {
			driver.findElement(By.className("[[activeConfigIdClass]]")).isDisplayed();
			logger.info("Config ID is 'Activated 2' ");
			Thread.sleep(3000);
		}

	}
}