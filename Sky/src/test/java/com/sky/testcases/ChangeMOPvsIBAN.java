package com.sky.testcases;



import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sky.pages.BaseTest;
import com.sky.pages.LoginPage;
import com.sky.pages.SearchPage;
import com.sky.utilities.ReadExcelFile;


public class ChangeMOPvsIBAN extends BaseTest {
	
	String fileName=System.getProperty("user.dir")+"\\TestData\\TestInfo.xlsx";
	String contractFile=System.getProperty("user.dir")+"\\TestData\\ContractInfo.xlsx";


	@Test(priority =1,dataProvider="LoginDataProvider")
	public void ChangeMOP(String userEmail,String userPwd) throws Throwable
	{
		LoginPage lp=new LoginPage(driver);
		//call the Login portal
		lp.LoginPortal(userEmail, userPwd);
		
		if(userEmail.equals("madhava.aravind.capgemini@bbhit.com") && userPwd.equals("Aravind012@!"))
		{
			System.out.println("Login Successful");
			Assert.assertTrue(true);
		}
		else
		{
			System.out.println("Test Failed");
			captureScreenShot(driver,"VerifyLogin");
			Assert.assertTrue(false);
		}
		lp.launch360view();
		
		//lp.searchContract();
		SearchPage sp = new SearchPage(driver);
		String contractnumber=ReadExcelFile.getCellValue(fileName, "ContractInfo", 0, 0);
		
	}
	@Test(priority=2)
	public void Entercontract() throws Throwable
	{
		LoginPage lp=new LoginPage(driver);
		lp.searchContract();
	}
	@Test(priority=3)
	public void clickchangeMOP() throws Throwable
	{
		LoginPage lp=new LoginPage(driver);
		lp.startMOPprocess();
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