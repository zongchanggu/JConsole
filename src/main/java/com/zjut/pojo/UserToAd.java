package com.zjut.pojo;

import java.util.List;
/**
 * 
 * @author:zongchnaggu
 * @description:created by gu
 * @date:2016年12月22日 下午7:28:26
 */
public class UserToAd {

	private int userID;
	private String userName;
	private List<Advertise> ads;
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public List<Advertise> getAds() {
		return ads;
	}
	public void setAds(List<Advertise> ads) {
		this.ads = ads;
	}
	
	

}
