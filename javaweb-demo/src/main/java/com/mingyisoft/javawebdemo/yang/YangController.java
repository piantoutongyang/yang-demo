package com.mingyisoft.javawebdemo.yang;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mingyisoft.javawebdemo.bean.CommonJsonObject;

@Controller
public class YangController {
	@ResponseBody
	@Async
	@RequestMapping(value = "/queryUserById", method = RequestMethod.GET, produces = "application/json")
	public CommonJsonObject<String> queryUserById(Integer userId) throws Exception {
		System.out.println(Thread.currentThread() + " " + 1);
		CommonJsonObject<String> json = new CommonJsonObject<>();
		System.out.println(Thread.currentThread() + " " + 2);
		Thread.sleep(3 * 1000);
		json.setData("我阿哈哈哈");
		System.out.println(Thread.currentThread() + " " + 3);
		return json;
	}
}