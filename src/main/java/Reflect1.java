/**
 * @author dbxiao
 */


import java.lang.reflect.Method;

public class Reflect1 {

	public static void main(String[] args) throws  Exception  {
		// TODO Auto-generated method stub
		Class<?> c = Class.forName("com.db.T");
		Object o = c.newInstance();
		Method[] method = c.getMethods();
		for(Method m : method) {
			if (m.getName().equals("m1") ) {
				m.invoke(o);
			}
			
			if(m.getName().equals("m2")) {
				for(Class cm :m.getParameterTypes()) {
					System.out.println("getParameterTypes : " + cm.getName());
				}
				System.out.println("getReturnType: " + m.getReturnType());
				
				System.out.println(m.invoke(o, 111,"sss"));
				
			}
		}
	}

}

class T {
	
	public void m1() {
		System.out.println("excute m1");
	}
	
	public T m2(int x , String y) {
		System.out.println("excute m2 " + x + y );
		return new T();
		
	}
}