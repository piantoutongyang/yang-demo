package com.mingyisoft.javademo.thread.threadgroup;

public class ThreadGroupDemo1 {
	public static void main(String[] args) {
		//返回主线程所属的线程组
		ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();
		System.out.println("线程组名称 " + mainGroup.getName());
		System.out.println("线程组是否为后台线程 " + mainGroup.isDaemon());
		System.out.println("线程组的活动线程数目 " + mainGroup.activeCount());
		//创建新的线程组
		ThreadGroup newGroup = new ThreadGroup("newGroup");
		//设置后台线程
		newGroup.setDaemon(true);
		//设置线程优先级
		newGroup.setMaxPriority(Thread.MAX_PRIORITY);
		
		//设置异常处理

		new ThreadDemo(newGroup,"newThread1").start();
		new ThreadDemo(newGroup,"newThread2").start();
		//中断所有线程
//		newGroup.interrupt();
	}
}

class ThreadDemo extends Thread {
	public ThreadDemo(ThreadGroup threadGroup, String name) {
		super(threadGroup, name);
	}

	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println(this.getName() + " " + i);
		}
	}
}