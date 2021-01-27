package com.eshopping.womenshopping.testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.eshopping.womenshopping.generic.ExcelLibrary;
import com.eshopping.womenshopping.pages.HomePage;
import com.eshopping.womenshopping.pages.OrderDetailsPage;
import com.eshopping.womenshopping.pages.ProductDetailsPage;
import com.eshopping.womenshopping.pages.ProductsListPage;

public class TC004 extends BaseTest {
	@Test(description="To Verify Whether the Product deleted from ODP Is Displayed in ODP")
	public void testProductIsNotAvailableODP() throws InterruptedException {
		
		String menuName=ExcelLibrary.getStringData(XL_PATH, "TC003", 1, 0);
		String productId=ExcelLibrary.getStringData(XL_PATH, "TC003", 1, 1);
		int quantity=(int)(double)ExcelLibrary.getNumericData(XL_PATH, "TC003", 1, 2);
		String size=ExcelLibrary.getStringData(XL_PATH, "TC003", 1, 3);
		String color=ExcelLibrary.getStringData(XL_PATH, "TC003", 1, 4);
		
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
		
		odp.deleteProductFromODP(productId);
		
		Thread.sleep(5000);
		
		Assert.assertEquals(odp.isProductDisplayed(productId), false, "Expected Product is Displayed in ODP");
	}
}
