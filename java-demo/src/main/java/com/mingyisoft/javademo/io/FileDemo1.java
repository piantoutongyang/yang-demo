package com.mingyisoft.javademo.io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

public class FileDemo1 {
	public static void main(String[] args) throws Exception {
		File f1 = new File("enya恩雅-only time.mp3");//相对路径文件名
		File f2 = new File("D:\\yangWorkSpaces\\yangDemoWorkSpace\\javademo");//绝对路径
		/**
		 * 访问文件名&路径相关方法
		 */
		System.out.println(f1.getName());//返回文件名
		System.out.println(f2.getName());//返回路径名，只返回最后一级子路径名
		System.out.println(f2.getPath());//返回路径名，在File的构造里怎么写的就返回什么
		System.out.println(f1.getAbsolutePath());//返回绝对路径
		System.out.println(f1.getAbsoluteFile());//返回绝对路径对应的File对象
		System.out.println(f2.getParentFile());//返回父目录对应的File对象
		System.out.println(f2.getParent());//返回父目录对象
		System.out.println(f1.renameTo(new File("abc.mp3")));//重命名文件&目录，成功返回true，否则返回false
		/**
		 * 文件检查相关方法
		 */
		System.out.println(f1.exists());//判断文件&目录是否存在
		System.out.println(f1.canWrite());//判断文件&目录是否可写
		System.out.println(f1.canRead());//判断文件&目录是否可读
		System.out.println(f1.isFile());//判断文件&目录是否是文件
		System.out.println(f1.isDirectory());//判断文件&目录是否是目录
		System.out.println(f2.isAbsolute());//判断文件&目录是否是绝对路径
		/**
		 * 获取常规文件信息
		 */
		System.out.println(f1.lastModified());//返回文件&目录的最后修改时间,long类型
		System.out.println(f1.length());//返回文件&目录的长度
		/**
		 * 文件操作相关方法
		 */
		//当File对象不存在时创建对象,创建成功返回true,否则返回false
		System.out.println(new File("4.mp3").createNewFile());
		System.out.println(new File("4.mp3").delete());//删除文件&目录,删除成功返回true,否则返回false
		//创建临时空文件,在前缀与后缀中间会有一串随机数组成临时文件名
		System.out.println(File.createTempFile("aaa", ".txt"));
		System.out.println(new File("4.mp3").createNewFile());
		//在jvm退出后删除文件
		new File("4.mp3").deleteOnExit();
		//删除文件,成功返回true,失败返回false
		System.out.println(new File("4.mp3").delete());
		/**
		 * 目录操作相关方法
		 */
		System.out.println(new File("D:\\aaa\\bb").mkdir());//创建目录,成功返回true,错误返回false
		System.out.println(Arrays.asList(new File("D:\\aaa").list()));//返回子文件名&目录名的字符串数组
		System.out.println(Arrays.asList(new File("D:\\aaa").listFiles()));//返回子文件名&目录名的文件数组
		System.out.println(Arrays.asList(File.listRoots()));//列出系统根路径,例如[C:\, D:\]
		/**
		 * 文件过滤
		 */
		File f = new File("D:\\yangWorkSpaces\\yangDemoWorkSpace\\javase\\src\\main\\java\\com\\mingyisoft\\javase\\thread\\threadsafe\\demo1");
		System.out.println(Arrays.asList(f.list(new FilenameFilter(){
			@Override
			public boolean accept(File dir, String name) {
				return name.endsWith(".java") || new File(name).isDirectory();
			}
		})));
	}
}
