package com.mingyisoft.javademo.designpattern.factory.easyfactory.demo3better;

import com.mingyisoft.javademo.designpattern.factory.easyfactory.demo1.Output;

public class Demo3Main {
	public static void main(String[] args) throws Exception {
		Mouse mouse = BetterSimpleFactory.createMouse();
		Output printer = BetterSimpleFactory.createPrinter();
		
		mouse.doSomething();
		printer.out();
	}
}
