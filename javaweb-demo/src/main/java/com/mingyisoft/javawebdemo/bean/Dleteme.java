package com.mingyisoft.javawebdemo.bean;

public class Dleteme {
	public static void main(String[] args) {
		Father f = new Father();
		Father f1 = new Son();
		Son f2 = new Son();
		
		f.say();
		System.out.println("---");
		f1.say();
		System.out.println("---");
		f2.say();
	}
}

class Father{
	protected void say(){
		System.out.println("father say");
		eat();
	}
	
	/**
	 * 让子类实现
	 */
	public void eat() {
		
	}
}

class Son extends Father {
	public void eat() {
		System.out.println("son eat");
	}
}