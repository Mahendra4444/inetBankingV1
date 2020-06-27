package com.inetBanking.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;

public class TC_Logintest_001 extends BaseClass
{

	@Test
	public void loginTest()
	{
		
		driver.get(baseurl);
		//driver.manage().window().maximize();
		logger.info("URL is opened");
		LoginPage lp= new LoginPage(driver);
		lp.setUserName(usernamee);
		logger.info("Enter UserName");
		lp.setPassword(pass);
		logger.info("Enter Password");
		lp.clickSubmit();
		
		
		if(driver.getTitle().equals("Guru99 bank manager"))
		{
			Assert.assertTrue(true);
			logger.info("Login test passed");
		}
		else
		{
			Assert.assertFalse(false);
			logger.info("Login test failed");
		}
		
	}
}
