package com.mingyisoft.javademo.generics;

/**
 * 泛型方法专项讲解
 */
public class GenericsDemo3<S> {
	public <T> T eat(T param) {
		// 该方法没有走类的泛型类型S，而是走当前方法自己的泛型类型T，一般来自方法的参数类型。
		// 如果不想走类的泛型方法，必须要在方法声明中写上<T>，否则编译报错。
		// 此处有没有类的泛型类型与当前方法都没有关系，即使没有类的泛型类型，这里也不会报错。
		return param;
	}

	public <T> T eat(T param1, T param2) {
		// 注意，如果走方法自己的泛型类型，在多个参数的情况下，
		// param1与param2的类型允许不一致，但如果是类的泛型类型走就必须一致。
		return param2;
	}

	public S sleep(S param) {
		// 该方法走类的泛型类型S。
		return param;
	}

	public static void main(String[] args) {
		// 类的泛型类型是String
		GenericsDemo3<String> g = new GenericsDemo3<>();
		// eat方法的泛型参数是Integer，跟方法参数走
		System.out.println(g.eat(6));
		// sleep方法的泛型参数是String，跟类走
		System.out.println(g.sleep("hello"));
		// eat方法的两个泛型参数允许不一致
		System.out.println(g.eat(true, 5));
	}
}
