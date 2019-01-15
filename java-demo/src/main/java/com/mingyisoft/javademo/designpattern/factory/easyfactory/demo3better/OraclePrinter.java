package com.mingyisoft.javademo.designpattern.factory.easyfactory.demo3better;

import com.mingyisoft.javademo.designpattern.factory.easyfactory.demo1.Output;

public class OraclePrinter implements Output {
	@Override
	public void out() {
		System.out.println("我是oracle打印机哟");
	}
}
