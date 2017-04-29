/**
 * @ version 1.0
 * @ author dbxiao
 */

import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.InetAddress;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Hello1 {
	static String username;
	static String password;
	public static PrintStream ps;
    FirefoxDriver f = new FirefoxDriver();
    AndroidDriver<WebElement> adriver;
	public static SimpleDateFormat df=new SimpleDateFormat("MM-dd_HH-mm-ss");
	public static SimpleDateFormat df1=new SimpleDateFormat("[ HH:mm:ss ] ");
	
	//初始化用户名、密码
	public static void initUser(String u,String p){
		Hello1.username=u;
		Hello1.password=p;
	}
	
	//入口
	public static void main(String[] args)  {
		new MyFrame().startFrame();
	 }
	
	//开始
	public void start() {
		try {
			//创建日志文件
			String file_name="d:/"+df.format(new Date())+".log";
			//实例化打印流
			ps = new PrintStream(file_name);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			//new Hello1().start();
		}
		//登录
		this.login();
		//^_^
		this.clickCheck();
	}
	
	 //登录
	public void login() {
		 
		f.get("https://tieba.baidu.com/index.html");
		this.waitForElement(this.f,By.id("username"));
		f.findElementById("username").sendKeys(Hello1.username);
		this.waitForElement(this.f,By.id("password_input"));
		f.findElementById("password_input").sendKeys(Hello1.password);
		this.waitForElement(this.f,By.id("login_button"));
		f.findElementById("login_button").click();
		this.waitForElement(this.f,By.xpath("//a[@href='/users/logout']"));
		System.out.println(this.f.findElement(By.xpath("//a[@href='/users/logout']")));
		ps.println(df1.format(new Date())+"login sucess ! ");
	}
	
	public void clickCheck() {
		SimpleDateFormat dfh=new SimpleDateFormat("HH");
		//SimpleDateFormat dfm=new SimpleDateFormat("mm");
		int hour =Integer.valueOf(dfh.format(new Date())).intValue();
		//int minute = Integer.valueOf(dfm.format(new Date())).intValue();
		//判断当前时间
		if(hour>=7&&hour<14){
			this.waitForElement(this.f,By.id("i"));
			this.f.findElementById("i").click();
			this.waitForElement(this.f,By.id("x"));
			this.waitForElement(this.f,By.name("xx"));
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			//判断是否有验证码
			if(this.isElement(this.f, By.id("image"))){
					ps.println(df1.format(new Date())+" begin to call createElementImage function ... ");
					//截图验证码
					this.createElementImage(this.f, this.f.findElement(By.id("image")));
					ps.println(df1.format(new Date())+" begin to get code ... ");
					//通过安卓获得验证码
					String code=this.getPngCode();
					while(code.equals("error")) {
						code=this.getPngCode();
					}
					//输入验证码
					this.f.findElement(By.id("code_input")).sendKeys(code);
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			this.f.executeScript("document.getElementsByName('check')[0].click()", "");	
			//提交信息，等待三秒
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//循环判断是否点击成功
			for(int i=0;;i++){
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				//如果尝试点击确定三次以上还不行则放弃
				if(i>3){
					ps.println(df1.format(new Date())+" click 3 times failure !  ");
					this.f.quit();
					break;
					//new Hello1().start();
				}
				//如果成功则通过安卓发送ok，失败则继续循环
				if(this.f.findElement(By.id("ui-dialog-title-tdialog")).getText().contains("成功")){
					ps.println(df1.format(new Date())+" in success !");
					this.f.quit();
					ps.println(df1.format(new Date())+" begin to start android for confirm ");
					boolean b=this.confirm();
					//判断是否发送失败，失败重发
					while(!b){
						ps.println(df1.format(new Date())+" start android for confirm again ");
						b=this.confirm();
					}
					break;
				} else {
					ps.println(df1.format(new Date())+" click failue 1 second reclick !");
					
					this.f.findElement(By.name("check")).click();
				}
			}
			
		} else if (hour>=14&&hour<=23){
			this.waitForElement(this.f,By.id("o"));
			this.f.findElementById("o").click();
			this.waitForElement(this.f,By.id("ui-dialog-title-tdialog"));
			this.waitForElement(this.f,By.name("check"));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			if(this.isElement(this.f, By.id("image"))){
					ps.println(df1.format(new Date())+" begin to call createElementImage function ... ");
					this.createElementImage(this.f, this.f.findElement(By.id("image")));
					ps.println(df1.format(new Date())+" begin to get code ... ");
					String code=this.getPngCode();
					while(code.equals("error")) {
						code=this.getPngCode();
					}
					this.f.findElement(By.id("code_input")).sendKeys(code);
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			this.f.executeScript("document.getElementsByName('check')[0].click()", "");	
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			for(int i=0;;i++){
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if(i>3){
					ps.println(df1.format(new Date())+" click 3 times failure !  ");
					this.f.quit();
					break;
					//new Hello1().start();
				}
				if(this.f.findElement(By.id("ui-dialog-title-tdialog")).getText().contains("成功")){
					ps.println(df1.format(new Date())+" out success !");
					this.f.quit();
					ps.println(df1.format(new Date())+" begin to start android for confirm ");
					boolean b=this.confirm();
					while(!b){
						b=this.confirm();
						ps.println(df1.format(new Date())+" start android for confirm again ");
					}
					break;
				} else {
					ps.println(df1.format(new Date())+" click failue 1 second reclick !");
					
					this.f.findElement(By.name("check")).click();
				}
			}
			
		} else {
			ps.println(df1.format(new Date())+"time  issue");
			this.f.quit();
		}
	}
	
	public boolean isElement(WebDriver driver,By by) {
		try {
			System.out.println(driver.findElement(by));
			ps.println(df1.format(new Date())+by+" is found ! return true ");
			return true;
		} catch(NoSuchElementException e) {
			ps.println(df1.format(new Date())+by+" not found ! return false \n");
			return false;
		}
	}
	
	public void waitForElement(WebDriver driver,By by) {
		for(int i=0;;i++){
			if(i>30){
				ps.println(df1.format(new Date())+"time out to find \n"+by);
				break;
			}
			if(isElement(driver,by)){
				ps.println(df1.format(new Date())+by+" is found !");
				break;
			} else {
				ps.println(df1.format(new Date())+" 1 second late  to find "+by+" again!");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						ps.println(df1.format(new Date())+" Interrupted Exception occur !\n"+e);
					}
			}
		}
	}
	
	public void createElementImage(WebDriver driver, WebElement webElement) {
		ps.println(df1.format(new Date())+" create image begin ! ");
		Point location = webElement.getLocation();
		Dimension size = webElement.getSize();
		try{	
			BufferedImage bigImage = ImageIO.read(this.f.getScreenshotAs(OutputType.FILE));
			BufferedImage subImage = bigImage.getSubimage(location.getX(), location.getY(), size.getWidth(),
					size.getHeight());
			ImageIO.write(subImage, "png", new File("d:/ad.png"));
			ps.println(df1.format(new Date())+" push image to android begin ! ");
			Thread.sleep(3000);
			String pushCmd="adb push d:/ad.png /sdcard/00/";
			Process pushP=Runtime.getRuntime().exec(pushCmd);
			BufferedReader pushBr=new BufferedReader(new InputStreamReader(pushP.getErrorStream()));
			String pushResult;
			//System.out.println(pushP.exitValue());
			boolean isOk=true;
			while(isOk){
				pushResult=pushBr.readLine();
				if(pushResult!=null){
					System.out.println(pushResult);
					ps.println(df1.format(new Date())+pushResult);
					if(pushResult.contains("bytes")){
						ps.println(df1.format(new Date())+" push png success ! ");
						isOk=false;
					}
				}
				System.out.println(isOk);
			}
		} catch(Exception e) {
			e.printStackTrace();
			ps.println(df1.format(new Date())+"createElementImage occur exception \n"+e);
			this.createElementImage(driver,webElement);
		}
	}
	
	public String getPngCode() {
		String code = null;
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "Android Emulator");
		capabilities.setCapability("platformVersion", "4.4");
		capabilities.setCapability("appPackage", "com.tencent.mobileqq");
		capabilities.setCapability("appActivity", ".activity.SplashActivity");
		capabilities.setCapability("noSign", "true");
		try {
			adriver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
			ps.println(df1.format(new Date())+" android start ! ");
			this.waitForElement(adriver, By.xpath("//android.widget.TabWidget/android.widget.RelativeLayout[2]"));
			adriver.findElement(By.xpath("//android.widget.TabWidget/android.widget.RelativeLayout[2]")).click();
			
			this.waitForElement(adriver, By.xpath("//*[contains(@content-desc,'特别关心 按钮')]"));
			ps.println(df1.format(new Date())+" click special care ");
			adriver.findElementByXPath("//*[contains(@content-desc,'特别关心 按钮')]").click();
			
			this.waitForElement(adriver, By.xpath("//android.widget.AbsListView/android.widget.RelativeLayout/android.widget.TextView"));
			String str = adriver.findElementByXPath("//android.widget.AbsListView/android.widget.RelativeLayout/android.widget.TextView").getText();
			ps.println(df1.format(new Date())+" now str is " + str);
			ps.println(df1.format(new Date())+" click special friend");
			adriver.findElementByXPath("//android.widget.AbsListView/android.widget.RelativeLayout/android.widget.TextView").click();
			
			this.waitForElement(adriver, By.xpath("//*[contains(@content-desc,'发消息')]"));
			ps.println(df1.format(new Date())+" click send message button. ");
			adriver.findElementByXPath("//*[contains(@content-desc,'发消息')]").click();
			
			this.waitForElement(adriver, By.xpath("//*[contains(@content-desc,'加号')]"));
			ps.println(df1.format(new Date())+" click + button. ");
			adriver.findElementByXPath("//*[contains(@content-desc,'加号')]").click();
			
			this.waitForElement(adriver, By.xpath("//*[contains(@content-desc,'文件按钮')]"));
			ps.println(df1.format(new Date())+" click document button. ");
			adriver.findElementByXPath("//*[contains(@content-desc,'文件按钮')]").click();
			
			this.waitForElement(adriver, By.xpath("//*[contains(@text,'本机')]"));
			ps.println(df1.format(new Date())+" click this phone. ");
			adriver.findElementByXPath("//*[contains(@text,'本机')]").click();
			
			this.waitForElement(adriver, By.xpath("//*[contains(@text,'全部')]"));
			ps.println(df1.format(new Date())+" click all . ");
			adriver.findElementByXPath("//*[contains(@text,'全部')]").click();
			
			this.waitForElement(adriver, By.xpath("//*[contains(@text,'SD卡')]/parent::*"));
			ps.println(df1.format(new Date())+" click sd_card ");
			adriver.findElementByXPath("//*[contains(@text,'SD卡')]/parent::*").click();
			
			this.waitForElement(adriver, By.xpath("//*[contains(@text,'00')]"));
			ps.println(df1.format(new Date())+" click 00 ");
			adriver.findElementByXPath("//*[contains(@text,'00')]").click();
			
			this.waitForElement(adriver, By.xpath("//*[@text='ad.png']/../android.widget.CheckBox"));
			ps.println(df1.format(new Date())+" click check_box ");
			adriver.findElementByXPath("//*[@text='ad.png']/../android.widget.CheckBox").click();
			
			this.waitForElement(adriver, By.id("com.tencent.mobileqq:id/send"));
			ps.println(df1.format(new Date())+" click send button. ");
			Thread.sleep(1000);
			adriver.findElementById("com.tencent.mobileqq:id/send").click();
			Thread.sleep(3000);
			String str1 = adriver.findElementById("com.tencent.mobileqq:id/title").getText();
			ps.println(df1.format(new Date())+" str1 is " + str1 );
			ps.println(df1.format(new Date())+" str == str1 ? --> "+str.equals(str1));
			int count=0;
			while (str.equals(str1)) {
				int x = adriver.manage().window().getSize().width;
				int y = adriver.manage().window().getSize().height;
				adriver.swipe(x / 2, y / 4, x / 2, y * 4 / 5, 2000);
				str1 = adriver.findElementById("com.tencent.mobileqq:id/title").getText();
				ps.println(df1.format(new Date())+" now str1 is " + str1 );
				count+=1;
				if(count>30){
					ps.println(df1.format(new Date())+"timeout to get an different name !\n ");
					adriver.quit();
					return "error";
				}
			}
			ps.println(df1.format(new Date())+" now code is " + code );
			code = str1;
			ps.println(df1.format(new Date())+" now code is " + code );
		} catch (Exception e) {
			// TODO Auto-generated catch block
			ps.println(df1.format(new Date())+"adriver exception occor !\n "+e);
			adriver.quit();
			return "error";
		}
		
		adriver.quit();
		return code;
		
	}
	
	public boolean confirm() {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "Android Emulator");
		capabilities.setCapability("platformVersion", "4.4");
		capabilities.setCapability("appPackage", "com.tencent.mobileqq");
		capabilities.setCapability("appActivity", ".activity.SplashActivity");
		capabilities.setCapability("noSign", "true");
		
		try {
			adriver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
			ps.println(df1.format(new Date())+" android start ! ");
			
			this.waitForElement(adriver, By.xpath("//android.widget.TabWidget/android.widget.RelativeLayout[2]"));
			ps.println(df1.format(new Date())+" click contact ");
			adriver.findElement(By.xpath("//android.widget.TabWidget/android.widget.RelativeLayout[2]")).click();
			
			this.waitForElement(adriver, By.xpath("//android.widget.RelativeLayout[contains(@content-desc,'特别关心 按钮')]"));
			ps.println(df1.format(new Date())+" click special care ");
			adriver.findElementByXPath("//android.widget.RelativeLayout[contains(@content-desc,'特别关心 按钮')]").click();
			
			this.waitForElement(adriver, By.xpath("//android.widget.AbsListView/android.widget.RelativeLayout/android.widget.TextView"));
			ps.println(df1.format(new Date())+" click special friend ");
			adriver.findElementByXPath("//android.widget.AbsListView/android.widget.RelativeLayout/android.widget.TextView").click();
			
			this.waitForElement(adriver, By.xpath("//android.widget.Button[contains(@content-desc,'发消息')]"));
			ps.println(df1.format(new Date())+" click send message button. ");
			adriver.findElementByXPath("//android.widget.Button[contains(@content-desc,'发消息')]").click();
			
			this.waitForElement(adriver, By.id("com.tencent.mobileqq:id/input"));
			ps.println(df1.format(new Date())+" type in ok ");
			adriver.findElementById("com.tencent.mobileqq:id/input").sendKeys("ok");
			
			this.waitForElement(adriver, By.id("com.tencent.mobileqq:id/fun_btn"));
			/*
			while(adriver.findElementById("com.tencent.mobileqq:id/fun_btn").getAttribute("enabled").equals("false")){
				ps.println("now "+adriver.findElementById("com.tencent.mobileqq:id/fun_btn").getAttribute("enabled"));
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			*/
			ps.println(df1.format(new Date())+" click send  ");
				Thread.sleep(1000);
			adriver.findElementById("com.tencent.mobileqq:id/fun_btn").click();
				
				Thread.sleep(3000);
			/*
			while(!adriver.findElementById("com.tencent.mobileqq:id/fun_btn").getAttribute("enabled").equals("false")){
				ps.println(df1.format(new Date())+" now "+adriver.findElementById("com.tencent.mobileqq:id/fun_btn").getAttribute("enabled"));
				adriver.findElementById("com.tencent.mobileqq:id/fun_btn").click();
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			*/
		} catch (Exception e) {
			// TODO Auto-generated catch block
			ps.println(df1.format(new Date())+" adriver exception in confirm +\n "+e);
			adriver.quit();
			return false;
		}
		adriver.quit();
		return true ;
	}
 }

