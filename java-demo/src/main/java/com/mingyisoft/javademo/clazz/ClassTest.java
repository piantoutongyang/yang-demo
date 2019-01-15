package com.mingyisoft.javademo.clazz;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

@SuppressWarnings(value="unchecked")
public class ClassTest {
	private ClassTest(){
		
	}
	public ClassTest(String name){
		System.out.println("执行有参构造器");
	}
	public void info(){
		System.out.println("执行无参数的info方法");
	}
	
	public void info(String str){
		System.out.println("执行有参数的info方法，str="+str);
	}
	
	class Inner{
		
	}
	
	public static void main(String[] args) throws Exception{
		Class<ClassTest> clazz = ClassTest.class;
		
		//全部构造器
		Constructor[] ctors = clazz.getDeclaredConstructors();
		for(Constructor c : ctors){
			System.out.println(c);
		}
		System.out.println("------------------------");
		
		//全部public构造器
		Constructor[] ctors2 = clazz.getConstructors();
		for(Constructor c : ctors2){
			System.out.println(c);
		}
		System.out.println("------------------------");
		//全部方法
		Method[] mtds = clazz.getMethods();
		for(Method m : mtds){
			System.out.println(m);
		}
		
		
		System.out.println("------------------------");
		//获取指定方法
		System.out.println(clazz.getMethod("info", String.class));
		System.out.println("------------------------");
		
		//全部注解
		Annotation[] anns = clazz.getAnnotations();
		for(Annotation a : anns){
			System.out.println(a);
		}
		
		System.out.println("------------------------");
		//特定注释
		System.out.println(clazz.getAnnotation(SuppressWarnings.class));
		
		System.out.println("------------------------");
		//全部内部类
		Class<?>[] inners = clazz.getDeclaredClasses();
		for(Class a : inners){
			System.out.println(a);
		}
		System.out.println("------------------------");
		//加载内部类
		Class inClazz = Class.forName("com.mingyisoft.javademo.clazz.ClassTest$Inner");
		//展示外部类
		System.out.println(inClazz.getDeclaringClass());
		
		
		System.out.println("------------------------");
		
		System.out.println("package-"+clazz.getPackage());
		System.out.println("parent--"+clazz.getSuperclass());
	}
}
