/**
 * @author dbxiao
 */
package test1;

import java.util.ArrayList;
import java.util.List;

public class MaoPao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> l = new ArrayList<Integer>();
		for (int i = 0;i < 10;i++) {
			l.add((int)(100*Math.random()));
		}
		System.out.println("当前顺序：");
		for (int i : l) {
			System.out.print(i+"|");
		}
		for (int i = 0;i < l.size();i++) {
			for (int j = i + 1;j < l.size();j++) {
				if (l.get(i) > l.get(j) ) {
					int a = l.get(i);
					int b = l.get(j);
					a = a^b;
					b = a^b;
					a = a^b;
					l.set(i, a);
					l.set(j, b);
					//System.out.println(i+","+j);
				}
			}
		}
		System.out.println("\n排序后为:");
		for( int i : l) {
			System.out.print(i+"|");
		}
	}

}
