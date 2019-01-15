package com.mingyisoft.javademo.designpattern.factory.easyfactory.demo3better;

import com.mingyisoft.javademo.designpattern.factory.easyfactory.demo1.Output;

public class BetterSimpleFactory {
	//此处可以改成从配置文件&缓存中读取
//	private static final String db = "Mysql";
	private static final String db = "Oracle";
	
	/**
	 * 创建打印机对象
	 * @return
	 * @throws Exception
	 */
	public static Output createPrinter() throws Exception{
		//通过反射，去掉了if-else判断分支，让程序更灵活
		return (Output) Class.forName("com.mingyisoft.javademo.designpattern.factory.easyfactory.demo3better."+db+"Printer").newInstance();
	}
	
	/**
	 * 创建鼠标对象
	 * @return
	 * @throws Exception
	 */
	public static Mouse createMouse() throws Exception{
		//通过反射，去掉了if-else判断分支，让程序更灵活
		return (Mouse) Class.forName("com.mingyisoft.javademo.designpattern.factory.easyfactory.demo3better."+db+"Mouse").newInstance();
	}
}
