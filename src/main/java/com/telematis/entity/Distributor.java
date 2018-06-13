package com.telematis.entity;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

/**
 * 分销商表
 * 
 * @author depc
 *
 */
@SuppressWarnings("serial")
public class Distributor implements Serializable {
	/*
	 * 分销商id
	 */
	@ApiModelProperty(value = "分销商id")
	private Integer dist_id;
	/*
	 * 分销商用户名
	 */
	@ApiModelProperty(value = "分销商用户名")
	private String dist_phone;
	/*
	 * 分销商密码
	 */
	@ApiModelProperty(value = "分销商密码")
	private String dist_password;
	/*
	 * 分销商所处公司
	 */
	@ApiModelProperty(value = "分销商所处公司")
	private String dist_company;

	/*
	 * 分销商所处地区
	 */
	@ApiModelProperty(value = "分销商所处地区")
	private String dist_area;

	public Integer getDist_id() {
		return dist_id;
	}

	public void setDist_id(Integer dist_id) {
		this.dist_id = dist_id;
	}

	public String getDist_phone() {
		return dist_phone;
	}

	public void setDist_phone(String dist_phone) {
		this.dist_phone = dist_phone;
	}

	@Override
	public String toString() {
		return "Distributor [dist_id=" + dist_id + ", dist_phone=" + dist_phone + ", dist_password=" + dist_password
				+ ", dist_company=" + dist_company + ", dist_area=" + dist_area + "]";
	}

	public String getDist_password() {
		return dist_password;
	}

	public void setDist_password(String dist_password) {
		this.dist_password = dist_password;
	}

	public String getDist_company() {
		return dist_company;
	}

	public void setDist_company(String dist_company) {
		this.dist_company = dist_company;
	}

	public String getDist_area() {
		return dist_area;
	}

	public void setDist_area(String dist_area) {
		this.dist_area = dist_area;
	}

}
