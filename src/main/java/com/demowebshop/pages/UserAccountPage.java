package com.demowebshop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demowebshop.utilities.ExcelUtility;
import com.demowebshop.utilities.RandomUtility;
import com.demowebshop.utilities.TestHelperUtility;

public class UserAccountPage extends TestHelperUtility {
	public WebDriver driver;

	public UserAccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	} 
	private final String _userAccountEmailField="//div[@class='header-links']//a[@class='account']";
	@FindBy(xpath=_userAccountEmailField) private WebElement userAccountEmailField;
	
	 public String getUserAccountEmailId()
	 {
		 String emailId = page.getElementText(userAccountEmailField);
		 return emailId;
	 }
	

}

