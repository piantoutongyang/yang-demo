package com.mingyisoft.javademo.designpattern.decorator.demo1;

public class Underwear extends Decorator {
	public void show() {
		System.out.println("穿内衣");
		super.show();
	}
}
