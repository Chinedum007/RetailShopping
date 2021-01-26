package com.eshopping.womenshopping.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.eshopping.womenshopping.generic.WebActionUtil;

public class OrderDetailsPage extends BasePage {
	
	String xpath = "//tbody//td//a[contains(@href,'pid')]/../..//i[@class='icon-trash']";
	
	@FindBy(xpath="//td[@class='cart_product']/a")
	private List<WebElement> productsList;
	
	public OrderDetailsPage(WebDriver driver, WebActionUtil webActionUtil) {
		super(driver,webActionUtil);
	}
	
	public boolean isProductDisplayed(String productId) {
		for(WebElement product:productsList) {
			if(product.getAttribute("href").contains(productId)) {
				return true;
			}
		}
		
		return false;
	}
	
	public void deleteProductFromODP(String productId) {
		
		xpath = xpath.replace("pid", productId);
		WebElement productTrashIcon = driver.findElement(By.xpath(xpath));	
		webActionUtil.clickOnElement(productTrashIcon);
	
	}
}
