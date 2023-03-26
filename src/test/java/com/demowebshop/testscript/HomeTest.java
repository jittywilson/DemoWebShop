package com.demowebshop.testscript;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.demowebshop.automationcore.Base;
import com.demowebshop.constants.ErrorMessages;
import com.demowebshop.constants.ExtentLogMessage;
import com.demowebshop.listeners.TestListner;
import com.demowebshop.pages.HomePage;
import com.demowebshop.utilities.ExcelUtility;

public class HomeTest extends Base {
	HomePage home;
	ThreadLocal<ExtentTest> extentTest = TestListner.getTestInstance();
	@Test
	public void tc_001_verifyHomePageTitle()
	{
		driver.get("https://demowebshop.tricentis.com/");
		List<ArrayList<String>> data = ExcelUtility.excelDataReader("HomePage");
		String expHomePageTitle = data.get(0).get(1);
		home = new HomePage(driver);
		String actualHomePageTitle = home.getHomePageTitle();
		//extentTest.get().log(Status.PASS,ExtentLogMessage.VALID_HOMEPAGE_TITLE);
		Assert.assertEquals(actualHomePageTitle, expHomePageTitle, ErrorMessages.TITLE_FAILURE_MESSAGE );
		//extentTest.get().log(Status.PASS,ExtentLogMessage.EXP_HOMEPAGE_TITLE_MATCHWITH_ACT_HOMEPAGE_TITLE );
	}
	@Test
	public void tc_002_verifySubscribtion()
	{
		driver.get("https://demowebshop.tricentis.com/");
		List<ArrayList<String>> data = ExcelUtility.excelDataReader("HomePage");
		String expMsg = data.get(2).get(1);
		System.out.println(expMsg);
		home = new HomePage(driver);
		home.setEmail();
		home.clickSubscribeButton();
		//extentTest.get().log(Status.PASS, ExtentLogMessage.SUBSCRIBE_BUTTON_CLICK);
		String actualMsg = home.getSubscribeMessage();
		//extentTest.get().log(Status.PASS, ExtentLogMessage.VALID_EMAIL);
		Assert.assertEquals(actualMsg, expMsg, ErrorMessages.EMAILMESSAGE_FAILURE_MESSAGE );
		//extentTest.get().log(Status.PASS, ExtentLogMessage.EXP_EMAIL_MATCHWITH_ACT_EMAIL );
	}


}
