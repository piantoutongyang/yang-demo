package com.mingyisoft.javademo.jdk8;

import java.util.Arrays;
import java.util.stream.Stream;

public class LambdaDemo1 {
	public static void main(String[] args) {
		//原来新建个线程输出内容
		new Thread(new Runnable() {
	        public void run() {
	            System.out.println("Hello World111");
	        }
	    }).start();

		//现在新建个线程输出内容
		new Thread(() -> System.out.println("Hello World222")).start();
		
		//修改方法的能力，其实说白了，就是函数中可以接受以函数为单元的参数，在C/C++中就是函数指针，在Java中就是Lambda表达式
		//在上面代码中用了Arrays里的sort方法，现在我们不需要按字典排序，而是按字符串的长度进行排序，
		//是不是很方便，我们不需要实现Comparable接口，使用一个Lambda表达式就可以改变一个函数的形为~
		String []datas = new String[] {"han","ming","yyyyang"};
		Arrays.sort(datas,(v1 , v2) -> Integer.compare(v1.length(), v2.length()));
	    Stream.of(datas).forEach(param -> System.out.println(param));
	}
}
