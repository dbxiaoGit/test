/**
 * @ version 1.0
 * @ author dbxiao
 */

package com.test;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Picture {

	public static void main(String[] args) {
		new Picture().start();
	}

	public void start() {
		FirefoxDriver f = new FirefoxDriver();
		f.get("http://www.android-doc.com/tools/help/MonkeyRunner.html");
		
		try {
			ImageIO.write(ImageIO.read(f.getScreenshotAs(OutputType.FILE)),"png",new File("d:/111.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		f.quit();
	}
}
