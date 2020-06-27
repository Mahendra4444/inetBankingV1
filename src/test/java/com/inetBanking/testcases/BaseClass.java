package com.inetBanking.testcases;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetBanking.utilites.ReadConfig;

public class BaseClass {
	
	ReadConfig readconfig = new ReadConfig();
	
	public String baseurl=readconfig.getApllicationURL();
	public String usernamee=readconfig.getUserNmae();
	public String pass=readconfig.getPassword();
	public static WebDriver driver;
	public static Logger logger;
	//public String baseurl="http://demo.guru99.com/v3/index.php";
	//public String usernamee="1303";
	//public String pass="Guru99";
	
	
	
	@Parameters("browser")
	@BeforeClass
	public void setup()
	{
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Driver//chromedriver.exe");
		logger= Logger.getLogger("ebanking");
		PropertyConfigurator.configure("log4j.properties");
		System.setProperty("webdriver.chrome.driver",readconfig.getPath());
		driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		 
	}
	
	// if you run different browsers
//	public void setup(String br)
//	{
//		
//		logger=Logger.getLogger("ebanking");
//		PropertyConfigurator.configure("log4j.properties");
//		
//		if(br.equals("chrome"))
//		{
//			System.setProperty("webdriver.chrome.driver",readconfig.getPath());
//			driver=new ChromeDriver();
//		}
//		driver.get(baseurl);
//	}
		//else if(br.equals("firefox")) 
		//{
		//		System.setProperty("webdriver.chrome.driver",readconfig.getPath());
		//		driver=new ChromeDriver();
		//}
		//else if(br.equals("ie")) 
		//{
		//		System.setProperty("webdriver.chrome.driver",readconfig.getPath());
		//		driver=new ChromeDriver();
		//}
		
	
			
	@AfterClass
	public void tearDown()
	{
		//driver.quit();
	}

}
