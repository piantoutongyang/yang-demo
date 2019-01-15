package com.mingyisoft.javademo.exceptiondemo;

/**
 * 自定义异常
 * 
 * @author yangmh
 *
 */
public class YangException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1998686844673228031L;
	private String reason;
	private int port;

	public YangException(String reason, int port) {
		this.reason = reason;
		this.port = port;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}
}
