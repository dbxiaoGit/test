/**
 * @ version 1.0
 * @ author dbxiao
 */

package com.db;

import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import org.openqa.selenium.remote.DesiredCapabilities;

public class HuanleChat {
	DesiredCapabilities cap ;
	AndroidDriver<AndroidElement> driver;
	int screenWidth,screenHeight;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new HuanleChat();
	}
	public HuanleChat() {
		cap = new DesiredCapabilities();
		cap.setCapability("deviceName", "aaa");
		cap.setCapability("platformVersion", "4.4");
		cap.setCapability("appPackage", "com.tencent.tmgp.hlxq");
		cap.setCapability("appActivity", "com.tencent.tmgp.hlxq.CelfAndroidPlugin");
		try {
			driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
			System.out.println(driver.getPageSource());
			screenWidth = driver.manage().window().getSize().width;
			screenHeight =driver.manage().window().getSize().height;
			System.out.println(screenWidth+"|"+screenHeight);
			Thread.sleep(10000);
			System.out.println("点击朕已阅");
			driver.tap(1,screenWidth/2 , screenHeight*9/10, 300);
			Thread.sleep(1000);
			System.out.println("点击进入游戏");
			driver.tap(1,screenWidth/2 , screenHeight*9/10, 300);
			Thread.sleep(20000);
			System.out.println("点击聊天区域");
			driver.tap(1,screenWidth/5 , screenHeight*14/15, 300);
			Thread.sleep(3000);
			while(true) {
				this.sendMsg();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("退出");
			driver.quit();
		}
	}
	
	public void sendMsg() throws InterruptedException {
		int duration = (int) (Math.random()*4000);
		System.out.println("长按语音按钮");
		driver.tap(1,screenWidth/8 , screenHeight*14/15, 1000+duration);
		Thread.sleep(3000);
		System.out.println("点击表情按钮");
		driver.tap(1,screenWidth/2-10 , screenHeight*14/15, 300);
		Thread.sleep(1000);
		System.out.println("选择表情");
		driver.tap(1,screenWidth/2+50 , screenHeight*10/15+20, 300);
		Thread.sleep(3000);
	}

}
