/**
 * @ version 1.0
 * @ author dbxiao
 */

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;

import io.appium.java_client.android.AndroidDriver;

import java.io.*;
import java.text.SimpleDateFormat;


public class HelloJava {
	
	public static PrintStream ps;
    FirefoxDriver f = new FirefoxDriver();
	public static SimpleDateFormat df=new SimpleDateFormat("MM-dd_HH-mm-ss");
	public static SimpleDateFormat df1=new SimpleDateFormat("[ HH:mm:ss ] ");
	String s = "adfdsfsdf";
	public static void main(String[] args)  {
			new HelloJava().start();
	 }
	
	public void start() {
		f.get("http://www.baidu.com");
	String com="document.getElementById('kw').value="+s;
	System.out.println(com);
		f.executeScript("s=s;document.getElementById('kw').value=s", s);
		f.findElement(By.id("su")).click();
	}
	
 }