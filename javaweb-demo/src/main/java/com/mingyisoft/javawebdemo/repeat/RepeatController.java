package com.mingyisoft.javawebdemo.repeat;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mingyisoft.javawebdemo.bean.CommonJsonObject;
@Controller
public class RepeatController {
	@RepeatToken(save=true)
	@ResponseBody
	@RequestMapping(value = "/getRepeatToken", method = RequestMethod.GET)  
	public CommonJsonObject getRepeatToken() {
		System.out.println("啦啦啦111");
		return new CommonJsonObject<String>();
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.GET)
	@ResponseBody
    @RepeatToken(remove=true)  
    public CommonJsonObject<String> save(String id) {
		System.out.println("提交进来了啦");
		CommonJsonObject<String> json = new CommonJsonObject<String>();
		json.setMsg(id);
		return json;
	}
}
