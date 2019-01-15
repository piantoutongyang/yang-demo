package com.mingyisoft.javademo.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 用字节输入输出流复制文件
 * @author lenovo
 *
 */
public class FileInputOutStreamDemo1 {
	public static void main(String[] args) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		try {
			fis = new FileInputStream("enya恩雅-only time.mp3");
			fos = new FileOutputStream("new-enya恩雅-only time.mp3");
			
			byte[] temp = new byte[1024];
			while(fis.read(temp)!=-1) {
				fos.write(temp);
			}
			
			temp = new byte[1024];
			//将字符串写入到文件
			fos = new FileOutputStream("aaa.txt");
			fos.write("我爱你亲爱的姑娘".getBytes());//直接覆盖，而不是追加。如果想追加怎么办？
			fis = new FileInputStream("aaa.txt");
			fis.read(temp);
			System.out.println(new String(temp));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(fis!=null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(fos!=null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		System.out.println("结束");
	}
}
