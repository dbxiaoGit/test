/**
 * @author dbxiao
 */
package test1;
import java.util.regex.Pattern;

public class Regx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Regx().start();
	}
	
	public void start(){
		System.out.println(Pattern.matches("^\\w+@(\\w+\\.)+\\w+$", "1a_bA1@a2.2W.cn"));
	}
}
