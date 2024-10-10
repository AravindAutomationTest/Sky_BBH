package com.sky.testcases;



import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sky.pages.BaseTest;
import com.sky.pages.LoginPage;
import com.sky.utilities.ReadExcelFile;

public class LoginTest extends BaseTest{
	String fileName = System.getProperty("user.dir")+"\\Testdata\\TestInfo.xlsx";
	@Test(priority =1,dataProvider="LoginDataProvider")
	void verifyLogin(String username ,String password ) throws Throwable {
		LoginPage lp = new LoginPage(driver);
//		String username="madhava.aravind.capgemini@bbhit.com";
//		String password="Aravind012@!";
		lp.LoginPortal(username,password);
		Thread.sleep(5000);
		lp.logout();
		
		
	}
	@DataProvider(name="LoginDataProvider")
	public String[][] LoginDataProvider()
	{
		
		
		int ttlRows= ReadExcelFile.getRowCount(fileName, "LoginData");
		int ttlColumns= ReadExcelFile.getColCount(fileName, "LoginData");
		
		String data[][]= new String[ttlRows-1][ttlColumns];
		
		for(int i=1;i<ttlRows;i++)
		{
			for(int j=0;j<ttlColumns;j++)
			{
				data[i-1][j]=ReadExcelFile.getCellValue(fileName, "LoginData", i, j);
			}
		}
		return data;
	}
}
