package com.mingyisoft.javademo.designpattern.observer;

public class PhoneObserver implements Observer {
	@Override
	public void notify(Object arg) {
		System.out.println("phone已经知道了变动..."+arg);
	}
}
