package com.ccs.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ccs.pageObjects.ContentPage;
import com.ccs.pageObjects.LoginPage;

public class TC_AtrbFontsTest_007 extends BaseClass{
	
	@Test
	public void atrbFontsTest() throws InterruptedException, IOException
	{
		
		//calling SignIn method
		TC_LoginTest_001 signIn = new TC_LoginTest_001();
		signIn.signInTest();
		
		LoginPage lp = new LoginPage(driver); 
		ContentPage cp = new ContentPage(driver);
		
		lp.cliktogbtn();
		logger.info("Clicked on Toggle button");
		Thread.sleep(3000);
		
		lp.clikconfiglnk();
		logger.info("Selected Congiuration link");
		
		lp.clikcommlnk();
		logger.info("Selected Configuration->Communication link");
		
		lp.clikAtrbConflnk();
		logger.info("Selected Configuration->Communication->Attributes link");
		Thread.sleep(3000);
		
		lp.clikAtrbFontConflnk();
		logger.info("Selected Configuration->Communication->Attributes->Fonts link");
		Thread.sleep(20000);
		 
		//validating Title
		boolean res=driver.getPageSource().contains("Document Fonts"); 
		if(res==true) 
		{
			Assert.assertTrue(true);
			logger.info("You are at Document Fonts Landing page....");
		  
		}
		else 
		{ 
			logger.info("You are not at Document Fonts Landing page....");
			captureScreen(driver,"documentFontsLandingPage_TC007"); 
			Assert.assertTrue(false);
		 }	 
		
		Thread.sleep(3000);
		cp.txtInputSearch("cc");
		logger.info("Entered Fonts name in Search text box");
		Thread.sleep(3000);

		cp.ViewAllBtn();
		logger.info("Clicked on 'View All Fonts' to search the selected Fonts");
		Thread.sleep(5000);
	}

}
