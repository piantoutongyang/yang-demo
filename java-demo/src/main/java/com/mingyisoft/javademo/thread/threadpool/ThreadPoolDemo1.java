package com.mingyisoft.javademo.thread.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolDemo1 {
	public static void main(String[] args) {
		//创建线程池
		//newCachedThreadPool：创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。
		//newFixedThreadPool：创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待。
		//newScheduledThreadPool：创建一个定长线程池，支持定时及周期性任务执行。
		//newSingleThreadExecutor：创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行。
		
		//不用以前的start()来启动线程，而是直接提交给线程池即可运行线程。
		ExecutorService pool = Executors.newFixedThreadPool(3);
		Runnable t = new Runnable() {
			public void run() {
				System.out.println(Thread.currentThread().getName());
			}
		};
		
		for(int i = 0 ; i < 9 ;i++) {
			pool.submit(t);
		}
		//关闭线程池
		pool.shutdown();
		/**
		 * 调用shutdown()后线程池不再接受新任务，但会将以前所有已提交的任务执行完成，
		 * 待所有任务执行完毕后，线程池内的所有线程会全部死亡。
		 */
	}
}

class ThreadPool extends Thread{
	public void run() {
		for(int i = 0 ; i < 10 ; i++) {
			System.out.println(this.getName() + " " + i);
		}
	}
}