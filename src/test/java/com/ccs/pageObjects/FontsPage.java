package com.ccs.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class FontsPage {
	//add web driver
		WebDriver ldriver;
		
		//add constructor
		public FontsPage(WebDriver rdriver)
		{
			ldriver=rdriver;
			PageFactory.initElements(rdriver, this);
		}


}
