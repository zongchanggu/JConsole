package com.zjut.pojo;

import java.util.Date;
/**
 * 
 * @author:zongchnaggu
 * @description:created by gu
 * @date:2016年12月13日 下午10:46:59
 */
public class Device {
	private int ID;
	private int DevID;
	private String DevName;
	private Date DeployTime;
	private int Type;
	private int AdID;
	private int Status;
	private int AdTotalNum;
	private int FaultNum;
	private Date CurrentTime;
	private String AddressXY;
	private String Location;
	private String Province;
	private String City;
	private String Street;

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

	public String getDevName() {
		return DevName;
	}

	public void setDevName(String devName) {
		DevName = devName;
	}

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

	public int getAdID() {
		return AdID;
	}

	public void setAdID(int adID) {
		AdID = adID;
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

}
