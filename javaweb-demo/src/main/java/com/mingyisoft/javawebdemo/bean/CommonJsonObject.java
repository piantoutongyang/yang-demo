package com.mingyisoft.javawebdemo.bean;

import com.mingyisoft.javawebdemo.util.ReflectUtil;

/**
 * @category json返回对象
 * @author yangmh
 *
 */
public class CommonJsonObject<T> {
	//默认200为应答成功
	private int code = 200;
	private T data;
	private String msg;

	public CommonJsonObject() {
		
	}

	public CommonJsonObject(int code) {
		this.code = code;
	}
 
	public CommonJsonObject(int code,T data) {
		this.data = data;
		this.code = code;
	}
	
	public CommonJsonObject(int code,T data,String msg) {
		this.data = data;
		this.code = code;
		this.msg = msg;
	}
	
	public String toString(){
		return ReflectUtil.reflectToString(this);
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}