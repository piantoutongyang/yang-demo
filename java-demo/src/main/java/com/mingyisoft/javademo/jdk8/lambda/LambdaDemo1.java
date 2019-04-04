package com.mingyisoft.javademo.jdk8.lambda;

import java.util.Arrays;
import java.util.stream.Stream;
/**
 * 
 * @author alexyang
 * lambda的语法：
 * (parameters) -> expression，(parameters) ->{ statements; }，parameters可为null。
 * lambda重要特性：
 * 1.不需要声明参数类型，编译器可以自动识别参数值；
 * 2.单个参数无需定义圆括号，多个参数需要定义圆括号；
 * 3.如果主体只有一条语句则不需要大括号，如果是多条语句则需要大括号；
 * 4.编译器自动识别返回值；
 * 
 */
public class LambdaDemo1 {
	public static void main(String[] args) {
		//原来新建个线程输出内容，()表示没有参数，主体如果是一堆代码则可以使用大括号包起来{}
		new Thread(new Runnable() {
	        public void run() {
	            System.out.println("Hello World111");
	        }
	    }).start();

		//现在新建个线程输出内容
		new Thread(() -> System.out.println("Hello World222")).start();
//		Runnable r = () -> System.out.println("hello world");
		
		//修改方法的能力，其实说白了，就是函数中可以接受以函数为单元的参数，在C/C++中就是函数指针，在Java中就是Lambda表达式
		//在上面代码中用了Arrays里的sort方法，现在我们不需要按字典排序，而是按字符串的长度进行排序，
		//是不是很方便，我们不需要实现Comparable接口，使用一个Lambda表达式就可以改变一个函数的形为~
		String []datas = new String[] {"han","ming","yyyyang"};
		Arrays.sort(datas,(v1 , v2) -> Integer.compare(v1.length(), v2.length()));
	    Stream.of(datas).forEach(param -> System.out.println(param));
	}
}
