package com.mingyisoft.javademo.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 字符输入流
 * 
 * @author lenovo
 *
 */
public class FileWriterDemo1 {
	public static void main(String[] args) {

		FileReader fr = null;
		FileWriter fw = null;

		try {
			char[] temp = new char[1024];
			// 将字符串写入到文件
			fw = new FileWriter("aaa.txt");
			fw.write("我爱你亲爱的姑娘55555666");// 直接覆盖，而不是追加。如果想追加怎么办？
			fr = new FileReader("aaa.txt");
			fr.read(temp);
			System.out.println(new String(temp));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fr != null) {
				try {
					fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (fw != null) {
				try {
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		System.out.println("结束");
	}
}
