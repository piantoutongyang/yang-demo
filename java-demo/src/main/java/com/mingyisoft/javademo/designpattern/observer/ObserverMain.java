package com.mingyisoft.javademo.designpattern.observer;

public class ObserverMain {
	public static void main(String[] args) {
//		java.util.Observable a = null;
//		java.util.Observer b = null;

		Product p = new Product();

		PhoneObserver phoneObserver = new PhoneObserver();
		MailObserver mailObserver = new MailObserver();

		// 注册观察者,这个步骤可以放到Product的构造中去，或者抽出去，不用每个对象每次都注册
		p.registerObserver(phoneObserver);
		p.registerObserver(mailObserver);

		p.setName("张三");
		p.setPrice(15);
		// 删除观察者
		p.unRegisterObeserver(mailObserver);
		System.out.println("------------删除观察者之后--------------------");

		p.setName("张三");
		p.setPrice(15);
		// 好处是我可以动态的增加&删除观察者。不用强依赖，强耦合，随时增删观察者。。。

	}
}
