package com.mingyisoft.javademo.operationalcharacter;

public class InstanceOfDemo1 {
	public static void main(String[] args) {
		A a = new B();
		C c = new C();
		System.out.println(a instanceof A);
		System.out.println(a instanceof B);
		System.out.println(c instanceof A);
//		System.out.println(c instanceof B);
		
		//A是接口，java允许一个类实现多个接口，因此System.out.println(c instanceof A);是有可能成功的，所以编译时不会报错。
		//如果把A从接口改成类，System.out.println(c instanceof A);也会编译出错。
	}
}

interface A{
	
}

class B implements A{
	
}

class C {
	
}
