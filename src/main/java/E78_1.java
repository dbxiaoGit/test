/**
 * @ version 1.0
 * @ author dbxiao
 */


public class E78_1 {
	private int id;
	
	public void setId(int id){
		this.id=id;
	}
	
	public int getId(){
		return this.id;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		E78_11 a=new E78_11();
		a.setId(10086);
		System.out.println(a.getId());
	}

}
class E78_11 extends E78_1{
	
	
}
