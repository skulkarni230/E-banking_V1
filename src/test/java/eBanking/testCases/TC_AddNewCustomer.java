package eBanking.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import eBanking.pageObject.AddCustomerPage;
import eBanking.pageObject.LoginPage;

public class TC_AddNewCustomer extends BaseClass {
	
	
	
	@Test
	public void addCustomerTest() throws IOException, InterruptedException
	{
		LoginPage lp = new LoginPage(driver);
		AddCustomerPage ac = new AddCustomerPage(driver);
		driver.get(readconfig.getURL());
		lp.setUserName(readconfig.getUserName());
		lp.setPassword(readconfig.getPassword());
		lp.clickLogin();
		logger.info("Clicked on login button");
		
		if (isAleartPresent() == true) {
			logger.warn("Either credentials are expired or invalid");
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			
		} else {
			Assert.assertTrue(true);
			logger.info("logged in successfully");			
		}
	
		
		
		
		
		//Thread.sleep(3000L);
		/*
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30)
					if(wait.until(ExpectedConditions)))
		}*/
		/*//To close advertisement
		driver.switchTo().frame(driver.findElement(By.id("ad_iframe")));
		driver.findElement(By.id("dismiss-button")).click();
		driver.switchTo().defaultContent();*/
		
		/*if (isAleartPresent() == true) {
			driver.switchTo().alert().dismiss();
			driver.switchTo().defaultContent();
			//driver.switchTo().
		}*/
		
				
		ac.clickAddNewCustomer();
		ac.custname("Harsha Mittal");
		logger.info("Entered Name");
		ac.custdgender("male");
		logger.info("Selected Gender");
		ac.custdob("23", "12", "1994");
		logger.info("Entered DOB");
		ac.custdaddress("78 Dalal street");
		logger.info("Entered Address");
		ac.custcity("Mumbai");
		logger.info("Entered City");
		ac.custstate("Maharashtra");
		logger.info("Entered State");
		ac.custpin("413007");
		logger.info("Entered PIN");
		ac.custmobile("8881212");
		logger.info("Entered MOB");
		String email = randomString()+"@gamil.com";
		ac.custmail(email);
		logger.info("Entered Mail");
		
		ac.custpassword("Hello");
		logger.info("Entered Password");
		ac.clickSubmit();
		logger.info("Clicked on Submit");
	
		boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("Customer created Successfully");
			
		}
		else
		{
			captureScreen(driver,"addCustomerTest");
			Assert.assertTrue(false);
			logger.info("Error Occured");
		}
		
		
	}
	
	
	
	

}
