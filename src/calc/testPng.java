/**
 * @ version 1.0
 * @ author dbxiao
 */

package calc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class testPng {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream fis =new FileInputStream("d:/ad.png");
		int i;
		System.out.print("aaa");
		while(true){
			System.out.print("aaa");
			i=fis.read();
			System.out.print(i);
			if(i==-1)break;
		}
		fis.close();
	}

}
