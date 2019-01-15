package com.mingyisoft.javademo.designpattern.decorator.demo1;

public class Decorator extends Person {
	protected Person p;
	/**
	 * 打扮
	 * @param p
	 */
	public void decorate(Person p) {
		this.p = p;
	}
	
	/**
	 * 展示
	 */
	public void show() {
		System.out.println("111");
		if(p!=null) {
			System.out.println("222");
			p.show();
		}
	}
}
