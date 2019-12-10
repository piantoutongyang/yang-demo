package com.mingyisoft.shardingjdbcdemo.user.controller;

import com.mingyisoft.shardingjdbcdemo.user.entity.UserDO;
import com.mingyisoft.shardingjdbcdemo.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//import io.shardingsphere.core.keygen.DefaultKeyGenerator;

/**
 * Created by Administrator on 2017/8/16.
 */
@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
//	@ResponseBody
//	@PostMapping("/user/addAll")
//	public int addAll() {
//		for(int i = 0 ; i < 1000 ; i ++) {
//			  User user = new User();
////			  long a = new DefaultKeyGenerator().generateKey().longValue();
////			  System.out.println(a);
////			  System.out.println(a % 100);
////			  user.setUserId(a);
//			  user.setUserId((long)i);
//			  user.setUserName("abcdef");
////			  userService.addUser(user);
//		  }
//		return 1;
//	}

	@ResponseBody
	@GetMapping("/user/add")
	public int addUser() {
		UserDO user = new UserDO();
		user.setUserName("cccddd");
		userService.addUser(user);
		userService.addUser1(user);
//		userService.addUser2(user);
//		userService.addUser3(user);
//		userMapper.insert(user);
        
//		userService.addUser(user);
//		userService.insert(user);
//		System.out.println(user.getUserId());
		return 1;
	}

	@ResponseBody
	@GetMapping("/user/all")
	public Object findAllUser(@RequestParam(name = "pageNum", required = false, defaultValue = "1") int pageNum,
			@RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize) {
//		return userService.findAllUser(pageNum, pageSize);
		return null;
	}
	
	@ResponseBody
	@GetMapping("/user/all1")
	public Object findAllUser1(@RequestParam(name = "pageNum", required = false, defaultValue = "1") int pageNum,
			@RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize) {
//		return userService.findAllUser(pageNum, pageSize);
		return null;
	}
}