package com.mingyisoft.javademo.collection.set;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * 当一个对象(重写过hashcode与equals的对象)被存储进hashset集合中以后，就不能修改这个对象中的那些参与计算哈希值的字段了(例如例子中的name字段)，
 * 否则，对象修改后的哈希值与最初存储进hashset集合时的哈希值就不同了，
 * 这种情况下，即使在contains方法使用该对象的当前引用作为的参数去hashset集合中检索对象，也将返回找不到对象的结果，这也会导致无法从hashset集合中单独删除当前对象，
 * 从而造成内存泄露，所谓的内存泄露也就说有一个对象不再被使用，但它一直占有内存空间，没有被释放。
 * @author yangmh
 *
 */
public class HashSetDemo2 {
	public static void main(String[] args) {
		System.out.println(16%5);
		System.out.println(6%5);
		
		Person s1 = new Person();
		s1.setName("yang1");
		Person s2 = new Person();
		s2.setName("yang2");
		Person s3 = new Person();
		s3.setName("yang3");
		Person s4 = new Person();
		s4.setName("yang1");
		
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
		System.out.println(s3.hashCode());
		System.out.println(s4.hashCode());
		
		System.out.println("------");
		
		Set set = new HashSet();
		set.add(s1);
		set.add(s4);
		
		//不存在的元素，去contains，也返回true，是因为2个对象的hashcode与equals都一样，不是按内存去判断
		System.out.println(set.contains(s4));
		
		System.out.println(set.contains(s1));
		s1.setName("ming");
		System.out.println(set.contains(s1));
		
		Iterator iter = set.iterator();
		while(iter.hasNext()){
			System.out.println(iter.next());
		}
		
		System.out.println(s1.hashCode());
		System.out.println(s4.hashCode());
		
		
		List aaa =new ArrayList();
		Set a = new HashSet();
		
		
	}
}
