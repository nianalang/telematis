package com.telematis.entity;

import java.io.Serializable;

/**
 * 筛选销售的地区
 * 
 * @author 念阿郎
 *
 */
public class SaleArea implements Serializable {
	/**
	 * 销售的车的类型
	 */
	private String data;

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 9067437563632724021L;

}
