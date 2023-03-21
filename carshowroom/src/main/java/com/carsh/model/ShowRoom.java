package com.carsh.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection ="Showroom")
public class ShowRoom {

	
	private int sid;
	private String sName;
	private String sLocation;
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public String getsLocation() {
		return sLocation;
	}
	public void setsLocation(String sLocation) {
		this.sLocation = sLocation;
	}
	@Override
	public String toString() {
		return "ShowRoom [sid=" + sid + ", sName=" + sName + ", sLocation=" + sLocation + "]";
	}
	
	
}
