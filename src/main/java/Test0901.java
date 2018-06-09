/**
 * @ version 1.0
 * @ author dbxiao
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class Test0901 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Test0901().start();
	}

	public void start() {
		FileInputStream fis;
		byte[] raw;
		StringBuilder sb= new StringBuilder();
		String rawString;
		try {
			fis= new FileInputStream("d:/ad.png");
			raw=new byte[fis.available()];
			fis.read(raw);
			fis.close();
			for(int i=0;i<raw.length;i++){
				int intV=raw[i]&0xff;
				if(Integer.toHexString(intV).length()<2){
					sb.append(0);
				}
				sb.append(Integer.toHexString(intV));
			}
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		rawString = sb.toString();
		System.out.println(rawString);
		
		FirefoxDriver f = new FirefoxDriver();
		WebDriverWait wdw = new WebDriverWait(f,10);
		f.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		f.get("http://npm.taobao.org");
		f.get("https://npm.taobao.org/1.html");
		//f.manage().window().maximize();
		try{
			wdw.until(ExpectedConditions.visibilityOf(f.findElementById("username"))).sendKeys("u");
			f.findElementById("password_input").sendKeys("p");
			f.findElementById("login_button").click();
		} catch (Exception e) {
			e.printStackTrace();
		}
		wdw.until(ExpectedConditions.visibilityOf(f.findElement(By.xpath("//*[@value='评论/处理意见...']")))).click();
		f.switchTo().frame(f.findElement(By.tagName("iframe")));
		f.findElement(By.tagName("body")).sendKeys(rawString);
		f.switchTo().parentFrame().findElement(By.id("update_status_btn")).click();
		//---------------
		FirefoxDriver f1 = new FirefoxDriver();
		f1.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		f1.get("http://npm.tencent.org");
		f1.get("https://npm.taobao.org");
		try{
			wdw.until(ExpectedConditions.visibilityOf(f1.findElementById("username"))).sendKeys("u");
			f1.findElementById("password_input").sendKeys("p");
			f1.findElementById("login_button").click();
		} catch (Exception e) {
			e.printStackTrace();
		}
		String content = f1.findElement(By.id("comment_area")).getText();
		Pattern p=Pattern.compile("aaaa([0-9a-zA-Z]{4})aaaa");
		Matcher m=p.matcher(content);
		
		System.out.println("\n++++++\n"+content+"\n+++++\n");
		while(!m.find()){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("not found");
			f1.navigate().refresh();
			content = f1.findElement(By.id("comment_area")).getText();
			m=p.matcher("\n----------\n"+content+"\n----------\n");
			System.out.println(content);
		}
		m=m.reset();
		while(m.find()){
			System.out.println(m.group(1));
		}
	}
	
}
