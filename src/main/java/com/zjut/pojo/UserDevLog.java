package com.zjut.pojo;

import java.util.Date;
/**
 * 
 * @author:zongchnaggu
 * @description:created by gu
 * @date:2016年12月13日 下午11:10:02
 */

public class UserDevLog {

	private int ID;
	private int UserID;
	private String UserName;
	private int DevID;
	private String DevName;
	private String Operation;
	private Date CurrentTime;

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getUserID() {
		return UserID;
	}

	public void setUserID(int userID) {
		UserID = userID;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
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

	public String getOperation() {
		return Operation;
	}

	public void setOperation(String operation) {
		Operation = operation;
	}

	public Date getCurrentTime() {
		return CurrentTime;
	}

	public void setCurrentTime(Date currentTime) {
		CurrentTime = currentTime;
	}

}
