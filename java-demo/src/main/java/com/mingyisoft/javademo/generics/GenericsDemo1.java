package com.mingyisoft.javademo.generics;

/**
 * 泛型类专项讲解
 */
public class GenericsDemo1<T> {
	T info;

	public T getInfo() {
		T a = null;
		return info;
	}

	public void setInfo(T info) {
		this.info = info;
	}

	public static void main(String[] args) {
		GenericsDemo1<String> g = new GenericsDemo1<>();
		// 实例变量的类型跟类的泛型类型走，是String类型。
		System.out.println(g.info);
		// 方法的参数类型跟类的泛型类型走，是String类型。
		g.setInfo("hello");
		// 方法的返回类型跟类的泛型类型走，是String类型。
		System.out.println(g.getInfo());
		
		GenericsDemo1<Integer> g2 = new GenericsDemo1<>();
		// 实例变量的类型跟类的泛型类型走，是Integer类型。
		System.out.println(g2.info);
		// 方法的参数类型跟类的泛型类型走，是Integer类型。
		g2.setInfo(123);
		// 方法的返回类型跟类的泛型类型走，是Integer类型。
		System.out.println(g2.getInfo());
	}
}
