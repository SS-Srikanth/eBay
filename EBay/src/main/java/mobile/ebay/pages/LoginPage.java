package mobile.ebay.pages;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginPage 
{
AndroidDriver<AndroidElement> mDriver;
	
	public LoginPage(AndroidDriver<AndroidElement> mDriver) 
	{
		PageFactory.initElements(new AppiumFieldDecorator(mDriver), this);
		this.mDriver = mDriver;
	}
	
	@AndroidFindBy(id ="edit_text_username")
	public AndroidElement username_TxtField;
	
	@AndroidFindBy(id ="et_temp")
	public AndroidElement password_TxtField;
	
	@AndroidFindBy(id ="button_sign_in")
	public AndroidElement signin_Btn;
	
	public void enterUserName(String username)
	{

		/**
		 * enter username
		 */
		username_TxtField.clear();
		username_TxtField.sendKeys(username);
	}
	
	public void enterPassword(String password)
	{
		/**
		 * enter password
		 */
		password_TxtField.sendKeys(password);
		
	}
	public void clickSignin()
	{
		/**
		 * click sign in button 
		 */
		signin_Btn.click();
	}
	
}
