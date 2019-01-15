package com.mingyisoft.javademo.designpattern.factory.factorymethod.demo1;

import com.mingyisoft.javademo.designpattern.factory.easyfactory.demo1.Output;
import com.mingyisoft.javademo.designpattern.factory.easyfactory.demo1.Printer;

public class PrinterFactory implements OutputFactory{
	@Override
	public Output getOutput() {
		return new Printer();
	}
}
