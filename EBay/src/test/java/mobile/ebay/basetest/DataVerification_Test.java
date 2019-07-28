package mobile.ebay.basetest;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import mobile.ebay.model.Constants;
import mobile.ebay.pages.HomePage;

public class DataVerification_Test extends BaseTest
{
	String itemName, itemPrice;
	
	@Test
	public void dataVerification_ProductAndCheckoutScreen() throws IOException
	{
		try 
		{
			homePage.searchItem(dataManager.readPropertiesData(Constants.propertiesFilePath, "itemName"));
			homePage.clickRandomTV(dataManager.readPropertiesData(Constants.propertiesFilePath, "randomTV"));
		 	itemName = homePage.itemDetails_Txt.getText();
		 	itemPrice = homePage.itemPrice_Txt.getText();
			homePage.clickAddToCart_Btn();
			homePage.clickCart_Icn();
			Assert.assertEquals(itemName,shoppingCartPage.itemDetails_Text.getText());
		} 
		catch (Exception e) 
		{
			commonLibrary.takeScreenshot();
			Assert.fail(e.toString());
		}
		
		
		
	}
	
}
