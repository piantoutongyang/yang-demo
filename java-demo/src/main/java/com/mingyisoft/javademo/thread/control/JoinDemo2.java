package com.mingyisoft.javademo.thread.control;

public class JoinDemo2 {
	public static void main(String[] args) throws Exception {
		System.out.println("start");
		JoinThread2 r2 = new JoinThread2();
		Thread t2 = new Thread(r2);
		Thread1 t1 = new Thread1(t2);
		
		t1.start();
		t2.start();

		// 在join()之前的执行，还是会造成争抢式
		// for(int i = 0 ; i < 100 ; i++) {
		// System.out.println(Thread.currentThread().getName()+" "+i);
		// }

		t1.join();
		// t1和t2的join会并发执行，并不会因为t1.join()先调用就执行完t1再执行t2.
		for (int i = 0; i < 50; i++) {
			System.out.println(Thread.currentThread().getName() + " " + i);
		}
//		t2.join();

		// 主线程等待t1,t2两个线程都执行完毕再继续往下走，否则直接就走了，因为多线程是异步的。
		// join()方法也可以加入超时时间，如果超过时间则不再等待

		System.out.println("done");
	}
}

class Thread1 extends Thread {
	Thread t2 ;
	public Thread1(Thread t2) {
		this.t2 = t2;
	}
	public void run() {
		try {
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + " " + i);
		}
	}
}

class JoinThread2 implements Runnable {
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + " " + i);
		}
	}
}