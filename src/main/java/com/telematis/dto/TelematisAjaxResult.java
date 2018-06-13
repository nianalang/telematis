package com.telematis.dto;

/**
 * //所有的ajax请求的返回类型封装JSON结果
 */

import java.io.Serializable;

@SuppressWarnings("serial")
public class TelematisAjaxResult<T> implements Serializable {

	private boolean success;// 成功的标志

	private T list; // 数据
	
	private String error;// 错误的原因

	public TelematisAjaxResult(boolean success, String error) {
		super();
		this.success = success;
		this.error = error;
	}

	public TelematisAjaxResult(boolean success, T data) {
		this.success = success;
		this.list = data;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public T getData() {
		return list;
	}

	public void setData(T data) {
		this.list = data;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
}
