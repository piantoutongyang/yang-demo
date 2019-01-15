package com.mingyisoft.javademo.thread.control;
/**
 * 后台线程
 * @author lenovo
 *
 */
public class DaemonDemo1 {
	public static void main(String[] args) {
		Thread t1 = new Thread(new DaemonThread());
		//设置为后台线程
		t1.setDaemon(true);
		t1.start();
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName()+" "+i);
		}
		//后台线程还没有完全运行完就会死掉，因为主线程先死了。
		//查看是否为后台线程
		System.out.println(t1.isDaemon());
		System.out.println(Thread.currentThread().isDaemon());
	}
}
class DaemonThread implements Runnable{
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName()+" "+i);
		}
	}
}