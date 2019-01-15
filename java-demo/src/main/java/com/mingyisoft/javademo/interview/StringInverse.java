package com.mingyisoft.javademo.interview;

/**
 * 给定一个字符串，将这个字符串反转。
 * 
 * @author lenovo
 *
 */
public class StringInverse {
	public static void main(String[] args) {
		System.out.println(inverse("abcdefg"));
	}

	public static String inverse(String param) {
		StringBuilder sb = new StringBuilder();
		char[] temp = param.toCharArray();
		for (int i = temp.length-1; i >= 0; i--) {
			sb.append(temp[i]);
		}
		return sb.toString();
	}
}
