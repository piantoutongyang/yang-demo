package com.mingyisoft.javademo.designpattern.factory.easyfactory.demo3better;

import com.mingyisoft.javademo.designpattern.factory.easyfactory.demo1.Output;

public class MysqlPrinter implements Output {
	@Override
	public void out() {
		System.out.println("我是mysql打印机哟");
	}
}
