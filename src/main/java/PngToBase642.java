/**
 * @ version 1.0
 * @ author dbxiao
 */

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.TransferHandler;

import org.openqa.selenium.OutputType;

public class PngToBase642 extends JFrame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new PngToBase642();
	}
	
	static final long serialVersionUID = 1L;
	JTextField field;  
	JTextArea area;
	
	public PngToBase642() {
        this.setTitle("图片转base64编码");  
        this.setSize(500, 500);  
        this.setLocationRelativeTo(null);  
        this.setLayout(null);  
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
          
        field = new JTextField();  
        field.setBounds(50, 0, 300, 30);  
        
        area = new JTextArea();
        //area.setBounds(50, 30, 300, 400);
        
        //自动换行
        area.setLineWrap(true);
        
          
        field.setTransferHandler(new TransferHandler()  
        {  
            private static final long serialVersionUID = 1L;  
            @Override  
            public boolean importData(JComponent comp, Transferable t) {  
                try {  
                    Object o = t.getTransferData(DataFlavor.javaFileListFlavor);  
  
                    String filepath = o.toString();  
                    if (filepath.startsWith("[")) {  
                        filepath = filepath.substring(1);  
                    }  
                    if (filepath.endsWith("]")) {  
                        filepath = filepath.substring(0, filepath.length() - 1);  
                    }  
                    System.out.println(filepath);  
                    field.setText(filepath);  
                   
                    if(filepath.contains("png")){
                    	
                    } else if(filepath.contains("jpg")) {
                    	
                    }
                    BufferedImage bf = ImageIO.read(new File(filepath));
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    ImageIO.write(bf,"png",baos);
                    byte[] b = baos.toByteArray();
                    String s = OutputType.BASE64.convertFromPngBytes(b);
                    s = "<img src=\"data:image/png;base64,"+s+"\"/>";
                    area.setText(s);
                    
                    
                    return true;  
                }  
                catch (Exception e) {  
                    e.printStackTrace();  
                }  
                return false;  
            }  
            @Override  
            public boolean canImport(JComponent comp, DataFlavor[] flavors) {  
                for (int i = 0; i < flavors.length; i++) {  
                    if (DataFlavor.javaFileListFlavor.equals(flavors[i])) {  
                        return true;  
                    }  
                }  
                return false;  
            }  
        });  
        
        JScrollPane scroll = new JScrollPane(area); 
        //把定义的JTextArea放到JScrollPane里面去 

        //分别设置水平和垂直滚动条自动出现 
        //scroll.setHorizontalScrollBarPolicy( JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); 
        scroll.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 
        scroll.setBounds(50, 30, 300, 400);
        this.add(field);  
        this.add(scroll);
        this.setVisible(true);  
	}

}
