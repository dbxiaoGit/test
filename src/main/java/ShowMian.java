/**
 * @ version 1.0
 * @ author dbxiao
 */
   
   
import java.awt.*;   
import java.awt.image.ColorModel;   
import java.awt.event.*;   
import java.io.BufferedReader;   
import java.io.File;   
import java.io.FileReader;   
import java.io.FileWriter;   
import java.io.IOException;   
   
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;   
import javax.swing.border.Border;   
//import com.sun.java.swing.plaf.windows.resources.windows;   

public class ShowMian extends JFrame {   
   
    JFrame lockjf;// 锁屏界面   
    boolean isexit = false;   
    JPanel lockjp = new JPanel();   
    JLabel jl_username;   
    JLabel jl_password;   
    JButton jb_ensure;// 确定按钮   
    JButton jb_result;// 撤消按钮   
    JTextField jtf_username;// 用户名   
    JPasswordField jtf_password;// 用户密码   
    JTextArea jta;
    // 用来得到屏幕的分辨率   
    Toolkit toolkit;   
    // 用来接受屏幕返回的分辨率   
    int xscreen;// 屏幕的x坐标   
    int yscreen;// 屏幕的y坐标   
    // 定义线程让窗体每秒获得一次焦点   
    Thread thread;   
    SimpleDateFormat df=new SimpleDateFormat("[ HH:mm:ss ] ");
   
    public ShowMian() {   
        // 初始化界面   
        lockjp = new driver();   
        lockjf = this;   
        lockjf.setBackground(Color.BLACK);
        jl_username = new JLabel("用户名：");
        jl_username.setForeground(Color.red);
        jl_password = new JLabel("暗  号：");  
        jl_password.setForeground(Color.red);
        jtf_username = new JTextField();   
        jtf_password = new JPasswordField();   
        jta = new JTextArea();
        jb_ensure = new JButton("确定");   
        jb_result = new JButton("取消");   
        // 得到当前的分辨率   
        toolkit = this.getToolkit();   
        final Dimension dimension = toolkit.getScreenSize();   
        xscreen = dimension.width;   
        yscreen = dimension.height;   
        // System.out.println(xscreen + ":" + yscreen);   
        // 设置主窗体的大小   
   
        // 把各个组件注册到jframe   
        add(lockjp);   
        lockjp.setLayout(null);   
       // lockjp.add(jl_username);   
        lockjp.add(jta);
        lockjp.add(jl_password);   
       // lockjp.add(jtf_username);   
        lockjp.add(jtf_password);   
        lockjp.add(jb_ensure);   
        lockjp.add(jb_result);   
        // 设置各个组件的位置   
        this.setBounds(0, 0, xscreen, yscreen);   
        // lable的设置   
        jta.setBounds(xscreen - 270,  0, 200,  yscreen - 150);
        jl_username.setBounds(xscreen - 270, yscreen - 150, 60, 20);   
        jl_password.setBounds(xscreen - 270,  yscreen - 150 + 60, 60,   
                20);   
        // textare的设置   
        jtf_username.setBounds(jl_username.getX() + 60, jl_username.getY(),   
                140, 20);   
        jtf_username.setBorder(null);   
        jtf_password.setBounds(jl_password.getX() + 60, jl_password.getY(),   
                140, 20);   
        jtf_password.setBorder(null);   
        // button的设置   
        jb_ensure.setBounds(jl_username.getX(), jl_username.getY() + 110, 60,   
                30);   
        jb_result.setBounds(jb_ensure.getX() + 140, jb_ensure.getY(), 60, 30);   
        // 设置按钮事件   
        jb_ensure.addActionListener(new ActionListener() {   
   
            public void actionPerformed(ActionEvent arg0) {   
                // System.out.println(jtf_username.getText().equals("wayking")+":"+jtf_password.getText().equals("2925138"));   
                // TODO Auto-generated method stub   
                System.out.println(jtf_password.getPassword());   
                if (jtf_password.getText().equalsIgnoreCase("138831")) {   
                    // System.out.println("11111111111111111111111111");   
                    System.exit(1);   
                } else {   
                    jtf_username.setText("");   
                    jtf_password.setText(""); 
                    jta.setText(jta.getText()+"\n"+df.format(new Date())+"尻！没有暗号就别乱搞啊！");
                }   
            }   
   
        });   
        jb_result.addActionListener(new ActionListener() {   
   
            public void actionPerformed(ActionEvent arg0) {   
                // TODO Auto-generated method stub   
                jtf_username.setText("");   
                jtf_password.setText("");   
            }   
        });   
        // 设置焦点   
        thread = new Thread(new Runnable() {   
   
            public void run() {   
                while (true) {   
                    toFront();   
                    try {   
                        thread.sleep(100);   
                    } catch (InterruptedException e) {   
                        // TODO Auto-generated catch block   
                        e.printStackTrace();   
                    }   
                }   
            }   
        });   
        // 去掉工具栏   
        setUndecorated(true);   
   
        // 添加窗口监听   
        this.addWindowListener(new WindowListener() {   
   
            public void windowActivated(WindowEvent arg0) {   
                // TODO Auto-generated method stub   
   
            }   
   
            public void windowClosed(WindowEvent arg0) {   
                // TODO Auto-generated method stub   
   
            }   
   
            public void windowClosing(WindowEvent arg0) {   
                setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);// 不执行任何操作；要求程序在已注册的   
            }   
   
            public void windowDeactivated(WindowEvent arg0) {   
                // TODO Auto-generated method stub   
   
            }   
   
            public void windowDeiconified(WindowEvent arg0) {   
                // TODO Auto-generated method stub   
   
            }   
   
            public void windowIconified(WindowEvent arg0) {   
                // TODO Auto-generated method stub   
            }   
   
            public void windowOpened(WindowEvent arg0) {   
                // TODO Auto-generated method stub   
   
            }   
        });
        
        thread.start();   
        setVisible(true);   
        this.setAlwaysOnTop(true);}
    
    
    public static void main(String[] args) {   
        new ShowMian();   
    }   
    
    class driver extends JPanel {   
        @Override   
        protected void paintComponent(Graphics g) {   
            g.setColor(Color.BLACK);;   
            
            g.drawImage(new ImageIcon("c:/screen.jpg").getImage(), 0, 0, this   
                    .getWidth(), this.getHeight(), this);   
            g.drawRect(960, 600, 320, 200);   
            g.drawRect(960, 600, 318, 198);   
            setVisible(true);
        }   
    }   
   
}  