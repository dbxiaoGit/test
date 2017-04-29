/**
 * @ version 1.0
 * @ author dbxiao
 */
 
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import javax.imageio.ImageIO;
public class TestP {
    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(ImageIO.getReaderFormatNames()));  
        new TestP();
    }
    
    public TestP() throws Exception {
        BufferedImage bii = ImageIO.read(new File("d:/2.jpg"));
        int width = bii.getWidth();
        int height = bii.getHeight();
        int[][] gray = new int[width][height];
        BufferedImage bio = new BufferedImage(width,height,BufferedImage.TYPE_BYTE_BINARY);
        for(int i = 0 ; i < width ; i++) {
            for(int j = 0 ; j < height ; j++) {
                gray[i][j] = getGray(bii.getRGB(i, j));
            }
        }
        
       int sw = avgGray(gray,width,height);
        for(int i = 0 ; i < width ; i++) {
            for(int j = 0 ; j < height ; j++) {
                if(getAC(gray,i,j,width,height) > sw) {
                    bio.setRGB(i, j, new Color(255,255,255).getRGB());
                } else {
                    bio.setRGB(i, j, new Color(0,0,0).getRGB());
                }
            }
        }
        
        
        ImageIO.write(bio, "png", new File("d:/out_getAC2avgGray.png"));
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
}