/**
 * @ version 1.0
 * @ author dbxiao
 */

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateBug {
	FirefoxDriver f;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new CreateBug().start();
	}

	public void start() {
		f = new FirefoxDriver();
		f.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		f.get("https://tieba.baidu.com/index.html");
		f.findElement(By.id("username")).sendKeys("admin");
		f.findElement(By.id("password_input")).sendKeys("123456");
		f.findElement(By.id("login_button")).click();
		f.findElement(By.id("btn_add_bug")).click();
		Set<String> windowSet = f.getWindowHandles();
		for(String s:windowSet){
			System.out.println(s);
			f.switchTo().window(s);
			if(f.getTitle().contains("创建缺陷")) {
				System.out.println(f.getTitle()+"\tbreak!");
				f.switchTo().window(s);
				break;
			}
		}
		f.executeScript("arguments[0].value=\"【主干】\"", f.findElement(By.id("BugTitle")));
		Select severityS = new Select(f.findElement(By.id("BugSeverity")));
		Select versionS = new Select(f.findElement(By.id("BugVersionReport")));
		Select baselineS = new Select(f.findElement(By.id("BugBaselineFind")));
		Select originS = new Select(f.findElement(By.id("BugOriginphase")));
		Select frequencyS = new Select(f.findElement(By.id("BugFrequency")));
		Select module=new Select(f.findElement(By.id("BugModule")));
		
		severityS.selectByIndex(2);
		versionS.selectByIndex(1);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		baselineS.selectByIndex(1);
		originS.selectByValue("测试验收阶段");
		frequencyS.selectByIndex(1);
		module.selectByIndex(1);
		f.executeScript("arguments[0].value=\"scott;\"", f.findElement(By.id("BugCurrentOwnerValue")));
		//f.findElement(By.id("BugCurrentOwnerValue")).sendKeys("liamllyang");
		f.findElement(By.id("BugCcValue")).click();
		f.findElement(By.id("_view")).click();
		
		
		
		
	}
}
