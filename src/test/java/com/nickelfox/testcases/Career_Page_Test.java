package com.nickelfox.testcases;

import java.awt.AWTException;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import com.nickelfox.baseclass.BaseClass;
import com.nickelfox.pages.Career_Page;

public class Career_Page_Test extends BaseClass{

	Career_Page career;

	@BeforeMethod
	void beforeMethod() throws InterruptedException, AWTException {
		launcTheBrowser();
		career = new Career_Page(driver);

	}

	@Test(priority = 1, enabled = true)

	public void Test_Career_Form() throws InterruptedException, AWTException{

		career.Go_to_Career_Page(driver);
		career.fill_Career_Form(driver);
	//	career.sbmtBTN();
	//	career.successMesge(driver);
	//	career.autoFillapplication();

	}




}
