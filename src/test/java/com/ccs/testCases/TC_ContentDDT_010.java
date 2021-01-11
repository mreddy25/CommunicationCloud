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

public class TC_ContentDDT_010 extends BaseClass{
	
	/*
	@Test
	public void SignIn() throws InterruptedException, IOException  {
		// calling SignIn method
		TC_LoginTest_001 signIn = new TC_LoginTest_001();
		signIn.signInTest();
	}
*/

	@Test(dataProvider="LoginData")
	
	public void ContCreateDDT(String bconName, String bconLName, String bconDesc, String conVname, String contDesc, String activeDate, String cKEditData) throws InterruptedException, IOException
	
	{
		// calling SignIn method
		TC_LoginTest_001 signIn = new TC_LoginTest_001();
		signIn.signInTest();
		
		//MapConfig Id
		TC_MapConfigID_013 mapConfigId = new TC_MapConfigID_013();
		mapConfigId.mapConfigID();
		
		LoginPage lp = new LoginPage(driver);
		ContentPage cp = new ContentPage(driver);
		Thread.sleep(3000);
		
		
		lp.cliktogbtn();
		logger.info("Clicked on Toggle button");
		Thread.sleep(3000);

		lp.clikconfiglnk();
		logger.info("Selected Congiuration link");

		lp.clikcommlnk();
		logger.info("Selected Configuration->Communication link");

		lp.clikComContConflnk();
		logger.info("Selected Configuration->Communication->Content link");
		Thread.sleep(20000);

		// Validating Title page
		boolean res = driver.getPageSource().contains("Content");
		if (res == true) {
			Assert.assertTrue(true);
			logger.info("You are at Content Landing page....");

		} else {
			logger.info("You are not at Content Landing page....");
			captureScreen(driver, "documentContentLandingPage_TC010");
			Assert.assertTrue(false);
		}
/*
		Thread.sleep(3000);
		cp.txtInputSearch(contsearchinput);
		logger.info("Entered Content name in Search text box");
		Thread.sleep(3000);
*/
/*		if (driver.findElement(By.xpath("//*[starts-with(@id,'SearchBox')]")).isDisplayed())
		{
		
			driver.findElement(By.xpath("//*[starts-with(@id,'SearchBox')]")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[starts-with(@id,'SearchBox')]")).sendKeys(contsearchinput);
			logger.info("Entered Content name in Search text box: "+contsearchinput);
			Thread.sleep(3000);
		}
	*/	
/*		cp.ViewAllBtn();
		logger.info("Clicked on 'View All Contents' to search the selected Content");
		Thread.sleep(5000);
	


		// boolean Results = driver.findElement(By.xpath("//span[text()='Results']")) !=
		// null;
		if (cp.resultstWind() == true) {
			Assert.assertTrue(true);
			logger.info("selected content/s will be listed in results window");
		} else {
			logger.info("selected items are not liseds in results window");
			captureScreen(driver, "CreateResults_TC010");
			Assert.assertTrue(false);
		}
*/	
		cp.CreateBtn();
		logger.info("Clicked on 'Plus(+) icon button to create new Content");
		Thread.sleep(25000);

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
		boolean res1 = driver.findElement(By.xpath("//span[text()='Creating New Content']")) != null;
		 if (res1 == true) {
			Assert.assertTrue(true);
			logger.info("You are at 'Creating New Content' window");

		} else if (driver.findElement(By.xpath("//span[text()='Creating New Content']")).isDisplayed()){
			logger.info("You are at 'Creating New Content' window - 2");
			Thread.sleep(3000);
		} else {
			logger.info("You are not at Create new content window");
			captureScreen(driver, "CreateNewContent_TC010");
			Assert.assertTrue(false);
		}

		Thread.sleep(3000);
		cp.radioBtn().click();
		//cp.radioBtnClk();
		logger.info("Selected Text radio button to create new Content");
		Thread.sleep(3000);
		
		if (driver.findElement(By.xpath("//span[text()='Continue']")).isDisplayed()) {
			driver.findElement(By.xpath("//span[text()='Continue']")).click();
			logger.info("Clicked on 'continue' in Dialog Box");
			Thread.sleep(3000);
		}else {
		cp.continueBtn();
		logger.info("Clicked on continue button 1/4 Choose Content Type");
		Thread.sleep(5000);
		}
		// Create Base Content
		boolean cad = driver.getPageSource().contains("Add Identification");
		// boolean cad = cp.addIdentWind();
		if (cad == true) {
			Assert.assertTrue(true);
			logger.info("You are at 2/4 Add Identification dialog window");
		} else if (driver.findElement(By.xpath("//span[text()='Add Identification']")).isDisplayed()){
			logger.info("You are at 2/4 Add Identification dialog window- 2");
			Thread.sleep(5000);			
		}
		else {
			logger.info("You are not at 2/4 Add Identification dialog window");
			captureScreen(driver, "ContentAddIdentWindow_TC010");
			Assert.assertTrue(false);
		}
		
		cp.baseContName(bconName);
		logger.info("Entered Content name ");
		Thread.sleep(3000);

		cp.baseContLongName(bconLName);
		logger.info("Entered Content  long name");
		Thread.sleep(3000);
		
		if (driver.findElements(By.tagName("textarea")).get(1).isEnabled())
		{
			driver.findElements(By.tagName("textarea")).get(1).sendKeys(bconDesc);
			logger.info("Entered Layout Description as : "+bconDesc);
			//FindElement(By.xpath("//span[contains(@class,'title') and contains(text(),'Administration')]"))
		}else if (driver.findElement(By.xpath("//*[starts-with(@id,'textArea') and @maxlength='4000']")).isDisplayed()) {
			driver.findElement(By.xpath("//*[starts-with(@id,'textArea') and @maxlength='4000']")).sendKeys(bconDesc);
			logger.info("Entered Content  desc 1 name");
			Thread.sleep(3000);
		}else if (driver.findElements(By.tagName("oj-text-area")).get(1).isEnabled())
			{
				//driver.findElements(By.tagName("oj-text-area")).get(1).sendKeys(bconDesc);
				driver.findElements(By.tagName("oj-text-area")).get(1).sendKeys(Keys.chord(Keys.CONTROL, "a"),bconDesc);
			logger.info("Entered Content  desc 2 name:"+bconDesc);
			Thread.sleep(3000);
			}else if (driver.findElements(By.tagName("textarea")).get(1).isEnabled())
			{
				driver.findElements(By.tagName("textarea")).get(1).sendKeys(bconDesc);
				logger.info("Entered Layout Description as : "+bconDesc);
				Thread.sleep(3000);
			}else if (driver.findElement(By.className("text-area oj-textarea oj-form-control oj-component oj-text-field oj-text-field-label-inside oj-has-no-value oj-complete")).isDisplayed()) {
				driver.findElement(By.className("text-area oj-textarea oj-form-control oj-component oj-text-field oj-text-field-label-inside oj-has-no-value oj-complete")).click();
				Thread.sleep(3000);
				driver.findElement(By.className("text-area oj-textarea oj-form-control oj-component oj-text-field oj-text-field-label-inside oj-has-no-value oj-complete")).sendKeys(bconDesc);
				logger.info("Entered Layout Description 123 as : "+bconDesc);
			}
				else 
	
					//else if (driver.findElement(By.xpath("//input[text()='Description']")).isEnabled())
					{
					driver.findElement(By.xpath("//input[text()='Description']")).click();
					Thread.sleep(3000);
						driver.findElement(By.xpath("//input[text()='Description']")).sendKeys(bconDesc);
						
						logger.info("Entered Content Description 111 : "+bconDesc);
		}
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
			captureScreen(driver, "EditorToolBar_TC010");
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
		/*else {
			//driver.findElement(By.xpath("//span[text()='Continue' and @class='oj-button-text']")).click();
			driver.findElement(By.xpath("//span[text()='Continue']")).click();
			logger.info("clicked continue 2");
		}
*/
		Thread.sleep(20000);

		// Content Creation status window
		boolean successWind = driver.findElement(By.xpath("//span[text()='Success!']")).isDisplayed();
		if (successWind == true) {
			Assert.assertTrue(true);
			logger.info("Content creation windows is displayed with 'Success'");
		} else {
			logger.info("Content creation windows is not displayed with 'Success'");
			captureScreen(driver, "ContCreatSuccess_TC010");
			Assert.assertTrue(false);
		}
		Thread.sleep(2000);
		
		// Finish Button-
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
		
		Thread.sleep(30000);

		if (driver.findElement(By.tagName("h1")).isDisplayed()){
			driver.findElement(By.tagName("h1")).getText().equals(conVname);
			//driver.findElement(By.tagName("h1")).getText();
		logger.info("title 2:"+conVname);
		}
		else 
		{
		
		driver.findElement(By.xpath("//div[@class='oj-flex-bar-middle oj-sm-flex-direction-column oj-helper-clearfix']/h1")).isDisplayed();
	
			logger.info("title 1");
		}

		Boolean contTitle =driver.findElement(By.tagName("h1")).isDisplayed();
		if (contTitle == true) {
			Assert.assertTrue(true);
			logger.info("Content is created with the name of :"+conVname);
		} else {
			logger.info("Content creation windows is not displayed with 'Success'");
			captureScreen(driver, "ContCreatSuccess_TC010");
			Assert.assertTrue(false);
		}
		
		
		
	}
	
	
	  @DataProvider(name="LoginData") String [][] getData() throws IOException {
	  String path=System.getProperty("user.dir")+"/src/test/java/com/ccs/testData/LoginData.xlsx";
	  
	  //read the data from xlsx //get row count
	  int rownum=XLUtils.getRowCount(path, "Sheet2");//path- xl location path and 	  sheet1 - sheet name //get cell count 
	  int colcount=XLUtils.getCellCount(path, "Sheet2", 1); //here 1- row number
	  
	  String contentdata[][]=new String[rownum][colcount];
	  
	  for(int i=1;i<=rownum;i++)//outer for loop for row 
		  { 
		  	for(int j=0;j<colcount;j++)//inner for loop for column
		  		{
		  		contentdata[i-1][j]=XLUtils.getCellData(path, "Sheet2", i, j);
		  		} 
		  	}
	  
	  return contentdata;
	  } 
		

}