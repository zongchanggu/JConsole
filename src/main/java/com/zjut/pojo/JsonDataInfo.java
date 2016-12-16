package com.zjut.pojo;

import java.util.List;

public class JsonDataInfo {
	
	private int total = 0;
	
	private List<Object> rows = null;

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<Object> getRows() {
		return rows;
	}

	public void setRows(List<Object> rows) {
		this.rows = rows;
	}

}
