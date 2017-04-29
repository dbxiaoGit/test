/**
 * @ version 1.0
 * @ author dbxiao
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class RefreshPage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new RefreshPage();
	}
	
	public RefreshPage() {
		try {
			ServerSocket sc = new ServerSocket(80);
			while(true) {
				Socket s = sc.accept();
				BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
				String url = br.readLine();
				System.out.println(url);
				String[] url_split = url.split(" ");
				String response = "<script type='text/javascript'>window.location.href='http://npm.taobao.org"+url_split[1]+"'</script>";
				System.out.println(response);
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
				bw.write(response);
				bw.flush();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
