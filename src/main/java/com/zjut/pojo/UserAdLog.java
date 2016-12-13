package com.zjut.pojo;

import java.util.Date;

public class UserAdLog {

	private int ID;
	private int UserID;
	private String UserName;
	private int AdID;
	private String AdName;
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
