package com.zjut.pojo;

import java.io.Serializable;

public class UserType implements Serializable {

	private static final long serialVersionUID = 1L;

	private int TypeID;
	private String Comment;

	public int getTypeID() {
		return TypeID;
	}

	public void setTypeID(int typeID) {
		TypeID = typeID;
	}

	public String getComment() {
		return Comment;
	}

	public void setComment(String comment) {
		Comment = comment;
	}

}
