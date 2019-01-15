package com.swagger.doc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;

/**
 * Created by haoyifen on 16-9-28 2016 下午5:43
 */

import org.springframework.context.annotation.Configuration;

import io.swagger.annotations.ApiOperation;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Title: swagger核心配置类（就这一个）.<br>
 * Description: MySwaggerConfig<br>
 */
@Configuration
@EnableSwagger2
public class MySwaggerConfig {
	/**
	 * Title: 构建swagger.<br>
	 * Description: 这个方法起什么名字都可以，主要是注解起作用<br>
	 * 
	 * @category buildDocket
	 * @return
	 */
	@Bean
	public Docket buildDocket() { 
		String env = "dev";//判断当前环境是什么，通过缓存拿。
		Docket docket = null;
		if("dev".equals(env)){
			// 添加http请求头
			ParameterBuilder tokenPar = new ParameterBuilder();
			List<Parameter> pars = new ArrayList<Parameter>();
			tokenPar.name("token").description("令牌").modelRef(new ModelRef("string")).parameterType("header")
					.required(false).build();
			pars.add(tokenPar.build());

			docket = new Docket(DocumentationType.SWAGGER_2).apiInfo(buildApiInf())// 构建信息
					.select() // 选择那些路径和api会生成document
					.apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))//只扫描有注解的
					//.apis(RequestHandlerSelectors.any()) 扫描所有类
					//.apis(RequestHandlerSelectors.basePackage("example.web.controller"))//要扫描的API(Controller)基础包
					.paths(PathSelectors.any()) // 对所有路径进行监控
					.build().globalOperationParameters(pars);// 添加header
		}
		
		return docket;
		
	}

	private ApiInfo buildApiInf() {
		String description = "aaaa<br>bbbb<br>通用返回码都放在这里,可以使用便利枚举类的形式形成一个字符串放到这里";
		return new ApiInfoBuilder().title("xxxx项目的API文档").description(description)
				.contact(new Contact("wesley", "http://blog.csdn.net/piantoutongyang", "171757607@qq.com"))
				.version("2.0.0").build();
	}
}
