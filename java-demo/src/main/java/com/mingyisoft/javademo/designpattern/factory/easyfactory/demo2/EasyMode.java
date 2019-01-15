package com.mingyisoft.javademo.designpattern.factory.easyfactory.demo2;

import java.util.Scanner;

/**
 * 最low版本的计算器，如果还没有任何的设计模式也美誉任何扩展性等特性可言，那么程序是这个样子的。
 * 
 * @author yangmh
 *
 */
public class EasyMode {
	public static void main(String[] args) {
		/**
		 * 如果按照现在这种写法，我再添加一个平方根的方法，就要修改本类，违背了开放关闭原则。
		 * 那么是否可以通过继承&多态进行解耦呢？让我们继续往下看。
		 */
		Scanner sc = new Scanner(System.in);
	
		System.out.println("Please Enter Symbol:");
		String symbol = sc.nextLine();


		System.out.println("Please Enter NumberA:");
		int a = sc.nextInt();
		
		
		System.out.println("Please Enter NumberB:");
		int b = sc.nextInt();

		int result = 0;
		System.out.println(symbol);

		switch (symbol) {
		case "+":
			result = a + b;
			break;
		case "-":
			result = a - b;
			break;
		case "*":
			result = a * b;
			break;
		case "/":
			result = a / b;
			break;
		}

		System.out.println("result===>" + result);
	}
}
