package com.mingyisoft.javademo.classinit;

public class ClassInitDemoSon1 extends ClassInitDemoFather{
	public ClassInitDemoSon1() {
		System.out.println("子类执行构造");
	}
	
	/**
	 * 实例变量和块，跟写的顺序有关系，块放到上面和下面不一样。
	 */
	int a = 9; 
	{
		System.out.println("子类执行初始化块");
		a = 6;
	}
	
	/**
	 * 静态变量和静态块，跟写的顺序有关系，块放到上面和下面不一样。
	 */
	static {
		System.out.println("子类执行静态初始化块");
		b = 6;
	}
	static int b = 9;
	
	
	public static void main(String[] args) {
		ClassInitDemoSon1 x = new ClassInitDemoSon1();
		System.out.println("a="+x.a);
		System.out.println("b="+x.b);
	}
}
