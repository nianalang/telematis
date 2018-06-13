package com.telematis.dto;

import java.io.Serializable;

/**
 * 封装Distributor的数据
 * 
 * @author depc 郎媛勤
 *
 */

@SuppressWarnings("serial")
public class DataDistributor implements Serializable {

	/*
	 * 销售的车的总数量
	 */
	private int all_vehicles_sale_number;

	public int getAll_vehicles_sale_number() {
		return all_vehicles_sale_number;
	}

	public void setAll_vehicles_sale_number(int all_vehicles_sale_number) {
		this.all_vehicles_sale_number = all_vehicles_sale_number;
	}
}
