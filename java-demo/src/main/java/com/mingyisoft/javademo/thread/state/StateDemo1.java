package com.mingyisoft.javademo.thread.state;

public class StateDemo1 {
	public static void main(String[] args) throws Exception {
		// 匿名内部类实现的Runnable接口，参考命令模式。
		Runnable run = new Runnable() {
			public void run() {
				synchronized (this) {
					System.out.println("谁来了" + Thread.currentThread().getName());
					for (int i = 0; i < 9999; i++) {
						System.out.print(i);
					}
				}
			}
		};

		Thread t1 = new Thread(run, "t1");
		Thread t2 = new Thread(run, "t2");
		// NEW状态
//		 System.out.println(t1.getState());
		t1.start();
		t2.start();

		// RUNNABLE状态
		System.out.println(t1.getState());
		// BLOCKED状态
		System.out.println(t2.getState());

		// 延迟100毫秒，让线程跑完
		// Thread.sleep(100L);
		// TERMINATED状态
		// System.out.println(t2.getState());

	}
}
