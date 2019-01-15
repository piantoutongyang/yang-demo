package com.mingyisoft.javademo.collection.list.linkedlist;

import java.util.LinkedList;
import java.util.List;

public class LinkedListStackDemo {
	public static void main(String[] args) {
		/**
		 * 使用linkedlist模拟一个stack栈，后进先出。
		 */
		LinkedList a = new LinkedList();

		for (int i = 0; i < 10; i++) {
			//push
			a.addFirst(i);
		}
		
		System.out.println(a.getFirst());
		
		//pop
		a.removeFirst();
		System.out.println(a.getFirst());
		
		a.removeFirst();
		System.out.println(a.getFirst());
	}
}
