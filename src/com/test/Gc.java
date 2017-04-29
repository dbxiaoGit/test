/**
 * @ version 1.0
 * @ author dbxiao
 */

package com.test;

public class Gc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		while(true) {
			new A();
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	
}

class A {
	int id;
	String name;
	String sex;
	
}
