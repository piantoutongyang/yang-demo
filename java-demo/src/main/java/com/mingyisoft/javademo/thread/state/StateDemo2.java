package com.mingyisoft.javademo.thread.state;

public class StateDemo2 {
	public static void main(String[] args) throws Exception {
		final Object lock = new Object();
		Thread t1 = new Thread() {
			public void run() {
				while (true) {
					synchronized (lock) {
						try {
							lock.wait();
						} catch (InterruptedException e) {

						}
					}
				}
			}
		};

		Thread t2 = new Thread() {
			public void run() {
				while (true) {
					synchronized (lock) {
						for (int i = 0; i < 10000000; i++) {
							// System. out.println(i);
						}
						lock.notifyAll();
					}
				}
			}
		};

		t1.start();  
        Thread.sleep(50);  
        t2.start();  
        System.out.println("线程" + t1.getName() + "当前的状态为:" +t1.getState());  
        System.out.println("线程" + t2.getName() + "当前的状态为:" +t2.getState());  
	}
}
