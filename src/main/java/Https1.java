/**
 * @author dbxiao
 */


import java.io.InputStreamReader;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

public class Https1 {

	public static void main(String[] args) {
		new Https1();
	}

	public Https1() {
		URL reqURL;
		try {
			reqURL = new URL("https://www.baidu.com");
			HttpsURLConnection httpsConn = (HttpsURLConnection) reqURL.openConnection();
			InputStreamReader insr;
			insr = new InputStreamReader(httpsConn.getInputStream());
			int respInt;
			do{
				respInt = insr.read();
				System.out.print((char)respInt);
			} while (respInt != -1);
		} catch (Exception e2) {
			e2.printStackTrace();
		} 
	}

}
