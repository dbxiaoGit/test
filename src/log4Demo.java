/**
 * @ version 1.0
 * @ author dbxiao
 */

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class log4Demo {
	static Logger log;
	public static void main(String[] args) {
		log = Logger.getLogger(log4Demo.class);
		new Schedule();
	}
}

class Schedule {
	Logger log;
	Calendar currentCalendar,targetCalendar;
	public Schedule() {
		log = Logger.getLogger(Schedule.class);
		currentCalendar = Calendar.getInstance();
		targetCalendar = Calendar.getInstance();
		log.debug("currentCalendar = " + currentCalendar.getTime());
		log.debug("targetCalendar = " + targetCalendar.getTime());
		log.info("change targetCalendar ");
		targetCalendar.set(Calendar.HOUR_OF_DAY,9);
		targetCalendar.set(Calendar.MINUTE,0);
		targetCalendar.set(Calendar.SECOND,0);
		log.debug("currentCalendar = " + currentCalendar.getTime());
		log.debug("targetCalendar = " + targetCalendar.getTime());
		if (targetCalendar.before( currentCalendar)) {
			long newTime = targetCalendar.getTimeInMillis() + 24*3600*1000;
			log.info("targetCalendar + 1 day");
			targetCalendar.setTimeInMillis(newTime);
			log.info("targetCalendar change to " + targetCalendar.getTime());
		}
		log.info("create schedule " + targetCalendar.getTime());
		new Timer().schedule(new TimerTask(){
			public void run(){
				new Excutor().start();
			}
		},targetCalendar.getTime());
		
	}
}

class Excutor {
	Logger log;
	FirefoxDriver controller,exc;
	String username="username";
	String password="password";
	WebDriverWait wdwC,wdwE;
	public Excutor() {
		log = Logger.getLogger(Excutor.class);
	}
	
	public void start() {
		init();
		controller.navigate().refresh();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String pageString = controller.getPageSource();
		if (readString(pageString,"buglog1","buglog2").equals("1")){
			doCheck();
		}
		end();
	}
	
	public void init() {
		try {
			log.debug("enter function init()");
			controller = new FirefoxDriver();
			controller.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			controller.manage().deleteAllCookies();
			controller.get("https://npm.taobao.org");
			wdwC = new WebDriverWait(controller,30);
			wdwC.until(ExpectedConditions.presenceOfElementLocated(By.id("username"))).sendKeys(username);
			controller.findElementById("password_input").sendKeys(password);
			controller.findElementById("login_button").click();
			wdwC.until(ExpectedConditions.presenceOfElementLocated(By.id("update_status_btn")));
		} catch(TimeoutException e) {
			log.error(e);
		}
		
	}
	
	
	public String readString( String source,String leftTag,String rightTag) {
		log.debug("enter function readString()");
		int posLeft = source.indexOf(leftTag);
		int posRight = source.indexOf(rightTag);
		String commond = "-1";
		log.debug("init commond value --> "+commond);
		if(posLeft == -1 || posRight == -1) {
			log.debug("source have no leftTag...");
			log.debug("return -1");
			log.debug("end function correlation ");
			return commond;
		}
		commond = source.substring(posLeft+leftTag.length(), posRight);
		log.debug("change commond value --> "+commond);
		log.debug("return " + commond);
		log.debug("end function correlation");
		log.debug("end function readString()");
		return commond;
		
	}
	
	public void writeString(String string) {
		log.debug("enter function writeString()");
		try {
			wdwC.until(ExpectedConditions.presenceOfElementLocated(By.className("lazyeditor-loader")));
			log.debug("is located By.className(\"lazyeditor-loader\") "+isLocated(controller,By.className("lazyeditor-loader")));
			log.debug("is located By.xpath "+isLocated(controller,By.xpath("//a[@name='comment']")));
			controller.executeScript("callLazyEditorCommentDescription(document.getElementsByClassName('lazyeditor-loader')[0]);", "");
			Thread.sleep(3000);
			controller.findElement(By.cssSelector("#editor-CommentDescription > div.editor-toolbar > span.editor-btn.editor-ico.editor-ico-source")).click();
			wdwC.until(ExpectedConditions.presenceOfElementLocated(By.className("editor-iframe")));
			log.debug("is located By.className(\"editor-iframe\") "+isLocated(controller,By.className("editor-iframe")));
			controller.switchTo().frame(controller.findElementByClassName("editor-iframe"));
			controller.findElementByTagName("body").sendKeys(string);
			Thread.sleep(3000);
			controller.switchTo().parentFrame();
			controller.findElementById("update_status_btn").click();
			Thread.sleep(3000);
		} catch(TimeoutException e) {
			log.error(e);
		} catch (InterruptedException e1) {
			log.error(e1);
		}
		log.debug("end function writeString()");
	}
	
