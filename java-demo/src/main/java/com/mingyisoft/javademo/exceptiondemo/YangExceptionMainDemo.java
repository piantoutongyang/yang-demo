package com.mingyisoft.javademo.exceptiondemo;

public class YangExceptionMainDemo {
	public static void main(String[] args) {
		try {
			eat();
		} catch (YangException e) {
			e.printStackTrace();
		}
	}
	
	public static void eat(){
		throw new YangException("hahaha",8080);
	}
}
