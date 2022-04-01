package eBanking.dataProviders;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import eBanking.utilities.XLUtility;

public class dataProviderArray {
	
	@DataProvider(name = "LoginData")
	
	public String[][] getData() throws IOException {
		String path = "./\\src\\test\\java\\eBanking\\testData\\data.xlsx";
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
