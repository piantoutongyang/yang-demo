package com.mingyisoft.javademo.designpattern.command.demo1;

public class Process {
	public static void doSomething(Command c) {
		System.out.println("模拟工作");
		// 吃饭的逻辑目前定不下来，需要从外面传进来。
		c.eat();
		System.out.println("模拟睡觉");
	}
}
