package com.mingyisoft.javademo.designpattern.factory.easyfactory.demo1;

public class Demo1Main {
	public static void main(String[] args) {
//		BetterPrinter p1 =new BetterPrinter();
//		BetterPrinter p2 =new BetterPrinter();
//		
//		p1.out();
//		p2.out();
		
		Output output = OutPutFactory.getOutput();
		output.out();
	}
}
