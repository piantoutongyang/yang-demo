package com.mingyisoft.javademo.designpattern.facade.demo1;

public class FacadeDemo1 {
	public static void doSomething(){
		SleepUtil.sleep();
		EatUtil.eat();
		WorkUtil.work();
	}
}
