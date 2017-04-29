/**
 * @ version 1.0
 * @ author dbxiao
 */

package com.xiao;

public class StringDemo {

	public static void main(String[] args) {
		String s=new String();
		long startTime=System.currentTimeMillis();
		for(int i=0;i<10000;i++){
			s+=i;
		}
		long endTime=System.currentTimeMillis();
		System.out.println("消耗时间是："+(endTime-startTime));
		StringBuilder sb=new StringBuilder();
		startTime=System.currentTimeMillis();
		for(int i=0;i<10000;i++){
			sb.append(i);
		}
		endTime=System.currentTimeMillis();
		System.out.println("消耗时间是；"+(endTime-startTime));
	}

}
