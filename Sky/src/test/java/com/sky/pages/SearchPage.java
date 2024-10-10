package com.sky.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	WebDriver driver;
	//constructor
		public SearchPage(WebDriver lDriver)
		{
			this.driver=lDriver;
			
			PageFactory.initElements(driver,this);
			
		}
		
		@FindBy(xpath="//button[normalize-space()='Search...']") WebElement searchInput;
		
		
		
		public void serachContract(String SerachCon) throws Throwable
		{
			searchInput.click();
			Thread.sleep(2000);
			searchInput.sendKeys(SerachCon);
			//Click Enter
			//searchInput.sendKeys(Keys.RETURN);
			
		}
	
}
