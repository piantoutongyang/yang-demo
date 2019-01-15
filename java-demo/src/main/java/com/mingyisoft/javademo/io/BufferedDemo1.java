package com.mingyisoft.javademo.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * 字节缓冲流
 * 
 * @author lenovo
 *
 */
public class BufferedDemo1 {
	public static void main(String[] args) {
		// jdk1.7支持的自动关闭资源的try写法
		try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("123.mp3"));
				BufferedInputStream bis = new BufferedInputStream(new FileInputStream("enya恩雅-only time.mp3"));
				BufferedReader br = new BufferedReader(new FileReader("456.txt"));
				BufferedWriter bw = new BufferedWriter(new FileWriter("789.txt"))) {
			
			String tempStr = null;
			while ((tempStr = br.readLine()) != null) {
				// 如遇乱码问题可以:
				// 1.将文本文件保存到UTF-8的编码集
				// 2.使用转换流并设置编码集而并非FileReader文件流
				System.out.println(tempStr);
				//BufferedWriter不会自动换行，可以使用PrintWriter自动换行。
				bw.write(tempStr);
			}

			byte[] temp = new byte[1024];
			while (bis.read(temp) > 0) {
				bos.write(temp);
			}
			System.out.println("结束");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
