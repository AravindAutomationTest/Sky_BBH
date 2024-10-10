package com.sky.pages;


import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.sky.utilities.BrowserFactory;
import com.sky.utilities.ConfigDataProvider;

public class BaseTest {

	public WebDriver driver;
	public ConfigDataProvider config = new ConfigDataProvider();
//	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));

	@BeforeClass
	public void setUp()
	{
		driver=BrowserFactory.startApplication(driver,config.getBrowser(),config.getStagingUrl());
	}
	
// @AfterClass
//	public void tearDown()
//	{
//		BrowserFactory.quitBrowser(driver);
//	}
	 public void captureScreenShot(WebDriver driver,String testName) throws IOException
	 {
		 // Convert webdriver object to TakesScreenshot interface
		 TakesScreenshot screenshot= ((TakesScreenshot)driver);
		 
		 // Step 2 :call getScreenshotAs method to capture image file
		 
		 File src= screenshot.getScreenshotAs(OutputType.FILE);
		 File srcpath=new File("."+"//Screenshots//"+ testName + ".png");
		 
		 // Step 3 : copy image file to destination 
		 FileUtils.copyFile(src, srcpath);
		 
	 }
}
