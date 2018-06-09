/**
 * @ version 1.0
 * @ author dbxiao
 */

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TestP1 {
    public static void main(String[] args) {
        JFrame jframe = new JFrame();
        jframe.add(new ImagePanel());
        jframe.setVisible(true);
        jframe.setSize(400, 300);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
 
class ImagePanel extends JPanel {
 
    private BufferedImage image;
 
    public ImagePanel() {
        try {
            image = ImageIO.read(new File("d:/icon1.png"));
        } catch (IOException ex) {
            // handle exception...
        }
    }
 
    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, null); 
        //此处第四个参数为null没有问题
    }
 
}
