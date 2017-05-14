/**
 * @author dbxiao
 */
package test1;

import java.util.ArrayList;

public class testLambda {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new testLambda().test();
	}

	public void test(){
		ArrayList<Integer> la = new ArrayList<Integer>();
		la.add(4);
		la.add(5);
		la.add(6);
		la.forEach((a1)->System.out.println(a1));
		la.forEach(System.out::print);
	}
}
