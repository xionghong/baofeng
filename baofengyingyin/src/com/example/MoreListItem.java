package com.example;

public class MoreListItem {

	private int imageId;
	private String txt;
	public int getImageId() {
		return imageId;
	}
	public void setImageId(int imageId) {
		this.imageId = imageId;
	}
	public String getTxt() {
		return txt;
	}
	public void setTxt(String txt) {
		this.txt = txt;
	}
	public MoreListItem(int imageId, String txt) {
		super();
		this.imageId = imageId;
		this.txt = txt;
	}
	
}
