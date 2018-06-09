package proxy;

import java.lang.reflect.Proxy;

import org.junit.Test;

/**
* Created by 136187300@qq.com on 2018年6月9日.
*/

public class TestProxy {

	@Test
	public void test1() {
		TestLog testLog = new TestLogImpl();
		TestLogInterceptor testLogInterceptor = new TestLogInterceptor();
		testLogInterceptor.setTarget(testLog);
		TestLog proxy = (TestLog)Proxy.newProxyInstance(TestLog.class.getClassLoader()
				, TestLog.class.getInterfaces(), testLogInterceptor);
		proxy.print();
		
		
	}
	
	public static void main(String[] args) {
		TestLog testLog = new TestLogImpl();
		TestLogInterceptor testLogInterceptor = new TestLogInterceptor();
		testLogInterceptor.setTarget(testLog);
		TestLog proxy = (TestLog)Proxy.newProxyInstance(testLog.getClass().getClassLoader()
				, testLog.getClass().getInterfaces(), testLogInterceptor);
		proxy.print();
	}
}
