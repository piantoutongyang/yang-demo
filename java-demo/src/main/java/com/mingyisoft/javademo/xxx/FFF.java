package com.mingyisoft.javademo.xxx;

<<<<<<< HEAD
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

public class FFF {
	public static void main(String[] args) {
		try {
			String a = Base64.encode("".getBytes());
			System.out.println(a+"===");
			
			System.out.println(new String(Base64.decode(a)));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
=======
public class FFF {
	public static void main(String[] args) {
		System.out.println("aaaBBBCCC");
>>>>>>> 37082c39ab331f896d5f0e23a54da00e85ddb5b7
	}
}
