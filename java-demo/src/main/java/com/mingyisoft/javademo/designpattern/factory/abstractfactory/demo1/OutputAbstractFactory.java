package com.mingyisoft.javademo.designpattern.factory.abstractfactory.demo1;

import com.mingyisoft.javademo.designpattern.factory.factorymethod.demo1.BetterPrinterFactory;
import com.mingyisoft.javademo.designpattern.factory.factorymethod.demo1.OutputFactory;
import com.mingyisoft.javademo.designpattern.factory.factorymethod.demo1.PrinterFactory;

/**
 * 抽象工厂类
 * @author yangmh
 *
 */
public class OutputAbstractFactory {
	public static OutputFactory getOutputFactory(String type){
		if(type.equals("better")){
			return new BetterPrinterFactory();
		}else{
			return new PrinterFactory();
		}
	}
}
