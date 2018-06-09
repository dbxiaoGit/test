/**
 * @author dbxiao
 */


public class ClassLoader1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassLoader c = ClassLoader1.class.getClassLoader();
		while (c != null) {
			System.out.println(c.getClass().getName());
			c = c.getParent();
		}
	}

}
