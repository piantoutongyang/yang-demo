package com.mingyisoft.javademo.designpattern.observer;
/**
 * 观察者接口
 * @author yangmh
 *
 */
public interface Observer {
	/**
	 * 通知
	 * @param arg
	 */
	public void notify(Object arg);
}
