package com.demowebshop.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demowebshop.utilities.TestHelperUtility;

public class RegisterPage extends TestHelperUtility {
	public WebDriver driver;
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	private final String _firstName="FirstName";
	@FindBy(id=_firstName)
	private WebElement firstName;
	
	private final String _lasttName="LastName";
	@FindBy(id=_lasttName)
	private WebElement lastName;
	
	private final String _email="Email";
	@FindBy(id=_email)
	private WebElement email;
	
	private final String _password="Password";
	@FindBy(id=_password)
	private WebElement password;
	
	private final String _cPassword="ConfirmPassword";
	@FindBy(id=_cPassword)
	private WebElement cPassword;
	
	private final String _registerButton="register-button";
	@FindBy(id=_registerButton)
	private WebElement registerButton;
	
	private final String _gender="//input[@name='Gender']/following-sibling::label";
	@FindBy(xpath=_gender)
	private List<WebElement> gender;
	
	
	public void setFirstName(String fName)
	{
		page.enterText(firstName,fName);
	}
	
	public void setLastName(String lName)
	{
		page.enterText(lastName,lName);
	}
	
	public void setEmail(String email1)
	{
		page.enterText(email,email1);
	}
	
	public void setPassword(String password1)
	{
		page.enterText(password,password1);
	}
	
	public void setConfirmPassword(String confirmPassword1)
	{
		page.enterText(cPassword,confirmPassword1);
	}
	
	public void selectGender(String gender1)
	{
		for(int i = 0; i<gender.size();i++)
		{
			String value = page.getElementText(gender.get(i));
			
			if(value.equals(gender1))
			{
				page.clickOnElement(gender.get(i));
				break;
			}
		}
	}
	
	
	public UserAccountPage clickOnRegisterButton()
	{
		page.clickOnElement(registerButton);
		return new UserAccountPage(driver);
	} 
	
}
