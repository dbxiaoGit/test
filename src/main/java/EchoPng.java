/**
 * @author dbxiao
 */

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class EchoPng {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new EchoPng();
	}
	
	public EchoPng() {
		JFrame j = new JFrame();
		BufferedImage bi = null;
		try {
			bi = ImageIO.read(new File("d:/icon.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ImgPanel p = new ImgPanel(bi);
		j.add(p);
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		j.setSize(400, 400);
		j.setVisible(true);
	}
	

}

class ImgPanel extends JPanel {
	BufferedImage bi;
	public ImgPanel(BufferedImage bi) {
		this.bi = bi;
	}
	
	@Override
	public void paint(Graphics g) {
		g.drawImage(this.bi, 0, 0, null);
	}
}