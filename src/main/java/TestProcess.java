/**
 * @ version 1.0
 * @ author dbxiao
 */

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.TextArea;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TestProcess {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		/*
		System.out.println(InetAddress.getLocalHost().getHostName().split("-")[0]);
		String confirm_cmd="cmd.exe /c netstat -ano | findstr 4723";
		Process p=Runtime.getRuntime().exec(confirm_cmd);
		BufferedReader br=new BufferedReader(new InputStreamReader(p.getInputStream()));
		String result;
		while((result=br.readLine())!=null){
			if(result.contains("LISTENING")){
				
				System.out.println(result);
				break;
			}
		}
		*/
		JFrame f=new JFrame();
		f.setBounds(100,100,400,400);
		f.setVisible(true);
		f.setLayout(new BorderLayout());
		JPanel jp1=new JPanel();
		jp1.add(new Button("1"));
		jp1.add(new Button("2"));
		jp1.add(new Button("3"));
		JPanel jp2=new JPanel();
		JPanel jp3=new JPanel();
		
		f.add(jp1,BorderLayout.PAGE_START);
		f.add(jp2,BorderLayout.SOUTH);
		f.add(jp3,BorderLayout.CENTER);
		//f.add(new Button("b"),BorderLayout.NORTH);
		

	}
}
