package com.mingyisoft.javademo.collection.set;
/**
 * 重写了equals与hashCode方法
 * @author yangmh
 *
 */
public class Person {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String toString() {
		return name;
	}

	public boolean equals(Object other) {
		System.out.println("走了equals()");
	    //1.判断是否等于自身.
	    if(other == this){
	      return true;
	    }

	    //2.使用instanceof运算符判断other是否为Person类型的对象. 
	    if(!(other instanceof Person)){
	      return false;
	    }

	    //3.比较Person类中自定义的属性name
	    Person p = (Person)other;//需要强制类型转换
	    return p.name.equals(this.name);

	}

	public int hashCode() {
		int result = 17;
		result = result * 31 + name.hashCode();
		System.out.println("走了hashCode(),hashCode="+result);
		return result;
	}

}
