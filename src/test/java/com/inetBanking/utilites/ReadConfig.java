package com.inetBanking.utilites;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
		
	Properties po;
	
	public ReadConfig()
	{
		File f= new File("./Configuration/Config.properties");     
		
		try {
			FileInputStream fs= new FileInputStream(f);
			po = new Properties();
			po.load(fs);
			
			
			
		}catch(Exception e)
		{
			System.out.println("Exception is"+e.getMessage());
		}
	}
	// here we are get all details from config.poperties
	public  String getApllicationURL()
	{
		String pro= po.getProperty("baseurl");
		return pro;
	}
	
	public  String getUserNmae()
	{
		String usr= po.getProperty("usernamee");
		return usr;
	}
	
	public  String getPassword()
	{
		String pas= po.getProperty("pass");
		return pas;
	}
	
	public  String getPath()
	{
		String path= po.getProperty("ChromePath");
		return path;
	}
	
}
