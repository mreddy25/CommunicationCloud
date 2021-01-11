package com.ccs.testCases;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ccs.pageObjects.CCSPageObjects;
import com.ccs.pageObjects.ContentPage;
import com.ccs.pageObjects.LoginPage;
import com.ccs.utilities.XLUtils;

public class TC_DeleteContent_016 extends BaseClass{

	@Test(dataProvider = "ContData")

	public void DeleteContDDT(String uname, String pwd, String bconName, String bconLName, String bconDesc,
			String conVname, String contDesc, String activeDate, String cKEditData)
			throws InterruptedException, IOException

	{
		// Open the browser with URL
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
		lp.loginSuccess();
		logger.info("Login test passed and Logged in as a: " + uname);

		// Calling MapConfig Id function
		TC_MapConfigID_013 mapConfigId = new TC_MapConfigID_013();
		mapConfigId.mapConfigID();

		// Calling Class- Go to Content Landing page
		ContentLandingPage ContLandingPage = new ContentLandingPage();
		ContLandingPage.ContLandingPage();
		
		//enter text in search field
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
		
		//kebab/ellipsis menu		
		if (cob.kebabMenu().isDisplayed())
		{
			cob.kebabMenu().click();
			logger.info("Clicked on kebab menu ");
			Thread.sleep(3000);
		}

		//select delete options
		if (cob.deleteOption().isDisplayed())
		{
			cob.deleteOption().click();
			logger.info("Clicked on Delete option ");
			Thread.sleep(3000);
		}		

		//Click on 'yes' in warning window
		if (cob.YesToConfirm().isDisplayed()) {
			cob.YesToConfirm().click();
			logger.info("Clicked on 'Yes' Button to confirm the deletion of Content");
		}
		
		Thread.sleep(20000);
		//Click on'Ok' in warning window
		if (cob.OkToConfirm().isDisplayed()) {
			cob.OkToConfirm().click();
			logger.info("Clicked on 'Ok' Button to complete the delete process");
			Thread.sleep(3000);
		}
		
		Thread.sleep(20000);
		//verify after deleting the content
		if (cob.NoItems().isDisplayed())
		{
			logger.info("Selected item is deleted and No items to display here");
			Thread.sleep(3000);
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



