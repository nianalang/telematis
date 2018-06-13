package com.telematis.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * 用于向前台传分页数据用的类，包括total（总数）和rows（数据）
 * 
 * @author 念阿郎
 *
 */
public class Datagrid {

	private long total;
	private List rows = new ArrayList();

	public Datagrid() {
		super();
	}

	public Datagrid(long total, List rows) {
		super();
		this.total = total;
		this.rows = rows;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public List getRows() {
		return rows;
	}

	public void setRows(List rows) {
		this.rows = rows;
	}
}
