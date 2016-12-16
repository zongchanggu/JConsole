package com.zjut.pojo;

import java.util.Date;

/**
 * 
 * @author:zongchnaggu
 * @description:created by gu
 * @date:2016年12月13日 下午11:10:16
 */
public class Advertise {
	private int AdID;
	private int Type;
	private Date ResieterTime;
	private Date StartTime;
	private Date EndTime;
	private double Duration;
	private Date CurrentTime;
	private String UploadPath;
	private String RealPath;
	private String AdName;
	private int ViewNum;
	private int Status;

	public int getAdID() {
		return AdID;
	}

	public void setAdID(int adID) {
		AdID = adID;
	}

	public int getType() {
		return Type;
	}

	public void setType(int type) {
		Type = type;
	}

	public Date getResieterTime() {
		return ResieterTime;
	}

	public void setResieterTime(Date resieterTime) {
		ResieterTime = resieterTime;
	}

	public Date getStartTime() {
		return StartTime;
	}

	public void setStartTime(Date startTime) {
		StartTime = startTime;
	}

	public Date getEndTime() {
		return EndTime;
	}

	public void setEndTime(Date endTime) {
		EndTime = endTime;
	}

	public double getDuration() {
		return Duration;
	}

	public void setDuration(double duration) {
		Duration = duration;
	}

	public Date getCurrentTime() {
		return CurrentTime;
	}

	public void setCurrentTime(Date currentTime) {
		CurrentTime = currentTime;
	}

	public String getUploadPath() {
		return UploadPath;
	}

	public void setUploadPath(String uploadPath) {
		UploadPath = uploadPath;
	}

	public String getRealPath() {
		return RealPath;
	}

	public void setRealPath(String realPath) {
		RealPath = realPath;
	}

	public String getAdName() {
		return AdName;
	}

	public void setAdName(String adName) {
		AdName = adName;
	}

	public int getViewNum() {
		return ViewNum;
	}

	public void setViewNum(int viewNum) {
		ViewNum = viewNum;
	}

	public int getStatus() {
		return Status;
	}

	public void setStatus(int status) {
		Status = status;
	}

}
