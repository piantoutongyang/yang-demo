package com.mingyisoft.javademo.nio;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

public class CharsetDemo1 {
	public static void main(String[] args) throws Exception {
		// 获取Charset对象
		// Charset cs = Charset.forName("ISO-8859-1");
		Charset csCn = Charset.forName("GBK");
		// 获取编码器与解码器
		CharsetEncoder csCnEncoder = csCn.newEncoder();
		CharsetDecoder csCnDecoder = csCn.newDecoder();
		CharBuffer cb = CharBuffer.allocate(8);
		cb.put('a');
		cb.put('b');
		cb.put('c');
		cb.flip();
		// 将CharBuffer转ByteBuffer
		ByteBuffer bb = csCnEncoder.encode(cb);
		for (int i = 0; i < bb.limit(); i++) {
			System.out.println(bb.get(i) + "");
		}
		// 将ByteBuffer转成CharBuffer
		System.out.println(csCnDecoder.decode(bb));
		System.out.println("------");
	}
}
