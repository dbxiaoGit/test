/**
 * @ version 1.0
 * @ author dbxiao
 */

import java.io.IOException;

public class RunTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Process p=Runtime.getRuntime().exec("javac");
			try {
				System.out.println(p.waitFor());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
