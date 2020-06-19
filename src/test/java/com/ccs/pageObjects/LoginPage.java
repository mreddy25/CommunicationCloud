package com.ccs.pageObjects;

import org.openqa.selenium.By;
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
}
