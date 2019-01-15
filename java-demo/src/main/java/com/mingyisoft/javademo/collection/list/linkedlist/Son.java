package com.mingyisoft.javademo.collection.list.linkedlist;

public class Son extends Father{
	public void finalize() throws Throwable{
		System.out.println("wowowoow");
	}
	
	public static void main(String[] args) {
		Father s = new Son();
		s = null;
		System.gc();
		System.out.println("hahha");
		try {
			Thread.sleep(99999999);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
