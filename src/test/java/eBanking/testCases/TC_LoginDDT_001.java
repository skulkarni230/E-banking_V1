package eBanking.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import eBanking.pageObject.LoginPage;
import eBanking.utilities.XLUtility;

public class TC_LoginDDT_001 extends BaseClass {

	@Test(dataProvider = "LoginData")
	public void loginDDT(String user, String password) {

		driver.get(baseURL);
		logger.info("Page Opened Successfully");
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(user);
		logger.info("username added");
		lp.setPassword(password);
		logger.info("password added");
		lp.clickLogin();
		logger.info("clicked on login button");

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
		
		
	}
	
	public boolean isAleartPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	

	@DataProvider(name = "LoginData")
	String[][] getData() throws IOException {
		String path = "D:\\Selenium Setup\\UPC2.0\\E-Banking_V1\\src\\test\\java\\eBanking\\testData\\data.xlsx";
		XLUtility xlutil = new XLUtility(path);
		int rowNum = xlutil.getRowCount("Sheet1");
		
		int colCount = xlutil.getCellCount("Sheet1", 1);
		

		String logindata[][] = new String[rowNum][colCount];

		for (int i = 1; i <= rowNum; i++) {

			for (int j = 0; j < colCount; j++) {

				logindata[i - 1][j] = xlutil.getCellData("Sheet1", i, j);

			}
		}
		return logindata;
	}

}
