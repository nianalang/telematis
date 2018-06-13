package com.telematis.entity;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

/**
 * 简化版的用户名和密码
 * 
 * @author depc
 *
 */

@SuppressWarnings("serial")
public class SimplifyAdmin implements Serializable {

	/*
	 * 管理员用户名
	 */
	@ApiModelProperty(value="用户名")
	private String admin_phone;

	/*
	 * 管理员密码
	 */
	@ApiModelProperty(value="密码")
	private String admin_password;

	public String getAdmin_phone() {
		return admin_phone;
	}

	public void setAdmin_phone(String admin_phone) {
		this.admin_phone = admin_phone;
	}

	public String getAdmin_password() {
		return admin_password;
	}

	public void setAdmin_password(String admin_password) {
		this.admin_password = admin_password;
	}

	@Override
	public String toString() {
		return "SimplifyAdmin [admin_phone=" + admin_phone + ", admin_password=" + admin_password + "]";
	}
}
