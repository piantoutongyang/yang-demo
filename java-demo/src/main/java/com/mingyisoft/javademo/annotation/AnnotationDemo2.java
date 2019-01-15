package com.mingyisoft.javademo.annotation;
@Deprecated
public class AnnotationDemo2 {
	@Deprecated
	public AnnotationDemo2() {

	}

	@Deprecated
	String name = "alex";

	@Deprecated
	public void sleep() {
		System.out.println(123);
	}

	public static void main(String[] args) {
		AnnotationDemo2 a = new AnnotationDemo2();
		System.out.println(a.name);;
		a.sleep();
	}
}
