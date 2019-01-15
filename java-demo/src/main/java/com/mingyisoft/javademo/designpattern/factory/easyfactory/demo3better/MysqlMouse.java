package com.mingyisoft.javademo.designpattern.factory.easyfactory.demo3better;

public class MysqlMouse implements Mouse {
	@Override
	public void doSomething() {
		System.out.println("我是mysql鼠标哟");
	}
}
