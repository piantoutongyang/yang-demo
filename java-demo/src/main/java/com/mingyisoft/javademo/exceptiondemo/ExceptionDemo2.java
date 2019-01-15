package com.mingyisoft.javademo.exceptiondemo;

import java.io.IOException;

public class ExceptionDemo2 {
	public static void main(String[] args) throws Exception {
		eat(0);
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
