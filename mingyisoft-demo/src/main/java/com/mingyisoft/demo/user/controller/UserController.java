package com.mingyisoft.demo.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mingyisoft.demo.user.dao.UserMapper;
import com.mingyisoft.demo.user.model.User;
import com.mingyisoft.demo.user.service.UserService;

//import io.shardingsphere.core.keygen.DefaultKeyGenerator;

/**
 * Created by Administrator on 2017/8/16.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {
//	@Autowired
//	private UserMapper userMapper;

	@Autowired
	private UserService userService;
	
	@ResponseBody
	@PostMapping("/addAll")
	public int addAll() {
		for(int i = 0 ; i < 1000 ; i ++) { 
			  User user = new User();
//			  long a = new DefaultKeyGenerator().generateKey().longValue();
//			  System.out.println(a); 
//			  System.out.println(a % 100); 
//			  user.setUserId(a); 
			  user.setUserId((long)i); 
			  user.setUserName("abcdef");
//			  userService.addUser(user);
		  }
		return 1;
	}

	@ResponseBody
	@GetMapping("/add")
	public int addUser() {
		User user = new User();
		user.setUserName("cccddd");
		userService.addUser(user);
		userService.addUser1(user);
		userService.addUser2(user);
		userService.addUser3(user);
//		userMapper.insert(user);
        
//		userService.addUser(user);
//		userService.insert(user);
//		System.out.println(user.getUserId());
		return 1;
	}

	@ResponseBody
	@GetMapping("/all")
	public Object findAllUser(@RequestParam(name = "pageNum", required = false, defaultValue = "1") int pageNum,
			@RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize) {
//		return userService.findAllUser(pageNum, pageSize);
		return null;
	}
	
	@ResponseBody
	@GetMapping("/all1")
	public Object findAllUser1(@RequestParam(name = "pageNum", required = false, defaultValue = "1") int pageNum,
			@RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize) {
//		return userService.findAllUser(pageNum, pageSize);
		return null;
	}
}