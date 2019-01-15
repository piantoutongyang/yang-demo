package com.mingyisoft.javademo.designpattern.factory.easyfactory.demo2;

public class Demo2Main {
	public static void main(String[] args) {
//		HardMode h = new AddMode();
//		h.setA(8);
//		h.setB(2);
//		h.operate();
//		System.out.println(h.getResult());
		
		//简单工厂
		
		HardMode h = HardModeFactory.createOperate("+");
		h.setA(1);
		h.setB(3);
		h.operate();
		System.out.println(h.getResult());
	}
}
