/**
 * @ version 1.0
 * @ author dbxiao
 */


public class E67_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a=new int[5];
		for(int i=0;i<a.length;i++){
			if(i%2==0){
				a[i]=-1*i-i*2;
			}else a[i]=i*2+5;
		}
		System.out.println("数组原始内容为：");
		for(int i:a)System.out.print("\t"+i);
		int t=a[0];
		for(int i=0;i<a.length;i++){
			
			if(a[i]<t)t=a[i];
			if(i==a.length-1)System.out.println("\n数组中最小的数是："+t);
		}
		
	}

}
