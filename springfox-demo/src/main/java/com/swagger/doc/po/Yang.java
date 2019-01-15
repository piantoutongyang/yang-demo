package com.swagger.doc.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="Yang(杨模型)")
public class Yang {
	@ApiModelProperty(value="杨ID",required=true,example="12345")
    private String yangId;
	@ApiModelProperty(value="杨用户名",required=true,example="abcde")
    private String yangName;
	@ApiModelProperty(value="杨年龄",required=false,example="16")
    private Integer yangAge;
	
	public String getYangId() {
		return yangId;
	}
	public void setYangId(String yangId) {
		this.yangId = yangId;
	}
	public String getYangName() {
		return yangName;
	}
	public void setYangName(String yangName) {
		this.yangName = yangName;
	}
	public Integer getYangAge() {
		return yangAge;
	}
	public void setYangAge(Integer yangAge) {
		this.yangAge = yangAge;
	}
}
