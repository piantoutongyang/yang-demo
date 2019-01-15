package com.mingyisoft.javademo.generics;

/**
 * 父子类继承与泛型：子类没有使用类的泛型类型
 * 
 * @param <S>
 */
public class GenericsDemo6 {
	public static void main(String[] args) {
		
	}
}

class Generics6Father<S> {
	public S info;

	public Generics6Father() {

	}

	public Generics6Father(S info) {
		this.info = info;
	}

	public S getInfo() {
		return info;
	}

	public void setInfo(S info) {
		this.info = info;
	} 
}

class Generics6Son extends Generics6Father<Integer> {
	//错误写法：class Generics6Son extends Generics6Father<T>
	//正确写法：class Generics6Son extends Generics6Father
	//如果子类没有给父类泛型，则默认为Object。
	public Integer getInfo() {
		//子类重写父类方法
		return info;
	}
	
//	public String getInfo() {
//		//子类重写父类方法，错误写法，应该是Integer类型
//		return info;
//	}
}
