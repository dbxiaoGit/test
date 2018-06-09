/**
 * @ version 1.0
 * @ author dbxiao
 */


import java.util.ArrayList;
import java.util.List;

public class E96_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list=new ArrayList<>();
		for(int i=0;i<6;i++){
			int temp=getR(2,32);
			while(list.contains(temp)){
				temp=getR(2,32);
			}
			list.add(temp);
		}
		int sum=0;
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
			sum+=list.get(i);
		}
		System.out.println("���ǣ�"+sum);
		
	}
	
	private static int getR(long a,long b){
		int i;
		i=(int)(Math.random()*(b-a)+a);
		if(i>=b-1){
			return i-1;
		}else if(i%2==0){
			return i;
		}else
			return i+1;
	}
	
	

}