	public void doCheck() {
		int times = 0;
		String code = null;
		log.debug("enter function doCheck()");
		try {	
			exc = new FirefoxDriver();
			exc.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			exc.manage().deleteAllCookies();
			exc.get("http://om.tencent.com/attendances/checkOut");
			wdwE = new WebDriverWait(exc,30);
			wdwE.until(ExpectedConditions.presenceOfElementLocated(By.id("login_button")));
			exc.findElementById("username").sendKeys(username);
			exc.findElementById("password_input").sendKeys(password);
			exc.findElementById("login_button").click();
			wdwE.until(ExpectedConditions.presenceOfElementLocated(By.id("checkin_btn")));
			exc.findElementById("checkin_btn").click();
			int aTimes = 0;
			do{
				Thread.sleep(3000);
				if(isLocated(exc,By.id("image"))) {
					String base64String = getImgString(exc,exc.findElement(By.id("image")));
					writeString(base64String);
					Thread.sleep(120000);
					do{
						Thread.sleep(120000);
						controller.navigate().refresh();
						try {
							Thread.sleep(3000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						String pageString = controller.getPageSource();
						code = readString(pageString,"buglog3","buglog4");
						times++;
						log.debug("try times "+times);
					} while(!Pattern.matches("[0-9a-zA-Z]{4}",code) && times < 5);
					if (times >=5) {
						log.debug("code value is "+ code);
						log.debug("code not correct");
					} else {
						log.debug("times < 5 ,code value is "+ code);
						log.debug("isLocated code_input element ? "+isLocated(exc,By.id("code_input")));
						exc.findElement(By.id("code_input")).sendKeys(code);
						Thread.sleep(3000);
					}
				} 
				Thread.sleep(3000);
				if (!isLocated(exc,By.id("image"))) {
					int i = (int) (10*Math.random());
					log.debug("sleep " + i + "minutes.");
					writeString(Integer.toString(i));
					Thread.sleep(i*60*1000);
				}
				exc.findElement(By.name("check")).click();
				Thread.sleep(30000);
				log.debug("current title is "+exc.findElement(By.id("ui-dialog-title-tdialog")).getText() );
				aTimes++;
				log.debug("debug aTimes is "+aTimes);
			}while (!exc.findElement(By.id("ui-dialog-title-tdialog")).getText().equals("ǩ��ɹ�֪��") && aTimes < 3);
			if(exc.findElement(By.id("ui-dialog-title-tdialog")).getText().equals("ǩ��ɹ�֪��")) {
				writeString("ok");
			} else {
				log.debug("aTimes is "+aTimes);
			}
		} catch(Exception e) {
			log.error(e);
		}
		log.debug("end function doCheck()");
	}
	
	public String getImgString(FirefoxDriver fd,WebElement we) {
		log.debug("enter function getImgString()");
		String s = null;
		Point location = we.getLocation();
		Dimension size = we.getSize();
		BufferedImage bigImage = null;
		try {
			bigImage = ImageIO.read(fd.getScreenshotAs(OutputType.FILE));
			BufferedImage subImage1 = bigImage.getSubimage(location.getX(), location.getY(), size.getWidth(),
			size.getHeight());
			/*
			int width = subImage1.getWidth();
			int height = subImage1.getHeight();
			int[][] gray = new int[width][height];
			BufferedImage subImage2 = new BufferedImage(width,height,BufferedImage.TYPE_BYTE_BINARY);
			for(int i = 0 ; i < width ; i++) {
			    for(int j = 0 ; j < height ; j++) {
			        gray[i][j] = getGray(subImage1.getRGB(i, j));
			    }
			}
			
			int sw = avgGray(gray,width,height);
			for(int i = 0 ; i < width ; i++) {
			    for(int j = 0 ; j < height ; j++) {
			        if(getAC(gray,i,j,width,height) > sw) {
			        	subImage2.setRGB(i, j, new Color(255,255,255).getRGB());
			        } else {
			        	subImage2.setRGB(i, j, new Color(0,0,0).getRGB());
			        }
			    }
			}
			*/
			ImageIO.write(subImage1, "png", new File("d:/code1.png"));
			//ImageIO.write(subImage2, "jpg", new File("d:/code2.jpg"));
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write(subImage1, "jpg",baos); 
			byte[] a = baos.toByteArray();
			s = OutputType.BASE64.convertFromPngBytes(a);
		} catch (IOException e) {
			log.debug(e);
			e.printStackTrace();
		} 
		s = "<img src=\"data:image/jpg;base64,"+s+"\"/>";
		log.debug(s);
		log.debug("end function getImgString()");
		return s;
	}
	
	public boolean isLocated(WebDriver driver,By locator) {
		try {
			log.debug("enter function isLocated()");
			driver.findElement(locator);
			log.debug("return true ");
			return true ;
		} catch(NoSuchElementException e) {
			log.debug("return false");
			return false;
		}
	}
	
	public int getGray(int rgb) {
		Color c = new Color(rgb);
		int r = c.getRed();
		int g = c.getGreen();
		int b = c.getBlue();
		return (r+g+b)/3;
	}
	    
	public int getAC(int[][] gray,int x,int y,int width,int height) {
		int sum;
		sum = gray[x][y]
		        +(x == 0 || y == 0 ? 255 : gray[x-1][y-1])
		        +(x == 0 ? 255 : gray[x-1][y])
		        +(x == 0 || y == height - 1  ? 255 : gray[x-1][y+1])
		        +(y == 0 ? 255 : gray[x][y-1])
		        +(y == height -1 ? 255 : gray[x][y+1])
		        +(x == width -1 || y == 0 ? 255 : gray[x+1][y-1])
		        +(x == width-1 ? 255 : gray[x+1][y])
		        +(x == width-1 || y == height - 1 ? 255 : gray[x+1][y+1]);
		return sum/9;
	}
	
	public int avgGray(int[][] points ,int width,int height) {
    	int sum = 0 ;
    	for (int i = 0 ;i < width ; i++) {
    		for (int j = 0 ; j < height ; j++) {
    			sum += points[i][j];
    		}
    	}
    	//System.out.println(sum/width/height);
    	return sum/width/height;
    }
	
	public void end() {
		if (controller != null) {
			controller.quit();
		}
		if (exc != null) {
			exc.quit();
		}
		new Schedule();
	}
}
