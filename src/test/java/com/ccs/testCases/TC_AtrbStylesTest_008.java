package com.ccs.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ccs.pageObjects.ContentPage;
import com.ccs.pageObjects.LayoutPage;
import com.ccs.pageObjects.LoginPage;
import com.ccs.utilities.XLUtils;

public class TC_AtrbStylesTest_008 extends BaseClass
{

	@Test(dataProvider="StylesData")
	public void atrbStylesTest(String uname, String pwd, String sName, String styleName, String styleLName, String styleDesc) throws InterruptedException, IOException
		{
		
		//calling SignIn method
		//TC_LoginTest_001 signIn = new TC_LoginTest_001();
		//signIn.signInTest();

		
		//Get URL
		driver.get(baseURL);
		logger.info("URL is opened: "+baseURL);
		
		//here LoginPage- pageObject class
		LoginPage lp = new LoginPage(driver);
		ContentPage cp = new ContentPage(driver);
		Thread.sleep(3000);
		
		//details page-
		lp.clkkdetailBtn();
		lp.clkproceedLink();
		
		lp.setUserName(uname);
		logger.info("Entered username: " +uname);

		lp.setPassword(pwd);
		logger.info("Entered password");
		Thread.sleep(3000);

		lp.clickSignin();
		logger.info("Clicked on Sign In");

				
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
			 captureScreen(driver,"loginTest_TC006");
			 Assert.assertTrue(false);
			 logger.info("Login test filed");
		 
		 }

	
		lp.cliktogbtn();
		logger.info("Clicked on Toggle button");
		Thread.sleep(3000);
		
		lp.clikconfiglnk();
		logger.info("Selected Congiuration link");
		
		lp.clikcommlnk();
		logger.info("Selected Configuration->Communication");
		
		lp.clikAtrbConflnk();
		logger.info("Selected Configuration->Communication->Attributes link");
		Thread.sleep(3000);
		
		lp.clikAtrbStyleConflnk();
		logger.info("Selected Configuration->Communication->Attributes->Styles link");
		Thread.sleep(20000);
		 
		//validating Title
		boolean res=driver.getPageSource().contains("Document Styles"); 
		if(res==true) 
		{
			Assert.assertTrue(true);
			logger.info("You are at Document Styles Landing page....");
		  
		}
		else 
		{ 
			logger.info("You are not at Document Styles Landing page....");
			captureScreen(driver,"documentStylesLandingPage_TC008"); 
			Assert.assertTrue(false);
		  }	 

		Thread.sleep(3000);
		cp.txtInputSearch(sName);
		logger.info("Entered Style name in Search text box"+sName);
		Thread.sleep(3000);

		
		cp.ViewAllBtn();
		logger.info("Clicked on 'View All Styles' to search the selected Style");
		Thread.sleep(5000);
		
		
		// click create button
		cp.CreateBtn();
		logger.info("Clicked on 'Plus(+) icon button to create new Layout");
		Thread.sleep(5000);		
		
		//validating window name
		boolean res1 = driver.findElement(By.xpath("//span[text()='Creating']")) != null;
		if (driver.getPageSource().contains("Creating New Layout")) {
			logger.info("Creating New Layout window");
		} else if (driver.getTitle().equals("Creating New Style"))
		{
			logger.info("equals- Creating New Style window");
		}else if (driver.getTitle().equals("Creating Style"))
		{
			logger.info("equals- Creating Style");
		}
		
		else if (res1 == true) {
			Assert.assertTrue(true);
			logger.info("You are at Create new Style window");

		} else {
			logger.info("You are not at Create new Style window");
			captureScreen(driver, "CreateNewStyle_TC006");
			Assert.assertTrue(false);
		}

			
		// provide layout details details
		
				
		if (driver.findElement(By.xpath("//*[@class='oj-inputtext-input oj-text-field-input oj-component-initnode' or @id='textinput_ojcustomelem70|input']")).isEnabled())
		
			{
			driver.findElement(By.xpath("//*[@class='oj-inputtext-input oj-text-field-input oj-component-initnode' or @id='textinput_ojcustomelem70|input']")).sendKeys(styleName);
			logger.info("Entered Layout Name 1: "+styleName);
			}else {
		cp.baseContName(styleName);
		logger.info("Entered Layout Name: "+styleName);
		Thread.sleep(3000);
			}
		
		//enter  Layout long name 
		if (driver.findElement(By.xpath("//*[@class='oj-textarea-input oj-text-field-input oj-component-initnode' or @id='textArea_ojcustomelem71|input']")).isEnabled())
		
		{
			driver.findElement(By.xpath("//*[@class='oj-textarea-input oj-text-field-input oj-component-initnode' or @id='textArea_ojcustomelem71|input']")).sendKeys(styleLName);
			logger.info("Entered Layout Long Name Name 1: "+styleLName);
		}else if(driver.findElement(By.xpath("//*[@class='oj-textarea-input oj-text-field-input oj-component-initnode' or @maxlength='4000']")).isEnabled())
		{
			driver.findElement(By.xpath("//*[@class='oj-textarea-input oj-text-field-input oj-component-initnode' or @maxlength='4000']")).sendKeys(styleLName);
			logger.info("Entered Layout Long Name Name : "+styleLName);
			
		}else {
			cp.baseContLongName(styleLName);
			logger.info(" unable to entered Layout  long name:"+styleLName);
			Thread.sleep(3000);
		}

		//enter Layout Description	
		
		if (driver.findElements(By.tagName("textarea")).get(1).isEnabled())
		{
			driver.findElements(By.tagName("textarea")).get(1).sendKeys(styleDesc);
			logger.info("Entered Layout Description as : "+styleDesc);
		}

		else if (driver.findElement(By.xpath("//input[text()='Description']")).isEnabled())
		{
			driver.findElement(By.xpath("//input[text()='Description']")).sendKeys(styleDesc);
			
			logger.info("Entered Layout Description : "+styleDesc);

		}else {
			
			driver.findElement(By.xpath("//textarea[text()='Description']")).sendKeys("muni");
		
			logger.info("Entered Layout Description : ");
		}


	}

	
	//Read Data from excel
	
	  @DataProvider(name="StylesData") String [][] getData() throws IOException {
	  String path=System.getProperty("user.dir")+"/src/test/java/com/ccs/testData/LoginData.xlsx";
	  
	  //read the data from xlsx //get row count
	  int rownum=XLUtils.getRowCount(path, "StyleData");//path- xl location path and 	  sheet1 - sheet name //get cell count 
	  int colcount=XLUtils.getCellCount(path, "StyleData", 2); //here 1- row number
	  
	  String stylesdata[][]=new String[rownum][colcount];
	  
	  for(int i=2;i<=rownum;i++)//outer for loop for row 
		  { 
		  	for(int j=0;j<colcount;j++)//inner for loop for column
		  		{
		  		stylesdata[i-2][j]=XLUtils.getCellData(path, "StyleData", i, j);
		  		} 
		  	}
	  
	  return stylesdata;
	  } 
	
	
}
