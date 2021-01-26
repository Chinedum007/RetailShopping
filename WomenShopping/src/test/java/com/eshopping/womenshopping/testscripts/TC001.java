package com.eshopping.womenshopping.testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.eshopping.womenshopping.generic.ExcelLibrary;
import com.eshopping.womenshopping.pages.HomePage;
import com.eshopping.womenshopping.pages.OrderDetailsPage;
import com.eshopping.womenshopping.pages.ProductDetailsPage;
import com.eshopping.womenshopping.pages.ProductsListPage;

public class TC001 extends BaseTest {
	@Test(description="To Verify Whether the Product Added Is Displayed in ODP")
	public void testProductInODP() {
		
		String menuName=ExcelLibrary.getStringData(XL_PATH, "TC001", 1, 0);
		String productId=ExcelLibrary.getStringData(XL_PATH, "TC001", 1, 1);
		int quantity=(int)(double)ExcelLibrary.getNumericData(XL_PATH, "TC001", 1, 2);
		String size=ExcelLibrary.getStringData(XL_PATH, "TC001", 1, 3);
		String color=ExcelLibrary.getStringData(XL_PATH, "TC001", 1, 4);
		
		HomePage hp = new HomePage(driver,webActionUtil);
		hp.clickOnMenu(menuName);
		
		ProductsListPage plp = new ProductsListPage(driver, webActionUtil);
		plp.clickOnProduct(productId);
		
		ProductDetailsPage pdp = new ProductDetailsPage(driver, webActionUtil);
		pdp.increaseQuantity(quantity);
		pdp.selectSize(size);
		pdp.selectColor(color);
		pdp.clickOnAddToKart();
		pdp.clickOnProceedToCheckout();
		
		OrderDetailsPage odp = new OrderDetailsPage(driver, webActionUtil);
		Assert.assertEquals(odp.isProductDisplayed(productId), true, "Expected Product Not Displayed in ODP");
	}
}
