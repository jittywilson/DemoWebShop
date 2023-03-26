package com.demowebshop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demowebshop.utilities.RandomUtility;
import com.demowebshop.utilities.TestHelperUtility;

public class LoginPage extends TestHelperUtility {
	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
//	private final String _loginLink = "//a[@class='ico-login']";
//	@FindBy(xpath = _loginLink)
//	private WebElement loginLink;
	
	private final String _emailField = "Email";
	@FindBy(id = _emailField)
	private WebElement emailField;
	
	private final String _passwordField = "Password";
	@FindBy(id = _passwordField)
	private WebElement passwordField;
	
	private final String _loginButton = "//input[@class='button-1 login-button']";
	@FindBy(xpath = _loginButton)
	private WebElement loginButton;
	
	private final String _errorMsg ="//div[@class='validation-summary-errors']//span";
	@FindBy(xpath=_errorMsg)
	private WebElement errorMsg;
	
	public String getLoginPageTitle() {
		String title = page.getPageTitle(driver);
		return title;
	}
	
	public void setEmailField(String userEmail) {
		//userEmail = page.getElementText(emailField);
		page.enterText(emailField, userEmail);
	
	}
	
	public void setPasswordField(String password) {
		//String password = page.getElementText(passwordField);
		page.enterText(passwordField, password);
	}
	
//	public void clickLoginButton() {
//		page.clickOnElement(loginButton);
//	}
	
	public UserAccountPage clickOnLoginButton() // navigating to another page
	{
		page.clickOnElement(loginButton);
		return new UserAccountPage(driver);
	}
	
	public String getErrorMessage()
	{
		String errorMsg1 = page.getElementText(errorMsg);
		return errorMsg1;
	}

}
