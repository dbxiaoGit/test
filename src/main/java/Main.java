/**
 * @ version 1.0
 * @ author dbxiao
 */

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main {

	private static AndroidDriver driver;
	
	public static void main(String[] args)  {
		 DesiredCapabilities capabilities = new DesiredCapabilities();
	        capabilities.setCapability("deviceName","selendroid");
	        capabilities.setCapability("platformVersion", "4.2");
	        capabilities.setCapability("appPackage", "com.android.chrome");
	        capabilities.setCapability("appActivity", "org.chromium.chrome.browser.ChromeTabbedActivity");
	    
		try {
			driver=new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			driver.quit();
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		try{
		driver.get("http://www.baidu.com");
		System.out.println("dianji");
		driver.switchTo().parentFrame() ;
			TouchAction tap = new TouchAction(driver);
			tap.press(451,721).waitAction(200).release().perform();
			//driver.tap(1, 451, 721, 200);
			driver.findElement(By.id("kw")).sendKeys("adf");
			driver.quit();
		}catch(WebDriverException e){
			e.printStackTrace();
			driver.quit();
			
		}
	}

}