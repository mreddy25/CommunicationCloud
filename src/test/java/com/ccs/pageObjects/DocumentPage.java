package com.ccs.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class DocumentPage {
	
	//add web driver
		WebDriver ldriver;
		
		//add constructor
		public DocumentPage(WebDriver rdriver)
		{
			ldriver=rdriver;
			PageFactory.initElements(rdriver, this);
		}
		
		
}
