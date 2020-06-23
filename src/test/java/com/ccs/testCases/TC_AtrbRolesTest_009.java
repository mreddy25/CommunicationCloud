package com.ccs.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ccs.pageObjects.LoginPage;

public class TC_AtrbRolesTest_009 extends BaseClass
{
	
	@Test
	public void atrbStylesTest() throws InterruptedException, IOException
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
		logger.info("Selected Configuration->Communication link");
		
		lp.clikAtrbConflnk();
		logger.info("Selected Configuration->Communication->Attributes link");
		Thread.sleep(3000);
		
		lp.clikAtrbStyleConflnk();
		logger.info("Selected Configuration->Communication->Attributes->Styles link");
		Thread.sleep(20000);
		 
		//validating Title
		boolean res=driver.getPageSource().contains("Document Styles"); 
		if(res==true) 
		{
			Assert.assertTrue(true);
			logger.info("You are at Document Stules Landing page....");
		  
		}
		else 
		{ 
			logger.info("You are not at Document Styles Landing page....");
			captureScreen(driver,"documentStylesLandingPage"); 
			Assert.assertTrue(false);
		  }	 

	}


}
