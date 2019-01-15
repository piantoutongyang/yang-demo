package com.mingyisoft.javademo.generics;

/**
 * 专项讲解泛型构造方法
 * 
 * @author lenovo
 *
 * @param <S>
 */
public class GenericsDemo5<S> {
	S info;

	public GenericsDemo5() {

	}

	public GenericsDemo5(S info) {
		this.info = info;
	}

	public <T> GenericsDemo5(T info1, T info2) {
		System.out.println(info1);
		System.out.println(info2);
		// 下面的泛型S与泛型T为互斥，会造成编译错误。
		// this.info = info1;
	}

	public static void main(String[] args) {
		GenericsDemo5<Boolean> g1 = new GenericsDemo5<>(true);
		System.out.println("----->"+g1.info);
		GenericsDemo5<Boolean> g2 = new GenericsDemo5<>("a", "b");
	}
}
