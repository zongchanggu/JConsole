package com.zjut.pojo;

import java.util.Date;

/**
 * 
 * <p>
 * @author:zongchnaggu
 * </p>
 * <p>
 * @description:created by gu
 * </p>
 * <p>
 * @date:2016年12月11日
 * </p>
 *
 */
public class User {

	private int ID;
	private int UserID;
	private String Phone;
	private String UserName;
	private String PassWord;
	private int Type;
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

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getPassWord() {
		return PassWord;
	}

	public void setPassWord(String passWord) {
		PassWord = passWord;
	}

	public int getType() {
		return Type;
	}

	public void setType(int type) {
		Type = type;
	}

	public Date getCurrentTime() {
		return CurrentTime;
	}

	public void setCurrentTime(Date currentTime) {
		CurrentTime = currentTime;
	}

}
