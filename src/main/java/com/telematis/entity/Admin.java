package com.telematis.entity;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

/**
 * 管理员表
 * 
 * @author depc
 *
 */
 //@SuppressWarnings("serial")
public class Admin implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * 管理员id
	 */
	@ApiModelProperty(value = "管理员id")
	private Integer admin_id;

	/*
	 * 管理员用户名
	 */
	@ApiModelProperty(value = "管理员用户名")
	private String admin_phone;

	/*
	 * 管理员密码
	 */
	@ApiModelProperty(value = "管理员密码")
	private String admin_password;
	/*
	 * 管理员邮箱
	 */
	@ApiModelProperty(value = "管理员邮箱")
	private String admin_email;

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

	public String getAdmin_email() {
		return admin_email;
	}

	public void setAdmin_email(String admin_email) {
		this.admin_email = admin_email;
	}

	public Integer getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(Integer admin_id) {
		this.admin_id = admin_id;
	}

	@Override
	public String toString() {
		return "Admin [admin_id=" + admin_id + ", admin_phone=" + admin_phone + ", admin_password=" + admin_password
				+ ", admin_email=" + admin_email + "]";
	}

}