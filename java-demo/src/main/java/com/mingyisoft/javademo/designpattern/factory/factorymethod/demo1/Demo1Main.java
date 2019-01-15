package com.mingyisoft.javademo.designpattern.factory.factorymethod.demo1;

public class Demo1Main {
	public static void main(String[] args) {
		OutputFactory of1=  new PrinterFactory();
		of1.getOutput().out();
		
		OutputFactory of2=  new BetterPrinterFactory();
		of2.getOutput().out();
	}
}
