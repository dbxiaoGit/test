/**
 * @ version 1.0
 * @ author dbxiao
 */

import java.awt.*;
import java.io.*;

import javax.swing.*;

public class StreamTest {

	public static void main(String[] args) throws Exception {
		Process p=Runtime.getRuntime().exec("ipconfig");
		System.out.println(p.waitFor());
			System.out.println(p.exitValue());
		BufferedReader sbf=new BufferedReader(new InputStreamReader(p.getInputStream()));
		BufferedReader ebf=new BufferedReader(new InputStreamReader(p.getInputStream()));
		String s=null;
	JFrame f=new JFrame();
	f.setTitle("xxx tool");
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	f.setBounds(400, 400, 400, 400);
	
	JLabel u_label=new JLabel("username:");
	JTextField u_field=new JTextField(20);
	JPanel u_panel=new JPanel();
	u_panel.add(u_label);
	u_panel.add(u_field);
	
	JLabel p_label=new JLabel("password:");
	JTextField p_field=new JTextField(20);
	JPanel p_panel=new JPanel();
	p_panel.add(p_label);
	p_panel.add(p_field);
	
	String[] year = {"2016", "2017", "2018", "2019","2020"};
	JComboBox year_box = new JComboBox(year);
	
	String[] month =new String[12];
	for(int i=0;i<month.length;i++) {
		month[i]=Integer.toString(i+1);
	}
	JComboBox month_box = new JComboBox(month);
	
	String[] day=new String[31];
	for(int i=0;i<day.length;i++) {
		day[i]=Integer.toString(i+1);
	}
	JComboBox day_box = new JComboBox(day);
	
	String[] hour = new String[24];
	for(int i=0;i<hour.length;i++) {
		hour[i]=Integer.toString(i);
	}
	JComboBox hour_box = new JComboBox(hour);
	
	String[] minute = new String[60];
	for(int i=0;i<minute.length;i++) {
		minute[i]=Integer.toString(i);
	}
	JComboBox minute_box = new JComboBox(minute);
	
	JLabel year_label=new JLabel("年");
	JLabel month_label=new JLabel("月");
	JLabel day_label=new JLabel("日");
	JLabel hour_label=new JLabel("时");
	JLabel minute_label=new JLabel("分");
	
	
	JPanel date_panel=new JPanel();
	date_panel.add(year_box);
	date_panel.add(year_label);
	date_panel.add(month_box);
	date_panel.add(month_label);
	date_panel.add(day_box);
	date_panel.add(day_label);
	date_panel.add(hour_box);
	date_panel.add(hour_label);
	date_panel.add(minute_box);
	date_panel.add(minute_label);
	
	JLabel tips_label=new JLabel("提示:");
	
	JLabel content_label=new JLabel("啊啊啊");
	
	JLabel tips1_label=new JLabel();
	JLabel tips2_label=new JLabel();
	JLabel tips3_label=new JLabel();
	JButton confirm_button = new JButton("确定");
	
	content_label.setForeground(Color.RED);
	JPanel sr_panel=new JPanel();
	sr_panel.setLayout(new GridLayout(10,1));
	sr_panel.add(u_panel);
	sr_panel.add(p_panel);
	sr_panel.add(date_panel);
	sr_panel.add(tips_label);
	sr_panel.add(content_label);
	sr_panel.add(tips1_label);
	sr_panel.add(tips2_label);
	sr_panel.add(tips3_label);
	sr_panel.add(confirm_button);
	
	
	f.add(sr_panel);
	f.setVisible(true);
	}

}
