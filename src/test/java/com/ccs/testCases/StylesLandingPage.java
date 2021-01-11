package com.ccs.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ccs.pageObjects.ContentPage;
import com.ccs.pageObjects.LoginPage;

public class StylesLandingPage extends BaseClass {
	@Test
	public void stylesLandingPage() throws InterruptedException, IOException {
	
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

		//select Attributes link
		lp.clikAtrbConflnk();
		logger.info("Selected Configuration->Communication->Attributes link");
		Thread.sleep(10000);
		
		//select Styles link
		lp.clikAtrbStyleConflnk();
		logger.info("Selected Configuration->Communication->Attributes->Styles link");
		Thread.sleep(10000);

		// Validating Title page
		boolean res = driver.getPageSource().contains("Styles");
		if (res == true) {
			Assert.assertTrue(true);
			logger.info("You are at Styles Landing page....");
		} else {
			logger.info("You are not at  Styles Landing page....");
			captureScreen(driver, "StylesLandingPage");
			Assert.assertTrue(false);
		}
		
	}

}
