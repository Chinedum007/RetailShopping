package com.eshopping.womenshopping.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.eshopping.womenshopping.generic.WebActionUtil;

public class HomePage extends BasePage {
	
	@FindBy(linkText="Sign out")
	private WebElement signOutLink;
	
	@FindBy(linkText="Women")
	private WebElement womenMenu;
	
	@FindBy(xpath="(//a[.='Dresses'])[2]")
	private WebElement dressesMenu;
	
	@FindBy(xpath="(//a[.='T-shirts'])[2]")
	private WebElement tShirtsMenu;
	
	public HomePage(WebDriver driver, WebActionUtil webactionUtil) {
		super(driver,webactionUtil);
	}
	
	public void signOut() {
		webActionUtil.clickOnElement(signOutLink);
	}
	
	public void clickOnMenu(String menuName) {
		switch(menuName) {
			case "women":webActionUtil.clickOnElement(womenMenu); 
						 break;
			case "dresses":webActionUtil.clickOnElement(dressesMenu); 
			 			 break;
			case "tshirts":webActionUtil.clickOnElement(tShirtsMenu); 
			 			 break;
		}
	}
}
