package com.demowebshop.testscript;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.demowebshop.automationcore.Base;
import com.demowebshop.constants.ErrorMessages;
import com.demowebshop.listeners.TestListner;
import com.demowebshop.pages.HomePage;
import com.demowebshop.pages.LoginPage;
import com.demowebshop.pages.UserAccountPage;
import com.demowebshop.utilities.ExcelUtility;

public class UserAccountTest extends Base{
	HomePage home;
	LoginPage login;
	UserAccountPage user;
	
	ThreadLocal<ExtentTest> extentTest = TestListner.getTestInstance(); 
	
	

}
