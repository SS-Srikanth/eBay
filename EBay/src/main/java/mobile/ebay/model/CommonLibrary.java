package mobile.ebay.model;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class CommonLibrary {
	
	/**
	 * To manage all common actions 
	 */ 
	
	private AndroidDriver<AndroidElement> mDriver;
	WebDriverWait wait;
	public CommonLibrary() 
	{
		
	}
	public CommonLibrary(AndroidDriver<AndroidElement> mDriver)
	{
		this.mDriver  = mDriver;
		wait = new WebDriverWait(mDriver, 40);
	}
	public void scrollDown()
	{
		/**
		 * To scroll down the screen
		 */ 
		Dimension dimension = mDriver.manage().window().getSize();
		
		Double scrollHeightStart = dimension.getHeight()*0.5;
		int scrollStart = scrollHeightStart.intValue();
		
		Double scrollHeightEnd = dimension.getHeight()*0.2;
		int scrollEnd = scrollHeightEnd.intValue();
		
		new TouchAction(mDriver).press(PointOption.point(0, scrollStart)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(PointOption.point(0, scrollEnd)).release().perform();
	}
	
	public void scrollUp()
	{
		
		/**
		 * To scroll up  the screen
		 */ 
		
		Dimension dimension = mDriver.manage().window().getSize();
		
		Double scrollHeightStart = dimension.getHeight()*0.5;
		int scrollStart = scrollHeightStart.intValue();
		
		Double scrollHeightEnd = dimension.getHeight()*0.2;
		int scrollEnd = scrollHeightEnd.intValue();
		
		new TouchAction(mDriver).press(PointOption.point(0, scrollEnd)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(PointOption.point(0, scrollStart)).release();
	}
	
	public void explicitWait(WebDriver driver,AndroidElement androidElement)
	{
		/**
		 * wait for the element 
		 */ 
		
		wait.until(ExpectedConditions.visibilityOf(androidElement));
	}
	
	public void takeScreenshot() throws IOException
	{
		/**
		 * Take the screen shot 
		 */ 
		String folderName = "screenshot";
        File file=((TakesScreenshot)mDriver).getScreenshotAs(OutputType.FILE);
        
        SimpleDateFormat simpleDateFormat = new  SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");
        new File(folderName).mkdir();
        
        String fileName=simpleDateFormat.format(new Date())+".png";
        
        FileUtils.copyFile(file, new File(folderName + "/" + fileName));
	}
	
}
