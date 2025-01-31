package com.nickelfox.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

public class LoginTest {
    
    private WebDriver driver;
    private WebDriverWait wait;
    
    @BeforeClass
    public void setUp() {
    	WebDriverManager.firefoxdriver().setup();

		FirefoxOptions options = new FirefoxOptions();
		options.addArguments("start-maximized"); // open Browser in maximized mode
		options.addArguments("--disable-infobars"); // disabling infobars
		options.addArguments("--disable-extensions"); // disabling extensions
		options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
		options.addArguments("--no-sandbox");// Bypass OS security model
		options.addArguments("--disable-gpu"); // applicable to windows os only
		//options.addArguments("--headless");
		options.addArguments("--window-position=1920,1080");
		options.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) FireFox/134.0.2 Chrome/87.0.4280.88 Safari/537.36");

	
		driver = new FirefoxDriver(options=options);
		driver.manage().window().maximize();
		  driver.get("https://www.netflix.com/login");
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String strTitle=driver.getTitle();
		System.out.println("Title =" + " " + strTitle);
		System.out.println("user navigate to the website");
  
        
      
    }
    
    @Test
    public void testLogin() throws InterruptedException {
    	 WebElement emailField = driver.findElement(By.name("userLoginId"));
         emailField.sendKeys("vkpatel14355@gmail.com");
         System.out.println("enter the email id");

         // Locate the password input field and enter the password
         WebElement passwordField = driver.findElement(By.name("password"));
         passwordField.sendKeys("Dream@14355");
         System.out.println("enter the password");
         
         // Locate the Sign In button and click it
         WebElement signInButton = driver.findElement(By.xpath("//button[@type='submit']"));
         signInButton.click();
         System.out.println("click on the button");

         // Wait for a few seconds (you can use WebDriverWait for better synchronization)
         Thread.sleep(5000);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        
    
    }
}
