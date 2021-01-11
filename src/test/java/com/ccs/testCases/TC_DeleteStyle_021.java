package com.ccs.testCases;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ccs.pageObjects.CCSPageObjects;
import com.ccs.pageObjects.LoginPage;
import com.ccs.pageObjects.StylesPage;
import com.ccs.utilities.XLUtils;

public class TC_DeleteStyle_021 extends BaseClass{
	@Test(dataProvider="StylesData")
	public void updateStyles(String uname, String pwd, String sName, String styleName, String styleLName, String styleDesc, String attrbType, String AttrbName) throws InterruptedException, IOException
	{

		// calling SignIn method
		// TC_LoginTest_001 signIn = new TC_LoginTest_001();
		// signIn.signInTest();

		// calling SignIn method
		driver.get(baseURL);
		Thread.sleep(3000);
		logger.info("URL is opened: " + baseURL);
		Thread.sleep(3000);

		// here LoginPage- pageObject class
		LoginPage lp = new LoginPage(driver);
		StylesPage sp = new StylesPage(driver);
		CCSPageObjects cob = new CCSPageObjects(driver);

		// if details button is exists then click otherwise skip
		lp.detailBtn().click();
		logger.info("Clicked on 'details-button'");
		Thread.sleep(2000);

		// if Proceed link is exists then click otherwise skip
		lp.proceedLnk().click();
		logger.info("Clicked on 'proceed-link'");
		Thread.sleep(2000);

		// enter username
		lp.setUserName(uname);
		logger.info("Entered username: " + uname);

		// enter Password
		lp.setPassword(pwd);
		logger.info("Entered password");
		Thread.sleep(3000);

		// click on sign-in
		lp.clickSignin();
		logger.info("Clicked on Sign In");

		// validation Login windows Name
		if (lp.loginSuccess().isDisplayed()) {
			logger.info("Login test passed and Logged in as a: " + uname);
		} else {
			// call the capture screen method which is declared in base class
			captureScreen(driver, "loginTest_TC0018");
			Assert.assertTrue(false);
			logger.info("Login test failed");
		}

		// Calling MapConfig Id function
		TC_MapConfigID_013 mapConfigId = new TC_MapConfigID_013();
		mapConfigId.mapConfigID();

		// Calling Class- Navigate to Styles Landing page
		StylesLandingPage slp = new StylesLandingPage();
		slp.stylesLandingPage();
		Thread.sleep(5000);

		// search filed
		// if
		// (driver.findElement(By.xpath("//*[starts-with(@id,'SearchBox')]")).isDisplayed())
		if (cob.searchField().isDisplayed()) {
			cob.searchField().click();
			cob.searchField().sendKeys(styleName);
			logger.info("Clicked on 'Search Text' Field and entered Style name: " + styleName);
			Thread.sleep(3000);
		}
		// click on Search
		// if
		// (driver.findElement(By.xpath("//*[contains(@title,'Search')]")).isDisplayed())
		// {

		if (cob.searchIcon().isDisplayed()) {
			cob.searchIcon().click();
			logger.info("Clicked on 'Search' icon");
		}

		Thread.sleep(25000);
		// verify the search results
		// String searchresult =
		// driver.findElement(By.xpath("//span[contains(@class,'list-text')]")).getText();
		String searchresult = cob.searchResult().getText();
		if (searchresult.contains(styleName)) {
			logger.info("Searched Style name is: " + searchresult);
			Thread.sleep(3000);
		} else {
			logger.info("Searched Style name is not as:" + searchresult);
			Thread.sleep(3000);
		}
		// kebab/ellipsis menu
		// if
		// (driver.findElement(By.xpath("//span[contains(@class,'icon-ellipsis-menu')]")).isDisplayed())
		if (cob.kebabMenu().isDisplayed()) {
			cob.kebabMenu().click();
			logger.info("Clicked on kebab menu ");
			Thread.sleep(3000);
		}

		// Select delete option
		if (cob.deleteOption().isDisplayed())
		{
			cob.deleteOption().click();
			logger.info("Clicked on Delete option ");
			Thread.sleep(3000);
		}		

		//Click on 'yes' in warning window
		if (cob.YesToConfirm().isDisplayed()) {
			cob.YesToConfirm().click();
			logger.info("Clicked on 'Yes' Button to confirm the deletion of Style");
		}
		Thread.sleep(20000);
		
		//Click on'Ok' in warning window
		if (cob.OkToConfirm().isDisplayed()) {
			cob.OkToConfirm().click();
			logger.info("Clicked on 'Ok' Button to complete the delete process");
			Thread.sleep(3000);
		}
		Thread.sleep(20000);
		//verify after deleting the content
		if (cob.NoItems().isDisplayed())
		{
			logger.info("Selected item is deleted and No items to display here");
			Thread.sleep(3000);
		}
		
	
		

		// Sign off the application
		Thread.sleep(8000);
		TC_SignOff signOff = new TC_SignOff();
		signOff.signOff();
		logger.info("User is Signed off from the application ");

		// Clear browser history
		driver.get("chrome://settings/clearBrowserData");
		driver.findElement(By.xpath("//settings-ui")).sendKeys(Keys.ENTER);
		logger.info("Browser Data: Clear history, CCookies and Cache are cleared ");
		Thread.sleep(3000);

	}

	// Read Data from excel

	@DataProvider(name = "StylesData")
	String[][] getData() throws IOException {
		String path = System.getProperty("user.dir") + "/src/test/java/com/ccs/testData/LoginData.xlsx";

		// read the data from xlsx //get row count
		int rownum = XLUtils.getRowCount(path, "StyleData");// path- xl location path and sheet1 - sheet name //get cell
															// count
		int colcount = XLUtils.getCellCount(path, "StyleData", 2); // here 1- row number

		String stylesdata[][] = new String[rownum][colcount];

		for (int i = 2; i <= rownum; i++)// outer for loop for row
		{
			for (int j = 0; j < colcount; j++)// inner for loop for column
			{
				stylesdata[i - 2][j] = XLUtils.getCellData(path, "StyleData", i, j);
			}
		}

		return stylesdata;
	}


}
