/** 
 * File: HelloProxy.java<br> 
 * Project: demoyang<br> 
 * Package: com.mingyisoft.demoyang.designpattern.proxy.staticproxy<br> 
 * Company:韦博英语在线教育部<br> 
 * CreateDate:2016年10月7日 下午9:07:02
 * @author yangmh
 */
package com.mingyisoft.javademo.designpattern.proxy.staticproxy;

/**
 * Title: HelloProxy<br>
 * Description: HelloProxy<br>
 * Company: 韦博英语在线教育部<br>
 * CreateDate:2016年10月7日 下午9:07:02
 * 
 * @author yangmh
 */
public class HelloProxy implements IHello {
	private IHello target;

	public HelloProxy(IHello target) {
		this.target = target;
	}

	public void hello(String name) {
		System.out.println("日志开始");
		// 调用目标对象方法
		target.hello(name);
		System.out.println("日志结束");
	}
}
