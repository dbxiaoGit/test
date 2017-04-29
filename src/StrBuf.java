/**
 * @ version 1.0
 * @ author dbxiao
 */

import java.io.File;
import java.io.FileOutputStream;

public class StrBuf {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		msgPrint("d:/1.txt","sdf");

	}
	
	public static void msgPrint(String filePath,String str) throws Exception {
		File file=new File(filePath);
		FileOutputStream out=new FileOutputStream(file,true);
		StringBuffer sb=new StringBuffer();
		sb.append(str);
		sb.append("\t\n");
		out.write(sb.toString().getBytes("utf-8"));
		//out.flush();
		out.close();
	}
	
}
