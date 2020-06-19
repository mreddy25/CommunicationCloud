package com.ccs.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ccs.pageObjects.LoginPage;
import com.ccs.utilities.ReadExcelFile;
import com.ccs.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass
{
	@Test(dataProvider="LoginData")
	public void LoginDDT(String user, String pwd) throws InterruptedException, IOException
	{
		logger.info("URL is opened");
		//here LoginPage- pageObject class
		LoginPage lp = new LoginPage(driver);
		Thread.sleep(3000);
		
		//details page-
		driver.findElement(By.id("details-button")).click();
		driver.findElement(By.id("proceed-link")).click();
		
		lp.setUserName(user);
		logger.info("Entered username");
		
		lp.setPassword(pwd);
		logger.info("Entered password");
		
		lp.clickSignin();
		logger.info("Click on Sign In");
		Thread.sleep(45000);
		
		//validation
		if(driver.findElement(By.id("drawerToggleButton")) != null)		 
		 { 
			 Assert.assertTrue(true);
			 logger.info("Login test passed");
		 }
		 else 
		 {
			 //call the capture screen method which is declared in base class
			 captureScreen(driver,"loginTest");
			 Assert.assertTrue(false);
			 logger.info("Login test filed");
		 
		 }
		
		driver.findElement(By.id("drawerToggleButton")).click();
		Thread.sleep(3000);
		lp.clickSignoff();
		logger.info("User is Sign off");
		 
	}
	/*
	 * @AfterMethod
	 * 
	 * void LaunchBrowser() { driver.get(baseURL); }
	 */
		/*
	 * @AfterMethod void ProgramTermination() { driver.quit(); }
	 */
	  
	  @DataProvider(name="LoginData") String [][] getData() throws IOException {
	  String path=System.getProperty("user.dir")+"/src/test/java/com/ccs/testData/LoginData.xlsx";
	  
	  //read the data from xlsx //get row count
	  int rownum=XLUtils.getRowCount(path, "Sheet1");//path- xl location path and 	  sheet1 - sheet name //get cell count 
	  int colcount=XLUtils.getCellCount(path, "Sheet1", 1); //here 1- row number
	  
	  String logindata[][]=new String[rownum][colcount];
	  
	  for(int i=1;i<=rownum;i++)//outer for loop for row 
		  { 
		  	for(int j=0;j<colcount;j++)//inner for loop for column
		  		{
		  		logindata[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);
		  		} 
		  	}
	  
	  return logindata;
	  } 
}
	
	
