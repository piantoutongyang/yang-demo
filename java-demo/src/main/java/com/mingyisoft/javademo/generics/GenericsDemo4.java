package com.mingyisoft.javademo.generics;
/**
 * 专项讲解泛型静态方法
 * @author lenovo
 *
 * @param <S>
 */
public class GenericsDemo4<S> {
	public static <T> T eat(T param) {
		//虽然是类方法，但泛型类型与类无关，可以正常使用。
		return param;
	}
	
//	public static S sleep(S param) {
//	这种写法直接编译报错。
//		return param;
//	}
	
	public static void main(String[] args) {
		String alex = GenericsDemo4.eat("alex");
		System.out.println(alex);
	}
}
