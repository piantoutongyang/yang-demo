package com.mingyisoft.javademo.generics;

public class GenericsDemo77777 {
	public <T> T eat(Class<T> param) throws Exception {
		//Class<T>里的T会指明具体的泛型类型，返回类型会跟参数类型走。
		T t = param.newInstance();
		return t;
	}
	
	public static void main(String[] args) throws Exception {
		GenericsDemo77777 g1 = new GenericsDemo77777();
		Object g2 = g1.eat(Class.forName("com.mingyisoft.javademo.generics.GenericsDemo7"));
		//由于Class.forName的泛型类型不明确，导致无法在编译时定义真正的类型，因此返回后需要做强制类型转换
		String g3 = g1.eat(String.class);
		System.out.println(g2);
		System.out.println(g3);
	}
}
