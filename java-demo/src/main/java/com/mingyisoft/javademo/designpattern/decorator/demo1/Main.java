package com.mingyisoft.javademo.designpattern.decorator.demo1;

public class Main {
	public static void main(String[] args) {
		Person p = new Person("张三");
		TShirt t = new TShirt();
		Underwear u = new Underwear();
		
		//第一种穿法
		u.decorate(p);
		t.decorate(u);
		t.show();
		
		//第二种穿法
		//同上
	}
}
