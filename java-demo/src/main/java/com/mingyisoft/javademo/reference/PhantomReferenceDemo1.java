package com.mingyisoft.javademo.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

public class PhantomReferenceDemo1 {
	public static void main(String[] args) {
		String str = new String("alex");
		ReferenceQueue queue = new ReferenceQueue();
		PhantomReference pr = new PhantomReference(str,queue);
		str = null;
		System.out.println(pr.get());//不能通过虚引用来访问被访问对象
		System.gc();//无法准确控制gc，因此无法准确看到效果。
		System.runFinalization();
		System.out.println(queue.poll()==pr);//理论上应该是true,既然pr.get()是null，那我不知道还有什么实战意义
	}
}
