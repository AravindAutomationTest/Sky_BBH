package com.sky.pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BaseTest{

		WebDriver driver;
		//constructor
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		JavascriptExecutor js = (JavascriptExecutor) driver;


		public LoginPage(WebDriver lDriver)
		{
			this.driver=lDriver;
			
			PageFactory.initElements(driver,this);
		}
		
		@FindBy(id="username") WebElement uname;
		
		@FindBy(xpath="//input[@id='password']") WebElement pass;
		
		@FindBy(xpath="(//input[@id='Login'])[1]") WebElement loginButton;
	
		@FindBy(xpath="(//span[@class='uiImage'])[1]") WebElement logoutimage;
		
		@FindBy(xpath="(//a[normalize-space()='Log Out'])[1]") WebElement logoutclick;
		
		@FindBy(xpath="//*[contains(text(),'Launch New Order')]") WebElement launchneworder;
		
		@FindBy(xpath="//div[@class='slds-icon-waffle']") WebElement applauncher;
		
		@FindBy(className="appLauncherMenu") WebElement menu;
		
		@FindBy(xpath="//button[normalize-space()='View All']") WebElement viewAll;
		
		@FindBy(xpath="//input[@class='slds-input']") WebElement searchBar;
		@FindBy(xpath="//span[@title='All Apps']") WebElement allApps;

		@FindBy(xpath="//p[normalize-space()='360 View']") WebElement view360;
		@FindBy(xpath="//h1[.='360 View']") WebElement title360;
		@FindBy(xpath="//button[normalize-space()='Search...']") WebElement searchbtn;
		//@FindBy(xpath="//div[@type='search']") WebElement searchInput;
		//@FindBy(xpath="") WebElement searchInput;
		@FindBy(xpath="(//div[@role='option'])[4]") WebElement selectAccount;
		@FindBy(xpath="(//*[contains(@class,'btnLabel')])[8]") WebElement BillselectAction;
		@FindBy(xpath="//a[@aria-label='Change MOP']") WebElement selectchangemop;

		
		
		

		
		public void LoginPortal(String username,String password) throws Throwable {
			//loginclick.click();
			uname.sendKeys(username);
			pass.sendKeys(password);
			loginButton.click();
			Thread.sleep(5000);
		}
		
		public void logout()
		{
			logoutimage.click();
			logoutclick.click();
		}
		 public void clickLaunchNewOrder() {
		       // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		        wait.until(ExpectedConditions.visibilityOf(launchneworder));
		        launchneworder.click();// Using @FindBy element
		    }
		 public void launch360view() throws Throwable {
		        wait.until(ExpectedConditions.visibilityOf(applauncher));
		        applauncher.click();
		        wait.until(ExpectedConditions.visibilityOf(viewAll));
		        viewAll.click();
		        //scroll the page to view the 360
		        wait.until(ExpectedConditions.visibilityOf(allApps));
		        wait.until(ExpectedConditions.visibilityOf(searchBar));
		      //  wait.until(ExpectedConditions.visibilityOf(allApps));
		        searchBar.sendKeys("360");

		        wait.until(ExpectedConditions.visibilityOf(view360));
		        view360.click();
		        wait.until(ExpectedConditions.visibilityOf(title360));
		        

		 }
		 
		 public void  SearchPage(WebDriver lDriver)
			{
				this.driver=lDriver;
				
				PageFactory.initElements(driver,this);
			}
						
			public void searchContract() throws Throwable
			{
				wait.until(ExpectedConditions.visibilityOf(searchbtn));
				searchbtn.click();
				wait.until(ExpectedConditions.visibilityOf(selectAccount));
				selectAccount.click();//Here I have to script to search with contract
				//searchInput.click();
				Thread.sleep(1000);
				//searchInput.sendKeys("80016618");				
			}
			public void startMOPprocess() throws Throwable{
				wait.until(ExpectedConditions.visibilityOf(BillselectAction));
				BillselectAction.click();
				selectchangemop.click();
				

			}

	}
