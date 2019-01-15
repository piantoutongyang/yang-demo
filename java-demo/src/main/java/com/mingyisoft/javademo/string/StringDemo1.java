package com.mingyisoft.javademo.string;
/**
 * 小驼峰转蛇形
 * @author lenovo
 *
 */
public class StringDemo1 {
	public static void main(String[] args) {
		String s = "orderOptionId";
		String zz = s.replaceAll("[A-Z]", "_$0").toLowerCase();
		System.out.println(zz);
	}
}
