package com.mingyisoft.javademo.jdk8.lambda;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LambdaDemo2 {
	public static void main(String[] argus) {
		List<Integer> list = Arrays.asList(1, 2, 3);
		// Old way:
		for (Integer n : list) {
			System.out.println(n);
		}

		System.out.println("-----------------------");

		// New way:
		list.forEach(n -> System.out.println(n));
		System.out.println("-----------------------");
		// or we can use :: double colon operator in Java 8
		list.forEach(System.out::println);

		Map<String, Object> map = new HashMap<>();
		map.put("1", "a");
		map.put("2", "b");
		map.put("3", "c");
		map.forEach((key, value) -> {
			System.out.println(key);
			System.out.println(value);
		});

	}
}
