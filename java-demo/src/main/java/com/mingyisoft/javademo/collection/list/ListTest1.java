package com.mingyisoft.javademo.collection.list;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ListTest1 {
	public static void main(String[] args) {
		List list = new ArrayList();
		list.add("1");
		list.add("2");
		list.add(1,"3");
		
		List list2 = new LinkedList(list);
		list.addAll(list2);
		list2 = new LinkedList(list);
		list.addAll(list2);
		list2 = list.subList(2, 5);
		System.out.println(list2);
		list2.clear();
		System.out.println(list);
		
		Map a = new Hashtable();
		a.put(null, null);
		a.put(null, null);
	}
}
