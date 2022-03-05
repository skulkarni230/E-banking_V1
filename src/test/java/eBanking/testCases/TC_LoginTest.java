package eBanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import eBanking.pageObject.LoginPage;

public class TC_LoginTest extends BaseClass {

	@Test
	public void loginTest() throws IOException {
		driver.get(baseURL);
		logger.info("Page Opened Successfully");
		/*if (driver.getTitle().equals("Guru99 Demo Sites")) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}*/
		
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		System.out.println(username);
		logger.debug("Entered UserName");
		lp.setPassword(password);
		System.out.println(password);
		logger.debug("Entered Password");
		lp.clickLogin();
		logger.debug("Clicked on login button");

		if (driver.getTitle().equalsIgnoreCase("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
			logger.info("Logged in Succesfully");
		} else {
			captureScreen(driver,"loginTest");
			Assert.assertTrue(false);
			logger.error("Login Failed");
			
			
		}
	}

}
