package com.mingyisoft.javademo.algorithm;
/**
 * 递归 5 , 5*4*3*2*1 
 * @author lenovo
 *
 */
public class RecursionDemo2 {
	public static void main(String[] args) {
		System.out.println(eat(10));
	} 
	
	public static int eat(int param) {
		if(param ==0) {
			return 1;
		}else if(param ==1) {
			return 4;
		}else {
			return 2 *eat(param-1)+eat(param-2);
		}
	}
}
