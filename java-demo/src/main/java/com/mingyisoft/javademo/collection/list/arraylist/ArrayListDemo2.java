package com.mingyisoft.javademo.collection.list.arraylist;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * arraylist如何去重
 * 
 * @author lenovo
 *
 */
public class ArrayListDemo2 {
	public static void main(String[] args) {
		// 基本数据类型去重
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(1);

		List<Integer> list1 = list = new ArrayList<>(new HashSet(list));
		for (Integer i : list1) {
			System.out.println(i);
		}

		// 引用数据类型去重，要重写equals与hashcode，因为hashset的底层是hashmap，hashmap的key必须要实现，参见hashmap的底层原理。
		Person p1 = new Person();
		Person p2 = new Person();
		p1.setName("alex");
		p1.setAge(21);

		p2.setName("alex");
		p2.setAge(21);

		List<Person> list2 = new ArrayList<>();
		list2.add(p1);
		list2.add(p2);

		List<Person> list3 = new ArrayList<>(new HashSet(list2));
		for (Person i : list3) {
			System.out.println(i);
		}
	}
}

class Person {
	private String name;
	private Integer age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String toString() {
		return name + " " + age;
	}

	public boolean equals(Object obj) {
		if(obj instanceof Person) {
			Person p = (Person)obj;
			if(p.name == name && p.age == age) {
				return true;
			}
		}
		return false;
	}
	
	public int hashCode() {
		return name.hashCode()+age.hashCode();
	}
}
