package com.eshopping.womenshopping.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.eshopping.womenshopping.generic.WebActionUtil;

public class ProductDetailsPage extends BasePage {
	
	@FindBy(className="icon-plus")
	private WebElement plusIcon;
	
	@FindBy(id="group_1")
	private WebElement sizeListBox;
	
	@FindBy(xpath="//ul[@id='color_to_pick_list']//a")
	private List<WebElement> colorsList;
	
	@FindBy(name="Submit")
	private WebElement addToKartButton;
	
	@FindBy(xpath="//a[@title='Proceed to checkout']")
	private WebElement proceedToCheckoutButton;
	
	public ProductDetailsPage(WebDriver driver, WebActionUtil webActionUtil) {
		super(driver,webActionUtil);
	}
	
	public void increaseQuantity(int count) {
		for(int i=1;i<=count;i++) {
			webActionUtil.clickOnElement(plusIcon);
		}
	}
	
	public void selectSize(String sizeText) {
		webActionUtil.selectByTextInListBox(sizeListBox, sizeText);
	}
	
	public void selectColor(String colorName) {
		for(WebElement colorLink:colorsList) {
			if(colorLink.getAttribute("name").contains(colorName)) {
				colorLink.click();
			}
		}
	}
	
	public void clickOnAddToKart() {
		webActionUtil.clickOnElement(addToKartButton);
	}
	
	public void clickOnProceedToCheckout() {
		webActionUtil.clickOnElement(proceedToCheckoutButton);
	}
}
