package com.mingyisoft.javademo.thread.control;

public class PriorityDemo {
	public static void main(String[] args) {
		PriorityThread t1 = new PriorityThread();
		PriorityThread t2 = new PriorityThread();
		
		t1.setPriority(Thread.MAX_PRIORITY);
		t2.setPriority(Thread.MIN_PRIORITY);
		
		t1.start();
		t2.start();
		
		System.out.println("得到线程优先级t1="+t1.getPriority());
		System.out.println("得到线程优先级t2="+t2.getPriority());
	}
}
class PriorityThread extends Thread{
	public void run(){
		for(int i = 0 ; i < 100 ; i ++){
			System.out.println(" "+getName()+":"+i);
		}
	}
}
