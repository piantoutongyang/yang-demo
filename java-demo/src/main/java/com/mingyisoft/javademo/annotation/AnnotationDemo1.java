package com.mingyisoft.javademo.annotation;

public class AnnotationDemo1 extends AnnotationFather{
//	@Override
//	public void eaT () {
//		System.out.println(456);
//	}
	
	@Override
	public void sleep() {
		System.out.println(123);
	}
	
	public static void main(String[] args) {
		System.out.println("123");
		AnnotationDemo1 a = new AnnotationDemo1();
//		a.eaT();
	}
}
class AnnotationFather{
	public void eat() {
		System.out.println(1233);
	}
	
	public void sleep() {
		System.out.println(789);
	}
}