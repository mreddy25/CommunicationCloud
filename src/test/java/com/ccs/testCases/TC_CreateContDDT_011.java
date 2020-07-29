package com.ccs.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ccs.pageObjects.ContentPage;
import com.ccs.pageObjects.LoginPage;
import com.ccs.utilities.XLUtils;

public class TC_CreateContDDT_011 extends BaseClass
{

	@Test(dataProvider="ContData")
	
	public void ContCreateDDT(String uname, String pwd, String bconName, String bconLName, String bconDesc, String conVname, String contDesc, String activeDate, String cKEditData) throws InterruptedException, IOException
	
	{
		// calling SignIn method
		driver.get(baseURL);
		Thread.sleep(3000);
		logger.info("URL is opened: "+baseURL);
		//here LoginPage- pageObject class
		
		LoginPage lp = new LoginPage(driver);
		ContentPage cp = new ContentPage(driver);
		Thread.sleep(3000);
		
		//details page-
		lp.clkkdetailBtn();
		lp.clkproceedLink();
		
		lp.setUserName(uname);
		logger.info("Entered username: "+uname);
		
		lp.setPassword(pwd);
		logger.info("Entered password");
		
		lp.clickSignin();
		logger.info("Clicked on Sign In");
		Thread.sleep(45000);
		
		//validation
		boolean Logintitle=driver.getPageSource().contains("Dashboard"); 
		if(Logintitle==true) 
					 
		 { 
			 Assert.assertTrue(true);
			 logger.info("Login test passed and Logged in as a: "+uname);
		 }
		 else 
		 {
			 //call the capture screen method which is declared in base class
			 captureScreen(driver,"loginTest_TC011");
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
			captureScreen(driver, "documentContentLandingPage_TC010");
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
			captureScreen(driver, "SearchResults_TC011");
			Assert.assertTrue(false);
		}

		cp.CreateBtn();
		logger.info("Clicked on 'Plus(+) icon button to create new Content");
		Thread.sleep(5000);

		// driver.getTitle().equals("Creating New Content");
		/*	
		String expected_txt = "Creating New Content";
		WebElement header_txt_1 = driver.findElement(By.xpath("//span[text()='Creating']"));
		WebElement header_txt_2 = driver.findElement(By.xpath("//span[text()='New']"));
		WebElement header_txt_3 = driver.findElement(By.xpath("//span[text()='Content']"));
		String actual_txt1=header_txt_1.getText();
		String actual_txt2=header_txt_2.getText();
		String actual_txt3=header_txt_3.getText();
		
		String actual_txt=actual_txt1+actual_txt2+actual_txt3;
		Assert.assertEquals(actual_txt, expected_txt);
		
		if (expected_txt == actual_txt)
		{
			logger.info("title is:"+actual_txt);
		}
		*/
		boolean res1 = driver.findElement(By.xpath("//span[text()='Creating']")) != null;
		 if (res1 == true) {
			Assert.assertTrue(true);
			logger.info("You are at Create new content window");

		} else {
			logger.info("You are not at Create new content window");
			captureScreen(driver, "CreateNewContent_TC011");
			Assert.assertTrue(false);
		}

		Thread.sleep(3000);
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
			captureScreen(driver, "ContentAddIdentWindow_TC011");
			Assert.assertTrue(false);
		}
		
		cp.baseContName(bconName);
		logger.info("Entered Content name ");
		Thread.sleep(3000);

		cp.baseContLongName(bconLName);
		logger.info("Entered Content  long name");
		Thread.sleep(3000);

		cp.baseContDesc(bconDesc);
		logger.info("Entered Content description");
		Thread.sleep(3000);

		cp.continueBaseBtn();
		logger.info("Clicked on continue button in '2/4 Add Identification' window");
		Thread.sleep(5000);

		driver.getTitle().equals("Create Content Version");
		logger.info("You are at 'Create Content Version' window");
		Thread.sleep(3000);

		driver.findElement(By.xpath(
				"//*[@class='oj-inputtext-input oj-text-field-input oj-component-initnode' and @id='textinput|input']"))
				.sendKeys(conVname);
		logger.info("Entered Contant Version Name");
		Thread.sleep(3000);

		driver.findElement(By.xpath(
				"//*[@class='oj-textarea-input oj-text-field-input oj-component-initnode' and @id='textArea|input']"))
				.sendKeys(contDesc);
		logger.info("Entered Contant Description");
		Thread.sleep(3000);

		driver.findElement(By.xpath(
				"//*[@class='oj-inputdatetime-input oj-text-field-input oj-component-initnode' and @id='fromDate|input']"))
				.sendKeys(activeDate);
		logger.info("Entered Active Date");
		Thread.sleep(5000);

		driver.findElement(By.xpath("//span[text()='Continue']")).click();
		logger.info("clicked continue in contenet version window to create base content ");

		Thread.sleep(20000);

