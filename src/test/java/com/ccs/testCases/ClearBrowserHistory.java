package com.ccs.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class ClearBrowserHistory extends BaseClass{
	@Test
	public void ClearBrowHistory() throws InterruptedException, IOException {
		
	   driver.get("chrome://settings/clearBrowserData");  
	   driver.findElement(By.xpath("//settings-ui")).sendKeys(Keys.ENTER);
	   logger.info("Browser Data: Clear history, CCookies and Cache are cleared ");
	   Thread.sleep(3000);
		
/*		
		driver.get("chrome://settings/clearBrowserData");
		
		 wait = WebDriverWait(driver, timeout)
				    wait.until(get_clear_browsing_button)
		logger.info("Browser history url");
		driver.switchTo().window(parentWindow);
				
		WebElement  dropdown = driver.findElement(By.xpath("//*[@class='md-select']"));
		
		driver.findElement(By.xpath("//*[@class='md-select']")).click();
		logger.info("clicked selected");
		Select select= new Select(dropdown);
		//select.selectByValue("All time");
		select.selectByVisibleText("All time");
		
		
		logger.info("Browser history value selected");
		driver.findElement(By.id("clearBrowsingDataConfirm")).click();
		Thread.sleep(8000);
		*/
	
		
		
	}
}
