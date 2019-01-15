package com.mingyisoft.javademo.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * 通配符下限
 * @author lenovo
 *
 */
public class GenericsDemo13 {
	public static void eat(List<? super Integer> param) {
		
	}
	
	public static void main(String[] args) {
		eat(new ArrayList<Number>());
		eat(new ArrayList<Integer>());
		// 编译出错，因为Double并不是Integer的父类
//		eat(new ArrayList<Double>());
		
	}
}
