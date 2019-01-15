package com.mingyisoft.javademo.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.nio.charset.Charset;
/**
 * 使用NIO复制文件
 * @author lenovo
 *
 */
public class ChannelDemo1 {
	public static void main(String[] args) throws Exception {
		File f = new File("abcdefg.txt");

		try (FileChannel inChannel = new FileInputStream(f).getChannel();
				FileChannel outChannel = new FileOutputStream("aaa.txt").getChannel();
				FileChannel randomChannel = new RandomAccessFile(f,"rw").getChannel()) {
			/**
			 * 通过FileInputStream获取到的FileChannel只能读
			 * 通过FileOutputStream获取的FileChannel只能写
			 * 通过RandomAccessFile获取的FileChannel既可读又可写
			 */
			MappedByteBuffer buffer = inChannel.map(MapMode.READ_ONLY, 0, f.length());
			outChannel.write(buffer);
			buffer.clear();
			//ByteBuffer转CharBuffer
			CharBuffer cb = Charset.forName("GBK").newDecoder().decode(buffer);
			System.out.println(cb);
			//使用random来追加文件
			MappedByteBuffer randomBuffer = randomChannel.map(MapMode.READ_ONLY, 0, f.length());
			randomChannel.position(f.length());
			randomChannel.write(randomBuffer);
			//如果文件过大，可以采用以前的重复取水的方式
			System.out.println("重复取水");
			ByteBuffer buf = ByteBuffer.allocate(48);
			while (inChannel.read(buf) != -1) {
				//锁定Buffer的空白区域，为读数据做准备
				buf.flip();
				while (buf.hasRemaining()) {
					System.out.print((char) buf.get());
				}
				//将Buffer初始化，为下一次读数据做准备
				buf.clear();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
