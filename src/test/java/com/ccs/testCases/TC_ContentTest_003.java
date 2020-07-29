package com.ccs.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ccs.pageObjects.ContentPage;
import com.ccs.pageObjects.LoginPage;

public class TC_ContentTest_003 extends BaseClass {

	@Test
	public void contentTest() throws InterruptedException, IOException {
		// calling SignIn method
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

		lp.clikComContConflnk();
		logger.info("Selected Configuration->Communication->Content link");
		Thread.sleep(10000);

		// Validating Title page
		boolean res = driver.getPageSource().contains("Document Content");
		if (res == true) {
			Assert.assertTrue(true);
			logger.info("You are at Document Content Landing page....");

		} else {
			logger.info("You are not at Document Content Landing page....");
			captureScreen(driver, "documentContentLandingPage_TC003");
			Assert.assertTrue(false);
		}

		Thread.sleep(3000);
		cp.txtInputSearch(contsearchinput);
		logger.info("Entered Content name in Search text box");
		Thread.sleep(3000);

		cp.ViewAllBtn();
		logger.info("Clicked on 'View All Contents' to search the selected Content");
		Thread.sleep(5000);

		// boolean Results = driver.findElement(By.xpath("//span[text()='Results']")) !=
		// null;
		if (cp.resultstWind() == true) {
			Assert.assertTrue(true);
			logger.info("selected content/s will be listed in results window");
		} else {
			logger.info("selected items are not liseds in results window");
			captureScreen(driver, "CreateResults_TC003");
			Assert.assertTrue(false);
		}

		cp.CreateBtn();
		logger.info("Clicked on 'Plus(+) icon button to create new Content");
		Thread.sleep(5000);

		// driver.getTitle().equals("Creating New Content");
		boolean res1 = driver.findElement(By.xpath("//span[text()='Creating']")) != null;
		if (res1 == true) {
			Assert.assertTrue(true);
			logger.info("You are at Create new content window");

		} else {
			logger.info("You are not at Create new content window");
			captureScreen(driver, "CreateNewContent_TC003");
			Assert.assertTrue(false);
		}

		Thread.sleep(3000);
		// driver.findElement(By.id("Text|rb")).click();
		cp.radioBtnClk();
		logger.info("Selected Text radio button to create new Content");
		Thread.sleep(3000);

		cp.continueBtn();
		logger.info("Clicked on continue button 1/4 Choose Content Type");
		Thread.sleep(5000);

		// Create Base Content

		boolean cad = driver.getPageSource().contains("Add Identification");
		// boolean cad = cp.addIdentWind();
		if (cad == true) {
			Assert.assertTrue(true);
			logger.info("You are at 2/4 Add Identification dialog window");
		} else {
			logger.info("You are not at 2/4 Add Identification dialog window");
			captureScreen(driver, "ContentAddIdentWindow_TC003");
			Assert.assertTrue(false);
		}
		// driver.findElement(By.id("textinput|input")).sendKeys("CC-BaseContentName");
		cp.baseContName(bcontantname);
		logger.info("Entered Content name ");
		Thread.sleep(3000);

		// driver.findElement(By.id("textArea|input")).sendKeys("CC-ContentLongName");
		cp.baseContLongName(bcontlongname);
		logger.info("Entered Content  long name");
		Thread.sleep(3000);

		// driver.findElement(By.xpath("//*[@id='textArea|input' and
		// @maxlength='4000']")).sendKeys("CC-ContentDescription");
		cp.baseContDesc(bcontdesc);
		logger.info("Entered Content description");
		Thread.sleep(3000);

		// driver.findElement(By.id("Continue")).click();
		cp.continueBaseBtn();
		logger.info("Clicked on continue button in '2/4 Add Identification' window");
		Thread.sleep(5000);

		// driver.getPageSource().contains("Create Content Version");
		driver.getTitle().equals("Create Content Version");
		logger.info("You are at 'Create Content Version' window");
		Thread.sleep(3000);

		driver.findElement(By.xpath("//*[@id='textinput|input' and @maxlength='30']")).clear();
		logger.info("cleared contant name");
		driver.findElement(By.xpath(
				"//*[@class='oj-inputtext-input oj-text-field-input oj-component-initnode' and @id='textinput|input']"))
				.sendKeys("CC-Sample Content");
		logger.info("entered contant name");
		Thread.sleep(3000);

		driver.findElement(By.xpath(
				"//*[@class='oj-textarea-input oj-text-field-input oj-component-initnode' and @id='textArea|input']"))
				.sendKeys("CC-Sample Content");
		logger.info("entered contant description");
		Thread.sleep(3000);

		driver.findElement(By.xpath(
				"//*[@class='oj-inputdatetime-input oj-text-field-input oj-component-initnode' and @id='fromDate|input']"))
				.sendKeys("07/30/2020");
		logger.info("entered Active Date");
		Thread.sleep(5000);

		driver.findElement(By.xpath("//span[text()='Continue']")).click();
		logger.info("clicked continue in contenet version window to create base content ");

		Thread.sleep(20000);

		// driver.findElement(By.xpath("//span[text()='Editor
		// toolbars']")).isDisplayed();
		// driver.getPageSource().contains("Editor toolbars");
		// logger.info("cEditor tool bar is displayed ");

		boolean cke = driver.findElement(By.xpath("//span[text()='Editor toolbars']")) != null;
		if (cke == true) {
			Assert.assertTrue(true);
			logger.info("Editor tool bar is displayed");
		} else {
			logger.info("Editor tool bar is not displayed");
			captureScreen(driver, "EditorToolBar_TC003");
			Assert.assertTrue(false);
		}

		Thread.sleep(2000);
//CKEditor		
		WebElement ckeditor = driver
				.findElement(By.xpath("//*[@class='cke_wysiwyg_frame cke_reset' and @aria-describedby='cke_28']"));
		ckeditor.click();
		Thread.sleep(2000);
		ckeditor.sendKeys("Dear Customer");
		logger.info("entered 1st line in 'cke_wysiwyg_frame cke_reset'");
		Thread.sleep(2000);

		// note- test is not appearing when we enter test in 1st line)
		ckeditor.sendKeys(Keys.ENTER);
		logger.info("pressed ENTER button in key board");
		Thread.sleep(2000);

		ckeditor.sendKeys("Dear Customer, Thanks for Signing");
		logger.info("Entered content details in 'CKEditor'");
		Thread.sleep(3000);
		
		
		
		if(driver.findElement(By.xpath("//span[text()='Continue' and @class='oj-button-text']")).isDisplayed()) {
			driver.findElement(By.xpath("//span[text()='Continue' and @class='oj-button-text']")).click();
		logger.info(" Clicked on Continue after entering the content details in CKEditor");
		}
		/*else {
			//driver.findElement(By.xpath("//span[text()='Continue' and @class='oj-button-text']")).click();
			driver.findElement(By.xpath("//span[text()='Continue']")).click();
			logger.info("clicked continue 2");
		}
*/
		Thread.sleep(20000);

		// Content Creation complete window
		boolean successWind = driver.findElement(By.xpath("//span[text()='Success!']")).isDisplayed();
		if (successWind == true) {
			Assert.assertTrue(true);
			logger.info("Content creation 'Success' windows is displayed");
		} else {
			logger.info("Content creation 'Success' windows is not displayed");
			captureScreen(driver, "ContCreatSuccess_TC003");
			Assert.assertTrue(false);
		}
		Thread.sleep(2000);
		// Finish Button- ui-id-94
		if (driver.findElement(By.xpath("//span[text()='Finish' and @class='oj-button-text']")).isEnabled()) {
		driver.findElement(By.xpath("//span[text()='Finish'and @class='oj-button-text']")).click();
			logger.info("Clicked on Finish Button to complete the Content creation process");
		}


	//validating content title after creation
		
		/*		
		if (driver.findElement(By.tagName("h1")).isDisplayed()){
				
			//driver.findElement(By.tagName("h1")).getText().equals(anObject)
				driver.findElement(By.tagName("h1")).getText();
		logger.info("title 2");
		}
		*/
		if(driver.findElement(By.xpath("//*[@id='Identification' and @id='Content' and @id='Status Date']")).isDisplayed())
		{
			logger.info("title 3-Identification, Content and Status Date ");
		}
		else if (driver.findElement(By.tagName("h1")).isDisplayed()){
			
			//driver.findElement(By.tagName("h1")).getText().equals(anObject)
				driver.findElement(By.tagName("h1")).getText();
		logger.info("title 2");
		}
		else 
		{
		
		driver.findElement(By.xpath("//div[@class='oj-flex-bar-middle oj-sm-flex-direction-column oj-helper-clearfix']/h1")).isDisplayed();
	
			logger.info("title 1");
		}
	}

}
