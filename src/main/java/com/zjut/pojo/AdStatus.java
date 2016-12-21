package com.zjut.pojo;

import java.io.Serializable;

public class AdStatus implements Serializable {
	private static final long serialVersionUID = 1L;
	private int adStatusID;
	private String comment;

	public int getAdStatusID() {
		return adStatusID;
	}

	public void setAdStatusID(int adStatusID) {
		this.adStatusID = adStatusID;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "AdStatus [adStatusID=" + adStatusID + ", comment=" + comment + "]";
	}
	
}
