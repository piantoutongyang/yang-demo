package com.mingyisoft.shardingjdbcdemo.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("t_user")
//@Data
public class UserDO {
	@TableId(value = "user_id", type = IdType.AUTO)
	private Long userId;
	
//	@TableField("user_name")
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
