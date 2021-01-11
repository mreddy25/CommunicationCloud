package com.ccs.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ccs.pageObjects.ContentPage;
import com.ccs.pageObjects.LoginPage;

public class ContentLandingPage extends BaseClass{
	@Test
	public void ContLandingPage() throws InterruptedException, IOException {
	
		// here LoginPage- pageObject class
		LoginPage lp = new LoginPage(driver);
		ContentPage cp = new ContentPage(driver);
		Thread.sleep(3000);
		
		//click on Toggle button
		lp.cliktogbtn();
		logger.info("Clicked on Toggle button");
		Thread.sleep(3000);
		
		//select Configuration link
		lp.clikconfiglnk();
		logger.info("Selected Congiuration link");

		//select Communication link
		lp.clikcommlnk();
		logger.info("Selected Configuration->Communication link");

		//select content link
		lp.clikComContConflnk();
		logger.info("Selected Configuration->Communication->Content link");
		Thread.sleep(10000);

		// Validating Title page
		boolean res = driver.getPageSource().contains("Content");
		if (res == true) {
			Assert.assertTrue(true);
			logger.info("You are at Content Landing page....");
		} else {
			logger.info("You are not at  Content Landing page....");
			captureScreen(driver, "contentLandingPage_TC010");
			Assert.assertTrue(false);
		}
		
	}

}
