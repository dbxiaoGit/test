/**
 * @author dbxiao
 */
package test1;

import java.util.regex.Pattern;

public class TestRegx {
	static Pattern p,p2;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		p = Pattern.compile("^\\w+@(\\w+\\.)+\\w+$");
		p2 = Pattern.compile("^(\\w)+(\\.\\w+)*@(\\w)+((\\.\\w+)+)$");
		print1(1,"a123@163.com");
		print1(2,"123456789@qq.com");
		print1(3,"a1@b2.c3.com");
		print1(4,"Aa1@Bb2.Cc3.cn");
		print1(5,"Aa1_b@Bb2.Cc3.cn");
		print1(6,"Aa1_b-@Bb2.Cc3.cn");
		print1(7,"。@qq.com");
		print1(8,"Aa1.Bb2@qq.com");
	}
	static void print1(int line ,String s){
		System.out.print(line+" p-->");
		System.out.print(p.matcher(s).matches()+"\t|\t");
		System.out.print(line+" p2-->");
		System.out.print(p2.matcher(s).matches()+"\n");
	}
}
