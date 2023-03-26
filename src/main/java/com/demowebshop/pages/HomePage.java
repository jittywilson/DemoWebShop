package com.demowebshop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demowebshop.utilities.RandomUtility;
import com.demowebshop.utilities.TestHelperUtility;
import com.demowebshop.utilities.WaitUtility;

public class HomePage extends TestHelperUtility {
	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	private final String _subscribtionEmailField = "newsletter-email";
	@FindBy(id = _subscribtionEmailField)
	private WebElement subscribtionEmailField;

	private final String _subscribtionButton = "newsletter-subscribe-button";
	@FindBy(id = _subscribtionButton)
	private WebElement subscribtionButton;

	private final String _subMsgField = "newsletter-result-block";
	@FindBy(id = _subMsgField)
	private WebElement subMsgField;

	private final String _LoginLink = "//a[@class='ico-login']";
	@FindBy(xpath = _LoginLink)
	private WebElement LoginLink;

	private final String _registerLink = "//a[@class='ico-register']";
	@FindBy(xpath = _registerLink )
	private WebElement registerLink;
	
	public String getHomePageTitle() {
		String title = page.getPageTitle(driver);
		return title;
	}

	public void setEmail() {
		String email = RandomUtility.getRandomEmail();
		page.enterText(subscribtionEmailField, email);
	}

	public void clickSubscribeButton() {
		page.clickOnElement(subscribtionButton);
	}

	public String getSubscribeMessage() {
		wait.setHardWait();
		wait.waitForElementToBeVisible(driver, _subMsgField, WaitUtility.LocatorType.Id);
		String msg = page.getElementText(subMsgField);
		return msg;
	}

	public LoginPage clickOnLoginMenu() // navigating to another page
	{
		page.clickOnElement(LoginLink);
		return new LoginPage(driver);
	}

	public RegisterPage clickOnRegisterMenu() // navigating to another page
	{
		page.clickOnElement(registerLink);
		return new RegisterPage(driver);
	}
}
