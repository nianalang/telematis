package com.telematis.dto;

import java.io.Serializable;

/**
 * 返回的结果
 * @author 念阿郎
 *
 */
public class ResultData<T> implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5018310230762521176L;
	/**
	 * 返回的数据
	 */
	private String result;
	
	private T data;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}
