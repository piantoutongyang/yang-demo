package com.mingyisoft.javademo.thread.control;

/**
 * 后台线程
 * 
 * @author lenovo
 *
 */
public class YieldDemo1 {
	public static void main(String[] args) {
		YieldThread r = new YieldThread();
		new Thread(r).start();
		new Thread(r).start();
	}
}

class YieldThread implements Runnable {
	public void run() {
		for (int i = 0; i < 100; i++) {
			if(i==50) {
				Thread.yield();
			}
			System.out.println(Thread.currentThread().getName()+" "+i);
		}
	}
}