/**
 * @ version 1.0
 * @ author dbxiao
 */

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Call1 {
	SimpleDateFormat df;
	Date date;
	public static void main(String[] args) {
		new Call1().start();
	}
	public void start() {
		df=new SimpleDateFormat("yyyy-MM-dd_HH:mm");
		try {
			 date=df.parse("2016-3-24_7:50");
			 System.out.println(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new Timer().schedule(new TimerTask(){
			public void run(){
				try {
					Runtime.getRuntime().exec("java -jar f:/hello.jar");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					new Call1().start();
				}
			}
		},date);
	}
}
