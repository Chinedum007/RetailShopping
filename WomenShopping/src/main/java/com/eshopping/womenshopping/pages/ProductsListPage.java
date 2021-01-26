package com.eshopping.womenshopping.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.eshopping.womenshopping.generic.WebActionUtil;

public class ProductsListPage extends BasePage {
	
	@FindBy(className="product_img_link")
	private List<WebElement> productsList;
	
	public ProductsListPage(WebDriver driver, WebActionUtil webActionUtil) {
		super(driver,webActionUtil);
	}
	
	public void clickOnProduct(String productId) {
		for(WebElement product:productsList) {
			if(product.getAttribute("href").contains(productId)) {
				webActionUtil.jsClick(product);
				break;
			}
		}
	}
}
