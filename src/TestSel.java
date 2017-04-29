/**
 * @ version 1.0
 * @ author dbxiao
 */

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestSel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FirefoxDriver f= new FirefoxDriver();
		f.navigate().to("file:///f:/1.html");
		f.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//f.findElementByXPath("//*[@atta='div1-1']").click();
		//System.out.println(f.findElementByXPath("//*[@atta='div1-1']"));
		List<WebElement> l=f.findElementsByXPath("//*[@atta='div1-1' and contains(@attb,'div1')]");
		System.out.println(l.size());
		for(WebElement e:l){
			System.out.println(e);
			e.click();
		}
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		f.quit();
	}

}
