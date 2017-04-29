/**
 * @ version 1.0
 * @ author dbxiao
 */
 
package com.xiao;

public class E67_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1=new int[5];
		int[] arr2=new int[6];
		for(int i=0;i<arr1.length;i++){
			arr1[i]=i+2;
		}
		for(int i=0;i<arr2.length;i++){
			if(i<3)arr2[i]=arr1[i];
			else arr2[i]=i+3;
		}
		for(int i:arr1)System.out.println(i);
		for(int i:arr2)System.out.println(i);
	}

}
