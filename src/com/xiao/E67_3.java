/**
 * @ version 1.0
 * @ author dbxiao
 */

package com.xiao;

public class E67_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] arr=new String[5];
		for(int i=0;i<5;i++){
			arr[i]="a"+i;
		}
		for(String i:arr)System.out.println("替换前："+i);
		arr[1]="bb";
		for(String i:arr)System.out.println("替换后："+i);
		

	}

}
