package com.eshopping.womenshopping.testscripts;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.eshopping.womenshopping.generic.ExcelLibrary;
import com.eshopping.womenshopping.pages.HomePage;
import com.eshopping.womenshopping.pages.OrderDetailsPage;
import com.eshopping.womenshopping.pages.ProductDetailsPage;
import com.eshopping.womenshopping.pages.ProductsListPage;

public class TC002 extends BaseTest {
	
	@DataProvider
	public String[][] getData(){
		return ExcelLibrary.getMultipleData(XL_PATH, "TC002");
	}
	
	@Test(dataProvider="getData",
				description="To Verify Whether Multiple Products Added Is Displayed in ODP")
	public void testMultipleProductInODP(String menuName,
								 String productId,
								 String quantity,
								 String size,
								 String color) {
		
		HomePage hp = new HomePage(driver,webActionUtil);
		hp.clickOnMenu(menuName);
		
		ProductsListPage plp = new ProductsListPage(driver, webActionUtil);
		plp.clickOnProduct(productId);
		
		ProductDetailsPage pdp = new ProductDetailsPage(driver, webActionUtil);
		pdp.increaseQuantity((int)Double.parseDouble(quantity));
		pdp.selectSize(size);
		pdp.selectColor(color);
		pdp.clickOnAddToKart();
		pdp.clickOnProceedToCheckout();
		
		OrderDetailsPage odp = new OrderDetailsPage(driver, webActionUtil);
		Assert.assertEquals(odp.isProductDisplayed(productId), true, "Expected Product Not Displayed in ODP");
	}
}
