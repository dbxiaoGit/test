/**
 * @ version 1.0
 * @ author dbxiao
 */

import io.appium.java_client.android.AndroidDriver;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;


public class TestQQ610 {
    private AndroidDriver<WebElement> adriver;

    public void start() throws Exception{
    	DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName","Android Emulator");
        capabilities.setCapability("platformVersion", "4.4");
        capabilities.setCapability("appPackage", "com.tencent.mobileqq");
        capabilities.setCapability("appActivity", ".activity.SplashActivity");
        capabilities.setCapability("unicodeKeyboard", "true");
        capabilities.setCapability("resetKeyboard", "true");
        adriver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    	adriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    	
    	adriver.findElement(By.xpath("//android.widget.AbsListView/android.widget.LinearLayout[1]")).click();
    	adriver.findElement(By.id("com.tencent.mobileqq:id/input")).sendKeys("aa");
    	adriver.findElement(By.id("com.tencent.mobileqq:id/fun_btn")).click();
    	Thread.sleep(3000);
    	adriver.quit();
    }
    public static void main(String[] a) throws Exception{
    	new TestQQ610().start();
    }
}
