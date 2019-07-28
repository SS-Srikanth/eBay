package mobile.ebay.pages;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import mobile.ebay.model.CommonLibrary;

public class ShoppingCartPage {
	
	AndroidDriver<AndroidElement> mDriver;
	CommonLibrary comLib;
	public ShoppingCartPage(AndroidDriver<AndroidElement> mDriver) 
	{
		PageFactory.initElements(new AppiumFieldDecorator(mDriver), this);
		this.mDriver = mDriver;
		comLib = new CommonLibrary(mDriver);
	}
	
	@AndroidFindBy(id = "item_title")
	public AndroidElement itemDetails_Text;
	
	@AndroidFindBy(id = "item_price")
	public AndroidElement itemPrice_Text;

}
