package com.mingyisoft.javademo.exceptiondemo;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class ExceptionDemo3 {
	public static void main(String[] args) throws Exception {
		//jdk7的会自动关闭资源的try块
		try (PrintStream ps = new PrintStream(new FileOutputStream("aaa.txt"));) {
			ps.println("abc");
		} 
	}
	
	public void eat() throws RuntimeException, FileNotFoundException {
		
	}
}

class ExceptionDemo3Son extends ExceptionDemo3{
	public void eat() throws FileNotFoundException {
		
	}
}

interface InterfaceExceptionDemo3{
	
}
