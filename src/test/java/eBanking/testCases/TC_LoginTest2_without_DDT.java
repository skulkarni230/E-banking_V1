package eBanking.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import eBanking.pageObject.LoginPage;

public class TC_LoginTest2_without_DDT extends BaseClass {

	//This test case repeats as per the count given here in invocation count
	//In this test case I have eliminated use of Data Provider by using randomString method
	@Test(invocationCount = 2)
	public void loginTest() throws IOException {

		{

			driver.get(baseURL);
			logger.info("Page Opened Successfully");

			String uname1 = randomString() + "@gamil.com";
			String pass1 = randomString();
			LoginPage lp = new LoginPage(driver);
			lp.setUserName(uname1);
			System.out.println(uname1);
			logger.debug("Entered UserName");
			lp.setPassword(pass1);
			System.out.println(pass1);
			logger.debug("Entered Password");
			lp.clickLogin();
			logger.debug("Clicked on login button");

			if (isAleartPresent() == true) {
				driver.switchTo().alert().accept();
				driver.switchTo().defaultContent();
				Assert.assertTrue(false);
				logger.warn("wrong credentials");
			} else {
				Assert.assertTrue(true);
				logger.info("logged in successfully");
				lp.clickLogout();
				logger.info("logged out successfully");
				driver.switchTo().alert().accept();
				driver.switchTo().defaultContent();
			}

			if (driver.getTitle().equalsIgnoreCase("Guru99 Bank Manager HomePage")) {
				Assert.assertTrue(true);
				logger.info("Logged in Succesfully");
			} else {
				captureScreen(driver, "loginTest");
				Assert.assertTrue(false);
				logger.error("Login Failed");

			}
		}
	}
}
