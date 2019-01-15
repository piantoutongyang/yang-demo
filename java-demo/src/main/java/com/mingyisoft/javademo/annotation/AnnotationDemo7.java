package com.mingyisoft.javademo.annotation;
@AnnotationDemo5(name = "alex")
public class AnnotationDemo7 {
	@AnnotationDemo4
	String name;
	
	public void eat() {
		
	}
	
	public static void main(String[] args) {
		//使用反射来获取当前类所使用的注解
		AnnotationDemo5 a = (AnnotationDemo5)AnnotationDemo7.class.getAnnotation(AnnotationDemo5.class);
		//获取注解中的值
        System.out.println(a.id());
        System.out.println(a.name());
        //判断是否存在注解
        System.out.println(AnnotationDemo7.class.isAnnotationPresent(AnnotationDemo5.class));
        //使用反射来获取当前类所使用的全部注解
        System.out.println(AnnotationDemo7.class.getAnnotations());
	}
}
