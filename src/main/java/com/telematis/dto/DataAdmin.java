package com.telematis.dto;

import java.io.Serializable;

/**
 * 封装admin返回的数据
 * 
 * @author depc
 *
 */
@SuppressWarnings("serial")
public class DataAdmin implements Serializable {

	/**
	 * 北京现代的销售数据
	 */
	private int beijingHyundai;

	/**
	 * 东风日产的销售数据
	 */
	private int dongfengNissan;

	/**
	 * 一汽大众的销售数据
	 */
	private int fAWVolkswagen;

	public int getBeijingHyundai() {
		return beijingHyundai;
	}

	public void setBeijingHyundai(int beijingHyundai) {
		this.beijingHyundai = beijingHyundai;
	}

	public int getDongfengNissan() {
		return dongfengNissan;
	}

	public void setDongfengNissan(int dongfengNissan) {
		this.dongfengNissan = dongfengNissan;
	}

	public int getfAWVolkswagen() {
		return fAWVolkswagen;
	}

	public void setfAWVolkswagen(int fAWVolkswagen) {
		this.fAWVolkswagen = fAWVolkswagen;
	}
}
