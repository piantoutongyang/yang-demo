package com.mingyisoft.javademo.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * 通配符上限
 * @author lenovo
 *
 */
public class GenericsDemo11 {
	public static void eat(List<? extends Number> param) {
		
	}
	
	public static void main(String[] args) {
		eat(new ArrayList<Number>());
		eat(new ArrayList<Integer>());
		eat(new ArrayList<Double>());
		// 编译出错，因为String并不是Number的子类
//		eat(new ArrayList<String>());
	}
}
