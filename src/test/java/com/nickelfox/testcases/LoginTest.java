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

import java.time.Duration;

public class LoginTest {
    
    private WebDriver driver;
    private WebDriverWait wait;
    
    @BeforeClass
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.netflix.com/login");
        
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    
    @Test
    public void testLogin() {
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("userLoginId")));
        emailField.sendKeys("vkpatel14355@gmail.com");
        
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
        passwordField.sendKeys("Dream@14355");
        
        WebElement loginButton = driver.findElement(By.xpath("//button[@data-uia='login-submit-button']"));
        loginButton.click();
        
        System.out.println("Login button clicked successfully!");
        
        // Validate login (Example: Check for error message or dashboard)
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        // Add assertion (modify according to actual application behavior after login)
        WebElement profileIcon = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class, 'profile-gate-label')]")));
        Assert.assertNotNull(profileIcon, "Login failed - Profile icon not found");
    }
    
    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
