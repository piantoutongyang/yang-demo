package com.mingyisoft.javademo.network;

import java.net.InetAddress;

public class InetAddressDemo1 {
	public static void main(String[] args) throws Exception {
		//通过域名获取InetAddress对象
		InetAddress ip = InetAddress.getByName("www.baidu.com");
		//是否可达？
		System.out.println(ip.isReachable(5000));
		//获取ip地址
		System.out.println(ip.getHostAddress());
		//获取本机InetAddress对象
		InetAddress local = InetAddress.getLocalHost();
//		InetAddress local = InetAddress.getByAddress(new byte[] {127,0,0,1});
		//获取本机ip
		System.out.println(local.getHostAddress());
		//获取本机名称
		System.out.println(local.getHostName());
	}
}
