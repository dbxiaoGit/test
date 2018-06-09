/**
 * @ version 1.0
 * @ author dbxiao
 */


public class Single {
	private static Single single=new Single();
	private Single(){
		System.out.println("a Single create");
	}
	public static Single getInstence(){
		return single;
	}
}
