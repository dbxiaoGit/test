/**
 * @author dbxiao
 */
package test1;

public class EchoClassLoader {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(String.class.getClassLoader());
		System.out.println(java.io.File.class.getClassLoader());
		//System.out.println(com.sun.crypto.provider.DESKeyFactory.class.getClassLoader().getClass().getName());
		System.out.println(EchoClassLoader.class.getClassLoader().getClass().getName());
		System.out.println(ClassLoader.getSystemClassLoader().getClass().getName());
	}

}
