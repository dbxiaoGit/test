/**
 * @ version 1.0
 * @ author dbxiao
 */

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class World {
	
	PrintStream ps;
	FirefoxDriver f;
	String username;
	String password;
	SimpleDateFormat df_log=new SimpleDateFormat("[ HH:mm:ss ] ");
	SimpleDateFormat dfh=new SimpleDateFormat("HH");
	SimpleDateFormat dfm=new SimpleDateFormat("mm");
	//int hour =Integer.valueOf(dfh.format(new Date())).intValue();
	//int minute = Integer.valueOf(dfm.format(new Date())).intValue();
	 
	public static void main(String[] args) {
		new World().start(args);
	 }
	
	public void start(String[] args) {
		try {
			ps=new PrintStream("d:/a.log");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(args.length!=2){
			ps.println(df_log.format(new Date())+"\nUsage:\n\tjavaw World username password");
			System.exit(1);
		}
		
		this.username=args[0];
		this.password=args[1];
		ps.println(df_log.format(new Date())+"username="+this.username+"\t"+"password="+this.password);
		while(true) {
			int hour =Integer.valueOf(dfh.format(new Date())).intValue();
			int minute = Integer.valueOf(dfm.format(new Date())).intValue();
			this.clickCheck(hour, minute);
			try {
				Thread.sleep(600000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	public void login() {
		f = new FirefoxDriver();
		f.get("http://npm.taobao.org");
		this.waitForElement(this.f,By.id("username"));
		f.findElementById("username").sendKeys(this.username);
		this.waitForElement(this.f,By.id("password_input"));
		f.findElementById("password_input").sendKeys(this.password);
		this.waitForElement(this.f,By.id("login_button"));
		f.findElementById("login_button").click();
		this.waitForElement(this.f,By.xpath("//a[@href='/users/logout']"));
		System.out.println(this.f.findElement(By.xpath("//a[@href='/users/logout']")));
		ps.println(df_log.format(new Date())+"login sucess ! ");
	}
	
	public void clickCheck(int hour,int minute) {
		if(hour==9&&minute>15&&minute<26){
			this.login();
			this.waitForElement(this.f,By.id("checkin_btn"));
			this.f.findElementById("checkin_btn").click();
			this.waitForElement(this.f,By.id("ui-dialog-title-tdialog"));
			this.waitForElement(this.f,By.name("check"));
			this.f.executeScript("document.getElementsByName('check')[0].click()", "");	
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		} else if (hour==1&&minute>35&&minute<46){
			this.login();
			this.waitForElement(this.f,By.id("checkout_btn"));
			this.f.findElementById("checkout_btn").click();
			this.waitForElement(this.f,By.id("ui-dialog-title-tdialog"));
			this.waitForElement(this.f,By.name("check"));
			this.f.executeScript("document.getElementsByName('check')[0].click()", "");	
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		} 
	}
	
	public boolean isElement(WebDriver driver,By by) {
		try {
			System.out.println(driver.findElement(by));
			ps.println(df_log.format(new Date())+by+" is found ! return true ");
			return true;
		} catch(NoSuchElementException e) {
			ps.println(df_log.format(new Date())+by+" not found ! return false \n");
			return false;
		}
	}
	
	public void waitForElement(WebDriver driver,By by) {
		for(int i=0;;i++){
			if(i>30){
				ps.println(df_log.format(new Date())+"time out to find \n"+by);
				break;
			}
			if(isElement(driver,by)){
				ps.println(df_log.format(new Date())+by+" is found !");
				break;
			} else {
				ps.println(df_log.format(new Date())+" 1 second late  to find "+by+" again!");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					ps.println(df_log.format(new Date())+" Interrupted Exception occur !\n"+e);
				}
			}
		}
	}
}