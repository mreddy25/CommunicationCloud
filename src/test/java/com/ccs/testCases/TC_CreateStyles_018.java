package com.ccs.testCases;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ccs.pageObjects.CCSPageObjects;
import com.ccs.pageObjects.ContentPage;
import com.ccs.pageObjects.LayoutPage;
import com.ccs.pageObjects.LoginPage;
import com.ccs.pageObjects.StylesPage;
import com.ccs.utilities.XLUtils;

public class TC_CreateStyles_018 extends BaseClass
{
	String timeStamp = new SimpleDateFormat("yy.MM.dd.HH.mm.ss").format(new Date());
	@Test(dataProvider="StylesData")
	public void atrbStylesTest(String uname, String pwd, String sName, String styleName, String styleLName, String styleDesc, String attrbType, String AttrbName) throws InterruptedException, IOException
		{
		
		//calling SignIn method
		//TC_LoginTest_001 signIn = new TC_LoginTest_001();
		//signIn.signInTest();

		
		// calling SignIn method
		driver.get(baseURL);
		Thread.sleep(3000);
		logger.info("URL is opened: " + baseURL);
		Thread.sleep(3000);

		// here LoginPage- pageObject class
		LoginPage lp = new LoginPage(driver);
		ContentPage cp = new ContentPage(driver);
		StylesPage sp = new StylesPage(driver);
		CCSPageObjects cob = new CCSPageObjects(driver);		

		// if details button is exists then click otherwise skip
		lp.detailBtn().click();
		logger.info("Clicked on 'details-button'");
		Thread.sleep(2000);

		// if Proceed link is exists then click otherwise skip
		lp.proceedLnk().click();
		logger.info("Clicked on 'proceed-link'");
		Thread.sleep(5000);

		//enter username
		lp.setUserName(uname);
		logger.info("Entered username: " +uname);
		
		//enter Password
		lp.setPassword(pwd);
		logger.info("Entered password");
		Thread.sleep(3000);
		
		//click on sign-in
		lp.clickSignin();
		logger.info("Clicked on Sign In");
				
		//validation Login windows Name
		if(lp.loginSuccess().isDisplayed())
		{
			logger.info("Login test passed and Logged in as a: " + uname);	
		}else{
				 //call the capture screen method which is declared in base class
				 captureScreen(driver,"loginTest_TC0018");
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
		
		//Click on Create Button
		cob.createBtn().click();
		logger.info("Clicked on 'Plus(+) icon button to create new Content");
		Thread.sleep(5000);
			

		//validating Window name
		String winName = cp.addIdentificationWind().getText();
		if (cp.addIdentificationWind().isDisplayed()) {
			cp.addIdentificationWind().getText();
			logger.info("Dialog windows name is: "+winName);
			Thread.sleep(5000);
			} else {
			logger.info("You are not at 1/3 Add Identification dialog window");
			captureScreen(driver, "StyletAddIdentWindow_TC018");
			Assert.assertTrue(false);
		}

		//EnterName for Style
		if(cob.baseNameField().isEnabled())
		{
			cob.baseNameField().sendKeys(styleName + timeStamp);
			logger.info("Entered Styles Name as : " + styleName + timeStamp);
			Thread.sleep(3000);
		}
	
		//enter Long Name for Styles
		if(cob.longNameField().isEnabled())
		{
			cob.longNameField().sendKeys(styleLName + timeStamp);
			logger.info("Entered Style Long name as : " + styleLName + timeStamp);
			Thread.sleep(3000);
		}
		
		//Enter Description for Styles		
		if (cob.baseDescriptionField().get(1).isEnabled())
		{
			cob.baseDescriptionField().get(1).sendKeys(styleDesc + timeStamp);
			logger.info("Entered Style Description as : " + styleDesc + timeStamp);
			Thread.sleep(3000);
		}
		
		//Click on continue
		cob.continueBtn().isDisplayed();
		cob.continueBtn().click();
		logger.info("Clicked on continue button");
		Thread.sleep(5000);
		
		//validating window name
		String windowName= sp.wndAddStyle().getText();
		logger.info("Window name is: "+windowName);
		
		//click on add button
		cob.addAttrbBtn().click();
		logger.info("Clicked on add Attribute button");
		Thread.sleep(15000);
		
		//validating window name
/*		WebElement windName2 = cob.wndAttribute1();
 if (cob.wndAttribute1().isDisplayed())
	{
		logger.info("Window name is: "+windName2);
	}else {
		
			logger.info("Window name is not: "+windName2);
			captureScreen(driver, "StyletAttributeWindow_TC018");
			Assert.assertTrue(false);
	}
 */
	String windName2 = cob.wndAttribute1().getText();
	if (cob.wndAttribute1().isDisplayed()) {
		cob.wndAttribute1().getText();
		logger.info("Dialog windows name is: "+windName2);
		Thread.sleep(5000);
		} else {
		logger.info("Dialog windows name is not: "+windName2);
		captureScreen(driver, "StyletAddAttributeWindow_TC018");
		Assert.assertTrue(false);
	}
  
	
	sp.fontFamilyRbBtn().click();
	logger.info("Font-Family radio button is selected");
	//Thread.sleep(20000);
 
 	//select Style attribute- Font-Family
/* 	if (sp.fontFamilyRbBtn().isDisplayed())
 	{
 		sp.fontFamilyRbBtn().click();
 		logger.info("Font-Family radio button is selected");
 	}
 */
 	Thread.sleep(39000);
 	//click on Done
 	if(cob.doneBtn().isDisplayed())
 	{
 		cob.doneBtn().click();
 		logger.info("Clicked on 'Done' button");
 		Thread.sleep(20000);
 	}else {
 		cob.doneBtn2().click();
 		logger.info("Clicked on 'Done' button-2");
 		Thread.sleep(20000);
 	}
 	
 	//select the Calibri font button 	
		sp.fontCalibriRbBtn().click();
		logger.info("Font-Calibri radio button is selected");
		Thread.sleep(5000);
	
 	//click on Done button
		//driver.findElement(By.xpath("//oj-button[@id='Done']")).click();
 		cob.doneBtn2().click();
 		logger.info("Clicked on 'Done' button");
/* 	if (cob.doneBtn().isDisplayed())
 	{
 		cob.doneBtn().click();
 		logger.info("Clicked on 'Done' button");
 	}else {
 		driver.findElement(By.id("Done")).click();
 		logger.info("Clicked on 'Done' button-2");
 	}
 */
 	//String addedAtrbName = driver.findElement(By.className("oj-flex")).getText();
 	//String addedAtrbName = driver.findElement(By.xpath("//span[@class='sunrise-yellow set-value']")).getText();
 	String addedAtrbName = cob.addedAtrbName().getText();
 	logger.info("Added attribute is:"+addedAtrbName);
 	Thread.sleep(1000);
 
	//Click on continue
	//cob.continueBtn().isDisplayed();
  	
	cob.continueBtn2().click();
	logger.info("Clicked on continue button");
	Thread.sleep(19000);
		
	//success message Window
	String status=cob.wndSuccessMsg().getText();
	logger.info("Style creation is: "+status);

	
	//click on finish button
	cob.finishBtn().click();
	logger.info("Clicked on Finish button");
	Thread.sleep(25000);
	
	//assets title
	Boolean contTitle = cob.assetTitle().isDisplayed();
	if (contTitle == true) {
		logger.info("Style is created with the name of: " + styleName);
	} else {
		logger.info("Style is not created with the name of :" + styleName);
		captureScreen(driver, "StyleDetails_TC011");
		Assert.assertTrue(false);
	}
	
	//Sign off the application
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
