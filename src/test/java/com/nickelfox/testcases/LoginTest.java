package com.nickelfox.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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
    	WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized"); // open Browser in maximized mode
		options.addArguments("--disable-infobars"); // disabling infobars
		options.addArguments("--disable-extensions"); // disabling extensions
		options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
		options.addArguments("--no-sandbox");// Bypass OS security model
		options.addArguments("--disable-gpu"); // applicable to windows os only
		options.addArguments("--headless");
		options.addArguments("--window-position=1920,1080");
		options.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.88 Safari/537.36");
	
		driver = new ChromeDriver(options=options);
		driver.manage().window().maximize();
		  driver.get("https://www.netflix.com/login");
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String strTitle=driver.getTitle();
		System.out.println("Title =" + " " + strTitle);
		System.out.println("user navigate to the website");
        driver.get("https://www.netflix.com/login");
        
      
    }
    
    @Test
    public void testLogin() throws InterruptedException {
    	Thread.sleep(5000);
    	WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("userLoginId")));
        emailField.sendKeys("vkpatel14355@gmail.com");
        Thread.sleep(5000);
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
        passwordField.sendKeys("Dream@14355");
        Thread.sleep(5000);
        WebElement loginButton = driver.findElement(By.xpath("//button[@data-uia='login-submit-button']"));
        loginButton.click();
        
        System.out.println("Login button clicked successfully!");
        
        // Validate login (Example: Check for error message or dashboard)
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        
    }
    
    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
