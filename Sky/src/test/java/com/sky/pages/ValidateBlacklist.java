package com.sky.pages;


	import java.util.Random;

import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;

	public class ValidateBlacklist {
		
		
	    public static void main(String[] args) {
	        // Set the path for the ChromeDriver (replace with your path)
	        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
	        Random randomGenerator = new Random();
			String randomInt = String.format("%04d", randomGenerator.nextInt(10000));

	        // Initialize WebDriver
	        WebDriver driver = new ChromeDriver();

	        try {
	            // Open the target web page
	            driver.get("https://example.com");

	            // Locate the input field
	            WebElement inputField = driver.findElement(By.xpath("//*[contains(@id,'input19-')]"));

	            // Enter the initial value
	            inputField.sendKeys("4139981"+randomInt);

	            // Locate and click the Validate button
	            WebElement validateButton = driver.findElement(By.xpath("//button[contains(.,'Validate Blacklist')]"));
	            validateButton.click();

	            // Verify if the message is successful
	            WebElement messageElement = driver.findElement(By.xpath("(//*[contains(@id,'comboboxId-')])[3]"));
	            String messageText = messageElement.getText();

	            // Loop until the message is successful
	            while (!messageText.equals("No")) {
	                // If not successful, clear the field, enter a new value, and try again
	                inputField.clear();
	                inputField.sendKeys("4139982"+randomInt); // Adjust the new value as needed
	                validateButton.click();

	                // Re-fetch the message after clicking Validate again
	                messageElement = driver.findElement(By.xpath("(//*[contains(@id,'comboboxId-')])[3]"));
	                messageText = messageElement.getText();
	            }

	            // Once the message is successful, locate and click the Proceed button
	            WebElement proceedButton = driver.findElement(By.id("proceedButtonId"));
	            proceedButton.click();

	            System.out.println("Process completed successfully!");
	            
	        } finally {
	            // Close the browser after completing the test
	            driver.quit();
	        }
	    }
	}


