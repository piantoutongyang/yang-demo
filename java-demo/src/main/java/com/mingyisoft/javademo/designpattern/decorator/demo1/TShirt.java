package com.mingyisoft.javademo.designpattern.decorator.demo1;

public class TShirt extends Decorator{
	public void show() {
		System.out.println("穿T");
		super.show();
	}
}
