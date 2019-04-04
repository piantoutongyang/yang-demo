package com.mingyisoft.javademo.jdk8.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 集合排序
 * 
 * @author alexyang
 *
 */
public class LambdaDemo3 {
	public static void main(String[] argus) {
		List<String> names1 = new ArrayList<String>();
		names1.add("Google ");
		names1.add("Runoob ");
		names1.add("Taobao ");
		names1.add("Baidu ");
		names1.add("Sina ");

		List<String> names2 = new ArrayList<String>();
		names2.add("Google ");
		names2.add("Runoob ");
		names2.add("Taobao ");
		names2.add("Baidu ");
		names2.add("Sina ");

		// jdk7的写法
		Collections.sort(names1, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				return s1.compareTo(s2);
			}
		});
		
		System.out.println(names1);
		
		System.out.println("----------------------");
		
		// jdk8的写法
		Collections.sort(names2, (s1, s2) -> s1.compareTo(s2));
		
		System.out.println(names2);

	}
}
