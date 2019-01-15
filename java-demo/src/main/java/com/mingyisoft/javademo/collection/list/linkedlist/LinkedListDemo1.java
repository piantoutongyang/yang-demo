package com.mingyisoft.javademo.collection.list.linkedlist;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedListDemo1 {
	public static void main(String[] args) {
		// 创建并初始化链表,LinkedList既可以当队列也可以当栈
		LinkedList<String> books = new LinkedList<>();

		// 加入到链表的头部
		books.push("a");
		// 加入到栈的尾部,注意此处不会因为写在前面就放在链表的前面
		books.offer("b");
		// 加入到链表的头部（最后加的放在链表的最上面）
		books.offerFirst("c");
		//加入到链表的尾部
		books.addLast("d");
		//加入到链表的尾部
		books.addLast("e");
		//加入到链表的尾部
		books.addLast("f");
		//从 头删除一个链表元素
		books.removeFirst();
		//从 尾删除一个链表元素
		books.removeLast();
		
		// 遍历链表
		for (int i = 0; i < books.size(); i++) {
			System.out.println(books.get(i));
		}
		// 访问但不删除栈顶的元素
		System.out.println(books.peekFirst());
		// 访问但不删除队列的最后一个元素
		System.out.println(books.peekLast());
		// 将栈顶的元素弹出栈
		System.out.println(books.pop());
		// 访问并删除队列的最后一个元素
		System.out.println(books);
		System.out.println(books.pollLast());
		System.out.println(books);
		
		System.out.println("----------");
		//可以给定一个Collection作为参数来创建链表
		List<String> list = new ArrayList<>();
		list.add("g");
		list.add("h");
		list.add("i");
		LinkedList<String> books2 = new LinkedList<>(list);
		System.out.println(books2);
	}
}
