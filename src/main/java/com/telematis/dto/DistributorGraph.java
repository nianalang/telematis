package com.telematis.dto;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

/**
 * 分销商条形统计图的数据
 * 
 * @author depc
 *
 */

@SuppressWarnings("serial")
public class DistributorGraph implements Serializable {

	/*
	 * 统计车的时间
	 */
	@ApiModelProperty(value = "统计车的时间")
	private String countTime;

	/*
	 *  统计车的类型
	 */
	@ApiModelProperty(value = "统计车的类型")
	private String area;

	public String getCountTime() {
		return countTime;
	}

	public void setCountTime(String countTime) {
		this.countTime = countTime;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	@Override
	public String toString() {
		return "DistributorGraph [countTime=" + countTime + ", area=" + area + "]";
	}

}
