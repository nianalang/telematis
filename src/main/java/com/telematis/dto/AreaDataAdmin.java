package com.telematis.dto;

import java.io.Serializable;

public class AreaDataAdmin implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7983503896761230712L;

	/**
	 * 东风日产的销售数据
	 */
	private int dongFengNumber;
	
	/**
	 * 北京现代的销售数据
	 */
	private int beiJingNumber;
	
	/**
	 * 一汽大众的销售数据
	 */
	private int yiQiNumber;

	public int getDongFengNumber() {
		return dongFengNumber;
	}

	public void setDongFengNumber(int dongFengNumber) {
		this.dongFengNumber = dongFengNumber;
	}

	public int getBeiJingNumber() {
		return beiJingNumber;
	}

	public void setBeiJingNumber(int beiJingNumber) {
		this.beiJingNumber = beiJingNumber;
	}

	public int getYiQiNumber() {
		return yiQiNumber;
	}

	public void setYiQiNumber(int yiQiNumber) {
		this.yiQiNumber = yiQiNumber;
	}
}
