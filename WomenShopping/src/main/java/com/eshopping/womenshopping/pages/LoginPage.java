package com.eshopping.womenshopping.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.eshopping.womenshopping.generic.WebActionUtil;

public class LoginPage extends BasePage {
	
	@FindBy(linkText="Sign in")
	private WebElement signInLink;
	
	@FindBy(id="email")
	private WebElement emailTextField;
	
	@FindBy(id="passwd")
	private WebElement passwordTextField;
	
	@FindBy(id="SubmitLogin")
	private WebElement signInButton;
	
	@FindBy(linkText="Forgot your password?")
	private WebElement forgotPasswordLink;
	
	public LoginPage(WebDriver driver, WebActionUtil webactionUtil) {
		super(driver,webactionUtil);
	}
	
	public void login(String emailId, String emailPassword) {
		webActionUtil.clickOnElement(signInLink);
		webActionUtil.enterData(emailTextField, emailId);
		webActionUtil.enterData(passwordTextField, emailPassword);
		webActionUtil.clickOnElement(signInButton);
	}
	
}
