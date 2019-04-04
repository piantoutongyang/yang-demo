package com.mingyisoft.javademo.jdk8.functionalinterface;
/**
 * 函数式接口
 * @author alexyang
 *
 */
public class FunctionalInterfaceDemo1 {
	public static void main(String[] argus) {
		GreetingService greetService1 = message -> System.out.println("hello "+message);
		greetService1.sayMessage("xxx");
	}
}

@FunctionalInterface
interface GreetingService{
	void sayMessage(String message);
}
