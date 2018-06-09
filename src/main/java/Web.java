/**
 * @ version 1.0
 * @ author dbxiao
 */

import org.openqa.selenium.firefox.FirefoxDriver;

public class Web {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FirefoxDriver f =new FirefoxDriver();
		f.get("http://www.baidu.com");
		f.executeScript( "arguments[0].value=('sdf');arguments[1].click()",f.findElementById("kw"),f.findElementById("su"));
		
		
		
	}

}
