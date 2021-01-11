package com.ccs.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class StylesPage {
	//add web driver
		WebDriver ldriver;
		
		//add constructor
		public StylesPage(WebDriver rdriver)
		{
			ldriver=rdriver;
			PageFactory.initElements(rdriver, this);
		}
		
		//wind name- Add style
		@FindBy(how = How.XPATH, using ="//span[text()='Add Style']")
		@CacheLookup
		WebElement wndAddStyle;	
		public WebElement wndAddStyle() 
		{
			return wndAddStyle;
		}
		
		//StyleAttibute->Font-family
		//@FindBy(how = How.XPATH, using ="//input[@type='radio' and @id='Font-family|rb']")
		@FindBy(how = How.ID, using ="Font-family|rb")
		@CacheLookup
		WebElement fontFamilyRbBtn;
		
		public WebElement fontFamilyRbBtn() 
		{
			return fontFamilyRbBtn;
		}
		
		//StyleAttibute->Font-family->Calibri
		@FindBy(how = How.XPATH, using ="//input[@type='radio' and @id='Calibri|rb']")
		@CacheLookup
		WebElement fontCalibriRbBtn;
		
		public WebElement fontCalibriRbBtn() 
		{
			return fontCalibriRbBtn;
		}
		
		@FindBy(how = How.ID, using ="Text|rb")
		@CacheLookup
		WebElement radioBtn;
		public WebElement radioBtn() 
		{
			return radioBtn;
		}
		
		//selected attribute
		//@FindBy(how = How.XPATH, using ="//span[@class='oj-button-text' and contains(@text,'Calibri')]")
		@FindBy(how = How.XPATH, using ="//span[contains(@text,'Calibri')")
		@CacheLookup
		WebElement selectedAttrb;
		
		public WebElement selectedAttrb() 
		{
			return selectedAttrb;
		}

		//expand Style Attributes
		@FindBy(how = How.XPATH, using ="//*[contains(@id,'StyleAttributes')]")
		//@FindBy(how = How.XPATH, using ="//h4[contains(text(),'Style Attributes')]")
		//"//h4/a[contains(text(),'SAP M')]"
		@CacheLookup
		WebElement styleAttibute;
		
		public WebElement styleAttibute() 
		{
			return styleAttibute;
		}
		
		//expand Style Attributes
		@FindBy(how = How.XPATH, using ="//*[contains(@id,'StyleAttributes')]")
		//@FindBy(how = How.XPATH, using ="//h4[contains(text(),'Style Attributes')]")
		//"//h4/a[contains(text(),'SAP M')]"
		@CacheLookup
		WebElement styleAttibute2;
		
		public WebElement styleAttibute2() 
		{
			return styleAttibute2;
		}
		
		//expand Status Date
		@FindBy(how = How.XPATH, using ="//*[contains(@id,'StatusDate')]")
		@CacheLookup
		WebElement statusDate;
		
		public WebElement statusDate() 
		{
			return statusDate;
		}
		
		//expand Style Attributes
		@FindBy(how = How.XPATH, using ="//*[contains(@title,'Edit Style Attributes')]")
		@CacheLookup
		WebElement editStyleAttibute;
		
		public WebElement editStyleAttibute() 
		{
			return editStyleAttibute;
		}
			


}
