package com.ccs.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CCSPageObjects {
	//add web driver
	WebDriver ldriver;
	
	//add constructor
	public CCSPageObjects(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	//Validating Dashboard screen
	@FindBy(how = How.XPATH, using ="//li[text()='Dashboard']")
	@CacheLookup
	WebElement loginSuccess;
	
	public WebElement loginSuccess() 
	{
		return loginSuccess;
	}
	
	//Create/Add button to create assets
	@FindBy(how = How.ID, using ="add")
	@CacheLookup
	WebElement createBtn;
	
	public WebElement createBtn() 
	{
		return createBtn;
	}
	
	//click on Add button
	@FindBy(how = How.XPATH, using ="//oj-button[@value='Add' and @title='Add']")
	@CacheLookup
	WebElement addBtn;
	
	public WebElement addBtn() 
	{
		return addBtn;
	}
	
	//click on Add Attribute button
	@FindBy(how = How.XPATH, using ="//span[contains(@class,'icon-plus')]")
	@CacheLookup
	WebElement addAttrbBtn;
	
	public WebElement addAttrbBtn() 
	{
		return addAttrbBtn;
	}
	
	//Done Button
	@FindBy(how = How.ID, using ="NextButton")
	//@FindBy(how = How.XPATH, using ="//oj-button[@id='Done']")
	//@FindBy(how = How.XPATH, using ="//span[@class='oj-button-text' and contains(@text,'Done')]")
	@CacheLookup
	WebElement doneBtn;
	
	public WebElement doneBtn() 
	{
		return doneBtn;
	}
	
	//Done Button 2
	@FindBy(how = How.XPATH, using ="//oj-button[@id='Done']")
	//@FindBy(how = How.XPATH, using ="//span[@class='oj-button-text' and contains(@text,'Done')]")
	@CacheLookup
	WebElement doneBtn2;
	
	public WebElement doneBtn2() 
	{
		return doneBtn2;
	}
	
	//Update Button
	//@FindBy(how = How.XPATH, using ="//oj-button[@id='Done']")
	@FindBy(how = How.XPATH, using ="//span[contains(text(),'Update')]")
	//@FindBy(how = How.XPATH, using ="//span[@class='oj-button-text' and contains(@text,'Done')]")
	@CacheLookup
	WebElement updateBtn;
	
	public WebElement updateBtn() 
	{
		return updateBtn;
	}

	// Continue
	//@FindBy(how = How.XPATH, using ="//span[contains(@class,'oj-button-text') and contains(text(),'Continue')]")
	@FindBy(how = How.XPATH, using ="//span[contains(text(),'Continue')]")
	//@FindBy(how = How.XPATH, using ="//span[text()='Continue']")
	//By.xpath("//span[text()='Settings']")
	@CacheLookup
	WebElement continueBtn;	
	public WebElement continueBtn() 
	{
		return continueBtn;
	}
	
	//@FindBy(how = How.XPATH, using ="//span[contains(text(),'Continue')]")
	@FindBy(how = How.XPATH, using ="//span[text()='Continue']")
	@CacheLookup
	WebElement continueBtn2;	
	public WebElement continueBtn2() 
	{
		return continueBtn2;
	}

	//Search text field
	@FindBy(how = How.XPATH, using ="//*[starts-with(@id,'SearchBox')]")
	@CacheLookup
	WebElement searchField;	
	public WebElement searchField() 
	{
		return searchField;
	}		
		
	//Click on Search Icon
	//@FindBy(how = How.XPATH, using ="//*[contains(@title,'Search')]")
	@FindBy(how = How.XPATH, using ="//span[contains(@class,'icon-search')]")
	@CacheLookup
	WebElement searchIcon;	
	public WebElement searchIcon() 
	{
		return searchIcon;
	}
	
	//Search results
	@FindBy(how = How.XPATH, using ="//span[contains(@class,'list-text')]")
	@CacheLookup
	WebElement searchResult;	
	public WebElement searchResult() 
	{
		return searchResult;
	}
	
	//Search version list
	@FindBy(how = How.XPATH, using ="//span[contains(@class,'list-text')]")
	@CacheLookup
	WebElement versionsList;	
	public WebElement versionsList() 
	{
		return versionsList;
	}
	
	
	//Added Attribute name
	@FindBy(how = How.XPATH, using ="//span[contains(@class,'oj-choice-item')]")
	@CacheLookup
	WebElement fontFamilyName;	
	public WebElement fontFamilyName() 
	{
		return fontFamilyName;
	}
	
	//Added Attribute name
	@FindBy(how = How.XPATH, using ="//span[@class='sunrise-yellow set-value']")
	@CacheLookup
	WebElement addedAtrbName;	
	public WebElement addedAtrbName() 
	{
		return addedAtrbName;
	}
	
	//tree view/Expand Icon
	@FindBy(how = How.XPATH, using ="//span[contains(@class,'treeview-icon')]")
	@CacheLookup
	WebElement expandBtn;	
	public WebElement expandBtn() 
	{
		return expandBtn;
	}
	
	//Kebab/ellipsis menu
	@FindBy(how = How.XPATH, using ="//span[contains(@class,'icon-ellipsis-menu')]")
	@CacheLookup
	WebElement kebabMenu;	
	public WebElement kebabMenu() 
	{
		return kebabMenu;
	}
	
	//Kebab/ellipsis menu
	@FindBy(how = How.XPATH, using ="//span[contains(@class,'icon-ellipsis-menu')]")
	@CacheLookup
	WebElement kebabMenu2;	
	public WebElement kebabMenu2() 
	{
		return kebabMenu2;
	}
	//driver.findElement(By.xpath("//span[contains(@class,'icon-ellipsis-menu')]")).click();
	
	// Selecting 'go to details' option from kebab menu
	@FindBy(how = How.XPATH, using ="//span[text()='Go to Details']")
	@CacheLookup
	WebElement gotoDetails;	
	public WebElement gotoDetails() 
	{
		return gotoDetails;
	}
	
	//Selecting Edit option from kebab menu
	@FindBy(how = How.XPATH, using ="//span[text()='Edit']")
	@CacheLookup
	WebElement editOption;	
	public WebElement editOption() 
	{
		return editOption;
	}	
	
	//Selecting Move Up option from kebab menu
	@FindBy(how = How.XPATH, using ="//span[text()='Move Up']")
	@CacheLookup
	WebElement moveUpOption;	
	public WebElement moveUpOption() 
	{
		return moveUpOption;
	}
	
	//Selecting Move Down option from kebab menu
	@FindBy(how = How.XPATH, using ="//span[text()='Move Down']")
	@CacheLookup
	WebElement moveDownOption;	
	public WebElement moveDownOption() 
	{
		return moveDownOption;
	}
	
	//Selecting Delete option from kebab menu
	@FindBy(how = How.XPATH, using ="//span[text()='Delete']")
	@CacheLookup
	WebElement deleteOption;	
	public WebElement deleteOption() 
	{
		return deleteOption;
	}	
	
	//Selecting 'Create New Version option from kebab menu
	@FindBy(how = How.XPATH, using ="//span[text()='Create New Version']")
	@CacheLookup
	WebElement createNewVer;	
	public WebElement createNewVer() 
	{
		return createNewVer;
	}	
	
	//Yes button in confirmation window
	@FindBy(how = How.XPATH, using ="//span[contains(@class,'oj-button-text') and contains(text(),'Yes')]")
	@CacheLookup
	WebElement YesToConfirm;	
	public WebElement YesToConfirm() 
	{
		return YesToConfirm;
	}
	
	//Ok button in confirmation window
	@FindBy(how = How.XPATH, using ="//span[text()='OK']")
	@CacheLookup
	WebElement OkToConfirm;	
	
	public WebElement OkToConfirm() 
	{
		return OkToConfirm;
	}
	
	//Search result is empty
	@FindBy(how = How.XPATH, using ="//li[text()='No items to display.']")
	@CacheLookup
	WebElement NoItems;	
	
	public WebElement NoItems() 
	{
		return NoItems;
	}
	
	//BaseName text filed  for any any of the asset
	@FindBy(how = How.XPATH, using ="//*[starts-with(@id,'textinput')]")
	@CacheLookup
	WebElement baseNameField;	
	public WebElement baseNameField() 
	{
		return baseNameField;
	}	
	
	//Long Name text filed  for any any of the asset
	@FindBy(how = How.XPATH, using ="//*[starts-with(@id,'textArea')]")
	@CacheLookup
	WebElement longNameField;	
	public WebElement longNameField() 
	{
		return longNameField;
	}
	
	//Description field
	@FindBy(how = How.XPATH, using ="//*[starts-with(@id,'textArea')]")
	@CacheLookup
	WebElement descriptionField;	
	public WebElement descriptionField() 
	{
		return descriptionField;
	}
	
	//Base assets Description text filed  for any any of the asset
	@FindBy(how = How.TAG_NAME, using ="textarea")
	@CacheLookup
	private List<WebElement> baseDescriptionField;
	
	public List<WebElement> baseDescriptionField() 
	{
		return baseDescriptionField;
	}
	
	//VersionName	
	//Base assets Description text filed  for any any of the asset
	@FindBy(how = How.XPATH, using ="//*[starts-with(@id,'textinput')]")
	@CacheLookup
	WebElement versionNameField;
	
	public WebElement versionNameField() 
	{
		return versionNameField;
	}
	
	//Date filed  for any any of the asset
	@FindBy(how = How.XPATH, using ="//*[starts-with(@id,'fromDate')]")
	@CacheLookup
	WebElement dateField;
	
	public WebElement dateField() 
	{
		return dateField;
	}
	
	//Finish button	
	@FindBy(how = How.XPATH, using ="//span[text()='Finish' and @class='oj-button-text']")
	@CacheLookup
	WebElement finishBtn;
	
	public WebElement finishBtn() 
	{
		return finishBtn;
	}
	
	//Finish button	
	@FindBy(how = How.TAG_NAME, using ="h1")
	@CacheLookup
	WebElement assetTitle;
	
	public WebElement assetTitle() 
	{
		return assetTitle;
	}
	
	//exapand Identification
	//Finish button	
	@FindBy(how = How.XPATH, using ="//*[contains(@id,'Identification')]")
	@CacheLookup
	WebElement identification;
	
	public WebElement identification() 
	{
		return identification;
	}
	
	//wind name- attribute1
	@FindBy(how = How.XPATH, using ="//span[text()='Attribute 1']")
	@CacheLookup
	WebElement wndAttribute1;	
	public WebElement wndAttribute1() 
	{
		return wndAttribute1;
	}
	 //success message window
	@FindBy(how = How.XPATH, using ="//span[text()='Success!']")
	@CacheLookup
	WebElement wndSuccessMsg;
	
	public WebElement wndSuccessMsg() 
	{
		return wndSuccessMsg;
	}
	
}
