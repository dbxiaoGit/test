/**
 * @ version 1.0
 * @ author dbxiao
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class StrP20160808 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new PngToString().PngToString1("d:/ad.png");
	}

}

class PngToString {
	public String PngToString1(File file){
		FileInputStream fis;
		try {
			fis = new FileInputStream(file);
			System.out.println(file.getPath());
			int b;
			while((b=fis.read())!=-1){
				//System.out.println(Integer.toHexString(b));
			}
			
			fis.close();
			String s="a|b|csdf|a";
			String[] s1=s.split("|");
			for(String i :s1){
				System.out.println(i);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	public String PngToString1(String str) {
		return PngToString1(new File(str));
	}
}
