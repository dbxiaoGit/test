/**
 * @ version 1.0
 * @ author dbxiao
 */

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;

import java.net.URL;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TestQ {
    private AndroidDriver adriver;

    @Before
    public void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName","Android Emulator");
        capabilities.setCapability("platformVersion", "4.4");
        capabilities.setCapability("appPackage", "com.tencent.mobileqq");
        capabilities.setCapability("appActivity", ".activity.SplashActivity");
        capabilities.setCapability("unicodeKeyboard", "true");
        capabilities.setCapability("resetKeyboard", "true");
        adriver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @After
    public void tearDown() throws Exception {
        adriver.quit();
    }
    
    public void waitAndClick(int step,Point p,Dimension d,String s) throws Exception{
    	List<WebElement> l;
    	for(int i=0;;i++){
    		if(i>5){
    			throw new Exception("step"+step+" timeout!");
    		}
    		l = adriver.findElementsByAndroidUIAutomator(s);
    		int j=0;
    		for(WebElement e:l){
        		System.out.print(++j+"\tclassname:"+e.getAttribute("className")+"\tname:"+e.getAttribute("name")+"\tresourceId:"+e.getAttribute("resourceId")+ e.getLocation()+e.getSize()+"\n");
        	}
    		boolean isClicked=false;
    		for(WebElement e:l){
        		if(e.getLocation().equals(p)&&e.getSize().equals(d)){
        			System.out.println("begin to click "+step+"\tclassname:"+e.getAttribute("className")+"\tname:"+e.getAttribute("name")+"\tresourceId:"+e.getAttribute("resourceId")+ e.getLocation()+e.getSize());
        			e.click();
        			isClicked=true;
        			break;
        		} 
        	}
    		if(isClicked){
    			break;
    		}else{
    			Thread.sleep(1000);
    		}
    	}
	}

    @Test
    public void sendMsg() throws Exception{
    	
    	/*
    	waitAndClick(1,new Point(0,355),new Dimension(1080, 198),"new UiSelector().clickable(true)");
    	this.waitForElement(adriver, By.id("com.tencent.mobileqq:id/input"));
    	
    	System.out.println("send button enable status is "+adriver.findElementById("com.tencent.mobileqq:id/fun_btn").getAttribute("enabled"));
		
    	adriver.findElementById("com.tencent.mobileqq:id/input").sendKeys("ok");
		
    	System.out.println("send button enable status is "+adriver.findElementById("com.tencent.mobileqq:id/fun_btn").getAttribute("enabled"));
		
		this.waitForElement(adriver, By.id("com.tencent.mobileqq:id/fun_btn"));
		adriver.findElementById("com.tencent.mobileqq:id/fun_btn").click();
		
		System.out.println("send button enable status is "+adriver.findElementById("com.tencent.mobileqq:id/fun_btn").getAttribute("enabled"));
    	
    	*/
    	
    	
    	waitAndClick(1,new Point(0,355),new Dimension(1080, 198),"new UiSelector().clickable(true)");
    	waitAndClick(2,new Point(919,1664),new Dimension(152, 101),"new UiSelector().clickable(true)");
    	waitAndClick(3,new Point(300, 1452),new Dimension(240, 264),"new UiSelector().clickable(true)");
    	waitAndClick(4,new Point(447, 105),new Dimension(633-447, 195-105),"new UiSelector().clickable(true)");
    	//waitAndClick(4,new Point(0, 483),new Dimension(1080, 1143),"new UiSelector().clickable(true)");
    	waitAndClick(5,new Point(24, 96),new Dimension(158, 108),"new UiSelector().clickable(true)");
    	waitAndClick(6,new Point(0, 543),new Dimension(1080, 129),"new UiSelector().clickable(true)");
    	waitAndClick(7,new Point(0, 396),new Dimension(1080, 180),"new UiSelector().clickable(true)");
    	waitAndClick(8,new Point(0, 396),new Dimension(1080, 588-396),"new UiSelector().clickable(true)");
    	waitAndClick(9,new Point(856, 1656),new Dimension(212, 90),"new UiSelector().clickable(true)");
    	
    	
    	/*
    	WebDriverWait wdw=new WebDriverWait(adriver,30);
    	wdw.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.AbsListView/android.widget.LinearLayout[1]"))).click();
    	//adriver.findElement(By.id("com.tencent.mobileqq:id/ivTitleBtnRightCall"));
    	System.out.println(wdw.until(ExpectedConditions.elementToBeClickable(By.id("com.tencent.mobileqq:id/ivTitleBtnRightCall"))));
    	List<WebElement> l=adriver.findElements(By.xpath("//android.widget.ImageView"));
    	int i=0;
    	for(WebElement e:l){
    		System.out.print(++i+"\tclassname:"+e.getAttribute("className")+"\tname:"+e.getAttribute("name")+"\tresourceId:"+e.getAttribute("resourceId")+((MobileElement) e).getLocation()+"\n");
    		if(e.getLocation().equals(new Point(919,1664))){
    			System.out.println("ok");
    			e.click();
    		}
    	}
    	//System.out.println(adriver.getPageSource());
    	//System.out.println(adriver.findElement(By.xpath("//android.widget.ImageView[contains,(@Location='(919, 1664)')]")));
    	//wdw.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ImageView[10]"))).click();
    	//System.out.println(wdw.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.support.v4.view.ViewPager/android.widget.RelativeLayout[6]"))));
    	i=0;
    	l=adriver.findElements(By.xpath("//android.widget.RelativeLayout"));
    	for(WebElement e:l){
    		System.out.print(++i+"\tclassname:"+e.getAttribute("className")+"\tname:"+e.getAttribute("name")+"\tresourceId:"+e.getAttribute("resourceId")+((MobileElement) e).getLocation()+"\n");
    		if(e.getLocation().equals(new Point(300,1452))){
    			System.out.println("ok");
    			e.click();
    		}
    	}
    	
    	wdw.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.RadioButton[@text='本机']"))).click();
    	wdw.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text='全部']"))).click();
    	
    	i=0;
    	l=adriver.findElements(By.xpath("//android.widget.RelativeLayout"));
    	for(WebElement e:l){
    		System.out.print(++i+"\tclassname:"+e.getAttribute("className")+"\tname:"+e.getAttribute("name")+"\tresourceId:"+e.getAttribute("resourceId")+((MobileElement) e).getLocation()+"\n");
    		if(e.getLocation().equals(new Point(0,543))){
    			System.out.println("ok");
    			e.click();
    		}
    	}
    	
    	wdw.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.FrameLayout/android.widget.TextView[2]"))).click();
    	wdw.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.AbsListView/android.widget.FrameLayout[3]/android.widget.RelativeLayout"))).click();
    	wdw.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.AbsListView/android.widget.LinearLayout[1]"))).click();
    	wdw.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.CheckBox"))).click();
    	wdw.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Button"))).click();
    	
    	
    	//	this.waitForElement(adriver, By.xpath("//android.widget.AbsListView/android.widget.LinearLayout[1]"));
	//	adriver.findElement(By.xpath("//android.widget.AbsListView/android.widget.LinearLayout[1]")).click();
    	
	//	this.waitForElement(adriver, By.xpath("//android.widget.FrameLayout/android.widget.ImageView[10]"));
	//	adriver.findElementByXPath("//android.widget.FrameLayout/android.widget.ImageView[10]").click();
		String str = adriver.findElementByXPath("//android.widget.AbsListView/android.widget.RelativeLayout/android.widget.TextView").getText();
		/*
		ps.println(df1.format(new Date())+" click special friend");
		adriver.findElementByXPath("//android.widget.AbsListView/android.widget.RelativeLayout/android.widget.TextView").click();
		
		this.waitForElement(adriver, By.xpath("//*[contains(@content-desc,'发消息')]"));
		ps.println(df1.format(new Date())+" click send message button. ");
		adriver.findElementByXPath("//*[contains(@content-desc,'发消息')]").click();
		
		this.waitForElement(adriver, By.xpath("//*[contains(@content-desc,'加号')]"));
		ps.println(df1.format(new Date())+" click + button. ");
		adriver.findElementByXPath("//*[contains(@content-desc,'加号')]").click();
		
		this.waitForElement(adriver, By.xpath("//*[contains(@content-desc,'文件按钮')]"));
		adriver.findElementByXPath("//*[contains(@content-desc,'文件按钮')]").click();
		
		this.waitForElement(adriver, By.xpath("//*[contains(@text,'本机')]"));
		adriver.findElementByXPath("//*[contains(@text,'本机')]").click();
		
		this.waitForElement(adriver, By.xpath("//*[contains(@text,'全部')]"));
		adriver.findElementByXPath("//*[contains(@text,'全部')]").click();
		
		this.waitForElement(adriver, By.xpath("//*[contains(@text,'SD卡')]/parent::*"));
		adriver.findElementByXPath("//*[contains(@text,'SD卡')]/parent::*").click();
		
		this.waitForElement(adriver, By.xpath("//*[contains(@text,'00')]"));
		adriver.findElementByXPath("//*[contains(@text,'00')]").click();
		
		this.waitForElement(adriver, By.xpath("//*[@text='ad.png']/../android.widget.CheckBox"));
		adriver.findElementByXPath("//*[@text='ad.png']/../android.widget.CheckBox").click();
		
		this.waitForElement(adriver, By.id("com.tencent.mobileqq:id/send"));
		adriver.findElementById("com.tencent.mobileqq:id/send").click();
		
		
		String str1 = adriver.findElementById("com.tencent.mobileqq:id/title").getText();
		
		
		
		int count=0;
		while (str.equals(str1)) {
			int x = adriver.manage().window().getSize().width;
			int y = adriver.manage().window().getSize().height;
			adriver.swipe(x / 2, y / 4, x / 2, y * 4 / 5, 2000);
			str1 = adriver.findElementById("com.tencent.mobileqq:id/title").getText();
			count+=1;
			if(count>30){
				adriver.quit();
			}
		}
    	
		this.waitForElement(adriver, By.xpath("//android.widget.TabWidget/android.widget.RelativeLayout[2]"));
		adriver.findElement(By.xpath("//android.widget.TabWidget/android.widget.RelativeLayout[2]")).click();
		
		this.waitForElement(adriver, By.xpath("//android.widget.RelativeLayout[contains(@content-desc,'特别关心 按钮')]"));
		adriver.findElementByXPath("//android.widget.RelativeLayout[contains(@content-desc,'特别关心 按钮')]").click();
		
		this.waitForElement(adriver, By.xpath("//android.widget.AbsListView/android.widget.RelativeLayout/android.widget.TextView"));
		adriver.findElementByXPath("//android.widget.AbsListView/android.widget.RelativeLayout/android.widget.TextView").click();
		
		this.waitForElement(adriver, By.xpath("//android.widget.Button[contains(@content-desc,'发消息')]"));
		adriver.findElementByXPath("//android.widget.Button[contains(@content-desc,'发消息')]").click();
		
		this.waitForElement(adriver, By.id("com.tencent.mobileqq:id/input"));
		adriver.findElementById("com.tencent.mobileqq:id/input").sendKeys("ok");
		while(adriver.findElementById("com.tencent.mobileqq:id/fun_btn").getAttribute("enabled").equals("false")){
			System.out.println("now "+adriver.findElementById("com.tencent.mobileqq:id/fun_btn").getAttribute("enabled"));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.waitForElement(adriver, By.id("com.tencent.mobileqq:id/fun_btn"));
		System.out.println(adriver.findElementById("com.tencent.mobileqq:id/fun_btn").getAttribute("enabled"));
		adriver.findElementById("com.tencent.mobileqq:id/fun_btn").click();
		adriver.quit();
		*/
    }
    
    public void sendPng() {
		try{
			//List<AndroidElement> l;
			waitForElement(adriver, By.xpath("//android.widget.TabWidget/android.widget.RelativeLayout[2]"));
			System.out.println(adriver.findElementByXPath("//android.widget.TabWidget/android.widget.RelativeLayout[2]"));
			adriver.findElementByXPath("//android.widget.TabWidget/android.widget.RelativeLayout[2]").click();;
			
			this.waitForElement(adriver, By.xpath("//*[contains(@content-desc,'特别关心 按钮')]"));
			adriver.findElementByXPath("//*[contains(@content-desc,'特别关心 按钮')]").click();
			this.waitForElement(adriver, By.xpath("//android.widget.AbsListView/android.widget.RelativeLayout/android.widget.TextView"));
			adriver.findElementByXPath("//android.widget.AbsListView/android.widget.RelativeLayout/android.widget.TextView").click();
			this.waitForElement(adriver, By.xpath("//*[contains(@content-desc,'发消息')]"));
			adriver.findElementByXPath("//*[contains(@content-desc,'发消息')]").click();
			//this.waitForElement(adriver, By.id("com.tencent.mobileqq:id/input"));
			//adriver.findElementById("com.tencent.mobileqq:id/input").sendKeys("你好");

			this.waitForElement(adriver, By.xpath("//*[contains(@content-desc,'加号')]"));
			adriver.findElementByXPath("//*[contains(@content-desc,'加号')]").click();
			
			this.waitForElement(adriver, By.xpath("//*[contains(@content-desc,'文件按钮')]"));
			adriver.findElementByXPath("//*[contains(@content-desc,'文件按钮')]").click();
			
			this.waitForElement(adriver, By.xpath("//*[contains(@text,'本机')]"));
			adriver.findElementByXPath("//*[contains(@text,'本机')]").click();
			
			this.waitForElement(adriver, By.xpath("//*[contains(@text,'全部')]"));
			adriver.findElementByXPath("//*[contains(@text,'全部')]").click();
			
			this.waitForElement(adriver, By.xpath("//*[contains(@text,'SD卡')]/parent::*"));
			adriver.findElementByXPath("//*[contains(@text,'SD卡')]/parent::*").click();
			

			this.waitForElement(adriver, By.xpath("//android.widget.AbsListView/android.widget.LinearLayout[1]"));
			adriver.findElementByXPath("//android.widget.AbsListView/android.widget.LinearLayout[1]").click();
			
			this.waitForElement(adriver, By.xpath("//android.widget.CheckBox[1]"));
			adriver.findElementByXPath("//android.widget.CheckBox[1]").click();
			
			this.waitForElement(adriver, By.id("com.tencent.mobileqq:id/send"));
			adriver.findElementById("com.tencent.mobileqq:id/send").click();
			
			
		} catch(Exception e){
			e.printStackTrace();
		}
    }
    public boolean isElement(WebDriver driver,By by) {
		try {
			System.out.println(driver.findElement(by));
			System.out.println("return true "+by);
			return true;
		} catch(NoSuchElementException e) {
			System.out.println("return false "+by);
			return false;
		}
	}
	
	public void waitForElement(WebDriver driver,By by) {
		for(int i=0;;i++){
			if(i>10){
				System.out.println("time out"+by);
				break;
			}
			if(isElement(driver,by)){
				System.out.println("element found"+by);
				break;
			} else {
					try {
						System.out.println("wait a second "+by);
						Thread.sleep(1000);
					} catch (InterruptedException e) {
					}
			}
		}
	}
class MyExpectedCondition implements ExpectedCondition<WebElement> {
	AndroidDriver<WebElement> d;
	By b;
	public MyExpectedCondition(AndroidDriver<WebElement> d,By b){
		super();
		this.d=d;
		this.b=b;
	}
	@Override
	public WebElement apply(WebDriver d) {
		// TODO Auto-generated method stub
		System.out.println(d.findElement(b));
		return d.findElement(b);
	}
	
}
}
