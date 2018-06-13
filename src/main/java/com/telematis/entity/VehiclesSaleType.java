package com.telematis.entity;

import java.io.Serializable;

/**
 * 销售的车的类型
 * 
 * @author depc
 *
 */
@SuppressWarnings("serial")
public class VehiclesSaleType implements Serializable {

	/*
	 * 销售的车类型id
	 */
	private Integer vehicles_sale_type_id;
	/*
	 * 销售的车的类型
	 * 
	 */
	private String vehicles_sale_type;

	public Integer getVehicles_sale_type_id() {
		return vehicles_sale_type_id;
	}

	public void setVehicles_sale_type_id(Integer vehicles_sale_type_id) {
		this.vehicles_sale_type_id = vehicles_sale_type_id;
	}

	public String getVehicles_sale_type() {
		return vehicles_sale_type;
	}

	public void setVehicles_sale_type(String vehicles_sale_type) {
		this.vehicles_sale_type = vehicles_sale_type;
	}
}
