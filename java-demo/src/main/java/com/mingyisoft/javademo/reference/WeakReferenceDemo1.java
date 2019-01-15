package com.mingyisoft.javademo.reference;

import java.lang.ref.WeakReference;

public class WeakReferenceDemo1 {
	public static void main(String[] args) throws InterruptedException {
		String str = "alex";
		WeakReference wr = new WeakReference(str);
		str = null;
		System.out.println("---->"+wr.get());
		System.gc();//gc后应该是位null，但是无法准确控制gc，因此无法准确看到效果。
		System.runFinalization();
		System.out.println("---->"+wr.get());
	}
}
