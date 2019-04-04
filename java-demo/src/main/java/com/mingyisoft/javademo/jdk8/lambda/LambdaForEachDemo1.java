package com.mingyisoft.javademo.jdk8.lambda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LambdaForEachDemo1 {
	public static void main(String[] args) {
		//便利map老的方式
		Map<String, Integer> items = new HashMap<>();
		items.put("A", 10);
		items.put("B", 20);
		items.put("C", 30);
		for (Map.Entry<String, Integer> entry : items.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}

		System.out.println("---分隔符---");

		//便利map新的方式
		items.forEach((k, v) -> System.out.println(k + " " + v));
		System.out.println("---分隔符---");
		items.forEach((k,v)->{
		    System.out.println(k + " " + v);
		    if("C".equals(k)){
		        System.out.println("Hello C");
		    }
		});
		System.out.println("---分隔符---");
		//便利list老的方式
		List<String> items2 = new ArrayList<String>();
		items2.add("A");
		items2.add("B");
		items2.add("C");
		
		for(String temp : items2) {
			System.out.println(temp);
		}
		System.out.println("---分隔符---");
		//便利list新的方式
		items2.forEach(item->System.out.println(item));
		System.out.println("---分隔符---");
		items2.forEach(item->{
		    if("C".equals(item)){
		        System.out.println("HELLO C");
		    }
		});

	}
}
