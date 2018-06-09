/**
 * @ version 1.0
 * @ author dbxiao
 */

import java.awt.BorderLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class AndroidTools {
	JFrame f;
	JPanel j;
	TextArea ta;
	String record="adb shell screenrecord --time-limit 30 /sdcard/Pictures/Screenshots/1.mp4";
	String pull="adb pull /sdcard/Pictures/Screenshots/ d:/shot/";
	String clear="adb shell rm -rf /sdcard/Pictures/Screenshots/*";
	String log="adb pull /sdcard/android/data/com.tencent.tmgp.projectb/files/log/ d:/shot/";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new AndroidTools().start();
	}
	
	public void start(){
		f=new JFrame("Android Tool   v1.0");
		j=new JPanel();
		ta=new TextArea();
		//f.setLayout(new BorderLayout());
		JButton record_button=new JButton("record");
		record_button.addActionListener(new MyActionListener(record,ta));
		JButton pull_button=new JButton("pull");
		pull_button.addActionListener(new MyActionListener(pull,ta));
		JButton clear_button=new JButton("clear");
		clear_button.addActionListener(new MyActionListener(clear,ta));
		JButton log_button=new JButton("get_log");
		log_button.addActionListener(new MyActionListener(log,ta));
		j.add(record_button);
		j.add(pull_button);
		j.add(clear_button);
		j.add(log_button);
		f.add(j,BorderLayout.NORTH);
		f.add(ta,BorderLayout.CENTER);
		f.setBounds(100, 100, 444, 444);
		f.setVisible(true);
		f.setDefaultCloseOperation(3);
		
	}
}

class MyActionListener implements ActionListener{
	String cmd;
	TextArea ta;
	Process p;
	public MyActionListener(String cmd,TextArea ta){
		this.cmd=cmd;
		this.ta=ta;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		try {
			p=Runtime.getRuntime().exec(cmd);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Thread t=new Thread(new MyThread(p,ta));
		t.start();
	}
	
}

class MyThread implements Runnable{
	Process p;
	TextArea ta;
	public MyThread(Process p,TextArea ta){
		this.p=p;
		this.ta=ta;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(p.getInputStream()));
		while(true){
			try {
				String s=br.readLine();
				if(s!=null){
					ta.append(s+"\n");
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}