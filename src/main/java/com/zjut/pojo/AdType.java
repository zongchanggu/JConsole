package com.zjut.pojo;

import java.io.Serializable;

public class AdType implements Serializable {
	private static final long serialVersionUID = 1L;
	private int adTypeID;
	private String comment;

	public int getAdTypeID() {
		return adTypeID;
	}

	public void setAdTypeID(int adTypeID) {
		this.adTypeID = adTypeID;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "AdType [adTypeID=" + adTypeID + ", comment=" + comment + "]";
	}
	
}
