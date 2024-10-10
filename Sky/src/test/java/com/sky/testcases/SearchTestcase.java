package com.sky.testcases;

import org.testng.annotations.Test;

import com.sky.pages.BaseTest;
import com.sky.pages.LoginPage;
import com.sky.pages.SearchPage;
import com.sky.utilities.ReadExcelFile;

public class SearchTestcase extends BaseTest {
	String fileName=System.getProperty("user.dir")+"\\TestData\\TestInfo.xlsx";
	//String contractFile=System.getProperty("user.dir")+"\\TestData\\Test.xlsx";

@Test
	void searchContract() throws Throwable{
		
	
	LoginPage lp=new LoginPage(driver);
	String username=ReadExcelFile.getCellValue(fileName, "LoginData", 1, 0);
	String password=ReadExcelFile.getCellValue(fileName, "LoginData", 1, 1);
	lp.LoginPortal(username, password);
	lp.launch360view();
	
	SearchPage sp = new SearchPage(driver);
	String serachCon =ReadExcelFile.getCellValue(fileName, "ContractInfo", 0, 0);
	System.out.println("display the contract "+serachCon);
	sp.serachContract(serachCon);
//

}}
