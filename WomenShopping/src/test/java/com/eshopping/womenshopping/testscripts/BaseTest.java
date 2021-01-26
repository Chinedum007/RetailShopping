package com.eshopping.womenshopping.testscripts;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.eshopping.womenshopping.generic.AutoConstants;
import com.eshopping.womenshopping.generic.CaptureScreenshot;
import com.eshopping.womenshopping.generic.WebActionUtil;
import com.eshopping.womenshopping.pages.HomePage;
import com.eshopping.womenshopping.pages.LoginPage;

public class BaseTest implements AutoConstants {
	
	public WebDriver driver;//chromeBrowser
	public WebActionUtil webActionUtil;//Object is stored
	
	@Parameters({"browserName", "appUrl", "implicitTO","explicitTO"})
	@BeforeClass
	public void openApp(@Optional(DEFAULT_BROWSER)String browserName,
						@Optional(DEFAULT_URL)String appUrl,
						@Optional(ITO)String implicitTO,
						@Optional(ETO)String explicitTO) {
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty(CHROME_KEY, CHROME_PATH);
			driver = new ChromeDriver();
		} else if(browserName.equalsIgnoreCase("firefox")) {
			System.setProperty(GECKO_KEY, GECKO_PATH);
			driver = new FirefoxDriver();
		} else {
			throw new IllegalArgumentException();
		}
		
		driver.manage().window().maximize();
		long impTO=Long.parseLong(implicitTO);
		long expTO=Long.parseLong(explicitTO);
		driver.manage().timeouts().implicitlyWait(impTO, TimeUnit.SECONDS);
		driver.get(appUrl);
		webActionUtil = new WebActionUtil(driver, expTO);
	}
	
	@Parameters({"emailId","emailPassword"})
	@BeforeMethod
	public void loginToApp(@Optional(DEFAULT_USER)String emailId,
						   @Optional(DEFAULT_PWD)String emailPassword) {
		LoginPage lp = new LoginPage(driver, webActionUtil);
		lp.login(emailId, emailPassword);
	}
	
	@AfterMethod
	public void logout(ITestResult result) {
		
		if(result.getStatus()==ITestResult.FAILURE) {
			CaptureScreenshot.getImage(driver, result.getName());
		}
		
		HomePage hp = new HomePage(driver, webActionUtil);
		hp.signOut();
	}
	
	
	@AfterClass
	public void closeApp() {
		driver.quit();
	}
}
