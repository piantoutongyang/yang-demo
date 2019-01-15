package com.mingyisoft.javademo.thread;
/**
 * 3个线程按顺序执行，打印到30.京东面试题
 * @author lenovo
 *
 */
public class ThreeThreadDemo1 {

	public static void main(String[] args) throws InterruptedException {
		TargetNum targetNum = new TargetNum();
		Thread t1 = new YangThread(targetNum,1);
		Thread t2 = new YangThread(targetNum,2);
		Thread t3 = new YangThread(targetNum,3);
		t1.start();
		t2.start();
		t3.start();
	}
}

class TargetNum {
	public static int num = 1;
	/**
	 * 该哪个线程开始执行了,默认是线程1
	 */
	public static int flag = 1;
	public synchronized void addNum(int flagParam) throws Exception {
		if (flag != flagParam) {
			wait();
		} else {
			for (int i = num; i < num + 3; i++) {
				System.out.println(Thread.currentThread().getName() + "----" + i);
			}
			num += 3;
			if(flagParam==3) {
				flag = 1;
			}else {
				flag += 1;
			}
			notifyAll();
		}

	}
}

class YangThread extends Thread {
	private TargetNum targetNum;
	private int flagParam ;

	public YangThread(TargetNum targetNum,int flagParam) {
		this.targetNum = targetNum;
		this.flagParam = flagParam;
	}

	public void run() {
		try { 
			while(true) {
				if(targetNum.num>=30) {
					return;
				}else {
					targetNum.addNum(flagParam);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
