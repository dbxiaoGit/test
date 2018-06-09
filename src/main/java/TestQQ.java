/**
 * @ version 1.0
 * @ author dbxiao
 */

import io.appium.java_client.android.AndroidDriver;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestQQ {
	PrintWriter pw;
	//String[] cmd={"c:\\Program Files (x86)\\Appium\\node.exe","c:\\Program Files (x86)\\Appium\\node_modules\\appium\\bin\\appium.js","--address 127.0.0.1","--port 4723","--log-timestamp","--log d:/app.log","--local-timezone","--session-override"};
	String cmd="\"c:\\Program Files (x86)\\Appium\\node.exe\" \"c:\\Program Files (x86)\\Appium\\node_modules\\appium\\bin\\appium.js\" --address 127.0.0.1 --port 4723 --log-timestamp --log d:/app.log --local-timezone --session-override ";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestQQ t=new TestQQ();
		t.start();
	}

	private AndroidDriver<WebElement> adriver;
	public void start() {
		this.startAppium();
		while(!isStarted()){
			this.startAppium();
		}
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
      //  capabilities.setCapability("automationName", "Selendroid");
        
        capabilities.setCapability("deviceName", "xxx");
        capabilities.setCapability("platformVersion", "4.4");
        capabilities.setCapability("appPackage", "com.tencent.mobileqq");
        capabilities.setCapability("appActivity", ".activity.SplashActivity");
       // capabilities.setCapability("app", "d:/mobileqq_android.apk");
        capabilities.setCapability("unicodeKeyboard", "true");
        capabilities.setCapability("resetKeyboard", "true");
        capabilities.setCapability("noReset", "true");
        capabilities.setCapability("noSign", "true");
        
        try {
			adriver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        this.waitForElement(adriver, By.xpath("//android.widget.TabWidget/android.widget.RelativeLayout[2]"));
		adriver.findElement(By.xpath("//android.widget.TabWidget/android.widget.RelativeLayout[2]")).click();
		
		this.waitForElement(adriver, By.xpath("//android.widget.RelativeLayout[contains(@content-desc,'特别关心 按钮')]"));
		adriver.findElementByXPath("//android.widget.RelativeLayout[contains(@content-desc,'特别关心 按钮')]").click();
		
		this.waitForElement(adriver, By.xpath("//android.widget.AbsListView/android.widget.RelativeLayout/android.widget.TextView"));
		adriver.findElementByXPath("//android.widget.AbsListView/android.widget.RelativeLayout/android.widget.TextView").click();
		
		this.waitForElement(adriver, By.xpath("//android.widget.Button[contains(@content-desc,'发消息')]"));
		adriver.findElementByXPath("//android.widget.Button[contains(@content-desc,'发消息')]").click();
		
		this.waitForElement(adriver, By.className("android.widget.EditText"));
		adriver.findElementByClassName("android.widget.EditText").sendKeys("恭喜恭喜，测试通过，安卓可用"+"\n"+new Date());
		/*
		while(adriver.findElementById("com.tencent.mobileqq:id/fun_btn").getAttribute("enabled").equals("false")){
			System.out.println("now "+adriver.findElementById("com.tencent.mobileqq:id/fun_btn").getAttribute("enabled"));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		*/
		this.waitForElement(adriver, By.className("android.widget.Button"));
		System.out.println(adriver.findElement(By.className("android.widget.Button")).getAttribute("enabled"));
		adriver.findElement(By.className("android.widget.Button")).click();
		adriver.quit();
		
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
	
	public boolean isStarted(){
		String confirm_cmd="cmd.exe /c netstat -ano | findstr 4723";
		Process p1=null;
		try {
			p1 = Runtime.getRuntime().exec(confirm_cmd);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedReader br=new BufferedReader(new InputStreamReader(p1.getInputStream()));
		String result="aaa";
		boolean turn=false;
		System.out.println(result);
		int wait_times=0;
		while(!turn){
			try {
				result=br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(result!=null){
				if(result.contains("LISTENING")){
					System.out.println(result);
					turn=true;
					return true;
					}
			}
			wait_times+=1;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(wait_times>5){
				turn=true;
			}
			
		}
		System.out.println(result);
		return false;
		
	}
	
	public void startAppium(){
		if(!isStarted()){
			try {
				pw=new PrintWriter(new File("d:/start.log"));
				Process p=Runtime.getRuntime().exec(cmd);
				String name=InetAddress.getLocalHost().getHostName();
				String user=name.split("-")[0];
				Thread t=new Thread(new Runnable(){
	
					@Override
					public void run() {
						// TODO Auto-generated method stub
						String[] notify_cmd={"msg",user,"正在启动服务，请稍等。。。"};
						try {
							Runtime.getRuntime().exec(notify_cmd);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						BufferedReader br=new BufferedReader(new InputStreamReader(p.getInputStream()));
						String mssage_in;
						try {
							while((mssage_in=br.readLine())!=null){
								pw.println(mssage_in);
							}
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
					
				});
				t.start();
				Thread t1=new Thread(new Runnable(){
	
					@Override
					public void run() {
						// TODO Auto-generated method stub
						BufferedReader br=new BufferedReader(new InputStreamReader(p.getErrorStream()));
						String mssage_in;
						try {
							while((mssage_in=br.readLine())!=null){
								pw.println(mssage_in);
							}
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
					
				});
				t1.start();
				
				
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		}
	}
}
