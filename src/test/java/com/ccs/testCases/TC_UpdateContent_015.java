package com.ccs.testCases;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ccs.pageObjects.ContentPage;
import com.ccs.pageObjects.LoginPage;
import com.ccs.utilities.XLUtils;

public class TC_UpdateContent_015 extends BaseClass{
	String timeStamp = new SimpleDateFormat("yy.MM.dd.HH.mm.ss").format(new Date());

	@Test(dataProvider = "ContData")

	public void ReadContentDDT(String uname, String pwd, String bconName, String bconLName, String bconDesc,
			String conVname, String contDesc, String activeDate, String cKEditData) throws InterruptedException, IOException

	{
		// calling SignIn method
		//driver.get(baseURL);
		//Thread.sleep(3000);
		//logger.info("URL is opened: " + baseURL);
		
		// here LoginPage- pageObject class
		LoginPage lp = new LoginPage(driver);
		ContentPage cp = new ContentPage(driver);
		Thread.sleep(3000);

		// details page-
		// lp.clkkdetailBtn();
		// lp.clkproceedLink();

		//if details button is exists then click otherwise skip	
		if (driver.findElements(By.id("details-button")).isEmpty())
		{
			logger.info("Details-button is not dispayed to click");
		}else {
			driver.findElement(By.id("details-button")).click();
			logger.info("Clicked on 'details-button'");
		}
		Thread.sleep(2000);
		//if Proceed link is exists then click otherwise skip	
		if (driver.findElements(By.id("proceed-link")).isEmpty())
		{			
			logger.info("Proceed-link is not displayed to click");
		}else
			{
			driver.findElement(By.id("proceed-link")).click();
			logger.info("Clicked on 'proceed-link'");		
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
		
		
		boolean Logintitle = driver.getPageSource().contains("Dashboard");
		if (Logintitle == true)
		{
			Assert.assertTrue(true);
			logger.info("Login test passed and Logged in as a: " + uname);
		} else {
			// call the capture screen method which is declared in base class
			captureScreen(driver, "loginTest_TC011");
			Assert.assertTrue(false);
			logger.info("Login test filed");
		}
		
		// MapConfig Id
		TC_MapConfigID_013 mapConfigId = new TC_MapConfigID_013();
		mapConfigId.mapConfigID();
		
		// Calling Class- Go to Content Landing page
		ContentLandingPage ContLandingPage = new ContentLandingPage();
		ContLandingPage.ContLandingPage();

		
		//search filed
		if (driver.findElement(By.xpath("//*[starts-with(@id,'SearchBox')]")).isDisplayed())
		{
			driver.findElement(By.xpath("//*[starts-with(@id,'SearchBox')]")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[starts-with(@id,'SearchBox')]")).sendKeys(bconName);
			logger.info("Clicked on 'Search Text' Field and entered Content name");
			Thread.sleep(3000);
		}
		
		//click on Search
		if (driver.findElement(By.xpath("//*[contains(@title,'Search')]")).isDisplayed()) {
			driver.findElement(By.xpath("//*[contains(@title,'Search')]")).click();
			logger.info("Clicked on 'Search' icon");
			Thread.sleep(3000);
		} 
		
		String searchresult = driver.findElement(By.xpath("//span[contains(@class,'list-text')]")).getText();
			//if (searchresult.equals(bconName))
				if (searchresult.contains(bconName))
			{
			logger.info("searched content is: "+searchresult);
			Thread.sleep(3000);
			}else {
				logger.info("searched content is not:"+searchresult);
				Thread.sleep(3000);
			}
				
			//expand base content
			if (driver.findElement(By.xpath("//span[contains(@class,'treeview-icon')]")).isDisplayed())
			{
				driver.findElement(By.xpath("//span[contains(@class,'treeview-icon')]")).click();
				logger.info("clicked on Treeview-icon(+) menu ");		
			}
			
			Thread.sleep(20000);
           //content version
			String contversion = driver.findElement(By.xpath("//span[contains(@class,'list-text')]")).getText();
			//if (contversion.equals(conVname))
			if (contversion.contains(conVname))
			{
			logger.info("searched content is: "+conVname);
			Thread.sleep(3000);
			}else {
				driver.findElement(By.xpath("//*[contains(@class,'treeview-item-content')]")).isDisplayed();
					logger.info("treeview-item-content is displayed");
			}
			
			//kebab/ellipsis menu
			if (driver.findElement(By.xpath("//span[contains(@class,'icon-ellipsis-menu')]")).isDisplayed())
			{
				driver.findElement(By.xpath("//span[contains(@class,'icon-ellipsis-menu')]")).click();
				logger.info("clicked on kebab menu ");
				Thread.sleep(3000);
			}
			
			if (driver.findElement(By.xpath("//span[text()='Go to Details']")).isDisplayed())
			{
				driver.findElement(By.xpath("//span[text()='Go to Details']")).click();
				logger.info("clicked on Go to Details ");
				Thread.sleep(3000);
			}
		
			Thread.sleep(50000);
		
			Boolean contTitle = driver.findElement(By.tagName("h1")).isDisplayed();
			if (contTitle == true) {
				Assert.assertTrue(true);
				logger.info("Content detailed page is :" + conVname);
			} else {
				logger.info("Content detailed page is not :" + conVname);
				captureScreen(driver, "ContDetails_TC011");
				Assert.assertTrue(false);
			}
			
			if (driver.findElement(By.xpath("//*[contains(@id,'Identification')]")).isDisplayed())
			{
				driver.findElement(By.xpath("//*[contains(@id,'Identification')]")).click();
				logger.info("Clicked on Identification to expand");
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
