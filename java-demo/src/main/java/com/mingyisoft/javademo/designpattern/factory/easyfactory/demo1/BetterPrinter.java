package com.mingyisoft.javademo.designpattern.factory.easyfactory.demo1;
/**
 * 系统需要重构，使用BetterPrinter来代替Printer，
 * 只需要让BetterPrinter也实现Output接口，并改写工厂中的getOutput方法即可
 * @author yangmh
 *
 */
public class BetterPrinter implements Output{
	public void out() {
		System.out.println("我是性能较好的打印机");
	}
}
