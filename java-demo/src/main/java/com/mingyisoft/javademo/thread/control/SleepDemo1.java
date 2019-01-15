package com.mingyisoft.javademo.thread.control;

/**
 * 线程休眠
 * 
 * @author lenovo
 *
 */
public class SleepDemo1 {
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			if (i == 5) {
				try {
					//暂停5秒
					Thread.sleep(5 * 1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println(Thread.currentThread().getName() + " " + i);
		}
	}
}