/**
 * @ version 1.0
 * @ author dbxiao
 */

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;

public class CapTool {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Frame f=new Frame();
		f.setBounds(100, 100, 444, 444);
		Button recoder_screen =new Button("Record_Screen");
		Button pull_shot =new Button("Pull_Shot");
		Button clear_shot =new Button("Clear_Shot");
		recoder_screen.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					Runtime.getRuntime().exec("adb shell screenrecord --time-limit 60 /sdcard/Pictures/Screenshots/1.mp4");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		});
		
		pull_shot.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					Runtime.getRuntime().exec("adb pull /sdcard/Pictures/Screenshots/ C:\\Users\\v_dbxiao\\Desktop\\shot\\");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		});
		
		clear_shot.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					Runtime.getRuntime().exec("adb shell rm -rf /sdcard/Pictures/Screenshots/*");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		});
		f.setTitle("android tool");
		f.setLayout(new GridLayout(10,1));
		f.add(recoder_screen);
		f.add(pull_shot);
		f.add(clear_shot);
		f.setVisible(true);
		f.addWindowListener(new WindowListener(){

			@Override
			public void windowActivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowClosed(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowClosing(WindowEvent arg0) {
				// TODO Auto-generated method stub
				arg0.getWindow().dispose();
			}

			@Override
			public void windowDeactivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeiconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowIconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowOpened(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}

}
