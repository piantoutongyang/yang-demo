package com.mingyisoft.javademo.io;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamDemo1 {
	public static void main(String[] args) {
		FileInputStream fis = null;
		try{
			fis = new FileInputStream("D:\\yangWorkSpaces\\yangDemoWorkSpace\\javademo\\src\\main\\java\\com\\mingyisoft\\javademo\\io\\FileInpuStreamDemo1.java");
			byte[] temp = new byte[1024];
			while(fis.read(temp)!=-1) {
				System.out.println(new String(temp));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(fis!=null) {
					fis.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
