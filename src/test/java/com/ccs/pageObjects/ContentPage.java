package com.ccs.pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ContentPage {
	//add web driver
	WebDriver ldriver;
	
	//add constructor
	public ContentPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	//Content Type selection window
	@FindBy(how = How.XPATH, using ="//span[text()='Choose Content Type']")
	@CacheLookup
	WebElement contSelectionWindow;
	
	public WebElement contSelectionWindow() 
	{
		return contSelectionWindow;
	}
	
	//driver.findElement(By.cssSelector("[aria-label=expand]")).click();
	@FindBy(how = How.CSS, using ="[aria-label=expand]")
	@CacheLookup
	WebElement expandBtn;
	
	//driver.findElement(By.xpath("//span[text()='Content']")).click();
	@FindBy(how = How.XPATH, using ="//span[text()='Content']")
	@CacheLookup
	WebElement lstContent;
	
	@FindBy(how = How.XPATH, using ="//oj-button[@id='[['clearButton']]']")
	@CacheLookup
	WebElement clearBtn;
	
	@FindBy(how = How.XPATH, using ="//oj-button[@id='[['magnify']]']")
	@CacheLookup
	WebElement magnifyBtn;
	
	@FindBy(how = How.ID, using ="landingFilterSearch_SearchBox|input")
	@CacheLookup
	WebElement txtInputSearch;
		
	//@FindBy(how = How.ID, using ="btnViewAll")
	@FindBy(how = How.ID, using ="[['viewAllButton'+$unique]]")
	@CacheLookup
	WebElement btnViewAll;
	
	@FindBy(how = How.ID, using ="add")
	@CacheLookup
	WebElement createBtn;
	
	
		
	@FindBy(how = How.XPATH, using ="//span[text()='Results']")
	@CacheLookup
	WebElement resulstWind;
	
	@FindBy(how = How.ID, using ="Text|rb")
	@CacheLookup
	WebElement radioBtn;
		
	@FindBy(how = How.ID, using ="Continue")
	@CacheLookup
	WebElement continueBtn;
	
	@FindBy(how = How.ID, using ="Continue")
	@CacheLookup
	WebElement continueBaseBtn;
	
	
	@FindBy(how = How.XPATH, using ="//span[text()='Add Identification']")
	@CacheLookup
	WebElement addIdentificationWind;
	
	//@FindBy(how = How.ID, using ="textinput|input")
	@FindBy(how = How.XPATH, using ="//*[starts-with(@id,'textinput')]")
	@CacheLookup
	WebElement baseContName;

	//@FindBy(how = How.ID, using ="textArea|input")
	@FindBy(how = How.XPATH, using ="//*[starts-with(@id,'textArea')]")
	@CacheLookup
	WebElement baseContLongName;
	
	//@FindBy(how = How.XPATH, using ="//*[@id='textArea|input' and @maxlength='4000']")
	@FindBy(how = How.XPATH, using ="//*[starts-with(@id,'textArea' and @maxlength='4000')]")
	@CacheLookup
	WebElement baseContDesc;
	
	@FindBy(how = How.TAG_NAME, using ="Create Content Version")
	@CacheLookup
	WebElement CreateContVersion;
	
	//ck-toolbar
	@FindBy(how = How.XPATH, using ="//*[contains(@class,'ck-toolbar')]")
	@CacheLookup
	WebElement ckToolbar;
	
	//CKEDITOR 
	@FindBy(how = How.XPATH, using ="//*[contains(@class,'ck-editor__editable')]")
	@CacheLookup
	WebElement ckEditor;
	
	//Success message
	@FindBy(how = How.XPATH, using ="//span[text()='Success!']")
	@CacheLookup
	WebElement successMsgWind;
	
	public WebElement successMsgWind() 
	{
		return successMsgWind;
	}
	
		
	public WebElement ckToolbar() 
	{
		return ckToolbar;
	}
	public WebElement ckEditor() 
	{
		return ckEditor;
	}

	public boolean windCreatContVer() 
	{
		return CreateContVersion.isDisplayed();
	}
	
	public void baseContName(String bcontantname)
	{
		baseContName.sendKeys(bcontantname);	
	}
	
	public void baseContLongName(String bcontlongname)
	{
		baseContLongName.sendKeys(bcontlongname);	
	}
	
	
	public void baseContDesc(String bcontdesc)
	{
		baseContDesc.sendKeys(bcontdesc);	
	}

		
	public void selectContent() 
	{
		lstContent.click();
	}
	public void ClearBtn() 
	{
		clearBtn.click();
	}
	public void MagnifyBtn() 
	{
		magnifyBtn.click();
	}
	
	public void txtInputSearch(String contsearchinput)
	{
		txtInputSearch.sendKeys(contsearchinput);
		
	}
	public void ViewAllBtn() 
	{
		btnViewAll.click();
	}
	
	public void CreateBtn() 
	{
		createBtn.click();
	}
	
	public WebElement radioBtn() 
	{
		return radioBtn;
	}
	
	public boolean resultstWind() 
	{
		return resulstWind.isDisplayed();
	}
	
	
	public void expandArrow() 
	{
		expandBtn.click();
	}
	public void continueBtn() 
	{
		continueBtn.click();
	}
	
	public void continueBaseBtn() 
	{
		continueBaseBtn.click();
	}

	public WebElement addIdentificationWind() 
	{
		return addIdentificationWind;
	}
	

}