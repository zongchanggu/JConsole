package com.zjut.pojo;

/**
 * 
 * @author:zongchnaggu
 * @description:created by gu
 * @date:2016年12月23日 下午12:44:15
 */
public class CascadeEntity {

	private int id;
	private String text;
	private boolean selected;

	public CascadeEntity(int id, String text) {
		this.id = id;
		this.text = text;
	}

	public CascadeEntity(int id, String text, boolean selected) {
		this(id, text);
		this.selected = selected;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

}
