package com.ccs.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LayoutPage {
	//add web driver
		WebDriver ldriver;
		
		//add constructor
		public LayoutPage(WebDriver rdriver)
		{
			ldriver=rdriver;
			PageFactory.initElements(rdriver, this);
		}

		//@FindBy(how = How.ID, using ="landingFilterSearch_SearchBox|input")
		@FindBy(how = How.ID, using ="_ojcustomelem13_SearchBox|input")
		@CacheLookup
		WebElement txtInputSearch;
		
		@FindBy(how = How.ID, using ="[['viewAllButton'+$unique]]")
		@CacheLookup
		WebElement btnViewAll;
		
		public void ViewAllBtn() 
		{
			btnViewAll.click();
		}
		
		public void txtInputSearch(String contsearchinput)
		{
			txtInputSearch.sendKeys(contsearchinput);
			
		}
		


}
