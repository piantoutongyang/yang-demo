package com.mingyisoft.javademo.generics;

import java.util.List;

/**
 * 泛型方法与泛型通配符的区别
 * 
 * @author lenovo
 *
 */
public class GenericsDemo12 {
	public void eat1(List<?> param) {
		// 使用泛型通配符
	}

	public <T> void eat2(List<T> param) {
		// 使用泛型方法
	}

	public <T> void sleep(List<T> a, List<? extends T> b) {
		// 使用泛型方法+通配符
	}
}
