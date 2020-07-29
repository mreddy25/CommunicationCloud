package com.ccs.testCases;

import org.testng.annotations.Test;

import com.ccs.pageObjects.LoginPage;

import java.io.IOException;

//import junit.framework.Assert;
import org.junit.Assert;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

public class TC_LoginTest_001 extends BaseClass
{
	
	//test cases contains only Test method

	@Test
	public void signInTest() throws InterruptedException, IOException
	{
		//loginTest
		driver.get(baseURL);
		logger.info("URL is opened: "+baseURL);
		
		//here LoginPage- pageObject class
		LoginPage lp = new LoginPage(driver);
		Thread.sleep(3000);
		
		//details page-
		lp.clkkdetailBtn();
		lp.clkproceedLink();
		
		lp.setUserName(username);
		logger.info("Entered username: "+username);
		
		lp.setPassword(password);
		logger.info("Entered password");
		
		lp.clickSignin();
		logger.info("Clicked on Sign In");
		Thread.sleep(150000);
		
		//validation
		boolean res=driver.getPageSource().contains("Dashboard"); 
		if(res==true) 
					 
		 { 
			 Assert.assertTrue(true);
			 logger.info("Login test passed and Logged in as a: "+username);
		 }
		 else 
		 {
			 //call the capture screen method which is declared in base class
			 captureScreen(driver,"loginTest_TC001");
			 Assert.assertTrue(false);
			 logger.info("Login test filed");
		 
		 }
		
		//sign off from the application
		
		
		/*
		 * driver.findElement(By.id("drawerToggleButton")).click(); Thread.sleep(3000);
		 * lp.clickSignoff(); logger.info("User is Sign off");
		 */
		 
	}

	

}
