package com.ccs.testCases;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ccs.pageObjects.CCSPageObjects;
import com.ccs.pageObjects.ContentPage;
import com.ccs.pageObjects.LoginPage;
import com.ccs.utilities.XLUtils;

public class TC_CreateContDDT_011 extends BaseClass {

	String timeStamp = new SimpleDateFormat("yy.MM.dd.HH.mm.ss").format(new Date());

	@Test(dataProvider = "ContData")

	public void ContCreateDDT(String uname, String pwd, String bconName, String bconLName, String bconDesc,
			String conVname, String contDesc, String activeDate, String cKEditData)
			throws InterruptedException, IOException

	{
		// calling SignIn method
		driver.get(baseURL);
		Thread.sleep(3000);
		logger.info("URL is opened: " + baseURL);
		Thread.sleep(3000);

		// here LoginPage- pageObject class
		LoginPage lp = new LoginPage(driver);
		ContentPage cp = new ContentPage(driver);
		CCSPageObjects cob = new CCSPageObjects(driver);		

		// if details button is exists then click otherwise skip
		if (lp.noDetaislBtn().isEmpty()) {
			logger.info("Details-button is not dispayed to click");
			Thread.sleep(2000);
		} else {
			lp.detailBtn().click();
			logger.info("Clicked on 'details-button'");
			Thread.sleep(2000);
		}

		// if Proceed link is exists then click otherwise skip
		if (lp.noProceedLnk().isEmpty()) {
			logger.info("Proceed-link is not displayed to click");
			Thread.sleep(2000);
		} else {
			lp.proceedLnk().click();
			logger.info("Clicked on 'proceed-link'");
			Thread.sleep(2000);
		}

		// enter username
		lp.setUserName(uname);
		logger.info("Entered username: " + uname);

		// enter password
		lp.setPassword(pwd);
		logger.info("Entered password");

		// click on Sign In button
		lp.clickSignin();
		logger.info("Clicked on Sign In");
		Thread.sleep(45000);

		// validation window name
		
		if(lp.loginSuccess().isDisplayed())
		{
			logger.info("Login test passed and Logged in as a: " + uname);	
		}else{
				 //call the capture screen method which is declared in base class
				 captureScreen(driver,"loginTest_TC0011");
				 Assert.assertTrue(false);
				 logger.info("Login test failed");
		 }

		// Calling MapConfig Id function
		TC_MapConfigID_013 mapConfigId = new TC_MapConfigID_013();
		mapConfigId.mapConfigID();

		// Calling Class- Go to Content Landing page
		ContentLandingPage ContLandingPage = new ContentLandingPage();
		ContLandingPage.ContLandingPage();
		Thread.sleep(5000);
		
		cob.createBtn().click();
		logger.info("Clicked on 'Plus(+) icon button to create new Content");
		Thread.sleep(5000);

		//Validating Content Selection window name
		//boolean res1 = driver.findElement(By.xpath("//span[text()='Choose Content Type']")) != null;
		if (cp.contSelectionWindow().isDisplayed())		
		 {
			Assert.assertTrue(true);
			logger.info("You are at 'Choose Content Type' window");
		} else {
			logger.info("You are not at Choose Content Type window");
			captureScreen(driver, "ContSelectionWindow_TC010");
			Assert.assertTrue(false);
		}

		Thread.sleep(3000);
		cp.radioBtn().click();
		logger.info("Selected Text radio button to create new Content");
		Thread.sleep(3000);

		//if (driver.findElement(By.xpath("//span[text()='Continue']")).isDisplayed())
		if (cob.continueBtn().isDisplayed()){
			cob.continueBtn().click();
			logger.info("Clicked on continue button 1/4 Choose Content Type");
			Thread.sleep(3000);
		}
	
		// Create Base Content
		//boolean cad = driver.getPageSource().contains("Add Identification");
		
		if (cp.addIdentificationWind().isDisplayed()) {
			logger.info("You are at 2/4 Add Identification dialog window");
			Thread.sleep(5000);
			} else {
			logger.info("You are not at 2/4 Add Identification dialog window");
			captureScreen(driver, "ContentAddIdentWindow_TC010");
			Assert.assertTrue(false);
		}
		
		//EnterName for content
		if(cob.baseNameField().isEnabled())
		{
			cob.baseNameField().sendKeys(bconName + timeStamp);
			logger.info("Entered Base Content name as : " + bconName + timeStamp);
			Thread.sleep(3000);
		}else {
		cp.baseContName(bconName + timeStamp);
		logger.info("Entered Base Content name as-2 : " + bconName + timeStamp);
		Thread.sleep(3000);
		}
		
		//enter Long Name for Content
		if(cob.longNameField().isEnabled())
		{
			cob.longNameField().sendKeys(bconLName + timeStamp);
			logger.info("Entered Base Content Long name as : " + bconLName + timeStamp);
			Thread.sleep(3000);
		}else {
		cp.baseContLongName(bconLName + timeStamp);
		logger.info("Entered Base Content  long name as -2:" + bconLName + timeStamp);
		Thread.sleep(3000);
		}		
		
		//Enter Description for Content		
		if (cob.baseDescriptionField().get(1).isEnabled())
		{
			cob.baseDescriptionField().get(1).sendKeys(bconDesc + timeStamp);
			logger.info("Entered Base Contant Description as : " + bconDesc + timeStamp);
		}
		/*	
		cob.continueBtn().click();
		logger.info("Clicked on continue button in '2/4 Add Identification' window");
		Thread.sleep(18000);
*/
	
		//Continue button
		if(driver.findElement(By.xpath("//span[text()='Continue']")).isDisplayed())
		{
			driver.findElement(By.xpath("//span[text()='Continue']")).click();
			logger.info("Clicked on continue button in '2/4 Add Identification' window");
			Thread.sleep(18000);
		}
		
		
		// validating window title
		driver.getTitle().equals("Create Content Version");
		logger.info("You are at 'Create Content Version' window");
		Thread.sleep(3000);

		// enter content version name
		
		if(cob.versionNameField().isDisplayed())
		{
			cob.versionNameField().sendKeys(conVname + timeStamp);
			logger.info("Entered Contant Version Name:" + conVname + timeStamp);
			Thread.sleep(3000);
		}

		// enter cont description
		//if (driver.findElement(By.xpath("//*[starts-with(@id,'textArea')]")).isDisplayed()) {
		if (cob.descriptionField().isDisplayed())
		{
			cob.descriptionField().sendKeys(contDesc + timeStamp);
			logger.info("Entered Contant Description:" + contDesc + timeStamp);
			Thread.sleep(3000);
		}
	
		// enter active date
		//driver.findElement(By.xpath("//*[starts-with(@id,'fromDate')]"))
		if (cob.dateField().isEnabled()) {
			cob.dateField().sendKeys(activeDate);
			logger.info("Entered Active Date: " + activeDate);
			Thread.sleep(10000);
		}

		// click on continue
		//cob.continueBtn().isDisplayed();
		//cob.continueBtn().click();
	
		if (driver.findElement(By.xpath("//span[contains(@class,'oj-button-text') and contains(text(),'Continue')]")).isDisplayed())
		{
			driver.findElement(By.xpath("//span[contains(@class,'oj-button-text') and contains(text(),'Continue')]")).click();
			logger.info("clicked continue in contenet version window to create base content ");
		}

		Thread.sleep(150000);

		// ck toolbar
		
		//driver.findElement(By.xpath("//*[contains(@class,'ck-toolbar')]")).isDisplayed()
		if (cp.ckToolbar().isDisplayed()) {
			logger.info("ck-toolbar is displayed");
		} else {
			logger.info("ck-toolbar bar is not displayed");
			captureScreen(driver, "CKEditorToolBar_TC0011");
			Assert.assertTrue(false);
		}

		// CKEditor
		//WebElement ckeditor = driver.findElement(By.xpath("//*[contains(@class,'ck-editor__editable')]"));
		if (cp.ckEditor().isDisplayed()) {
			cp.ckEditor().click();
			logger.info("Clicked on ckeditor'");
			Thread.sleep(2000);
		}

		/*
		 * ckeditor.sendKeys("Dear Customer,"); ckeditor.sendKeys(Keys.ENTER);
		 */

		// enter data in ckeditor
		cp.ckEditor().sendKeys(cKEditData);
		logger.info("Entered content details in 'CKEditor'");
		Thread.sleep(3000);

		// Click Continue
		//driver.findElement(By.xpath("//span[text()='Continue' and @class='oj-button-text']"))
/*		if(cob.continueBtn().isDisplayed()) {
			cob.continueBtn().click();	
			logger.info("Clicked on Continue after entering the content details in CKEditor");
		}
*/		
		if (driver.findElement(By.xpath("//span[text()='Continue' and @class='oj-button-text']")).isDisplayed()) {
			driver.findElement(By.xpath("//span[text()='Continue' and @class='oj-button-text']")).click();
			logger.info("Clicked on Continue after entering the content details in CKEditor");
		}

		Thread.sleep(20000);

		// Content Creation status window
		driver.findElement(By.xpath("//span[text()='Success!']")).isDisplayed();
		boolean successWind = cp.successMsgWind().isDisplayed();
		if (successWind == true) {
			Assert.assertTrue(true);
			logger.info("Content creation windows is displayed with 'Success'");
		} else {
			logger.info("Content creation windows is not displayed with 'Success'");
			captureScreen(driver, "ContCreatSuccess_TC011");
			Assert.assertTrue(false);
		}
		Thread.sleep(2000);

		// Finish Button-
		//driver.findElement(By.xpath("//span[text()='Finish' and @class='oj-button-text']"))
		
		if (cob.finishBtn().isEnabled()) {
			cob.finishBtn().click();
			logger.info("Clicked on Finish Button to complete the Content creation process");
		}

		// validating content title after creation
		Thread.sleep(30000);
		//Boolean contTitle = driver.findElement(By.tagName("h1")).isDisplayed();
		Boolean contTitle = cob.assetTitle().isDisplayed();
		if (contTitle == true) {
			Assert.assertTrue(true);
			logger.info("Content is created with the name of :" + conVname + timeStamp);
		} else {
			logger.info("Content is not created with the name of :" + conVname + timeStamp);
			captureScreen(driver, "ContCreatSuccess_TC011");
			Assert.assertTrue(false);
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
		
		//Close the browser
		//driver.quit();
		//logger.info("Browser is closed ");

	}

	// data read from excel
	@DataProvider(name = "ContData")
	String[][] getData() throws IOException {
		String path = System.getProperty("user.dir") + "/src/test/java/com/ccs/testData/LoginData.xlsx";

		// read the data from xlsx //get row count
		int rownum = XLUtils.getRowCount(path, "ContentData");// path- xl location path and sheet1 - sheet name //get

		// cell count
		int colcount = XLUtils.getCellCount(path, "ContentData", 1); // here 1- row number

		String contentdata[][] = new String[rownum][colcount];

		for (int i = 1; i <= rownum; i++)// outer for loop for row
		{
			for (int j = 0; j < colcount; j++)// inner for loop for column
			{
				contentdata[i - 1][j] = XLUtils.getCellData(path, "ContentData", i, j);
			}
		}

		return contentdata;
	}

}
