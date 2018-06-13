package com.telematis.entity;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

/**
 * 分销商的简化数据
 * 
 * @author depc
 *
 */
@SuppressWarnings("serial")
public class SimplifyDistributor implements Serializable {

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
	 * 确认密码
	 */
	@ApiModelProperty(value = "分销商确认密码")
	private String confirm_password;

	public String getConfirm_password() {
		return confirm_password;
	}

	public void setConfirm_password(String confirm_password) {
		this.confirm_password = confirm_password;
	}

	public String getDist_phone() {
		return dist_phone;
	}

	public void setDist_phone(String dist_phone) {
		this.dist_phone = dist_phone;
	}

	public String getDist_password() {
		return dist_password;
	}

	public void setDist_password(String dist_password) {
		this.dist_password = dist_password;
	}

	@Override
	public String toString() {
		return "SimplifyDistributor [dist_phone=" + dist_phone + ", dist_password=" + dist_password + "]";
	}

}
