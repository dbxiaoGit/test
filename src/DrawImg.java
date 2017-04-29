/**
 * @ version 1.0
 * @ author dbxiao
 */

import java.awt.Graphics;
import java.awt.TextField;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.DebugGraphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DrawImg {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new DrawImg();
	}
	public DrawImg() {
		JFrame j = new JFrame();
		JPanel p = new JPanel();
		BufferedImage bi1 = null;
		BufferedImage bi2 = null;
		try {
			bi1 = ImageIO.read(new File("d:/icon1.png"));
			bi2 = ImageIO.read(new File("d:/icon2.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DebugGraphics g1 = new DebugGraphics();
		DebugGraphics g2 = new DebugGraphics();
		g1.drawImage(bi1,0,0,null);
		//g1.drawImage(bi2,0,0,j);
		p.update(g1);
		j.add(new JPanel());
		j.setSize(400, 400);
		j.setVisible(true);
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		p.update(g2);
		
	}

}
