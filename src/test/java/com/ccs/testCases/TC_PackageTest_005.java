package com.ccs.testCases;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.ccs.pageObjects.LoginPage;

public class TC_PackageTest_005 extends BaseClass {
	@Test
	public void packageTest() throws InterruptedException, IOException
	{
		
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
		logger.info("Click on Sign In");
		Thread.sleep(45000);
		
		lp.cliktogbtn();
		logger.info("Click on Toggle button");
		Thread.sleep(3000);
		
		lp.clikconfiglnk();
		logger.info("Selected Congiuration link");
		
		lp.clikcommlnk();
		logger.info("Selected Communication link");
		
		lp.clikComPackConflnk();
		logger.info("Selected Communication Document link");
		Thread.sleep(20000);
		 
		//validating Title
		boolean res=driver.getPageSource().contains("Document Package"); 
		if(res==true) 
		{
			Assert.assertTrue(true);
			logger.info("You are at Document Package Landing page....");
		  
		}
		else 
		{ 
			logger.info("You are not at Document Package Landing page....");
			captureScreen(driver,"documentPackageLandingPage"); 
			Assert.assertTrue(false);
		  }	 

	}
}