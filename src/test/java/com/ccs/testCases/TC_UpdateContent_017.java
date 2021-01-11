package com.ccs.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.ccs.pageObjects.CCSPageObjects;
import com.ccs.pageObjects.ContentPage;
import com.ccs.pageObjects.LoginPage;
import com.ccs.utilities.XLUtils;

public class TC_UpdateContent_017 extends BaseClass{
	@Test(dataProvider = "ContData")

	public void ReadContentDDT(String uname, String pwd, String bconName, String bconLName, String bconDesc,
			String conVname, String contDesc, String activeDate, String cKEditData) throws InterruptedException, IOException

	{
		// calling SignIn method
		driver.get(baseURL);
		Thread.sleep(3000);
		logger.info("URL is opened: " + baseURL);
		
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
		
		//enter username
		lp.setUserName(uname);
		logger.info("Entered username: " + uname);

		//enter password
		lp.setPassword(pwd);
		logger.info("Entered password");

		//click on Sign In button
		lp.clickSignin();
		logger.info("Clicked on Sign In");
		Thread.sleep(45000);

		// validation window name
		lp.loginSuccess();
		logger.info("Login test passed and Logged in as a: " + uname);
		
		// Calling MapConfig Id function
		TC_MapConfigID_013 mapConfigId = new TC_MapConfigID_013();
		mapConfigId.mapConfigID();
		
		// Calling Class- Go to Content Landing page
		ContentLandingPage ContLandingPage = new ContentLandingPage();
		ContLandingPage.ContLandingPage();
	
		//search filed		
		if (cob.searchField().isDisplayed())
		{
			cob.searchField().click();
			cob.searchField().sendKeys(bconName);
			logger.info("Clicked on 'Search Text' Field and entered Content name: "+ bconName);
			Thread.sleep(3000);
		}
		
		//click on Search	
		if(cob.searchIcon().isDisplayed())
		{
			cob.searchIcon().click();
			logger.info("Clicked on 'Search' icon");
		}
		
		Thread.sleep(25000);
		//verify the search results
		//String searchresult = driver.findElement(By.xpath("//span[contains(@class,'list-text')]")).getText();
		String searchresult = cob.searchResult().getText();
				if (searchresult.contains(bconName))
			{
			logger.info("searched content is: "+searchresult);
			Thread.sleep(3000);
			}else {
				logger.info("searched content is not:"+searchresult);
				Thread.sleep(3000);
			}
				
			// Click on expand button
			cob.expandBtn().isDisplayed();
			cob.expandBtn().click();
			logger.info("clicked on Expand/Treeview-icon(+) button ");	
			
			Thread.sleep(20000);
           //content version list			
			//String contversion = driver.findElement(By.xpath("//span[contains(@class,'list-text')]")).getText();
			String contversion = cob.versionsList().getText();
			if (contversion.contains(conVname))
			{
			logger.info("searched content is: "+conVname);
			Thread.sleep(3000);
			}else {
				driver.findElement(By.xpath("//*[contains(@class,'treeview-item-content')]")).isDisplayed();
					logger.info("treeview-item-content is displayed");
			}
			
			//kebab/ellipsis menu		
			if (cob.kebabMenu().isDisplayed())
			{
				cob.kebabMenu().click();
				logger.info("Clicked on kebab menu ");
				Thread.sleep(3000);
			}
			
			//Select Create New Version option	
			if(cob.createNewVer().isDisplayed())
			{
				cob.createNewVer().click();
				logger.info("Clicked on Create New Verersion");
				Thread.sleep(3000);
			}
		
			Thread.sleep(60000);
			
			//String NewVersionName2 = driver.findElement(By.xpath("//*[contains(@class,'treeview-item-content')]")).getText();
			String NewVersionName = driver.findElements(By.xpath("//*[contains(@class,'treeview-item-content')]")).get(1).getText();
			logger.info("New Version name is: " + NewVersionName);
			
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
	// data read from excel
	@DataProvider(name = "ContData")
	String[][] getData() throws IOException {
		String path = System.getProperty("user.dir") + "/src/test/java/com/ccs/testData/LoginData.xlsx";

		// read the data from xlsx //get row count
		int rownum = XLUtils.getRowCount(path, "ContentData");// path- xl location path and sheet1 - sheet name //get
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
