package com.mingyisoft.javademo.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ScatterGatherDemo1 {
	public static void main(String[] args) throws Exception {
		FileChannel inChannel = new FileInputStream("abcdefg.txt").getChannel();
		FileChannel outChannel = new FileOutputStream("abcdefg.txt").getChannel();
		ByteBuffer header = ByteBuffer.allocate(2);
		ByteBuffer body   = ByteBuffer.allocate(2);

		/**
		 * read()方法内部会负责把数据按顺序写进传入的buffer数组内。一个buffer写满后，接着写到下一个buffer中。
		 * 实际上，scattering read内部必须写满一个buffer后才会向后移动到下一个buffer，因此这并不适合消息大小会动态改变的部分，
		 * header如果有一个固定的大小（比如128字节）,这种情形下可以正常工作。
		 */
		ByteBuffer[] bufferArray = { header, body };
		inChannel.read(bufferArray);
		
		header.flip();
		body.flip();
		
		while(header.hasRemaining()) {
			System.out.println(header.get());
		}
		
		while(body.hasRemaining()) {
			System.out.println(body.get());
		}
		
		header.clear();
		body.clear();
		/**
		 * 写入的时候针对的是buffer中position到limit之间的数据。也就是如果buffer的容量是128字节，但它只包含了58字节数据，
		 * 那么写入的时候只有58字节会真正写入。
		 * 因此gathering write是可以适用于可变大小的message的，这和scattering reads不同。
		 */
		outChannel.write(bufferArray);
	}
}
