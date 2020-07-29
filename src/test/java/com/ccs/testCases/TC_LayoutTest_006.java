package com.ccs.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ccs.pageObjects.ContentPage;
import com.ccs.pageObjects.LayoutPage;
import com.ccs.pageObjects.LoginPage;
import com.ccs.utilities.XLUtils;

public class TC_LayoutTest_006 extends BaseClass
{
	@Test(dataProvider="LayoutsData")
	public void layoutTest(String uname, String pwd, String sName, String layName, String layLName, String layDesc,
			String unitsType, String uWidth, String uHeight, String mTop, String mBottom, String mLeft, String mRight, String styleName) throws InterruptedException, IOException
	{
		

		
		//Get URL
		driver.get(baseURL);
		logger.info("URL is opened: "+baseURL);
		
		//here LoginPage- pageObject class
		LoginPage lp = new LoginPage(driver);
		ContentPage cp = new ContentPage(driver);
		LayoutPage lap = new LayoutPage(driver);
		Actions tab = new Actions(driver);
		Thread.sleep(3000);
		
		//details page-
		lp.clkkdetailBtn();
		lp.clkproceedLink();
		
		lp.setUserName(uname);
		logger.info("Entered username: " +uname);

		lp.setPassword(pwd);
		logger.info("Entered password");

		lp.clickSignin();
		logger.info("Clicked on Sign In");
		Thread.sleep(200000);
				
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
		logger.info("Selected Configuration->Communication link");
		
		lp.clikComLayConflnk();
		logger.info("Selected Configuration->Communication->Layout link");
		Thread.sleep(40000);
		 
		//validating Title
		boolean res=driver.getPageSource().contains("Document Layouts"); 
		if(res==true) 
		{
			Assert.assertTrue(true);
			logger.info("You are at Document Layout Landing page....");
		  
		}
		else 
		{ 
			logger.info("You are not at Document Layout Landing page....");
			captureScreen(driver,"documentLayoutLandingPage_TC006"); 
			Assert.assertTrue(false);
		 }	 

		Thread.sleep(3000);
		//lap.txtInputSearch(sName);
		if (driver.findElement(By.id("_ojcustomelem8_SearchBox|input")).isDisplayed())
		{
			driver.findElement(By.id("_ojcustomelem8_SearchBox|input")).sendKeys(sName);
			logger.info("Entered Layout name in Search text box: "+sName);
			Thread.sleep(3000);
		}else if(driver.findElement(By.id("oj-inputtext-input oj-text-field-input oj-component-initnode")).isEnabled())
		{
			driver.findElement(By.id("oj-inputtext-input oj-text-field-input oj-component-initnode")).sendKeys(sName);
			logger.info("Entered Layout name in Search text box 2: "+sName);
			Thread.sleep(3000);	
		}else
		{
		driver.findElement(By.className("full-width search-box oj-inputtext oj-form-control oj-component oj-text-field oj-complete oj-hover"));
		logger.info("Entered Layout name in Search text box 3: "+sName);
		Thread.sleep(3000);
		}
		
		if (driver.findElement(By.xpath("//span[text()='View All Layouts']")).isDisplayed())
				{
			driver.findElement(By.xpath("//span[text()='View All Layouts']")).click();
			logger.info("Clicked on 'View All Layouts' to search the selected Layout 1");
				}else {
		lap.ViewAllBtn();
		logger.info("Clicked on 'View All Layouts' to search the selected Layout 2");
		Thread.sleep(5000);
				}
		if (cp.resultstWind() == true) {
			Assert.assertTrue(true);
			logger.info("selected Layout/s will be listed in results window");
		} else

		{
			logger.info("selected items are not liseds in results window");
			captureScreen(driver, "SearchResults_TC006");
			Assert.assertTrue(false);
		}
		
		// click create button
		cp.CreateBtn();
		logger.info("Clicked on 'Plus(+) icon button to create new Layout");
		Thread.sleep(5000);		
		
		//validating window name
		boolean res1 = driver.findElement(By.xpath("//span[text()='Creating']")) != null;
		if (driver.getPageSource().contains("Creating New Layout")) {
			logger.info("Creating New Layout window");
		} else if (driver.getTitle().equals("Creating New Layout"))
		{
			logger.info("equals- Creating New Layout window");
		}else if (driver.getTitle().equals("Creating Layout"))
		{
			logger.info("equals- Creating Layout");
		}
		
		else if (res1 == true) {
			Assert.assertTrue(true);
			logger.info("You are at Create new Layout window");

		} else {
			logger.info("You are not at Create new Layout window");
			captureScreen(driver, "CreateNewLayout_TC006");
			Assert.assertTrue(false);
		}

			
		// provide layout details details
				
		if (driver.findElement(By.xpath("//*[@class='oj-inputtext-input oj-text-field-input oj-component-initnode' or @id='textinput_ojcustomelem70|input']")).isEnabled())
		
			{
			driver.findElement(By.xpath("//*[@class='oj-inputtext-input oj-text-field-input oj-component-initnode' or @id='textinput_ojcustomelem70|input']")).sendKeys(layName);
			logger.info("Entered Layout Name 1: "+layName);
			}
		else if (driver.findElements(By.tagName("textinput")).get(0).isEnabled())
		{
			driver.findElements(By.tagName("textinput")).get(0).sendKeys(layLName);
			logger.info("Entered Layout Name as : "+layLName);
		}
		else {
		cp.baseContName(layName);
		logger.info("Entered Layout Name: "+layName);
		Thread.sleep(3000);
			}
		
		//enter  Layout long name 
		if (driver.findElement(By.xpath("//*[@class='oj-textarea-input oj-text-field-input oj-component-initnode' or @id='textArea_ojcustomelem71|input']")).isEnabled())
		
		{
			driver.findElement(By.xpath("//*[@class='oj-textarea-input oj-text-field-input oj-component-initnode' or @id='textArea_ojcustomelem71|input']")).sendKeys(layLName);
			logger.info("Entered Layout Long Name Name 1: "+layLName);
		}else if(driver.findElement(By.xpath("//*[@class='oj-textarea-input oj-text-field-input oj-component-initnode' or @maxlength='4000']")).isEnabled())
		{
			driver.findElement(By.xpath("//*[@class='oj-textarea-input oj-text-field-input oj-component-initnode' or @maxlength='4000']")).sendKeys(layLName);
			logger.info("Entered Layout Long Name Name : "+layLName);
			
		}
		
		else if (driver.findElements(By.tagName("textarea")).get(0).isEnabled())
		{
			driver.findElements(By.tagName("textarea")).get(0).sendKeys(layLName);
			logger.info("Entered Layout Long Name as : "+layLName);
		}else {
			cp.baseContLongName(layLName);
			logger.info(" unable to entered Layout  long name:"+layLName);
			Thread.sleep(3000);
		}

		//enter Layout Description	
		
		if (driver.findElements(By.tagName("textarea")).get(1).isEnabled())
		{
			driver.findElements(By.tagName("textarea")).get(1).sendKeys(layDesc);
			logger.info("Entered Layout Description as : "+layDesc);
		}

		else if (driver.findElement(By.xpath("//input[text()='Description']")).isEnabled())
		{
			driver.findElement(By.xpath("//input[text()='Description']")).sendKeys(layDesc);
			
			logger.info("Entered Layout Description : "+layDesc);

		}else {
			
			driver.findElement(By.xpath("//textarea[text()='Description']")).sendKeys("muni");
		
			logger.info("Entered Layout Description : ");
		}
		//driver.findElements(By.xpath(“//*submit”)).get(2).click(); 
		
		//textarea[class="oj-textarea-input oj-text-field-input oj-component-initnode"][maxlength="4000"]] 
		//layout Description
		
/*		
		if (driver.findElement(By.xpath("//*[@class='oj-textarea-input oj-text-field-input oj-component-initnode' and @id='textArea_ojcustomelem72|input']")).isEnabled())
			
		{
			driver.findElement(By.xpath("//*[@class='oj-textarea-input oj-text-field-input oj-component-initnode' and @id='textArea_ojcustomelem72|input']")).sendKeys(layDesc);
			logger.info("Entered Layout Description : "+layDesc);
		}else if (driver.findElement(By.xpath("//*[starts-with(@id,'textArea' or @maxlength='4000']")).isEnabled())
				
			{
				driver.findElement(By.xpath("//*[starts-with(@id,'textArea' or @maxlength='4000']")).sendKeys(layDesc);
				logger.info("Entered Layout Description 3 : "+layDesc);
			}else{
				driver.findElement(By.xpath("//span[text()='Description']")).sendKeys(layDesc);
				
		//cp.baseContDesc(layDesc);
		logger.info("Entered Layout description 4:"+layDesc);
		Thread.sleep(3000);
		}
*/		
		//Set Units - validating section name
		driver.getTitle().equals("Set Units:");
		logger.info("You are at 'Set Units:' window");
		Thread.sleep(3000);
		
				
		/*
		if (driver.findElements(By.cssSelector(unitsType)) != null)
		{
		logger.info("selected Units as 1:"+unitsType);
		Thread.sleep(3000);	
		}
		else if (driver.findElements(By.tagName("a")).get(0).isDisplayed())
		{
			driver.findElements(By.tagName("a")).get(0).click();
			logger.info("clicked on down arow and slect index 0");
		}
		
		else 
		{
			driver.findElement(By.tagName("a")).click();
			logger.info("clicked on down arow");
		}

		//driver.findElement(By.className("oj-select-arrow oj-component-icon oj-clickable-icon-nocontext oj-select-open-icon")).click();
		//logger.info("Cliked on Units list");
		//Thread.sleep(3000);		

		WebElement unitsdropdown= driver.findElement(By.tagName("a"));
		Select select = new Select(unitsdropdown);
		select.selectByValue(unitsType);
		
		driver.findElements(By.cssSelector(unitsType));
		logger.info("selected Units as 2:"+unitsType);
		Thread.sleep(3000);	
		
	*/	
		if (driver.findElements(By.tagName("oj-input-text")).get(1).isEnabled())
		{
			driver.findElements(By.tagName("oj-input-text")).get(1).sendKeys(Keys.chord(Keys.CONTROL, "a"),uWidth);
		logger.info("Default Units width is cleared and entered value as:"+uWidth);
		Thread.sleep(3000);
		}
		
	/*	//driver.findElement(By.id("textinputwidthId|input")).sendKeys(uWidth);
		//driver.findElement(By.id("widthId")).sendKeys(uWidth);
		//driver.findElement(By.xpath("//fsgbu-ts-inputtext[@id='widthId']")).sendKeys(uWidth);
		//driver.findElement(By.xpath("//span[text()='Width']")).sendKeys("8.5");
		//driver.findElement(By.xpath("//span[text()='Width']")).sendKeys(uWidth);

		*/

		if (driver.findElements(By.tagName("oj-input-text")).get(2).isEnabled())
		{
			driver.findElements(By.tagName("oj-input-text")).get(2).sendKeys(Keys.chord(Keys.CONTROL, "a"),uHeight);
		logger.info("Default Units Height is cleared and entered the value as:"+uHeight);
		Thread.sleep(3000);
		}

			//driver.findElement(By.id("heightId")).sendKeys(uHeight);
			//driver.findElement(By.xpath("//fsgbu-ts-inputtext[@id='heightId']")).sendKeys(uHeight);
			//driver.findElement(By.xpath("//span[text()='Height']")).sendKeys(uHeight);

		//Margins section
		
		driver.getTitle().equals("Set Margins:");
		logger.info("You are at 'Set Margins:' section");
		Thread.sleep(5000);

		//enter top value

		if (driver.findElements(By.tagName("oj-input-text")).get(3).isEnabled())
		{
			driver.findElements(By.tagName("oj-input-text")).get(3).sendKeys(Keys.chord(Keys.CONTROL, "a"),mTop);
			logger.info("Default Margin Top value is cleared and entered value as:"+mTop);
			Thread.sleep(3000);
		}
		/*driver.findElement(By.id("topId")).sendKeys(mTop);
		//driver.findElements(By.tagName("oj-input-text")).get(3).sendKeys(mTop);
		driver.findElement(By.xpath("//fsgbu-ts-inputtext[@id='topId']")).sendKeys(mTop);
		driver.findElement(By.xpath("//span[text()='Top']")).sendKeys(mTop);
		 */
		
		//bottom value
		if (driver.findElements(By.tagName("oj-input-text")).get(4).isEnabled())
		{
			driver.findElements(By.tagName("oj-input-text")).get(4).sendKeys(Keys.chord(Keys.CONTROL, "a"),mBottom);
			logger.info("Default Margin Bottom value is cleared and entered value as:"+mBottom);
			Thread.sleep(3000);
		}
		/*
		driver.findElement(By.id("bottomId")).sendKeys(mBottom);
		driver.findElement(By.xpath("//fsgbu-ts-inputtext[@id='bottomId']")).sendKeys(mBottom);
		driver.findElements(By.tagName("oj-input-text")).get(4).sendKeys(mBottom);
		driver.findElement(By.xpath("//span[text()='Bottom']")).sendKeys(mBottom);
	*/
		
		//enter left value

		if (driver.findElements(By.tagName("oj-input-text")).get(5).isEnabled())
		{
			driver.findElements(By.tagName("oj-input-text")).get(5).sendKeys(Keys.chord(Keys.CONTROL, "a"),mLeft);
			logger.info("Default Margin Left value is cleared and entered the value as:"+mLeft);
			Thread.sleep(3000);
		}
		/*
		driver.findElement(By.id("leftId")).sendKeys(mLeft);
		driver.findElement(By.xpath("//fsgbu-ts-inputtext[@id='leftId']")).sendKeys(mLeft);
		driver.findElements(By.tagName("oj-input-text")).get(5).clear();
		driver.findElement(By.xpath("//span[text()='Left']")).sendKeys(mLeft);

		*/
		//enter margin right value
		if (driver.findElements(By.tagName("oj-input-text")).get(6).isEnabled())
		{
			driver.findElements(By.tagName("oj-input-text")).get(6).sendKeys(Keys.chord(Keys.CONTROL, "a"),mRight);
			logger.info("Default Margin Right value is cleared and entered the value as:"+mRight);
			Thread.sleep(3000);
		}
		/*
		driver.findElement(By.id("rightId")).sendKeys(mRight);
		driver.findElement(By.xpath("//fsgbu-ts-inputtext[@id='rightId']")).sendKeys(mRight);
		driver.findElements(By.tagName("oj-input-text")).get(6).sendKeys(mRight);
		driver.findElement(By.xpath("//span[text()='Right']")).sendKeys(mRight);
		 */
		
		if (driver.findElement(By.id("Continue")).isEnabled())
		{
		driver.findElement(By.id("Continue")).click();
		logger.info("Clicked on Continue");
		Thread.sleep(8000);
		} else {
			driver.findElement(By.xpath("//span[text()='Continue']")).click();
			logger.info("Clicked on Continue 2");
			Thread.sleep(3000);
		}
		
		boolean ma = driver.getPageSource().contains("Manage Associations");
		if (ma == true) {
			Assert.assertTrue(true);
			logger.info("You are at 2/3 Manage Associations window");
			Thread.sleep(3000);
		} else {
			logger.info("You are not at 2/3 Manage Associations window");
			captureScreen(driver, "LayoutAss_TC006");
			Assert.assertTrue(false);
		}
		
		//adding styles to layout
		
		//driver.findElement(By.xpath("//span[@class='p-tb-0 oj-collapsible-header' and @id='oj-collapsible-1-header']")).click();
		if (driver.findElements(By.tagName("oj-collapsible")).get(0).isEnabled())
		{
			driver.findElements(By.tagName("oj-collapsible")).get(0).click();
			logger.info("Expnaded the Style");
			Thread.sleep(3000);
		}else {
				logger.info("failed to click style");
				captureScreen(driver, "LayoutStyleLink_TC006");
				Assert.assertTrue(false);
		}
		
		//driver.findElement(By.id("")).
		Thread.sleep(3000);
		driver.findElement(By.tagName("oj-button")).click();
		logger.info("clicked on Add button to add styles");
		Thread.sleep(3000);
		
	//select existing style radio button
		if (driver.findElement(By.id("Use Existing Style|rb")).isEnabled())
		{
			driver.findElement(By.id("Use Existing Style|rb")).click();
			logger.info("clicked on Use Existing Style|rb");
			Thread.sleep(7000);
			
		}else
		{
			driver.findElement(By.xpath("//span[@class='oj-choice-item oj-enabled oj-selected']")).click();
			logger.info("clicked 2 on Use Existing Style|rb");
			Thread.sleep(3000);
		}
		
		//click on continue
		
		//html/body/div/div[2]/oj-dialog/div[3]/div/div/div[2]/oj-button
		if(driver.findElement(By.xpath("//span[@class='oj-button-text' and id='Continue']")).isEnabled())
		{
			driver.findElement(By.xpath("//span[@class='oj-button-text' and id='Continue']")).click();
			logger.info("clicked 1 continue");
			Thread.sleep(3000);	
		}else {
		driver.findElement(By.xpath("//span[@id='Continue']")).click();
		logger.info("clicked 2 on Use Existing Style|rb");
		Thread.sleep(3000);
		}
		/*
		
		if (driver.findElement(By.id("Continue")).isEnabled())
		{
		driver.findElement(By.id("Continue")).click();
		logger.info("Clicked 2 on Continue");
		Thread.sleep(8000);
		}
		else if (driver.findElement(By.className("full-width oj-button-primary oj-button oj-component oj-enabled oj-button-full-chrome oj-button-text-only oj-complete oj-default")).isEnabled())
		{
			driver.findElement(By.className("full-width oj-button-primary oj-button oj-component oj-enabled oj-button-full-chrome oj-button-text-only oj-complete oj-default")).click();

		logger.info("clicked 3 on Continue button to add styles");
		Thread.sleep(10000);
	} else if(driver.findElement(By.xpath("//span[text()='Continue']")).isEnabled()) {
			driver.findElement(By.xpath("//span[text()='Continue']")).click();
			logger.info("Clicked 4 on Continue");
			Thread.sleep(3000);
		}else
		{
			//driver.findElements(By.tagName("oj-button"))
			//driver.findElements(By.xpath("//oj-button[contains(@class, 'FINISH|NEXT']")).
			driver.findElements(By.tagName("oj-button")).get(1).findElement(By.xpath("//span[text()='Continue']")).click();
			//driver.findElements(By.tagName("oj-button")).get(1).click();
		logger.info("Clicked 5 on Continue ");
		Thread.sleep(3000);
		}
		*/
		//full-width oj-button-primary oj-button oj-component oj-enabled oj-button-full-chrome oj-button-text-only oj-complete oj-default
	//		search
		
		if (driver.findElement(By.xpath("//*[@class='oj-inputtext-input oj-text-field-input oj-component-initnode' and @id='_ojcustomelem93_SearchBox|input']")).isEnabled())
		{
			driver.findElement(By.xpath("//*[@class='oj-inputtext-input oj-text-field-input oj-component-initnode' and @id='_ojcustomelem93_SearchBox|input']")).sendKeys(styleName);
			logger.info("Entered style name in search box:"+styleName);
			Thread.sleep(3000);	
		}else if (driver.findElement(By.xpath("//*start-with(@id,'_ojcustomelem')]")).isEnabled())
		{
			driver.findElement(By.xpath("//*start-with(@id,'_ojcustomelem')]")).sendKeys(styleName);
			logger.info("Entered style name in search box 2:"+styleName);
			Thread.sleep(3000);
		}
		
		//select search name
		
		if (driver.findElement(By.xpath("//span[contains(@class,'list-text')]  [contains(text(), styleName)]")).isDisplayed())
		{
			driver.findElement(By.xpath("//span[contains(@class,'list-text')]  [contains(text(), styleName)]")).click();
			logger.info("clicked on selected  11"+styleName);
			Thread.sleep(3000);	
		}else
		{
			driver.findElement(By.name(styleName)).click();
			logger.info("clicked on selected: "+styleName);
		}
			
		//select check box for selected style
		if (driver.findElement(By.name("landingResultsViewList_checkboxSet_0")).isEnabled())
		{
			driver.findElement(By.name("landingResultsViewList_checkboxSet_0")).click();
			logger.info("clicked on selected style");
			Thread.sleep(3000);	
		}else
		{
			driver.findElement(By.xpath("//*[@class='oj-radiocheckbox-icon' and @name='_ojcustomelem105_checkboxSet_0']")).click();
			logger.info("clicked on selected stylec 2");
			Thread.sleep(3000);	
		}
	
		
		
		if (driver.findElement(By.xpath("//span[contains(@class,'oj-button-text')]  [contains(text(), 'Continue')]")).isDisplayed())
		{
			driver.findElement(By.xpath("//span[contains(@class,'oj-button-text')]  [contains(text(), 'Continue')]")).click();
			logger.info("clicked on Continue button after adding styles"+styleName);
			Thread.sleep(3000);	
		}else {
			driver.findElement(By.xpath("//span[text()='Continue' and @class='oj-button-text']")).click();
			logger.info("clicked on Continue button to add styles");
			Thread.sleep(10000);
			
		}
		//click continue again
		if (driver.findElement(By.xpath("//span[contains(@class,'oj-button-text')]  [contains(text(), 'Continue')]")).isDisplayed())
		{
			driver.findElement(By.xpath("//span[contains(@class,'oj-button-text')]  [contains(text(), 'Continue')]")).click();
			logger.info("clicked on Continue button 1");
			Thread.sleep(3000);	
		}
		else {
			driver.findElement(By.xpath("//span[text()='Continue' and @class='oj-button-text']")).click();
			logger.info("clicked on Continue button 2");
			Thread.sleep(10000);
			
		}
		
		//click continue again
		if (driver.findElement(By.xpath("//span[contains(@class,'oj-button-text')]  [contains(text(), 'Continue')]")).isDisplayed())
		{
			driver.findElement(By.xpath("//span[contains(@class,'oj-button-text')]  [contains(text(), 'Continue')]")).click();
			logger.info("clicked on Continue button 1 in 2/3 manage association window");
			Thread.sleep(3000);	
		}else {
			driver.findElement(By.xpath("//span[text()='Continue' and @class='oj-button-text']")).click();
			logger.info("clicked on Continue button 2 in 2/3 manage association window");
			Thread.sleep(10000);
			
		}
		

		
		driver.getTitle().equals("Position Styles");
		logger.info("You are at 'Position Styles' window");
		Thread.sleep(3000);
		
		//click continue in Manage Positions window
		driver.findElement(By.xpath("//span[text()='Continue']")).click();
		logger.info("clicked continue button in Manage Positions window ");
		Thread.sleep(20000);
	
		
		//Click on Finish button
		driver.findElement(By.xpath("//span[text()='Finish']")).click();
		logger.info("clicked Finish button in Document version window to create base content ");
		Thread.sleep(20000);
			

		// Layout Creation status window
		boolean successWind = driver.findElement(By.xpath("//span[text()='Success!']")).isDisplayed();
		if (successWind == true) {
			Assert.assertTrue(true);
			logger.info("Layout creation windows is displayed with 'Success'");
		} else {
			logger.info("Layout creation windows is not displayed with 'Success'");
			captureScreen(driver, "ContCreatSuccess_TC011");
			Assert.assertTrue(false);
		}
		
		driver.findElement(By.xpath("//span[text()='Finish']")).click();
		logger.info("clicked Finish to complete the process of Layout creation ");
		Thread.sleep(20000);
		
		Thread.sleep(30000);

		Boolean contTitle =driver.findElement(By.tagName("h1")).isDisplayed();
		if (contTitle == true) {
			Assert.assertTrue(true);
			logger.info("Layout is created with the name of :"+layName);
		} else {
			logger.info("Layout is not created with the name of :"+layName);
			captureScreen(driver, "LayoutCreatSuccess_TC006");
			Assert.assertTrue(false);
		}
		
		if (driver.findElement(By.id("drawerToggleButton")).isDisplayed()) {
		driver.findElement(By.id("drawerToggleButton")).click();


		}else if (driver.findElement(By.name("Application Navigation")).isDisplayed())
		{
			driver.findElement(By.name("Application Navigation")).click();
			logger.info("clicked on Application Navigation");
		}else {
			
		lp.clickSignoff();
		logger.info("User is Sign off last");
		Thread.sleep(5000);
		}
	}	
		
		
		//Read Data from excel
	
		  @DataProvider(name="LayoutsData") String [][] getData() throws IOException {
		  String path=System.getProperty("user.dir")+"/src/test/java/com/ccs/testData/LoginData.xlsx";
		  
		  //read the data from xlsx //get row count
		  int rownum=XLUtils.getRowCount(path, "LayoutData");//path- xl location path and 	  sheet1 - sheet name //get cell count 
		  int colcount=XLUtils.getCellCount(path, "LayoutData", 2); //here 1- row number
		  
		  String layoutdata[][]=new String[rownum][colcount];
		  
		  for(int i=2;i<=rownum;i++)//outer for loop for row 
			  { 
			  	for(int j=0;j<colcount;j++)//inner for loop for column
			  		{
			  		layoutdata[i-2][j]=XLUtils.getCellData(path, "LayoutData", i, j);
			  		} 
			  	}
		  
		  return layoutdata;
		  } 


}
