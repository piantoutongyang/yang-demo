package com.mingyisoft.javademo.classloader;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

public class ClassLoaderDemo1 {
	public static void main(String[] args) throws IOException {
		//获取系统类加载器
		ClassLoader systemLoader = ClassLoader.getSystemClassLoader();
		System.out.println("系统类加载器 " + systemLoader);
		/**
		 * 获取系统类加载器的加载路径，通常由classpath环境变量指定，如果操作系统没有指定classpath环境变量，
		 * 则默认以当前路径作为系统类加载器的加载路径。
		 */
		Enumeration<URL> eml = systemLoader.getResources("");
		while (eml.hasMoreElements()) {
			System.out.println(eml.nextElement());
		}
		ClassLoader extensionLader = systemLoader.getParent();
		System.out.println("扩展类加载器 " + extensionLader);
		System.out.println("扩展类加载器的加载路径 " + System.getProperty("java.ext.dirs"));
		System.out.println("扩展类加载器的parent: " + extensionLader.getParent());
	}
}
