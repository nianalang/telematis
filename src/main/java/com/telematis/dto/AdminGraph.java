package com.telematis.dto;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

/**
 * 管理员条形统计图的数据
 * 
 * @author depc
 *
 */
@SuppressWarnings("serial")
public class AdminGraph implements Serializable {
	/*
	 * 统计的车的区域
	 */
	@ApiModelProperty(value = "销售的区域")
	private String area;

	/*
	 * 统计车的时间
	 */
	@ApiModelProperty(value = "统计的频率")
	private String countTime;

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCountTime() {
		return countTime;
	}

	public void setCountTime(String countTime) {
		this.countTime = countTime;
	}
}
