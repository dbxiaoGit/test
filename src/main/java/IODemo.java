/**
 * @ version 1.0
 * @ author dbxiao
 */


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class IODemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		try {
			System.setOut(new PrintStream(new File("./a.txt")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i=0;i<100;i++)
		System.out.println(i);
	}

}
