package com.swagger.doc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.swagger.doc.po.CommonJsonObject;
import com.swagger.doc.po.Yang;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
/**
 * 通过http://localhost:8899/swagger-ui.html访问
 * @author lenovo
 *
 */
@Api(description = "controller的中文解释")
@Controller
public class YangController {

	@ResponseBody
	@ApiOperation(value = "接口名称-增111", notes = "接口描述-增,作者:alex")
	@RequestMapping(value = "/yang", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public CommonJsonObject<Object> insertYang(@ApiParam(value = "yang参数", required = true) @RequestBody Yang yang) {
		System.out.println("正在创建111");
		System.out.println(yang.getYangAge());
		System.out.println(yang.getYangId());
		System.out.println(yang.getYangName());

		return new CommonJsonObject<Object>();
	}

	@ApiOperation(value = "接口名称-删", notes = "接口描述-删,作者:alex")
	@ResponseBody
	@RequestMapping(value = "/yang", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public CommonJsonObject<Object> deleteYang(
			@ApiParam(name = "yangId", required = true, value = "杨Id") String yangId) {
		System.out.println("正在删除");
		System.out.println(yangId);

		return new CommonJsonObject<Object>();
	}

	@ApiOperation(value = "接口名称-改", notes = "接口描述-改,作者:alex")
	@ResponseBody
	@RequestMapping(value = "/yang", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public CommonJsonObject<Object> updateYang(@ApiParam(value = "yang参数", required = true) @RequestBody Yang yang) {
		System.out.println("正在修改");
		System.out.println(yang.getYangAge());
		System.out.println(yang.getYangId());
		System.out.println(yang.getYangName());
		return new CommonJsonObject<Object>();
	}
	
	@ResponseBody
	@ApiOperation(value = "接口名称-查单个", notes = "接口描述-查单个,作者:alex")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "yangId", value = "杨Id", required = true, dataType = "String",paramType = "path"),
		@ApiImplicitParam(name = "demoId", value = "做测试用的没有意义,多参数", required = false, dataType = "String",paramType = "query")
	})
	@RequestMapping(value = "/yang/{yangId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public CommonJsonObject<Yang> findYangById(@PathVariable String yangId,String demoId) {
		System.out.println("正在查询");
		System.out.println(yangId);
		
		Yang yang = new Yang();
		yang.setYangAge(123);
		yang.setYangId(yangId);
		yang.setYangName("hahaha");
		
		CommonJsonObject<Yang> json = new CommonJsonObject<Yang>();
		json.setData(yang);

		return json;
	}
	
	
	@ResponseBody
	@ApiOperation(value = "接口名称-查列表", notes = "接口描述-查列表,作者:alex")
	@RequestMapping(value = "/yangs", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public CommonJsonObject<List<Yang>> findYangList() {
		System.out.println("正在查询xxxxxxxx");
		
		Yang yang1 = new Yang();
		yang1.setYangAge(123);
		yang1.setYangId("123");
		yang1.setYangName("hahaha");
		
		Yang yang2 = new Yang();
		yang2.setYangAge(123);
		yang2.setYangId("123");
		yang2.setYangName("hahaha");
		
		List<Yang> yangList = new ArrayList<Yang>();
		yangList.add(yang1);
		yangList.add(yang2);
		
		CommonJsonObject<List<Yang>> json = new CommonJsonObject<List<Yang>>();
		json.setData(yangList);

		return json;
	}
	
	@ResponseBody
	@RequestMapping(value = "/noshow", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public CommonJsonObject<List<Yang>> noshow() {
		/**
		 * 没有没有写@ApiOperation标签则在swagger-ui中显示
		 */
		System.out.println("正在查询");
		
		Yang yang1 = new Yang();
		yang1.setYangAge(123);
		yang1.setYangId("123");
		yang1.setYangName("hahaha");
		
		Yang yang2 = new Yang();
		yang2.setYangAge(123);
		yang2.setYangId("123");
		yang2.setYangName("hahaha");
		
		List<Yang> yangList = new ArrayList<Yang>();
		yangList.add(yang1);
		yangList.add(yang2);
		
		CommonJsonObject<List<Yang>> json = new CommonJsonObject<List<Yang>>();
		json.setData(yangList);

		return json;
	}
}
