package com.mingyisoft.javademo.thread.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolDemo1 {
	public static void main(String[] args) {
		//创建线程池
		ExecutorService pool = Executors.newFixedThreadPool(3);
		//不用以前的start()来启动线程，而是直接提交给线程池即可运行线程。
		pool.submit(new ThreadPool());
		pool.submit(new ThreadPool());
		
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