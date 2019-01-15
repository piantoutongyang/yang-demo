package com.mingyisoft.javademo.extend;

public class ExtendDemo1 {
	public static void main(String[] args) {
		Son s = new Son();
		s.a();
	}
}

class Father {
	void a() {
		System.out.println("爸爸的a");
		b();
	}

	protected void b() {
		System.out.println("爸爸的b");
	}
}

class Son extends Father {
	void a() {
		System.out.println("儿子的a");
		b();
	}
	/**
	 * 这种情况下，子类确实从某种意义上来说破坏了父类的封装性，父类的b方法本意是只能被子类访问，
	 * 但子类调用了父类的b方法又把访问控制符改成了public让外界可以访问到，间接的让外界也能访问到父类的b方法。
	 */
	public void b() {
		super.b();
		System.out.println("儿子的b");
	}
}
