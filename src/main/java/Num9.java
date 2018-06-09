/**
 * @ version 1.0
 * @ author dbxiao
 */


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Num9 {

	public static void main(String[] args) {
		System.out.println("enter str :");
		Scanner sc =new Scanner(System.in);
		String s=sc.nextLine();
		char[] c =s.toCharArray();
		for(int i=0;i<c.length;i++){
			if(c[i]=='a'||c[i]=='b'||c[i]=='c')
				c[i]='2';
			if(c[i]=='d'||c[i]=='e'||c[i]=='f')
				c[i]='3';
			if(c[i]=='g'||c[i]=='h'||c[i]=='i')
				c[i]='4';
			if(c[i]=='j'||c[i]=='k'||c[i]=='l')
				c[i]='5';
			if(c[i]=='m'||c[i]=='n'||c[i]=='o')
				c[i]='6';
			if(c[i]=='p'||c[i]=='q'||c[i]=='q'||c[i]=='s')
				c[i]='7';
			if(c[i]=='t'||c[i]=='u'||c[i]=='v')
				c[i]='8';
			if(c[i]=='w'||c[i]=='x'||c[i]=='y'||c[i]=='z')
				c[i]='9';
				
		}
		for(char i :c)
			System.out.print(i);
	}

}
