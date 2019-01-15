package com.mingyisoft.javademo.io;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileDemo1 {
	public static void main(String[] args) {
		RandomAccessFile raf = null;
		try {
			raf = new RandomAccessFile("aaa.txt","rw");
			//获取指针位置，初始位置为0
			System.out.println(raf.getFilePointer());
			raf.write("江山如此多娇，引无数英雄尽折腰。".getBytes());
			//移动指针位置
			raf.seek(6);
			System.out.println(raf.getFilePointer());
			//追加内容
			raf.seek(raf.length());
			raf.write("昔秦皇汉武略输文采，唐宗宋祖稍逊风骚。".getBytes());
			//从头到尾读
			raf.seek(0);
			byte[] temp = new byte[1024];
			while(raf.read(temp)>0) {
				System.out.println(new String(temp));
			}
			System.out.println("结束");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				raf.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}
