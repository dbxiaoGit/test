/**
 * @ version 1.0
 * @ author dbxiao
 */

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class TestSocket {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		new TestSocket().start();
	}

	public void start() throws Exception {
		Socket s = new Socket(InetAddress.getByAddress(new byte[]{10,14,0,106}),8080);
		OutputStream os = s.getOutputStream();
		//Thread t=new Thread(new ReadClass(s.getInputStream()));
		//t.start();
		String msg = "02000000ac0201000a000000003ac8000109c18a226b9177989f67f1604fed2a31090de5aba7d4b8566aaeb4264db404081db8aeaefbc79a9c1acb7784edebdfe668204699bff47b6ac930f772b635e4ce24d250a8a48fb46ebe6a7e28cd73cf035678e1ceb812dacfc17df96b21d5a00269b46a66087c709ce968414fcab522d695be2e83be4a6fe46fd7efdeb57b5358a6a6e0040bc5cab5e1cbed5d4701b084012f495383cb5766449303";
		byte[] msgContent = msg.getBytes();
		for(byte b:msgContent){
			System.out.println(b);
		}
		
		for(int i = 0;i < 10;i++){
			os.write(msgContent);
			os.flush();
			Thread.sleep(1000);
		}
		os.close();
	}
}

class ReadClass extends Thread {
	
	DataInputStream is;
	public ReadClass(InputStream s){
		this.is = new DataInputStream(s);
	}
	@Override
	public void run(){
		while(true){
			char c;
			try {
				c = is.readChar();
				//System.out.println(c);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
		}
	}
}