package com.mingyisoft.javademo.generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 泛型通配符
 * 
 * @author lenovo
 *
 */
public class GenericsDemo8<V extends Number> {
	public static void main(String[] args) {
		List<Integer> a = new ArrayList<Integer>();
		// a.add("a");
		a.add(1);
		a.add(2);
		a.add(3);

		printList(a);
	}

	static void printList(List<?> a) {
		for (Object o : a) {
			System.out.println(o);
		}
	}
}
