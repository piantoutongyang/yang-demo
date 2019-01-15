package com.mingyisoft.javademo.collection.list.linkedlist;

import java.util.LinkedList;

public class LinkedListQueueDemo {
	public static void main(String[] args) {
		/**
		 * 使用linkedlist模拟一个queue队列，先进先出。
		 */
		LinkedList a = new LinkedList();
		
		for (int i = 0; i < 10; i++) {
			//push
			a.addFirst(i);
		}
		
		while(!a.isEmpty()){
			//pop
			System.out.println(a.removeLast());
		}
		
	}
}
