package com.mingyisoft.javademo.designpattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 被观察者父类，如果没有父类也可以，就把这些方法都散落在每个被观察者类中。
 * 或者使用java自带的java.util.Observable
 */
public class Observable {
	/**
	 * 观察者列表,以后可以改造成这个list放在缓存里等等
	 */
	List<Observer> observerList = new ArrayList<Observer>();
	/**
	 * 注册观察者
	 */
	public void registerObserver(Observer observer){
		observerList.add(observer);
	}
	/**
	 * 取消注册观察者
	 */
	public void unRegisterObeserver(Observer observer){
		observerList.remove(observer);
	}
	/**
	 * 通知所有观察者
	 */
	public void notifyObservers(Object arg){
		for(Observer observer : observerList){
			observer.notify(arg);;
		}
	}
}
