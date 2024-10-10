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
import com.sky.utilities.ReadExcelFile;


public class LoginTestDataDrivenTesting extends BaseTest {
	
	String fileName=System.getProperty("user.dir")+"\\TestData\\TestInfo.xlsx";
//	String contractFile=System.getProperty("user.dir")+"\\TestData\\ContractInfo.xlsx";


	@Test(priority =1,dataProvider="LoginDataProvider")
	public void VerifyLogin(String userEmail,String userPwd) throws Throwable
	{
		LoginPage lp=new LoginPage(driver);
//		String username ="Demo12";
//		String password ="Test123456$";
		//call the Login portal
		lp.LoginPortal(userEmail, userPwd);
		
		if(userEmail.equals("madhava.aravind.capgemini@bbhit.com") && userPwd.equals("Aravind012@!"))
		{
			System.out.println("Test Passed");
			Assert.assertTrue(true);
			Thread.sleep(5000);
			//call the logout once login is successful
			//lp.logout();
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Launch New Order')]")));
			
		}
		else
		{
			System.out.println("Test Failed");
			captureScreenShot(driver,"VerifyLogin");
			Assert.assertTrue(false);
		}
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
//	@DataProvider(name="ContractProvider ")
//	public String[][] ContractProvider()
//	{
//		
//		
//		int ttlRows= ReadExcelFile.getRowCount(contractFile, "LoginData");
//		int ttlColumns= ReadExcelFile.getColCount(contractFile, "LoginData");
//		
//		String data[][]= new String[ttlRows-1][ttlColumns];
//		
//		for(int i=1;i<ttlRows;i++)
//		{
//			for(int j=0;j<ttlColumns;j++)
//			{
//				data[i-1][j]=ReadExcelFile.getCellValue(contractFile, "LoginData", i, j);
//		}
//		}
//		return data;
//	}
//	
//	
//	
	
}