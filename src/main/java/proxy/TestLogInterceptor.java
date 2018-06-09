package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
* Created by 136187300@qq.com on 2018年6月9日.
*/

public class TestLogInterceptor implements InvocationHandler{
	
	private TestLog target;
	
	public TestLog getTarget() {
		return target;
	}

	public void setTarget(TestLog target) {
		this.target = target;
	}

	public void beforeMethod() {
		System.out.println("beforeMethod");
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		beforeMethod();
		method.invoke(target, args);
		return null;
	}}
