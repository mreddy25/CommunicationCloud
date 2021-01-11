package com.ccs.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.ccs.pageObjects.ContentPage;
import com.ccs.pageObjects.LoginPage;

public class TC_SignOff extends BaseClass {
	@Test
	public void signOff() throws InterruptedException, IOException {
		
		// here LoginPage- pageObject class
		LoginPage lp = new LoginPage(driver);
		ContentPage cp = new ContentPage(driver);
		Thread.sleep(3000);
	//click on Hamburger Icon
	if (driver.findElement(By.xpath("//*[contains(@class,'icon-ham-menu')]")).isDisplayed()) {
		driver.findElement(By.xpath("//*[contains(@class,'icon-ham-menu')]")).click();
		logger.info("Clicked on Hamberger/toggle button ");
		Thread.sleep(8000);
	}

	//click in Previous button
	driver.findElement(By.xpath("//*[contains(@class,'oj-navigationlist-previous-icon')]")).click();
	logger.info("Clicked on Previous(<) button ");
	Thread.sleep(8000);

	//click in Previous button again
	driver.findElement(By.xpath("//*[contains(@class,'oj-navigationlist-previous-icon')]")).click();
	logger.info("Clicked on Previous(<) button ");
	Thread.sleep(8000);
	
	if (driver.findElement(By.xpath("//*[contains(@class,'oj-navigationlist-previous-icon')]")).isDisplayed())
	{
			driver.findElement(By.xpath("//*[contains(@class,'oj-navigationlist-previous-icon')]")).click();
	logger.info("Clicked on Previous(<) button ");
	Thread.sleep(8000);
	}else {
		logger.info("No Previous(<) buttion are displaying to click on it");
		
	}

	// click on Sign of 
	if (driver.findElement(By.xpath("//span[text()='Sign Off']")).isDisplayed()) {
		driver.findElement(By.xpath("//span[text()='Sign Off']")).click();
		logger.info("clicked on Sign Off");
		Thread.sleep(30000);
	} else {
		lp.clickSignoff();
		logger.info("User is Signed off");
		Thread.sleep(30000);
	}	
	}	

}
