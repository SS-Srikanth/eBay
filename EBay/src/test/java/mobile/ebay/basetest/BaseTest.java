package mobile.ebay.basetest;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import mobile.ebay.model.CommonLibrary;
import mobile.ebay.model.Constants;
import mobile.ebay.model.DataManager;
import mobile.ebay.pages.HomePage;
import mobile.ebay.pages.LoginPage;
import mobile.ebay.pages.ShoppingCartPage;

public class BaseTest 
{
	public static AndroidDriver<AndroidElement> mDriver;
	public DesiredCapabilities capabilities;
	public static DataManager dataManager;
	public static HomePage homePage;
	public static ShoppingCartPage shoppingCartPage;
	public static LoginPage loginPage;
	public static CommonLibrary commonLibrary;
	
	public void launchApp() throws IOException 
	{
		/**
		 * Set all the desired capabilities
		 */
		capabilities = new DesiredCapabilities();
		capabilities.setCapability( "deviceName", Constants.deviceName);
		capabilities.setCapability( "platformName", Constants.platformName);
		capabilities.setCapability( CapabilityType.VERSION, Constants.androidVersion);
		capabilities.setCapability( "appPackage",Constants.appPackage);
		capabilities.setCapability( "appActivity", Constants.appActivity);
		capabilities.setCapability( "automationName", "uiAutomator2");
		capabilities.setCapability("noReset", false);

		mDriver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
		mDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}

	@BeforeMethod
	public void beforeMethod() throws IOException
	{
		/**
		 *  Managing all the objects 
		 */
		launchApp();
		dataManager = new DataManager();
		commonLibrary = new CommonLibrary(mDriver);
		homePage = new HomePage(mDriver);
		loginPage = new LoginPage(mDriver);
		shoppingCartPage = new ShoppingCartPage(mDriver);
		
		login();

	}
	
	public void login() throws IOException 
	{
		loginPage.clickSignin();
		String userName = dataManager.readExcelData(Constants.excelFilePath, Constants.excelFileName, Constants.excelSheetName, 1, 0).toString();
		String password = dataManager.readExcelData(Constants.excelFilePath, Constants.excelFileName, Constants.excelSheetName, 1, 1).toString();
		
		loginPage.enterUserName(userName);
		loginPage.enterPassword(password);
		loginPage.clickSignin();
		homePage.clickOnmayblatter();
		
		
		
	}
}
