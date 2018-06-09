/**
 * @ version 1.0
 * @ author dbxiao
 */


import java.awt.Container;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class ThreadAndAwt extends JFrame {
	private int counter=0;
	private static Thread t;
	private JLabel jl =new JLabel();
	private Container container=getContentPane();
	public ThreadAndAwt(){
		URL url=ThreadAndAwt.class.getResource("./icon.png");
		Icon icon=new ImageIcon(url);
		setBounds(400,400,400,400);
		container.setLayout(null);
		jl.setIcon(icon);
		jl.setBounds(10, 10, 50, 50);
		jl.setHorizontalAlignment(SwingConstants.LEFT);
		jl.setOpaque(true);
		container.add(jl);
		t=new Thread(new Runnable(){
			public void run(){
				while(counter<=400){
					jl.setBounds(counter, 10, 200, 200);
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					counter+=10;
					if(counter==400){
						counter=0;
					}
				}
			}
		});
		t.start();
		container.add(jl);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ThreadAndAwt();
	}

}
