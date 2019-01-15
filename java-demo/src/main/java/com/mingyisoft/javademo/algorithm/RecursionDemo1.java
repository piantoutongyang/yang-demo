package com.mingyisoft.javademo.algorithm;
/**
 * 递归 5 , 5*4*3*2*1 
 * @author lenovo
 *
 */
public class RecursionDemo1 {
	public static void main(String[] args) {
		System.out.println(eat(5));
		System.out.println(eat(3));
		System.out.println(eat(8));
	} 
	
	public static int eat(int param) {
		if(param ==1||param ==0) {
			return 1;
		}else {
			return param *eat(param -1);
		}
	}
}
