package com.ccs.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.ccs.utilities.ReadConfig;
//import org.testng.log4testng.Logger;


public class BaseClass {
	
	ReadConfig readconfig=new ReadConfig();
	
	//login details
	public String baseURL=readconfig.getApplicationURL();
	public String username=readconfig.getUsername();
	public String password=readconfig.getPassword();
	
	//Config ID
	
	public String configID=readconfig.getConfigID();
	//Content details
	public String contsearchinput=readconfig.getContSearchInput();
	public String bcontantname=readconfig.getBcontName();
	public String bcontlongname=readconfig.getBcontLongName();
	public String bcontdesc=readconfig.getBcontDesc();
	
	public static WebDriver driver; 
	public static Logger logger;
	
	@Parameters("browser")//this parameter is to be specified in xml file
	@BeforeClass
	public void setup(String br)
	{
		//for logs 
		logger = Logger.getLogger("ccs");
		PropertyConfigurator.configure("Log4j.properties");
		
		if(br.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
			driver = new ChromeDriver();
		}
		else if(br.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",readconfig.getFirefoxPath());
			driver = new FirefoxDriver();
			
			//FirefoxOptions firefoxOptions = new FirefoxOptions();
			//firefoxOptions.setCapability("marionette", true);
			//driver = new FirefoxDriver(firefoxOptions);
			
		}
		else if(br.equals("ie"))
		{
			System.setProperty("webdriver.ie.driver",readconfig.getIEPath());
			driver = new InternetExplorerDriver();
		}
				
		//maximize the browser and page load
		driver.manage().window().maximize();
		//driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		//driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//enter base URL
		//driver.get(baseURL);
		//logger.info("Browser is opened with the URL: "+ baseURL);
	}
		
	@AfterClass
	public void tearDown()
	{
		driver.quit();
		//logger.info("Browser is closed ");
		
	}
	
	//this method to be called whenever the test method failed
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	
	public String randomestring()
	{
		String generatedstring = RandomStringUtils.randomAlphabetic(8);
		return(generatedstring);
	}
	
	public String randomeNum()
	{	
		String generatedstring2 = RandomStringUtils.randomNumeric(4);
		return(generatedstring2);
	}

}
