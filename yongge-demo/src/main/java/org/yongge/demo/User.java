package org.yongge.demo;

public class User {
  private Long userId;
  private String userName;
  
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
  
	public String toString() {
		return userId + "   " + userName;
	}
  
}
