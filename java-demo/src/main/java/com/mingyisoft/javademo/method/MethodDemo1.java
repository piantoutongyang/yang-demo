package com.mingyisoft.javademo.method;
/**
 * 可变参数
 * 长度可变的形参只能处于参数列表的最后，一个方法最多只能包含一个长度可变的形参
 * @author lenovo
 *
 */
public class MethodDemo1 {
	public static void main(String[] args) {
		eat(1,"2","3","4");
	}
	
	public static void eat(int a ,String... b) {
		System.out.println(a);
		for(String x : b) {
			System.out.println(x);
		}
	}
}
