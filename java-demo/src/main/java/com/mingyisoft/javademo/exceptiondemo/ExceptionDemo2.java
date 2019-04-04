package com.mingyisoft.javademo.exceptiondemo;

import java.io.IOException;

public class ExceptionDemo2 {
	public static void main(String[] args) throws Exception {
		try {
			eat(1);
		}catch(NullPointerException | ArrayIndexOutOfBoundsException e) {
			//jdk1.7允许每个catch块捕获多个异常
			System.out.println("jdk1.7");
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("看看抛异常后是否还会运行？");
	}
	
	public static void eat(int n) throws NullPointerException,ArrayIndexOutOfBoundsException,IOException {
		if(n==1) {
			throw new NullPointerException();
		}else if(n==2) {
			throw new ArrayIndexOutOfBoundsException();
		}else if(n==3) {
			throw new IOException();
		}
	}
}
