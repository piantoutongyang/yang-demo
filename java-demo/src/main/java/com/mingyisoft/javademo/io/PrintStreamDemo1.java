package com.mingyisoft.javademo.io;

import java.io.FileOutputStream;
import java.io.PrintStream;
/**
 * 处理流包装节点流,一般要输出文本都应使用PrintStream
 * @author lenovo
 *
 */
public class PrintStreamDemo1 {
	public static void main(String[] args) {
		PrintStream ps = null;
		try {
			ps = new PrintStream(new FileOutputStream("bbb.txt"));
			ps.print("太阳当空照花儿对我笑");
			ps.println("小鸟说早早早你为什么背上小书包");
			ps.println(new PrintStreamDemo1());
			System.out.println("结束");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (ps != null) {
				ps.close();
			}
		}
	}
}
