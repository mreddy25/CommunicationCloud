package com.ccs.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver ldriver;
public LoginPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	
	}

//By detailButton = By.id("details-button");

/*public void cliclkdetailBtn()
{
	driver.findElement(detailButton).c
	this.click(detailButton);
}*/
	//@FindBy(id="details-button")
	//@CacheLookup
	//WebElement detailBtn;
	
	@FindBy(id="details-button")
	@CacheLookup
	WebElement detailsBtn;
	
	@FindBy(id="details-button")
	@CacheLookup
	private List<WebElement> noDetaislBtn;
	
	@FindBy(id="proceed-link")
	@CacheLookup
	WebElement proceedLnk;
	
	@FindBy(id="proceed-link")
	@CacheLookup
	private List<WebElement> noProceedLnk;

	@FindBy(how = How.XPATH, using ="//div[@class='oj-flex-item oj-sm-12']/input")
	@CacheLookup
	WebElement txtUserName;
	
	@FindBy(id="idcs-signin-basic-signin-form-password|input")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(how = How.XPATH, using ="//oj-button[@id='idcs-signin-basic-signin-form-submit']")
	@CacheLookup
	WebElement signInBtn;
	
	@FindBy(how = How.XPATH, using ="//li[text()='Dashboard']")
	@CacheLookup
	WebElement loginSuccess;
	
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
	
	public WebElement detailBtn()
	{
		return detailsBtn;
	}
	public List<WebElement> noDetaislBtn()
	{
		return noDetaislBtn;
	}
	
	public WebElement proceedLnk()
	{
		return proceedLnk;
	}
	
	public List<WebElement> noProceedLnk()
	{
		return noProceedLnk;
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
	
	public WebElement loginSuccess() 
	{
		return loginSuccess;
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