//定时类
class Call11 {
	SimpleDateFormat df;
	Date date;
	
	public void start(String time) {
		df=new SimpleDateFormat("yyyy-MM-dd_HH:mm");
		try {
			 date=df.parse(time);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new Timer().schedule(new TimerTask(){
			public void run(){
				new Hello1().start();
			}
		},date);
	}
}

//GUI类
class MyFrame1 {
	JFrame f=new JFrame();
	public static TextArea jta=new TextArea();
	static JPanel sr_panel;
	static String username;
	static String password;
	static String time;

	public void startFrame(){
		this.writePanel();
	}
	
	public void writePanel(){
		
		f.setTitle("xxx tool  Version:1.0");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setBounds(100, 100, 400, 400);
		
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
		JComboBox<String> year_box = new JComboBox<String>(year);
		
		String[] month =new String[12];
		for(int i=0;i<month.length;i++) {
			month[i]=Integer.toString(i+1);
		}
		JComboBox<String> month_box = new JComboBox<String>(month);
		
		String[] day=new String[31];
		for(int i=0;i<day.length;i++) {
			day[i]=Integer.toString(i+1);
		}
		JComboBox<String> day_box = new JComboBox<String>(day);
		
		String[] hour = new String[24];
		for(int i=0;i<hour.length;i++) {
			hour[i]=Integer.toString(i);
		}
		JComboBox<String> hour_box = new JComboBox<String>(hour);
		
		String[] minute = new String[60];
		for(int i=0;i<minute.length;i++) {
			minute[i]=Integer.toString(i);
		}
		JComboBox<String> minute_box = new JComboBox<String>(minute);
		
		JLabel year_label=new JLabel("年/");
		JLabel month_label=new JLabel("月/");
		JLabel day_label=new JLabel("日/");
		JLabel hour_label=new JLabel("时：");
		JLabel minute_label=new JLabel("分。");
		
		
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
		
		JLabel tips_label=new JLabel("温馨提示:");
		
		JLabel content_label=new JLabel("呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵。。。");
		
		JButton confirm_button = new JButton("确定");
		confirm_button.addActionListener(new ActionListener(){
			
			private PrintWriter pw;
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				confirm_button.setEnabled(false);
				this.startAppium();
				while(!isStarted()){
					this.startAppium();
				}
				
				MyFrame.username=u_field.getText();
				MyFrame.password=p_field.getText();
				MyFrame.time=(String) year_box.getSelectedItem()+"-"+month_box.getSelectedItem()+"-"+day_box.getSelectedItem()+"_"+hour_box.getSelectedItem()+":"+minute_box.getSelectedItem();
				Hello1.initUser(MyFrame.username, MyFrame.password);
				System.out.println(MyFrame.time);
				confirm_panel();
				new Call().start(time);
				
			}
			
			
			public boolean isStarted(){
				
				String confirm_cmd="cmd.exe /c netstat -ano | findstr 4723";
				Process p1=null;
				try {
					MyFrame.displayText(confirm_cmd);
					p1 = Runtime.getRuntime().exec(confirm_cmd);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				BufferedReader br=new BufferedReader(new InputStreamReader(p1.getInputStream()));
				String result="aaa";
				boolean turn=false;
				System.out.println(result);
				int wait_times=0;
				while(!turn){
					try {
						result=br.readLine();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if(result!=null){
						if(result.contains("LISTENING")){
							MyFrame.displayText(result);
							MyFrame.displayText("appium服务已启动了");
							turn=true;
							return true;
						}
					}
					wait_times+=1;
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if(wait_times>5){
						turn=true;
					}
					
				}
				return false;
				
			}
			
			public void startAppium(){
				if(!isStarted()){
					try {
						String cmd="\"c:\\Program Files (x86)\\Appium\\node.exe\" \"c:\\Program Files (x86)\\Appium\\node_modules\\appium\\bin\\appium.js\" --address 127.0.0.1 --port 4723 --log-timestamp --log d:/app.log --local-timezone --session-override";
						pw=new PrintWriter(new File("d:/start.log"));
						MyFrame.displayText("starting appium...");
						Process p=Runtime.getRuntime().exec(cmd);
						String name=InetAddress.getLocalHost().getHostName();
						String user=name.split("-")[0];
						Thread t=new Thread(new Runnable(){
			
							@Override
							public void run() {
								// TODO Auto-generated method stub
								String[] notify_cmd={"msg",user,"正在启动服务，请稍等。。。"};
								displayText("正在启动服务，请稍等。。。");
								try {
									Runtime.getRuntime().exec(notify_cmd);
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								BufferedReader br=new BufferedReader(new InputStreamReader(p.getInputStream()));
								String mssage_in="appium msg";
								try {
									while(true){
										if((mssage_in=br.readLine())!=null){
											MyFrame.displayText(mssage_in);
											pw.println(mssage_in);
										}
									}
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								
							}
							
						});
						t.start();
						Thread t1=new Thread(new Runnable(){
			
							@Override
							public void run() {
								// TODO Auto-generated method stub
								BufferedReader br=new BufferedReader(new InputStreamReader(p.getErrorStream()));
								String mssage_in;
								try {
									while((mssage_in=br.readLine())!=null){
										MyFrame.displayText(mssage_in);
										pw.println(mssage_in);
									}
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								
							}
							
						});
						t1.start();
						
						
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
				}
			}
			
		});
		
		content_label.setForeground(Color.RED);
		JPanel sr_panel=new JPanel();
		sr_panel.setLayout(new GridLayout(3,1));
		JPanel up_panel=new JPanel();
		JPanel down_panel=new JPanel();
		
		up_panel.add(u_panel);
		up_panel.add(p_panel);
		up_panel.add(date_panel);
		
	
		
		down_panel.add(tips_label);
		down_panel.add(content_label);
		down_panel.add(confirm_button);
		
		jta.setEditable(false);
		sr_panel.add(jta);
		sr_panel.add(up_panel);
		sr_panel.add(down_panel);
		
		f.add(sr_panel);
		f.setVisible(true);
	}
	
	public void confirm_panel(){
		JFrame confirm_frame=new JFrame("confirm");
		confirm_frame.setBounds(500, 100, 400, 400);
		JPanel confirm_panel=new JPanel();
		JLabel tips=new JLabel("请确认以下信息：");
		JLabel tips1=new JLabel("");
		JLabel u_label=new JLabel("username:");
		JLabel u_label1=new JLabel(MyFrame.username);
		u_label1.setBorder(BorderFactory.createLineBorder(Color.RED));
		JLabel p_label=new JLabel("password:");
		JLabel p_label1=new JLabel(MyFrame.password);
		p_label1.setBorder(BorderFactory.createLineBorder(Color.RED));
		JLabel time_label=new JLabel("time:");
		JLabel time_label1=new JLabel(MyFrame.time);
		time_label1.setBorder(BorderFactory.createLineBorder(Color.RED));
		confirm_panel.setLayout(new GridLayout(10,2));
		confirm_panel.add(tips);
		confirm_panel.add(tips1);
		confirm_panel.add(u_label);
		confirm_panel.add(u_label1);
		confirm_panel.add(p_label);
		confirm_panel.add(p_label1);
		confirm_panel.add(time_label);
		confirm_panel.add(time_label1);
		
		confirm_frame.add(confirm_panel);
		confirm_frame.setVisible(true);
	}
	
	public static void displayText(String a){
		MyFrame.jta.append(a);
		MyFrame.jta.append("\n");
	}


}
