package com.mingyisoft.javademo.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * 泛型通配符
 * 
 * @author lenovo
 *
 */
public class GenericsDemo10 {
	// 抱歉，由于List<Object>并不是一个父接口的概念，
	// 因此调用者传类似于List<String>是行不通的。
	public void eat1(List<Object> param) {
		for (int i = 0; i < param.size(); i++) {
			System.out.println(param.get(i));
		}
	}

	// 使用泛型通配符
	public void eat2(List<?> param) {
		for (int i = 0; i < param.size(); i++) {
			System.out.println(param.get(i));
		}
	}

	public static void main(String[] args) {
		GenericsDemo10 g = new GenericsDemo10();
		// 正确
		g.eat1(new ArrayList<Object>());
		// 错误
		// g.eat1(new ArrayList<String>());
		// 正确
		g.eat2(new ArrayList<String>());

		List<?> aaa = new ArrayList<>();
		// 错误，因为add()需要传递泛型类型E的对象或其子类对象，但现在无法知道List的泛型类型是什么，因此出现编译错误。
		// aaa.add(new Object());

	}
}