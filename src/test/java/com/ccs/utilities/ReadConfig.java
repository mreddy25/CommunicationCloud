package com.ccs.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro;
	
	//create constructer
	public ReadConfig()
	{
		File src = new File("./configuration/config.properties");

		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
	}

	//create methods for each variable to read
	//getApplicationURL method
	public String getApplicationURL()
	{
		String url=pro.getProperty("baseURL");
		return url;
	}
	
	//username method
	public String getUsername()
	{
	String username=pro.getProperty("username");
	return username;
	}
	
	//password
	public String getPassword()
	{
	String password=pro.getProperty("password");
	return password;
	}
	public String getContSearchInput()
	{
	String contsearchinput=pro.getProperty("contsearchinput");
	return contsearchinput;
	}
	
	
	public String getBcontName()
	{
	String bcontantname=pro.getProperty("bcontantname");
	return bcontantname;
	}
	
	public String getBcontLongName()
	{
	String bcontlongname=pro.getProperty("bcontlongname");
	return bcontlongname;
	}
	
	public String getBcontDesc()
	{
	String bcontdesc=pro.getProperty("bcontdesc");
	return bcontdesc;
	}
	
	//chrome browser method
	public String getChromePath()
	{
	String chromepath=pro.getProperty("chromepath");
	return chromepath;
	}
	
	
	//firefox browser path method
	public String getFirefoxPath()
	{
	String firefoxpath=pro.getProperty("firefoxpath");
	return firefoxpath;
	}
	
	public String getIEPath()
	{
	String iepath=pro.getProperty("iepath");
	return iepath;
	}
	
	//if you add any variable in config.propeties file, you need to add the method for that variable in below
}
