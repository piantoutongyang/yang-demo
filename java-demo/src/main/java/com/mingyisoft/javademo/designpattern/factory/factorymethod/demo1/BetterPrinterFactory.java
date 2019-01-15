package com.mingyisoft.javademo.designpattern.factory.factorymethod.demo1;

import com.mingyisoft.javademo.designpattern.factory.easyfactory.demo1.BetterPrinter;
import com.mingyisoft.javademo.designpattern.factory.easyfactory.demo1.Output;

public class BetterPrinterFactory implements OutputFactory{
	@Override
	public Output getOutput() {
		return new BetterPrinter();
	}
}
