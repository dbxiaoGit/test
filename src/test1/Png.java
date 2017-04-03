/**
 * @author dbxiao
 */
package test1;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Png {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		new Png().start();
	}
	public void start() throws IOException {
		FirefoxDriver f = new FirefoxDriver();
		f.get("http://www.baidu.com");
		File png = f.getScreenshotAs(OutputType.FILE);
		BufferedImage bi = ImageIO.read(png);
		WebElement we = f.findElementByXPath("//img");
		BufferedImage subImage = bi.getSubimage(we.getLocation().getX(), we.getLocation().getY(), we.getSize().width, we.getSize().height);
		//FileOutputStream fos = new FileOutputStream("d:1.png");
		ImageIO.write(subImage, "png", new File("d:/1.png"));
		f.close();
	}
}
