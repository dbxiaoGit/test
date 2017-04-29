/**
 * @ version 1.0
 * @ author dbxiao
 */

import java.io.*;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;

import java.util.concurrent.*;

public class Shot{
	public static void main(String[] args) throws Exception{
		FirefoxDriver a=new FirefoxDriver();
		a.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		a.get("http://elearning.pactera.com/els/html/studyCourse/studyCourse.enterCourse.do?courseId=7febd35cd13347448c1c26b3f6dea30d&studyType=STUDY");
		a.findElement(By.id("username")).sendKeys("username");
		a.findElement(By.id("password")).sendKeys("password");
		a.findElement(By.id("btn_login")).click();
		
		//Thread.sleep(10000);
		FileOutputStream fos=new FileOutputStream("d:/shot.png");
		FileInputStream fis=new FileInputStream(a.getScreenshotAs(OutputType.FILE));
		for(int b=0;(b=fis.read())!=-1;){
			fos.write(b);
		}
		fis.close();
		fos.close();
		a.close();
	}
}
