/**
 * @ version 1.0
 * @ author dbxiao
 */

package com.xiao;

public class E67_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] a=new int[3][3];
		int temp=1;
		for(int i=0;i<3;i++)
			for(int j=0;j<3;j++){
				a[i][j]=temp;
				temp++;
			}
		for(int i=0;i<3;i++){
			System.out.println("");
			for(int j=0;j<3;j++){
				System.out.print(a[i][j]+"\t");
			}
		}	
		
		System.out.println("\n以下内容为行列互调后的结果：");
		for(int i=0;i<3;i++){
			System.out.println("");
			for(int j=0;j<3;j++){
				System.out.print(a[j][i]+"\t");
			}
		}	
	}

}
