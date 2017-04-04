/**
 * @author dbxiao
 */
package test1;

import java.io.FileWriter;
import java.io.IOException;

public class testChar {

	public static void main(String[] args) {
		try {
			FileWriter fw = new FileWriter("d:/1.txt");
			for(int i = 1;i < 65535;i++) {
				fw.write((char)i);
				if(i % 100 == 0){
					fw.write(i+"\n");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
