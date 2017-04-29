/**
 * @ version 1.0
 * @ author dbxiao
 */

import java.util.ArrayList;
import java.util.List;

public class Th1 {
//	public static String str;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> l = new ArrayList<>();
		l.add("list_1");
		l.add("list_2");
		for(String s : l ) {
			//final String str = s;
			String str = new String(s);
			new Thread(){
				public void run() {
					try {
						new Th2().doM(str);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}.start();
		}
	}
}

class Th2 {
	public  void doM(String s) throws InterruptedException {
		for (int i = 0 ; i < 4 ; i++) {
			System.out.println(s);
			Thread.sleep(1000);
		}
	}
}