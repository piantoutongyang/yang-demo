package com.mingyisoft.javademo.designpattern.observer;
/**
 * 被观察者
 * @author yangmh
 *
 */
public class Product extends Observable{
	private double price;
	private String name;
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
		super.notifyObservers(price);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
		super.notifyObservers(name);
	}
}
