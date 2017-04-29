/**
 * @ version 1.0
 * @ author dbxiao
 */

package webtest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class JsTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new JsTest();
	}

	public JsTest() {
		super();
		// TODO Auto-generated constructor stub
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("http://127.0.0.1");
		driver.executeScript("alert(arguments[0]);alert(arguments[1])", "a","b","c");
	}
}
