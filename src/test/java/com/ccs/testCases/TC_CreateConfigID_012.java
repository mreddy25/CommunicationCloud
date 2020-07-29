package com.ccs.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ccs.pageObjects.ContentPage;
import com.ccs.pageObjects.LoginPage;
import com.ccs.utilities.XLUtils;

public class TC_CreateConfigID_012 extends BaseClass {
	@Test(dataProvider = "ContData")

	public void ConIDCreate(String uname, String pwd, String bconName, String bconLName, String bconDesc,
			String conVname, String contDesc, String activeDate, String cKEditData)
			throws InterruptedException, IOException

	{
		// calling SignIn method
		driver.get(baseURL);
		Thread.sleep(3000);
		logger.info("URL is opened: " + baseURL);
		// here LoginPage- pageObject class

		LoginPage lp = new LoginPage(driver);

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
		Thread.sleep(195000);

		// validation
		boolean Logintitle = driver.getPageSource().contains("Dashboard");
		if (Logintitle == true)

		{
			Assert.assertTrue(true);
			logger.info("Login test passed and Logged in as a: " + uname);
			Thread.sleep(5000);
		} else {
			// call the capture screen method which is declared in base class
			captureScreen(driver, "loginTest_TC011");
			Assert.assertTrue(false);
			logger.info("Login test filed");

		}

		Thread.sleep(5000);
		if (driver.findElement(By.xpath("//span[@class='config-id-section']")).isEnabled()) {
			driver.findElement(By.xpath("//span[@class='config-id-section']")).click();
			logger.info("Clicked on Config Id");
			Thread.sleep(3000);
		}else {
			captureScreen(driver, "ConfigIdDialog_TC012");
			Assert.assertTrue(false);
			logger.info("Config dialog is not displayed");
		}

		
		Thread.sleep(7000);

	//validaing dialog
	/*
		WebElement LL = driver.findElement(By.linkText("You don't have an active Config ID"));
		if(LL.isDisplayed())
		{
			logger.info("Dialog should be haning the text as 2");
			Thread.sleep(3000);
		}else if(driver.findElement(By.xpath("//*[starts-with(@id,'infoDialogGenericWizardInfoDialog')]")).isDisplayed())
		{
			logger.info("Dialog should be haning the text as 3");
			Thread.sleep(3000);
		}else if (driver.findElement(By.xpath("//i[@class='demo-icon icon-attention-circled m-all-0']")).isDisplayed())
		{
			logger.info("Dialog should be haning the text as 4");
			Thread.sleep(3000);
		}else if(driver.findElement(By.tagName("h2")).isDisplayed())
		{
			
			logger.info("Dialog should be haning the text as 5");
			Thread.sleep(3000);
			
		}else {
			
			driver.findElements(By.tagName("oj-dialog")).contains(LL);
			//driver.findElements(By.tagName("oj-dialog")).contains("You don't have an active Config ID")
			logger.info("Dialog should be haning the text as 6");
			
		}
*/
		if (driver.findElement(By.xpath("//Div[text()='Yes']")).isDisplayed()) {
			driver.findElement(By.xpath("//Div[text()='Yes']")).click();
			logger.info("Clicked on 'Yes' in Dialog Box");
			Thread.sleep(8000);

		}else
		{
			driver.findElement(By.className("oj-flex-item oj-sm-6 text-center")).click();
			logger.info("Clicked  2on 'Yes' in Dialog Box");
		}

		//select radio button
		if(driver.findElement(By.id("Existing|rb")).isEnabled())
		{
			driver.findElement(By.id("Existing|rb")).click();
			logger.info("Existing\rb bution is enabled and selected");
		}
		
		//continue
		
		if (driver.findElement(By.xpath("//span[text()='Continue']")).isDisplayed()) {
			driver.findElement(By.xpath("//span[text()='Continue']")).click();
			logger.info("Clicked on 'continue' in Dialog Box");
			Thread.sleep(8000);
		}
		
		if (driver.findElement(By.xpath("//input[text()='Search Text']")).isDisplayed()) {
			driver.findElement(By.xpath("//span[text()='Search Text']")).sendKeys("Blitz1");
			logger.info("Clicked on 'Search Text' in Dialog Box");
			Thread.sleep(8000);
		}
		
		if (driver.findElement(By.xpath("//*[contains(@title, 'Magnifier\r\n" + 
				"      ')]")).isDisplayed())
		{
			driver.findElement(By.xpath("//*[contains(@title, 'Magnifier\r\n" + 
					"      ')]")).click();
			logger.info("Clicked on 'magnifier' icon");
			Thread.sleep(8000);
		}

		
	}
	@AfterClass
	public void tearDown()
	{
		driver.quit();
		
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
