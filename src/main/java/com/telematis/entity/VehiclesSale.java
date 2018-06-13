package com.telematis.entity;

import java.io.Serializable;

import org.springframework.format.annotation.DateTimeFormat;

import io.swagger.annotations.ApiModelProperty;

/**
 * 车辆销售表
 * 
 * @author depc
 *
 */
@SuppressWarnings("serial")
public class VehiclesSale implements Serializable {
	/*
	 * 销售id
	 */
	@ApiModelProperty(value = "销售id")
	private Integer vehicles_sale_id;
	/*
	 * 分销商号码
	 */
	@ApiModelProperty(value = "分销商号码")
	private String dist_phone;

	/*
	 * 分销商所处的公司
	 */
	private String dist_company;
	
	/*
	 * 分销商所处的地区
	 */
	private String dist_area;
	
	/*
	 * 车主号码
	 */
	@ApiModelProperty(value = "车主号码")
	private String user_phone;
	/*
	 * 销售的车的类型
	 */
	@ApiModelProperty(value = "销售的车的类型")
	private String vehicles_sale_type;
	/*
	 * 销售的车的价格
	 */
	@ApiModelProperty(value = "销售的车的价格")
	private Integer vehicles_sale_price;
	/*
	 * 销售的车的数量
	 */
	@ApiModelProperty(value = "销售的车的数量")
	private int vehicles_sale_number;
	/*
	 * 销售的车的时间
	 */
	@ApiModelProperty(value = "销售的车的时间")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private String vehicles_sale_time;
	/*
	 * 销售的车的地区
	 */
	@ApiModelProperty(value = "销售的车的地区")
	private String vehicles_sale_area;

	public Integer getVehicles_sale_id() {
		return vehicles_sale_id;
	}

	public void setVehicles_sale_id(Integer vehicles_sale_id) {
		this.vehicles_sale_id = vehicles_sale_id;
	}

	public String getVehicles_sale_type() {
		return vehicles_sale_type;
	}

	public void setVehicles_sale_type(String vehicles_sale_type) {
		this.vehicles_sale_type = vehicles_sale_type;
	}

	public Integer getVehicles_sale_price() {
		return vehicles_sale_price;
	}

	public void setVehicles_sale_price(Integer vehicles_sale_price) {
		this.vehicles_sale_price = vehicles_sale_price;
	}

	public int getVehicles_sale_number() {
		return vehicles_sale_number;
	}

	public void setVehicles_sale_number(int vehicles_sale_number) {
		this.vehicles_sale_number = vehicles_sale_number;
	}

	public String getVehicles_sale_time() {
		return vehicles_sale_time;
	}

	public void setVehicles_sale_time(String vehicles_sale_time) {
		this.vehicles_sale_time = vehicles_sale_time;
	}

	public String getVehicles_sale_area() {
		return vehicles_sale_area;
	}

	public void setVehicles_sale_area(String vehicles_sale_area) {
		this.vehicles_sale_area = vehicles_sale_area;
	}

	public String getDist_phone() {
		return dist_phone;
	}

	public void setDist_phone(String dist_phone) {
		this.dist_phone = dist_phone;
	}

	public String getUser_phone() {
		return user_phone;
	}

	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
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
