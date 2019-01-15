package com.mingyisoft.javademo.pool;

public class StringPoolDemo1 {
	public static void main(String[] args) {
		String str1 = "str";
		String str2 = "ing";

		String str3 = "str" + "ing";
		String str4 = str1 + str2;
		System.out.println(str3 == str4);// false

		String str5 = "string";
		System.out.println(str3 == str5);// true

	}
}
