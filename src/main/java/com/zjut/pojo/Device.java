package com.zjut.pojo;

import java.io.Serializable;
import java.util.Date;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 
 * @author:zongchnaggu
 * @description:created by gu
 * @date:2016年12月13日 下午10:46:59
 */
public class Device implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6853541868918717139L;
	private int DevID;
	private String DevName;
	private int Type;
	private Date DeployTime;
	private int Status;
	private String Province;
	private String City;
	private String District;
	private String Street;
	private String Location;
	private String AddressXY;
	private int AdTotalNum;
	private int FaultNum;
	private Date CurrentTime;

	public int getDevID() {
		return DevID;
	}

	public void setDevID(int devID) {
		DevID = devID;
	}

	public String getDevName() {
		return DevName;
	}

	public void setDevName(String devName) {
		DevName = devName;
	}

	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")  
	public Date getDeployTime() {
		return DeployTime;
	}
	public void setDeployTime(Date deployTime) {
		DeployTime = deployTime;
	}

	public int getType() {
		return Type;
	}

	public void setType(int type) {
		Type = type;
	}

	public int getStatus() {
		return Status;
	}

	public void setStatus(int status) {
		Status = status;
	}

	public int getAdTotalNum() {
		return AdTotalNum;
	}

	public void setAdTotalNum(int adTotalNum) {
		AdTotalNum = adTotalNum;
	}

	public int getFaultNum() {
		return FaultNum;
	}

	public void setFaultNum(int faultNum) {
		FaultNum = faultNum;
	}
	public Date getCurrentTime() {
		return CurrentTime;
	}
	public void setCurrentTime(Date currentTime) {
		CurrentTime = currentTime;
	}

	public String getAddressXY() {
		return AddressXY;
	}

	public void setAddressXY(String addressXY) {
		AddressXY = addressXY;
	}

	public String getLocation() {
		return Location;
	}

	public void setLocation(String location) {
		Location = location;
	}

	public String getProvince() {
		return Province;
	}

	public void setProvince(String province) {
		Province = province;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public String getStreet() {
		return Street;
	}

	public void setStreet(String street) {
		Street = street;
	}

	public String getDistrict() {
		return District;
	}

	public void setDistrict(String district) {
		District = district;
	}

}
