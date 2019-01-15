package com.mingyisoft.javademo.classloader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * 自定义类加载器，实现加载前先编译的功能
 * 
 * @author lenovo
 *
 */
public class MyClassLoader extends ClassLoader {
	private boolean compile(String javaFile) throws IOException {
		System.out.println("CompileClassLoader正在编译" + javaFile + "...");
		// 调用系统的javac命令
		Process p = Runtime.getRuntime().exec("javac" + javaFile);
		// 其他的线程都在等待这个线程完成
		try {
			p.waitFor();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			;
		}
		// 获取javac线程的退出值
		int ret = p.exitValue();
		return ret == 0;
	}

	private byte[] getBytes(String filename) throws IOException {
		File file = new File(filename);
		long len = file.length();
		byte[] raw = new byte[(int) len];
		FileInputStream fin = new FileInputStream(file);
		// 一次读取class文件的全部二进制数据
		int r = fin.read(raw);
		if (r != len)
			throw new IOException("无法读取全部文件：" + r + " != " + len);
		fin.close();
		return raw;
	}

	protected Class<?> findClass(String name) throws ClassNotFoundException {
		System.out.println("进入findClass内部");
		Class clazz = null;
		// 将包路径中的点（.）替换成斜线（/）。
		String fileStub = name.replace(".", "/");
		String javaFilename =  fileStub + "java";
		String ClassFilename = fileStub + ".class";
		File javaFile = new File(javaFilename);
		File classFile = new File(ClassFilename);
		// 当指定的java源文件存在，且class文件不存在，或者java源文件的
		// 修改时间比class文件修改时间晚时，重新编译
		if (javaFile.exists() && (!classFile.exists()) || javaFile.lastModified() > classFile.lastModified()) {
			// 如果编译失败，或者该class文件不存在
			try {
				if (!compile(javaFilename) || !classFile.exists()) {

				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		// 如果class文件存在，系统负责将该文件转化成class对象
		if (classFile.exists()) {

			try {
				byte[] raw = getBytes(ClassFilename);
				// 调用ClassLoader的defineClass方法将二进制数据转换成class对象
				clazz = defineClass(name, raw, 0, raw.length);

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		// 如果clazz为null,表明加载失败，则抛出异常
		if (clazz == null) {
			try {
				throw new ClassNotFoundException(name);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println("找不到这个类");
				System.out.println(e.toString());
				;
				System.out.println("找不到这个类");
			}

		}
		return clazz;
	}

	public static void main(String[] args) throws Exception {
		//这个类有问题，重写了findClass后，竟然进不去。。。。
		// 第一个参数需要运行的类
		String progClass = "com.mingyisoft.javademo.classloader.ClassLoaderDemo1";
		// 剩下的参数将作为运行目标类时的参数，所以将这些参数复制到新的数组中
		String progArgs[] = new String[args.length - 1];
		System.arraycopy(args, 1, progArgs, 0, progArgs.length);
		MyClassLoader ccl = new MyClassLoader();
		// 加载需要运行的类
		Class<?> clazz = ccl.loadClass(progClass);
		// 加载需要运行的类的主方法
//		Method main = clazz.getMethod("main", (new String[0].getClass()));
//		Object argspArray[] = { progArgs };
//		main.invoke(null, argspArray);
	}
}
