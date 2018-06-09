/**
 * @ version 1.0
 * @ author dbxiao
 */


public class E78_2 {

	private int l;
	private int w;
	
	E78_2(){
		this.l=100;
		this.w=200;
	}
	
	E78_2(int x,int y){
		this.l=x;
		this.w=y;
	}
	
	public int area(){
		return l*w;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		E78_2 a1=new E78_2();
		E78_2 a2=new E78_2(500,600);
		System.out.println(a1.area());
		System.out.println(a2.area());
	}

}
