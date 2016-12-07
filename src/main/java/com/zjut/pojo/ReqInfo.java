package com.zjut.pojo;

import java.io.Serializable;

/**
 * 
 * <p>@author:zongchnaggu</p>
 * <p>@description:created by gu</p>
 * <p>@date:2016年12月7日</p>
 *
 */
public class ReqInfo implements Serializable {

	private static final long serialVersionUID = 5091049051824417814L;
	public short head;
	public int dev_id;
	public char status;
	public char type;
	public short end;

	public ReqInfo() {

	}

	public short getHead() {
		return head;
	}

	public void setHead(short head) {
		this.head = head;
	}

	public int getDev_id() {
		return dev_id;
	}

	public void setDev_id(int dev_id) {
		this.dev_id = dev_id;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	public char getType() {
		return type;
	}

	public void setType(char type) {
		this.type = type;
	}

	public short getEnd() {
		return end;
	}

	public void setEnd(short end) {
		this.end = end;
	}

	@Override
	public String toString() {
		return "[head:" + head + "	Dev_id:" + dev_id + "	Status:" + status + "	type:" + type+"]";
	}

}
