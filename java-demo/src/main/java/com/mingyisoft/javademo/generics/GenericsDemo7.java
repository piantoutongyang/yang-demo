package com.mingyisoft.javademo.generics;

/**
 * 父子类继承与泛型：子类有使用类的泛型类型
 * 
 * @param <S>
 */
public class GenericsDemo7 {
	public static void main(String[] args) {
		// 父类泛型使用String
		GenericsFather<String> f = new GenericsFather<>();
		// info是String类型
		System.out.println(f.info);
		// getInfo()是String类型
		System.out.println(f.getInfo());
		System.out.println(f.eat(5));
		System.out.println(f.sleep("5"));

		// 子类泛型使用Integer
		GenericsSon<Integer> s = new GenericsSon<>();
		System.out.println(s.info);
		System.out.println(s.getInfo());
		System.out.println(s.eat(5));
		// 遇到直接继承自父类的方法则需要走父类的泛型Boolean
		System.out.println(s.sleep(true));

		// 多态的情况下
		GenericsFather<Boolean> ss = new GenericsSon<Integer>();
		// 此处info是Boolean类型，虽然子类定义了泛型类型Boolean，
		// 但在多态下，调用的是父类的成员变量，会走父类的泛型类型。
		System.out.println(ss.info);
		System.out.println(ss.getInfo());
		System.out.println(ss.eat(5));
		System.out.println(ss.sleep(true));
	}
}

class GenericsFather<S> {
	public S info;

	public S getInfo() {
		return info;
	}

	public void setInfo(S info) {
		this.info = info;
	}

	public <A> A eat(A param) {
		return param;
	}

	public S sleep(S param) {
		return null;
	}
}

class GenericsSon<T> extends GenericsFather<Boolean> {
	public T info;

	public <S> S eat(S param) {
		return param;
	}

	public T eat2(T param) {
		return param;
	}
}
