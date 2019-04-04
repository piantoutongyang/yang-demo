package com.mingyisoft.javademo.jdk8.lambda;

/**
 * @author alexyang
 *
 */
public class LambdaDemo4 {
	public static void main(String[] argus) {
		// 类型声明
		MathOperation addition = (int a, int b) -> a + b;

		// 不用类型声明
		MathOperation subtraction = (a, b) -> a - b;

		// 大括号中的返回语句
		MathOperation multiplication = (int a, int b) -> {
			return a * b;
		};

		// 没有大括号及返回语句
		MathOperation division = (int a, int b) -> a / b;

		System.out.println("10 + 5 = " + addition.operation(10, 5));
		System.out.println("10 - 5 = " + subtraction.operation(10, 5));
		System.out.println("10 x 5 = " + multiplication.operation(10, 5));
		System.out.println("10 / 5 = " + division.operation(10, 5));

		// 不用括号
		GreetingService greetService1 = message -> System.out.println("Hello " + message);

		// 用括号
		GreetingService greetService2 = (message) -> System.out.println("Hello " + message);

		greetService1.sayMessage("Runoob");
		greetService2.sayMessage("Google");
		
		/**
		 * 相当于用lambda表达式来把之前的匿名内部类（命令模式）给简化了，提供了函数式编程能力。
		 */

	}

	interface MathOperation {
		int operation(int a, int b);
	}

	interface GreetingService {
		void sayMessage(String message);
	}
}
