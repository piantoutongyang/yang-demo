package com.mingyisoft.javademo.map.hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class HashMapDemo2 {
	public static void main(String[] args) {
		Map<String,String> m = new HashMap<String,String>();
		m.put("a", "1");
		m.put("b", "2");
		m.put("c", "3");
		
		for(Entry<String,String> e : m.entrySet()) {
			System.out.println(e.getKey());
			System.out.println(e.getValue());
		}
	}
}
