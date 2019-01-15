package com.mingyisoft.javademo.network;

import java.net.URLDecoder;
import java.net.URLEncoder;

public class URLDecoderDemo1 {
	public static void main(String[] args) {
		String word = URLDecoder.decode("%E6%88%91%E7%9A%84%E5%89%8D%E5%8D%8A%E7%94%9F");
		System.out.println(word);
		String luan = URLEncoder.encode(word);
		System.out.println(luan);
	}
}
