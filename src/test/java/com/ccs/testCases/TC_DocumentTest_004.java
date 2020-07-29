package com.ccs.testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ccs.pageObjects.ContentPage;
import com.ccs.pageObjects.LoginPage;

import com.ccs.utilities.XLUtils;

public class TC_DocumentTest_004 extends BaseClass {

	@Test(dataProvider = "DocumentData")

	public void documentTest(String uname, String pwd, String bDocName, String bDocLName, String bDocDesc,
			String DocVname, String docDesc, String activeDate) throws InterruptedException, IOException {
		// calling SignIn method
		// TC_LoginTest_001 signIn = new TC_LoginTest_001();
		// signIn.signInTest();

		// get the URL
		driver.get(baseURL);
		Thread.sleep(3000);
		logger.info("URL is opened: " + baseURL);
		// here LoginPage- pageObject class

		LoginPage lp = new LoginPage(driver);
		ContentPage cp = new ContentPage(driver);
		Thread.sleep(3000);

		// details page-
		lp.clkkdetailBtn();
		lp.clkproceedLink();

		lp.setUserName(uname);
		logger.info("Entered username: " + uname);

		lp.setPassword(pwd);
		logger.info("Entered password");

		lp.clickSignin();
		logger.info("Clicked on Sign In");
		Thread.sleep(45000);


		driver.manage().timeouts().setScriptTimeout(6000, TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		// validation
		boolean Logintitle=driver.getPageSource().contains("Dashboard"); 
		
		if(Logintitle==true) 
					 
		 { 
			 Assert.assertTrue(true);
			 logger.info("Login test passed and Logged in as a: "+uname);
		 }
		 else 
		 {
			 //call the capture screen method which is declared in base class
			 captureScreen(driver,"loginTest_TC004");
			 Assert.assertTrue(false);
			 logger.info("Login test filed");
		 
		 }

		lp.cliktogbtn();
		logger.info("Clicked on Toggle button");
		Thread.sleep(3000);

		lp.clikconfiglnk();
		logger.info("Selected Congiuration link");

		lp.clikcommlnk();
		logger.info("Selected Configuration->Communication link");

		lp.clikComDocConflnk();
		logger.info("Selected Configuration->Communication->Document link");
		Thread.sleep(20000);

		// validating Title
		boolean DocLandTitle = driver.getPageSource().contains("Document");
		if (DocLandTitle == true) {
			Assert.assertTrue(true);
			logger.info("You are at Document Landing page....");

		} else {
			logger.info("You are not at Document Landing page....");
			captureScreen(driver, "documentLandingPage_TC004");
			Assert.assertTrue(false);
		}

		if (driver.findElement(By.id("_ojcustomelem8_SearchBox|input")).isDisplayed())
		{
			driver.findElement(By.id("_ojcustomelem8_SearchBox|input")).sendKeys("cc");
			logger.info("Entered Layout name in Search text box: ");
			Thread.sleep(3000);
		}else {
			
				
		Thread.sleep(3000);
		cp.txtInputSearch("cc");
		logger.info("Entered Document name in Search text box");
		Thread.sleep(3000);
		}
		if (driver.findElement(By.xpath("//span[text()='View All Layouts']")).isDisplayed())
		{
	driver.findElement(By.xpath("//span[text()='View All Layouts']")).click();
	logger.info("Clicked on 'View All Layouts' to search the selected Layout 1");
		}else {
		cp.ViewAllBtn();
		logger.info("Clicked on 'View All Documents' to search the selected Document");
		Thread.sleep(5000);
		}
		// Validating result window

		if (cp.resultstWind() == true) {
			Assert.assertTrue(true);
			logger.info("selected Document/s will be listed in results window");
		} else

		{
			logger.info("selected items are not liseds in results window");
			captureScreen(driver, "SearchResults_TC004");
			Assert.assertTrue(false);
		}

		// click create button
		cp.CreateBtn();
		logger.info("Clicked on 'Plus(+) icon button to create new Document");
		Thread.sleep(5000);

		// validating window
		boolean res1 = driver.findElement(By.xpath("//span[text()='Creating']")) != null;

		// driver.getTitle().equals("Creating New Document")
		if (driver.getPageSource().contains("Creating New Document")) {
			logger.info("Creating New Document window");
		} else if (driver.getTitle().equals("Create Base Document"))

		{

			logger.info("section with 'Create Base Document' is displayed");
			Thread.sleep(3000);
		}

		else if (res1 == true) {
			Assert.assertTrue(true);
			logger.info("You are at Create new Document window");

		} else {
			logger.info("You are not at Create new Document window");
			captureScreen(driver, "CreateNewDocument_TC004");
			Assert.assertTrue(false);
		}

		// provide Base document details
		cp.baseContName(bDocName);
		logger.info("Entered Document Name ");
		Thread.sleep(3000);

		cp.baseContLongName(bDocLName);
		logger.info("Entered Document  long name");
		Thread.sleep(3000);

		cp.baseContDesc(bDocDesc);
		logger.info("Entered Document description");
		Thread.sleep(3000);

		cp.continueBaseBtn();
		logger.info("Clicked on continue button in '2/4 Add Identification' window");
		Thread.sleep(5000);

		driver.getTitle().equals("Create Document Version");
		logger.info("You are at 'Create Document Version' window");
		Thread.sleep(3000);

		driver.findElement(By.xpath(
				"//*[@class='oj-inputtext-input oj-text-field-input oj-component-initnode' and @id='textinput|input']"))
				.sendKeys(DocVname);
		logger.info("Entered Document Version Name:" + DocVname);
		Thread.sleep(3000);

		driver.findElement(By.xpath(
				"//*[@class='oj-textarea-input oj-text-field-input oj-component-initnode' and @id='textArea|input']"))
				.sendKeys(docDesc);
		logger.info("Entered Document Description:" + docDesc);
		Thread.sleep(3000);

		driver.findElement(By.xpath(
				"//*[@class='oj-inputdatetime-input oj-text-field-input oj-component-initnode' and @id='fromDate|input']"))
				.sendKeys(activeDate);
		logger.info("Entered Active Date:" + activeDate);
		Thread.sleep(5000);

		driver.findElement(By.xpath("//span[text()='Continue']")).click();
		logger.info("clicked continue in Document version window to create base content ");

		Thread.sleep(20000);

	}

	// method - read data from xls

	@DataProvider(name = "DocumentData")
	String[][] getData() throws IOException {
		String path = System.getProperty("user.dir") + "/src/test/java/com/ccs/testData/LoginData.xlsx";

		// read the data from xls //get row count
		int rownum = XLUtils.getRowCount(path, "DocumentData");// path- xl location path and sheet1 - sheet name //get
																// cell count
		int colcount = XLUtils.getCellCount(path, "DocumentData", 1); // here 1- row number

		String documentdata[][] = new String[rownum][colcount];

		for (int i = 1; i <= rownum; i++)// outer for loop for row
		{
			for (int j = 0; j < colcount; j++)// inner for loop for column
			{
				documentdata[i - 1][j] = XLUtils.getCellData(path, "DocumentData", i, j);
			}
		}

		return documentdata;
	}

}
