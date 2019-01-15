package com.swagger.doc.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="CommonJsonObject(通用返回模型)")
public class CommonJsonObject<T> {
	// 默认200为应答成功
	@ApiModelProperty(value="返回码",required=true,example="200")
	private int code = 200;
	@ApiModelProperty(value="返回数据",required=true)
	private T data;
	@ApiModelProperty(value="返回描述",required=true)
	private String msg;
	
	public CommonJsonObject(){
		
	}

	public CommonJsonObject(int code) {
		this.code = code;
	}

	public CommonJsonObject(int code, T data) {
		this.data = data;
		this.code = code;
	}

	public CommonJsonObject(int code, T data, String msg) {
		this.data = data;
		this.code = code;
		this.msg = msg;
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
