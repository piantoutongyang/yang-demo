package com.mingyisoft.javademo.nio;

import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class FileLockDemo1 {
	public static void main(String[] args) throws Exception {
		FileChannel fileChannel;
		try {
			fileChannel = new FileOutputStream("xxx.txt").getChannel();
			//创建文件锁对象，如果目标文件已被锁定则返回null
			FileLock lock = fileChannel.tryLock();
			
			//创建文件锁对象，如果目标文件已被锁定则一直阻塞
			// FileLock lock2 = fileChannel2.lock();
			//只对部分文件内容加锁，shared=true表示共享锁，shared=false表示排它锁，没有参数则默认是排它锁
			// FileLock lock = fileChannel.tryLock(0, 15, true);
			
			Thread.sleep(60 * 1000);
			// 释放锁
			lock.release();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
