package com.mingyisoft.javademo.designpattern.observer;

public class MailObserver implements Observer{
	@Override
	public void notify(Object arg) {
		System.out.println("mail已经知道了变动..."+arg);
	}
}
