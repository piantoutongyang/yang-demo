/** 
 * File: LogHandler.java<br> 
 * Project: demoyang<br> 
 * Package: com.mingyisoft.demoyang.designpattern.proxy.dynamicproxy<br> 
 * Company:韦博英语在线教育部<br> 
 * CreateDate:2016年10月7日 下午9:18:50
 * @author yangmh
 */
package com.mingyisoft.javademo.designpattern.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Title: LogHandler<br>
 * Description: LogHandler<br>
 * Company: 韦博英语在线教育部<br>
 * CreateDate:2016年10月7日 下午9:18:50
 * 
 * @author yangmh
 */
public class LogHandler implements InvocationHandler {
	// 目标对象&被代理对象
	private Object target;

	// 为目标对象创建一个动态代理对象，两个对象实现了相同接口，因此具有相同的方法。
	public <T> T getProxy(Object target) {
		this.target = target;
		return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
	}

	// 必须要实现这个方法，用于生成的代理对象回调此方法。
	// 每次调用动态代理对象的方法时都会执行这个invoke方法，
	// 参数为：动态代理对象，被代理对象的方法对象，执行参数
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("动态代理，日志开始");
		// 使用反射回调了目标对象的方法。
		Object result = method.invoke(target, args);
		System.out.println("动态代理，日志结束");
		return result;
	}
}
