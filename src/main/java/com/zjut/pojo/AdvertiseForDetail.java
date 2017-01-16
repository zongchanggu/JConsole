package com.zjut.pojo;

import java.io.Serializable;

/**
 * 
 * @author chen-zhiqiang
 *
 * @version 创建时间：2017年1月8日下午8:03:13
 */
public class AdvertiseForDetail extends Advertise implements Serializable{
	private static final long serialVersionUID = 1L;
	private String description;
	private String comment;
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	@Override
	public String toString() {
		return "AdvertiseForDetail [description=" + description + ", comment=" + comment + ", getAdID()=" + getAdID()
				+ ", getType()=" + getType() + ", getResieterTime()=" + getResieterTime() + ", getStartTime()="
				+ getStartTime() + ", getEndTime()=" + getEndTime() + ", getDuration()=" + getDuration()
				+ ", getCurrentTime()=" + getCurrentTime() + ", getUploadPath()=" + getUploadPath() + ", getRealPath()="
				+ getRealPath() + ", getAdName()=" + getAdName() + ", getViewNum()=" + getViewNum() + ", getStatus()="
				+ getStatus() + ", toString()=" + super.toString() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + "]";
	}
	
}
