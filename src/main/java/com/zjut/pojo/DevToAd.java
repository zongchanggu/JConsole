package com.zjut.pojo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 
 * @author:zongchnaggu
 * @description:created by gu
 * @date:2016年12月16日 下午7:48:23
 */
public class DevToAd implements Serializable {

	private static final long serialVersionUID = -888001186043340664L;
	private int ID;
	private int DevID;
	private int AdID;
	private String AdName;
	private int AdType;
	private int AdStatus;
	private int DevType;
	private String DevStatus;
	private String DevName;
	private Date StartTime;
	private Date EndTime;
	private String RealPath;

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getDevID() {
		return DevID;
	}

	public void setDevID(int devID) {
		DevID = devID;
	}

	public int getAdID() {
		return AdID;
	}

	public void setAdID(int adID) {
		AdID = adID;
	}

	public String getAdName() {
		return AdName;
	}

	public void setAdName(String adName) {
		AdName = adName;
	}

	public int getAdType() {
		return AdType;
	}

	public void setAdType(int adType) {
		AdType = adType;
	}

	public int getAdStatus() {
		return AdStatus;
	}

	public void setAdStatus(int adStatus) {
		AdStatus = adStatus;
	}

	public int getDevType() {
		return DevType;
	}

	public void setDevType(int devType) {
		DevType = devType;
	}

	public String getDevStatus() {
		return DevStatus;
	}

	public void setDevStatus(String devStatus) {
		DevStatus = devStatus;
	}

	public String getDevName() {
		return DevName;
	}

	public void setDevName(String devName) {
		DevName = devName;
	}

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	public Date getStartTime() {
		return StartTime;
	}

	public void setStartTime(Date startTime) {
		StartTime = startTime;
	}

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	public Date getEndTime() {
		return EndTime;
	}

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	public void setEndTime(Date endTime) {
		EndTime = endTime;
	}

	public String getRealPath() {
		return RealPath;
	}

	public void setRealPath(String realPath) {
		RealPath = realPath;
	}

	@Override
	public String toString() {
		return AdID + "," + AdType + "," + transfer(EndTime) + "," + RealPath + "," + AdName;
	}

	public String transfer(Date endTime) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String str = sdf.format(endTime);
		return str;
	}
}
