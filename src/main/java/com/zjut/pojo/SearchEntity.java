package com.zjut.pojo;

import java.util.*;

/**
 * 
 * @author:zongchnaggu
 * @description:created by gu
 * @date:2016年12月18日 下午3:21:36
 */
public class SearchEntity {
	private Date startTime;
	private Date endTime;
	private String status;
	private String DevName;

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDevName() {
		return DevName;
	}

	public void setDevName(String devName) {
		DevName = devName;
	}

}
