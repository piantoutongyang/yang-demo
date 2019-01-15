package com.mingyisoft.javademo.designpattern.factory.abstractfactory.demo1;

import com.mingyisoft.javademo.designpattern.factory.factorymethod.demo1.OutputFactory;

public class Demo1Main {
	public static void main(String[] args) {
		OutputFactory of=  OutputAbstractFactory.getOutputFactory("better");
		of.getOutput().out();
	}
}
