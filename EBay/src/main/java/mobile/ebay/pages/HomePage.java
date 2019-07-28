package mobile.ebay.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import mobile.ebay.model.CommonLibrary;

public class HomePage {
	
	AndroidDriver<AndroidElement> mDriver;
	CommonLibrary comLib;
	public HomePage(AndroidDriver<AndroidElement> mDriver) 
	{
		PageFactory.initElements(new AppiumFieldDecorator(mDriver), this);
		this.mDriver = mDriver;
		comLib = new CommonLibrary(mDriver);
	}
	
	@AndroidFindBy(id="home")
	public AndroidElement hambugerMenu_Btn;
	
	@AndroidFindBy(id = "textview_sign_out_status")
	public AndroidElement signIn_Btn;
	
	@AndroidFindBy(id = "search_box")
	public AndroidElement searchBox;
	
	@AndroidFindBy(id = "search_src_text")
	public AndroidElement search_TxtField;
	
	@AndroidFindBy(id = "text_slot_1")
	public AndroidElement saveTip_Txt;
	
	@AndroidFindBy(id = "button_add_to_cart")
	public AndroidElement addToCart_Btn;
	
	@AndroidFindBy(id = "menu_cart")
	public AndroidElement cart_Icn;
	
	@AndroidFindBy(id = "textview_item_name")
	public AndroidElement itemDetails_Txt;
	
	@AndroidFindBy(id = "textview_item_price")
	public AndroidElement itemPrice_Txt;
	
	@AndroidFindBy(id = "bt_maybe_later")
	public AndroidElement maybelater_Btn;
	
	public void clickOnHamburgerMenu_Btn()
	{
		/**
		 * click on Hamburger Menu
		 */
		hambugerMenu_Btn.click();
	}
	
	public void clickOnmayblatter()
	{
		/**
		 * click on may be later 
		 */
		maybelater_Btn.click();
	}
	public void searchItem(String itemName)
	{
		/**
		 * search for an item
		 */
		searchBox.click();
		search_TxtField.sendKeys(itemName);
		mDriver.findElement(By.xpath( "//android.widget.TextView[contains(@text,'"+itemName+"')]")).click();
		saveTip_Txt.click();
	}
	
	public void clickRandomTV(String TV)
	{
		/**
		 * select any random tv
		 */
		while(true)
		{
			try 
			{
				mDriver.findElement(By.xpath( "//android.widget.TextView[contains(@text,'"+TV+"')]")).click();
				break;
			} 
			catch (Exception e) 
			{
				comLib.scrollDown();
			}	
		}		
	}
	
	public void clickAddToCart_Btn()
	{
		/**
		 * click on add to cart button 
		 */
		addToCart_Btn.click();
	}
	public void clickCart_Icn()
	{

		/**
		 * click on cart icon
		 */
		cart_Icn.click();
	}
	
}
