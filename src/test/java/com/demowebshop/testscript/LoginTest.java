package com.demowebshop.testscript;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.demowebshop.automationcore.Base;
import com.demowebshop.constants.ErrorMessages;
import com.demowebshop.constants.ExtentLogMessage;
import com.demowebshop.dataprovider.DataProviders;
import com.demowebshop.listeners.TestListner;
import com.demowebshop.pages.HomePage;
import com.demowebshop.pages.LoginPage;
import com.demowebshop.pages.UserAccountPage;
import com.demowebshop.utilities.ExcelUtility;

public class LoginTest extends Base{
	HomePage home;
	LoginPage login;
	UserAccountPage useracountpage;
	ThreadLocal<ExtentTest> extentTest = TestListner.getTestInstance();
	@Test
	public void tc_003_verifyLoginPageTitle()
	{
		driver.get("https://demowebshop.tricentis.com/");
		List<ArrayList<String>> data = ExcelUtility.excelDataReader("LoginPage");
		String expLoginPageTitle = data.get(0).get(1);
		home = new HomePage(driver);
		login = home.clickOnLoginMenu();
		//extentTest.get().log(Status.PASS, ExtentLogMessage.LOGIN_MENU_CLICK);
		String actLogPgeTitle = login.getLoginPageTitle();
		//extentTest.get().log(Status.PASS,ExtentLogMessage.VALID_LOGINPAGE_TITLE);
		Assert.assertEquals(actLogPgeTitle, expLoginPageTitle, ErrorMessages.LOGINPAGETITLE_FAILURE_MESSAGE );
		//extentTest.get().log(Status.PASS,ExtentLogMessage.EXP_LOGINPAGE_TITLE_MATCHWITH_ACT_LOGINPAGE_TITLE );
		
	}
	
	@Test
	public void tc_004_verifyValidLogin()
	{
		driver.get("https://demowebshop.tricentis.com/");
		home = new HomePage(driver);
		login = home.clickOnLoginMenu();
		//extentTest.get().log(Status.PASS, ExtentLogMessage.LOGIN_MENU_CLICK);
		List<ArrayList<String>> data = ExcelUtility.excelDataReader("LoginPage");
		String expLoginPageTitle = data.get(0).get(1);
		String actLogPgeTitle = login.getLoginPageTitle();
		//extentTest.get().log(Status.PASS,ExtentLogMessage.VALID_LOGINPAGE_TITLE);
		Assert.assertEquals(actLogPgeTitle, expLoginPageTitle, ErrorMessages.LOGINPAGETITLE_FAILURE_MESSAGE );
		String userEmail = data.get(1).get(1);
		System.out.println(userEmail);
		login.setEmailField(userEmail);
		String userPassword = data.get(2).get(1);
		System.out.println(userPassword);
		login.setPasswordField(userPassword);
		useracountpage = login.clickOnLoginButton();
		//extentTest.get().log(Status.PASS, ExtentLogMessage.LOGIN_BUTTON_CLICK);
		String actEmail = useracountpage.getUserAccountEmailId();
		//extentTest.get().log(Status.PASS, ExtentLogMessage.VALID_EMAIL);
		Assert.assertEquals(actEmail, userEmail, ErrorMessages.INVALIDEMAILID_FAILURE_MESSAGE);
		//extentTest.get().log(Status.PASS, ExtentLogMessage.VALID_LOGIN_MESSAGE);
	}
	@Test(dataProvider="InvalidUserCredentials", dataProviderClass = DataProviders.class)
	public void tc_005_verifyInvalidLogin(String userName, String password)
	{
		driver.get("https://demowebshop.tricentis.com/");
		home = new HomePage(driver);
		login = home.clickOnLoginMenu();
		//extentTest.get().log(Status.PASS, ExtentLogMessage.LOGIN_MENU_CLICK);
		List<ArrayList<String>> data = ExcelUtility.excelDataReader("LoginPage");
		String expErrorMsg = data.get(3).get(1);
		home = new HomePage(driver);
		login = home.clickOnLoginMenu();
		//extentTest.get().log(Status.PASS, ExtentLogMessage.LOGIN_MENU_CLICK);
		login.setEmailField(userName);
		login.setPasswordField(password);
		login.clickOnLoginButton();
		//extentTest.get().log(Status.PASS, ExtentLogMessage.LOGIN_BUTTON_CLICK);
		String actErrorMsg = login.getErrorMessage();
		System.out.println(actErrorMsg);
		System.out.println(expErrorMsg);
		Assert.assertEquals(actErrorMsg, expErrorMsg, ErrorMessages.INVALID_ERROR_MESSAGE_FAILURE_MESSAGE);
		//extentTest.get().log(Status.PASS, "User Logged in unsuccessfully");

		
	}
}
