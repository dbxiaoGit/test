/**
 * @ version 1.0
 * @ author dbxiao
 */

import java.util.Calendar;
import java.util.regex.Pattern;

import org.openqa.selenium.firefox.FirefoxDriver;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new test().start();
	}

	public void start() {
		/*try {
			throw new Exception("aa");
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("\n\n\n\n\nbb");*/
		FirefoxDriver f = new FirefoxDriver();
		f.get("http://127.0.0.1/");
		System.out.println(Calendar.getInstance().get(Calendar.MINUTE));
		System.out.println(Pattern.matches("[0-9a-zA-Z]{4}","aaaa"));
		System.out.println(Pattern.matches("[0-9a-zA-Z]{4}","AAAA"));
		System.out.println(Pattern.matches("[0-9a-zA-Z]{4}","1aAs"));
		System.out.println(Pattern.matches("[0-9a-zA-Z]{4}","A1a2"));
		System.out.println(Pattern.matches("[0-9a-zA-Z]{4}","aa1A1"));
		System.out.println(Pattern.matches("[0-9a-zA-Z]{4}","11111"));
	}
}
