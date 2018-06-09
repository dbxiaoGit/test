/**
 * @ version 1.0
 * @ author dbxiao
 */

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;

public class TestUrl0509 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		new TestUrl0509().start();
	}
	
	public void start() throws Exception{
		URL u=new URL("http://www.qq.com");
		HttpURLConnection http59=(HttpURLConnection) u.openConnection();
		InputStream ip59=http59.getInputStream();
		BufferedReader br59=new BufferedReader(new InputStreamReader(ip59));
		String s;
		while((s=br59.readLine())!=null){
			System.out.println(s);
		}
		
	}

}
