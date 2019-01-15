package com.mingyisoft.javademo.clazz;

public class ClassDemo1 {
	public static void main(String[] args) {
		/**
		 * 其中Person为类名，p1为对象变量名，Person()则是调用Person类的无参构造方法。
		 * new运算符为对象分配内存空间，它调用构造方法，返回Person对象。
		 *（术语是返回Person对象的引用，新人可以暂忽略，这涉及到java堆栈内存）
         * 再将Person对象赋值给数据类型为Person的变量p1。
         * 一个类的不同对象，分别占据不同的内存空间，如果肆无忌惮的new，会导致内存溢出的风险。
		 */
		Person p1 = new Person();
		//使用"."来调用对象的属性与方法。
		p1.age = 14;
		p1.name = "张三";
		p1.eat();
		p1.sleep();
	}
}

class Person{
	String name;
	Integer age;
	
	public void eat() {
		System.out.println(name+"在吃饭.");
	}
	
	public void sleep() {
		System.out.println(name+"在睡觉.");
	}
}