package com.nickelfox.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Career_Page {

	@FindBy(xpath = "//li[@id='menu-item-29684']//a[normalize-space()='Careers']")
	WebElement linkCareer;


	@FindBy(xpath = "//span[contains(text(),'Business Development & Sales')]")
	WebElement lableBDS;

	@FindBy(xpath = "//div[@class='elementor-element elementor-element-777fe0e elementor-widget elementor-widget-html']//div[@class='current-opening__meta']")
	WebElement linkBADArrow;

	@FindBy(xpath = "//*[@id=\"detail-page-applybtn\"]/button/lyte-yield")
	WebElement intrsted_Btn;

	//*[@id=\"detail-page-applybtn\"]/button/lyte-yield")).click()

	@FindBy(xpath = "//lyte-dropdown[@id='630525000000063600']//lyte-icon[@class='dropdown']\r\n")
	WebElement surname;

	@FindBy(xpath = "//div[@class='jd-timeline cw-top-border']//div[1]//div[1]//div[1]//div[1]//crux-text-component[1]//div[1]//lyte-input[1]//div[1]//input[1]")
	WebElement firstName;

	@FindBy(xpath = "//lyte-input[@id='630525000000063544']//input[contains(@type,'text')]")
	WebElement txtLastName;

	@FindBy(xpath = "//lyte-input[@id='rec-form_630525000000063554_input']//input[contains(@type,'text')]")
	WebElement txtMobileNumber;

	@FindBy(xpath = "//lyte-input[@data-zcqa='manual_Email']//input[@type='text']")
	WebElement txtEmail;

	@FindBy(xpath = "(//input[contains(@type,'text')])[6]")
	WebElement txtCurrentCtc;

	@FindBy(xpath = "(//input[contains(@type,'text')])[7]")
	WebElement txtEpectedCtc;

	@FindBy(xpath = "(//input[contains(@type,'text')])[8]")
	WebElement txtNoticeperoid;

	@FindBy(xpath = "(//input[contains(@type,'text')])[10]")
	WebElement txtEnterRelvtEx;

	@FindBy(xpath = "//lyte-input[@data-zcqa='manual_Experience_in_Years']//input[@type='text']")
	WebElement txtEnterExYears;

	@FindBy(xpath = "//input[@id='addSkills']")
	WebElement txtSkills;

	@FindBy(xpath = "//li[normalize-space()='java']")
	WebElement btnApply;

	@FindBy(xpath = "(//input[@type='text'])[12]")
	WebElement textCityName;

	@FindBy(xpath = "(//input[@type='text'])[12]")
	WebElement textCitySelect;

	@FindBy(xpath = "//lyte-autocomplete[@id='630525000000063564']//input[@id='inputId']")
	WebElement textStateSelect;

	@FindBy(xpath = "//lyte-drop-item[@id='Lyte_Drop_Item_3816']//span[contains(@class,'cxLookupDropboxLabel')][contains(text(),'Bulandshahr, Bulandshahr, Bulandshahr, Uttar Prade')]")
	WebElement textStateSelectOpts;

	@FindBy(xpath = "(//input[contains(@type,'text')])[14]")
	WebElement textLinkedinLink;

	@FindBy(xpath = "//rec-file-upload-component[@cx-prop-class=' ']//lyte-file-message")
	WebElement textResume;

	@FindBy(xpath = "//button[contains(@type,'submit')]")
	WebElement btnSubmitApl;

	@FindBy(xpath = "//div[contains(text(),'Thank you for applying at Nickelfox. We will get b')]")
	WebElement successMessage;

	@FindBy(xpath = "//a[normalize-space()='Upload your resume']")
	WebElement autoFillAppli;

	@FindBy(xpath = "//button[@type='accept']")
	WebElement okBtn;

	public Career_Page(WebDriver driver) {

		PageFactory.initElements(driver, this); 
	}

	public void Go_to_Career_Page(WebDriver driver) throws InterruptedException  {
		linkCareer.click();
		System.out.println("click on the career link");


	}

	public void fill_Career_Form(WebDriver driver) throws InterruptedException, AWTException {
		//Thread.sleep(5000);
		//	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", lableBDS);
		Thread.sleep(5000);
		lableBDS.click();
		System.out.println("click on the job apply");
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", linkBADArrow);
		ArrayList<String> wid = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(wid.get(1));
		System.out.println("Page title of active tab: " + driver.getTitle());

		Thread.sleep(3000);
		intrsted_Btn.click();
		System.out.println("click on the intersted button");

		//surname.click();
		Thread.sleep(4000);
		firstName.sendKeys("automation qa");
		System.out.println("en ter the first name");
		txtLastName.sendKeys("Automation");
		System.out.println("enter the last name");
		txtMobileNumber.sendKeys("9876543211");
		System.out.println("enter the mobile number");
		txtEmail.sendKeys("Automation@nickelfox.com");
		System.out.println("enter the email id");
		txtCurrentCtc.sendKeys("500000");
		System.out.println("enter the current CTC");
		txtEpectedCtc.sendKeys("700000");
		System.out.println("enter the expected CTC");
		txtNoticeperoid.sendKeys("1 Month");
		System.out.println("enter the notice period");
		txtEnterRelvtEx.sendKeys("3");
		System.out.println("enter the exp");
		txtEnterExYears.sendKeys("3.5");

		Thread.sleep(6000);

		txtSkills.click();
		System.out.println("click on the skill field");
		txtSkills.sendKeys("java");
		System.out.println("enter the skill");
		Thread.sleep(4000);
		btnApply.click();
		System.out.println("click on the apply button");

		Thread.sleep(2000);
		textCityName.click();
		textCityName.sendKeys("Bulandshahr");
		System.out.println("enter the city name");

		Thread.sleep(8000);
		textCitySelect.click();
		System.out.println("select the city");

		Thread.sleep(5000);
		textStateSelect.sendKeys("Uttar Pradesh");
		System.out.println("enter the state");
		Thread.sleep(8000);
		//textStateSelectOpts.click();
		//Thread.sleep(8000);
	//	textLinkedinLink.sendKeys("https://x.com/nayantharau/status/1844129837818290371?s=48");
	//	System.out.println("enter the linkdin link");
		Thread.sleep(5000);
	//	textResume.click();
	//	System.out.println("click on the resume upload");

		// Copy the file path to the clipboard
		//copyToClipboard("D:\\D\\NIckelfox_2024\\Nickelfox\\Resume\\Color block resume.docx");

		// Give a little delay to ensure the clipboard is ready (you can adjust this if necessary)
		Thread.sleep(1000);

		// Create a Robot instance to simulate key presses
		Robot robot = new Robot();

		// Press Ctrl+V to paste the file path
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);

		// Press Enter to confirm
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	// Helper method to copy text to the system clipboard
	private static void copyToClipboard(String text) {
	//	StringSelection stringSelection = new StringSelection(text);
		//Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
	//	System.out.println("resume upload successfully");

	}


	//D:\D\NIckelfox_2024\Nickelfox\Resume\Color block resume.docx
	public void sbmtBTN() throws InterruptedException {
		Thread.sleep(8000);
		btnSubmitApl.click();
		System.out.println("click on the submit button");
	}
	public void successMesge(WebDriver driver) throws InterruptedException {

		Thread.sleep(5000);
		WebElement element= successMessage;
		System.out.println(element.getText());

		Thread.sleep(4000);
		//	Alert simpleAlert = driver.switchTo().alert();
		//simpleAlert.accept();
		okBtn.click();

		System.out.println("Clik on the OK button");

	}

	public void autoFillapplication() throws InterruptedException, AWTException {


		autoFillAppli.click();


		copyToClipboard("D:\\D\\NIckelfox_2024\\Nickelfox\\Resume\\Color block resume.docx");

		// Give a little delay to ensure the clipboard is ready (you can adjust this if necessary)
		Thread.sleep(1000);

		// Create a Robot instance to simulate key presses
		Robot robot = new Robot();

		// Press Ctrl+V to paste the file path
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);

		// Press Enter to confirm
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);



	}

	// Helper method to copy text to the system clipboard
	
	//	utilities.fileUpload.uploadFile("C:\\Users\\Prashant kumar\\Videos\\nickelFox (1)\\nickelFox\\testData\\Color block resume.docx");

}


