package com.mingyisoft.javademo.designpattern.factory.easyfactory.demo1;

public class OutPutFactory {
	public static Output getOutput() {
		 return new Printer();
		// 代码重构后
//		return new BetterPrinter();
	}
}
