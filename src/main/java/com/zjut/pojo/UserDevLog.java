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
	private String OperationType;
	private Date CurrentTime;
	private String OperationName;

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

	public String getOperationType() {
		return OperationType;
	}

	public void setOperationType(String operationType) {
		OperationType = operationType;
	}

	public String getOperationName() {
		return OperationName;
	}

	public void setOperationName(String operationName) {
		OperationName = operationName;
	}

	public Date getCurrentTime() {
		return CurrentTime;
	}

	public void setCurrentTime(Date currentTime) {
		CurrentTime = currentTime;
	}

}
