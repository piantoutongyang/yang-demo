package com.mingyisoft.javademo.generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 限制类型:子类
 * 
 * @author lenovo
 *
 */
public class GenericsDemo9<V extends Number> {
	// 限制传递的泛型类型必须是Number的子类
	public static void main(String[] args) {
		GenericsDemo9<Integer> a = new GenericsDemo9<>();
		// Integer是Number的子类，运行正常
		GenericsDemo9<Double> b = new GenericsDemo9<>();
		// Double是Number的子类，运行正常
		// GenericsDemo8<String> c = new GenericsDemo8<>();
		// String不是Number的子类，编译错误
	}
}

class GenericsDemo88<V extends ArrayList & Collection & List> {
	// 可以用于限制多个接口，只能有一个父类上限，但可以有多个接口上限。类上限要写在第一位。
	
}