		boolean cke = driver.findElement(By.xpath("//span[text()='Editor toolbars']")) != null;
		if (cke == true) {
			Assert.assertTrue(true);
			logger.info("Editor tool bar is displayed");
		} else {
			logger.info("Editor tool bar is not displayed");
			captureScreen(driver, "EditorToolBar_TC011");
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

		ckeditor.sendKeys("Dear Customer,");
		logger.info("Entered content details in 'CKEditor'");
		Thread.sleep(3000);
		
		ckeditor.sendKeys(Keys.ENTER);
		logger.info("pressed ENTER button in key board");
		Thread.sleep(2000);
		
		ckeditor.sendKeys(cKEditData);
		logger.info("Entered content details in 'CKEditor'");
		Thread.sleep(3000);
			
		//Click Continue
		if(driver.findElement(By.xpath("//span[text()='Continue' and @class='oj-button-text']")).isDisplayed()) {
			driver.findElement(By.xpath("//span[text()='Continue' and @class='oj-button-text']")).click();
		logger.info(" Clicked on Continue after entering the content details in CKEditor");
		}

		Thread.sleep(20000);

		// Content Creation status window
		boolean successWind = driver.findElement(By.xpath("//span[text()='Success!']")).isDisplayed();
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
		if (driver.findElement(By.xpath("//span[text()='Finish' and @class='oj-button-text']")).isEnabled()) {
		driver.findElement(By.xpath("//span[text()='Finish'and @class='oj-button-text']")).click();
			logger.info("Clicked on Finish Button to complete the Content creation process");
		}

	//validating content title after creation
		
		Thread.sleep(30000);

		Boolean contTitle =driver.findElement(By.tagName("h1")).isDisplayed();
		if (contTitle == true) {
			Assert.assertTrue(true);
			logger.info("Content is created with the name of :"+conVname);
		} else {
			logger.info("Content is not created with the name of :"+conVname);
			captureScreen(driver, "ContCreatSuccess_TC011");
			Assert.assertTrue(false);
		}
	
		/*
		driver.findElement(By.id("drawerToggleButton")).click();
		Thread.sleep(3000);
		lp.clickSignoff();
		logger.info("User is Sign off");
		*/
		
		if (driver.findElement(
				By.xpath("//span[text()='Application Navigation' and @class='demo-icon icon-ham-menu m-all-0 oj-button-icon oj-start']")).isDisplayed())
				{
				driver.findElement(
				By.xpath("//span[text()='Application Navigation' and @class='demo-icon icon-ham-menu m-all-0 oj-button-icon oj-start']")).click();
				logger.info("Application Navigation button is clicked");
				} else if (driver.findElement(By.id("drawerToggleButton")).isDisplayed()){
					driver.findElement(By.id("drawerToggleButton")).click();
					logger.info("toggle button is clicked");
					
					Thread.sleep(5000);
				}
					else if(driver.findElement(By.id("signoff")).isDisplayed()) {
						driver.findElement(By.id("signoff")).click();
						logger.info("signoff button is clicked");
						
					}else {
						driver.findElement(By.id("drawerToggleButton")).click();
						Thread.sleep(3000);
						lp.clickSignoff();
						logger.info("User is Sign off");
					}
				
		if (driver.findElement(By.id("signoff")).isDisplayed()) {
			driver.findElement(By.id("signoff")).click();
			logger.info("User is Sign off 1");
			Thread.sleep(3000);
		} else {
			driver.findElement(
					By.xpath("//span[text()='Previous' and @class='oj-button-icon oj-start oj-navigationlist-previous-icon oj-component-icon oj-clickable-icon-nocontext']"))
					.click();
			logger.info("click previous Arrow 1");
			Thread.sleep(5000);
		}

		if (driver
				.findElement(
						By.xpath("//span[text()='Previous' and @class='oj-button-text oj-helper-hidden-accessible']"))
				.isDisplayed()) {
			driver.findElement(
					By.xpath("//span[text()='Previous' and @class='oj-button-text oj-helper-hidden-accessible']"))
					.click();
			logger.info("click previous Arrow 2");
			Thread.sleep(5000);
		} else {
			lp.clickSignoff();
			logger.info("User is Sign off  after clickin previous arrow 1");
			Thread.sleep(5000);

		}

		lp.clickSignoff();
		logger.info("User is Sign off last");
		Thread.sleep(5000);
		
		
	}
	
	
	  @DataProvider(name="ContData") String [][] getData() throws IOException {
	  String path=System.getProperty("user.dir")+"/src/test/java/com/ccs/testData/LoginData.xlsx";
	  
	  //read the data from xlsx //get row count
	  int rownum=XLUtils.getRowCount(path, "ContentData");//path- xl location path and 	  sheet1 - sheet name //get cell count 
	  int colcount=XLUtils.getCellCount(path, "ContentData", 1); //here 1- row number
	  
	  String contentdata[][]=new String[rownum][colcount];
	  
	  for(int i=1;i<=rownum;i++)//outer for loop for row 
		  { 
		  	for(int j=0;j<colcount;j++)//inner for loop for column
		  		{
		  		contentdata[i-1][j]=XLUtils.getCellData(path, "ContentData", i, j);
		  		} 
		  	}
	  
	  return contentdata;
	  } 

}
