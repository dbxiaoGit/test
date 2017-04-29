/**
 * @ version 1.0
 * @ author dbxiao
 */

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ProB {
    private AndroidDriver<WebElement> driver;

    public void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName","Android Emulator");
        capabilities.setCapability("platformVersion", "4.4");
        capabilities.setCapability("appPackage", "com.x.tmgp.ProjectB");
        capabilities.setCapability("appActivity", ".ApolloTest");
        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    	System.out.println(driver.currentActivity());
    	System.out.println(driver.manage().window().getSize());
    	for(int i=0;i<30;i++){
    		System.out.println(i);
    		Thread.sleep(1000);
    	}
    	
    	long a=System.currentTimeMillis()+3*60*1000;
    	while(System.currentTimeMillis()<a){
    		Thread.sleep(200);
    		driver.tap(1, 1500, 1030, 100);
    		System.out.println("tap once again ");
    	}
    	
    	//driver.close();
    	//System.out.println("close:"+driver);
    	driver.quit();
    	System.out.println("quit:"+driver);
    	System.out.println(driver.equals(null));
    	driver.quit();
    }

    public void s2() throws InterruptedException, MalformedURLException{
    	 DesiredCapabilities capabilities = new DesiredCapabilities();
         capabilities.setCapability("deviceName","Android Emulator");
         capabilities.setCapability("platformVersion", "4.4");
         capabilities.setCapability("appPackage", "com.x.mobileqq");
         capabilities.setCapability("appActivity", ".activity.SplashActivity");
         driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
     	System.out.println(driver.currentActivity());
     	System.out.println(driver.manage().window().getSize());
     	for(int i=0;i<1;i++){
     		System.out.println(i);
     		Thread.sleep(1000);
     	}
     	
     	long a=System.currentTimeMillis()+1*3*1000;
     	while(System.currentTimeMillis()<a){
     		Thread.sleep(200);
     		driver.tap(1, 1500, 1030, 100);
     		System.out.println("tap once again ");
     	}
     	
     	//driver.close();
     	//System.out.println("close:"+driver);
     	driver.quit();
     	System.out.println("quit:"+driver);
     	System.out.println(driver.equals(null));
     	driver.quit();
    }

    public static void main(String[] a) throws Exception {
    	ProB p=new ProB();
    	p.setUp();
    	//p.s2();
    	
    }
}
