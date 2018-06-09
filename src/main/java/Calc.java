/**
 * @ version 1.0
 * @ author dbxiao
 */


import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Calc {
	public Calc(){
		Frame mainFrame = new Frame("calc v1.0");
		TextArea resultTextArea = new TextArea();
		//resultTextArea.setSize(300, 100);
		Panel resultPanel = new Panel();
		resultPanel.add(resultTextArea);
		Panel downPanel = new Panel();
		Panel numPanel = new Panel();
		Panel functionPanel = new Panel();
		
		Button[] button=new Button[9];
		final String[] num=new String[9];
		for(int i=1;i<10;i++){
			num[i] = Integer.toString(i);
			button[i]  = new Button(num[i]);
			numPanel.add(button[i]);
		}
		Button btnClean = new Button("c");
		Button btnZero= new Button("0");
		Button btnEqual = new Button("=");
		numPanel.add(btnClean);
		numPanel.add(btnZero);
		numPanel.add(btnEqual);
		
		Button plus = new Button("+");
		Button minus = new Button("-");
		Button multiply = new Button("*");
		Button divide = new Button("/");
		functionPanel.add(plus);
		functionPanel.add(minus);
		functionPanel.add(multiply);
		functionPanel.add(divide);
		downPanel.add(numPanel);
		downPanel.add(functionPanel);
		mainFrame.add(resultTextArea);
		mainFrame.add(downPanel);
		numPanel.setLayout(new GridLayout(4,3));
		functionPanel.setLayout(new GridLayout(4,1));
		mainFrame.setLayout(new GridLayout(2,1));
		mainFrame.pack();
		mainFrame.addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		//mainFrame.setSize(400,400);
		mainFrame.setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Calc();
	}

}
