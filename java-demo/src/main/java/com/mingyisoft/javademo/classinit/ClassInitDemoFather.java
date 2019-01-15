package com.mingyisoft.javademo.classinit;

public class ClassInitDemoFather {
	public ClassInitDemoFather() {
		System.out.println("父类执行构造");
	}
	
	/**
	 * 实例变量和块，跟写的顺序有关系，块放到上面和下面不一样。
	 */
	int a = 9; 
	{
		System.out.println("父类执行初始化块");
		a = 6;
	}
	
	/**
	 * 静态变量和静态块，跟写的顺序有关系，块放到上面和下面不一样。
	 */
	static {
		System.out.println("父类执行静态初始化块");
		b = 6;
	}
	static int b = 9;
}
