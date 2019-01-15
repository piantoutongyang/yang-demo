package com.mingyisoft.javademo.network;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class URLConnectionDemo1 {
	public static void main(String[] args) throws Exception {
		String urlStr = "https://www.baidu.com/img/bd_logo1.png?a=a&b=b";
		URL url = new URL(urlStr);
		//资源名/img/bd_logo1.png
		System.out.println(url.getFile());
		//主机名&域名www.baidu.com
		System.out.println(url.getHost());
		//路径/img/bd_logo1.png
		System.out.println(url.getPath());
		//端口号-1
		System.out.println(url.getPort());
		//协议https
		System.out.println(url.getProtocol());
		//参数
		System.out.println(url.getQuery());
		//打开连接并返回流对象
		InputStream in = url.openStream();
		byte[] b = new byte[1024] ;
		
		if(in.read(b)!=-1) {
			System.out.println(new String(b,"UTF-8"));
		}
		//创建远程连接对象
		URLConnection conn = url.openConnection();
	}
}
