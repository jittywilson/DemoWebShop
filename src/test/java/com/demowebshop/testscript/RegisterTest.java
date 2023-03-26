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
import com.demowebshop.listeners.TestListner;
import com.demowebshop.pages.HomePage;
import com.demowebshop.pages.RegisterPage;
import com.demowebshop.pages.UserAccountPage;
import com.demowebshop.utilities.ExcelUtility;
import com.demowebshop.utilities.RandomUtility;

public class RegisterTest extends Base {
	HomePage home;
	RegisterPage register;
	UserAccountPage user;
	ThreadLocal<ExtentTest> extentTest = TestListner.getTestInstance();
	@Test
	public void tc_006_verifyRegistration()
	{
		driver.get("https://demowebshop.tricentis.com/");
		List<ArrayList<String>> data = ExcelUtility.excelDataReader("RegisterPage");
		String gender = data.get(0).get(1);
		String fName = RandomUtility.getfName();
		//extentTest.get().log(Status.PASS, ExtentLogMessage.VALID_FIRSTNAME );
		String lName = RandomUtility.getlName();
		//extentTest.get().log(Status.PASS, ExtentLogMessage.VALID_LASTNAME );
		String email = RandomUtility.getRandomEmail();
		//extentTest.get().log(Status.PASS, ExtentLogMessage.VALID_EMAIL );
		String password = fName+"@123";
		String cPassword = password;
		home = new HomePage(driver);
		register = home.clickOnRegisterMenu();
		//extentTest.get().log(Status.PASS, ExtentLogMessage.REGISTER_MENU_CLICK);
		register.selectGender(gender);
		register.setFirstName(fName);
		register.setLastName(lName);
		register.setEmail(email);
		register.setPassword(password);
		register.setConfirmPassword(cPassword);
		user = register.clickOnRegisterButton();
		//extentTest.get().log(Status.PASS, ExtentLogMessage.REGISTER_BUTTON_CLICK );
		String actEmail = user.getUserAccountEmailId();
		//extentTest.get().log(Status.PASS, ExtentLogMessage.VALID_EMAIL );
		Assert.assertEquals(actEmail, email, ErrorMessages.EMAILMESSAGE_FAILURE_MESSAGE);
		//extentTest.get().log(Status.PASS, "Invalid Email found");
	}
}
