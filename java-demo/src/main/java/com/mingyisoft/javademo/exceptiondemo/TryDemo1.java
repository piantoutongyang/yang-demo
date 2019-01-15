package com.mingyisoft.javademo.exceptiondemo;

public class TryDemo1 {
	
	public static void main(String[] args) {
		System.out.println(eat());
		System.out.println(sleep());
	}
	
	public static int eat() {
		int temp = 0;
		try {
			temp = 2;
			return temp;
		}finally {
			temp = 3;
		}
	}
	
	public static int sleep() {
		int temp = 0;
		try {
			int i = 5/0;
			return temp;
		}catch(Exception ex) {
			temp = 2;
			return temp;
		}finally {
			temp = 3;
		}
	}
}
