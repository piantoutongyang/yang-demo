package com.mingyisoft.javademo.designpattern.command.demo1;

public class CommandDemo1Main {
	public static void main(String[] args) {
		Process.doSomething(new Command() {
			public void eat() {
				System.out.println("各种疯狂的吃啊啊啊~~~");
			}
		});
		
		System.out.println("---------------------");
		
		Process.doSomething(new Command() {
			public void eat() {
				System.out.println("慢悠悠的吃呢~~~");
			}
		});
	}
}
