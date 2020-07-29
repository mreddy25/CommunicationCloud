package com.ccs.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver ldriver;
public LoginPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	
	}

	@FindBy(id="details-button")
	@CacheLookup
	WebElement detailBtn;
	
	@FindBy(id="proceed-link")
	@CacheLookup
	WebElement proceedLnk;

	@FindBy(how = How.XPATH, using ="//div[@class='oj-flex-item oj-sm-12']/input")
	@CacheLookup
	WebElement txtUserName;
	
	@FindBy(id="idcs-signin-basic-signin-form-password|input")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(how = How.XPATH, using ="//oj-button[@id='idcs-signin-basic-signin-form-submit']")
	@CacheLookup
	WebElement signInBtn;
	
	@FindBy(id="signoff")
	@CacheLookup
	WebElement lnkSignoff;
	
	@FindBy(how = How.ID, using ="drawerToggleButton")
	@CacheLookup
	WebElement toggleBtn;
	//hambBtn
	
	@FindBy(id="configuration")
	@CacheLookup
	WebElement lnkConfig;
	
	@FindBy(id="communicationLanding")
	@CacheLookup
	WebElement lnkCommLand;	
	
	@FindBy(id="configLanding/CommunicationContentConfig")
	@CacheLookup
	WebElement lnkContConfig;
	
	@FindBy(id="configLanding/CommunicationDocumentConfig")
	@CacheLookup
	WebElement lnkDocConfig;	
	
	@FindBy(id="configLanding/CommunicationPackageConfig")
	@CacheLookup
	WebElement lnkPackConfig;
	
	@FindBy(id="configLanding/CommunicationLayoutConfig")
	@CacheLookup
	WebElement lnkLayoutConfig;
	
	@FindBy(id="CommunicationAttributes")
	@CacheLookup
	WebElement lnkAtrbConfig;
	
	@FindBy(id="configLanding/CommunicationFontConfig")
	@CacheLookup
	WebElement lnkComFontConfig;

	@FindBy(id="configLanding/CommunicationStyleConfig")
	@CacheLookup
	WebElement lnkComStyleConfig;

	@FindBy(id="configLanding/CommunicationRoleConfig")
	@CacheLookup
	WebElement lnkComRoleConfig;
		
	//Methods	
	public void clkkdetailBtn()
	{
		detailBtn.click();	
	}
	
	public void clkproceedLink()
	{
		proceedLnk.click();
	}
	public void setUserName(String uname)
	{
		txtUserName.sendKeys(uname);	
	}

	public void setPassword(String pwd)
	{
		txtPassword.sendKeys(pwd);	
	}
	public void clickSignin()
	{
		signInBtn.click();	
	}
	public void clickSignoff()
	{
		lnkSignoff.click();
	}
	public void cliktogbtn() 
	{
		toggleBtn.click();
	}
	public void clikconfiglnk() 
	{
		lnkConfig.click();
	}
	public void clikcommlnk() 
	{
		lnkCommLand.click();
	}
	public void clikComContConflnk() 
	{
		lnkContConfig.click();
	}
	public void clikComDocConflnk() 
	{
		lnkDocConfig.click();
	}
	public void clikComPackConflnk() 
	{
		lnkPackConfig.click();
	}
	public void clikComLayConflnk() 
	{
		lnkLayoutConfig.click();
	}
	public void clikAtrbConflnk() 
	{
		lnkAtrbConfig.click();
	}
	public void clikAtrbFontConflnk() 
	{
		lnkComFontConfig.click();
	}
	public void clikAtrbStyleConflnk() 
	{
		lnkComStyleConfig.click();
	}
	public void clikAtrbRoleConflnk() 
	{
		lnkComRoleConfig.click();
	}
	

}
