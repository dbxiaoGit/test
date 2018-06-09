/**
 * @author dbxiao
 */


import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;

public class QQWait {
	AndroidDriver<AndroidElement> adriver;
	List<AndroidElement> l;

	public void waitAndClick(int step, Point p, Dimension d, String s) throws Exception {
		for (int i = 0;; i++) {
			System.out.println("--->"+"step"+step+" Round "+i);
			if (i > 3) {
				throw new Exception("step" + step + " timeout!");
			}
			l = adriver.findElementsByAndroidUIAutomator(s);
			int j = 0;
			for (WebElement e : l) {
				System.out.print(++j + "\tclassname:" + e.getAttribute("className") + "\tname:" + e.getAttribute("name")
						+ "\tresourceId:" + e.getAttribute("resourceId") + e.getLocation() + e.getSize() + "\n");
			}
			boolean isClicked = false;
			for (WebElement e : l) {
				if (e.getLocation().equals(p) && e.getSize().equals(d)) {
					System.out.println("begin to click " + step + "\tclassname:" + e.getAttribute("className")
							+ "\tname:" + e.getAttribute("name") + "\tresourceId:" + e.getAttribute("resourceId")
							+ e.getLocation() + e.getSize());
					e.click();
					isClicked = true;
					break;
				}
			}
			if (isClicked) {
				break;
			} else {
				System.out.println("sleep 1 second");
				Thread.sleep(1000);
			}
		}
	}

	@Test
	public void f() throws Exception {

		waitAndClick(1, new Point(0, 237), new Dimension(720, 132), "new UiSelector().clickable(true)");
		waitAndClick(2, new Point(612, 1205), new Dimension(102, 68), "new UiSelector().clickable(true)");
		waitAndClick(3, new Point(200, 1064), new Dimension(160, 176), "new UiSelector().clickable(true)");
		waitAndClick(4, new Point(298, 70), new Dimension(124, 60), "new UiSelector().clickable(true)");
		waitAndClick(5, new Point(16, 64), new Dimension(121-16, 136-64), "new UiSelector().clickable(true)");
		waitAndClick(6, new Point(0, 362), new Dimension(720, 448-362), "new UiSelector().clickable(true)");
		waitAndClick(7, new Point(0, 264), new Dimension(720, 384-264), "new UiSelector().clickable(true)");
		waitAndClick(8, new Point(0, 264), new Dimension(720, 392-264), "new UiSelector().clickable(true)");
		waitAndClick(9, new Point(571, 1200), new Dimension(712-571, 1260-1200), "new UiSelector().clickable(true)");
	}

	@BeforeTest
	public void beforeTest() throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "Android Emulator");
		capabilities.setCapability("platformVersion", "4.4");
		capabilities.setCapability("appPackage", "com.tencent.mobileqq");
		capabilities.setCapability("appActivity", ".activity.SplashActivity");
		adriver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	}

	@AfterTest
	public void afterTest() {
		adriver.quit();
	}

}
