package com.nickelfox.baseclass;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestResult;

import org.testng.annotations.AfterMethod;


import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public WebDriver driver;
	//@BeforeMethod()
	public void launcTheBrowser() throws InterruptedException  {

		//WebDriverManager.firefoxdriver().setup();
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
		driver.get("https://nickelfox.com/");
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String strTitle=driver.getTitle();
		System.out.println("Title =" + " " + strTitle);
		System.out.println("user navigate to the website");




	}

	@AfterMethod 
	public void tearDown(ITestResult result) throws InterruptedException {
		if(ITestResult.FAILURE==result.getStatus()){
			try{

				TakesScreenshot screenshot=(TakesScreenshot)driver;
				File src=screenshot.getScreenshotAs(OutputType.FILE);
				String timestamp = new SimpleDateFormat("yyyy-MM-dd--hh-mm").format(new Date());
				FileUtils.copyFile(src, new File (".\\Screenshots\\"  +" "+ timestamp +".png"));
				System.out.println("Successfully captured a screenshot");
			}catch (Exception e){
				System.out.println("Exception while taking screenshot "+e.getMessage());
			} 
		}
		Thread.sleep(5000);
		//driver.quit();
	}
}	














