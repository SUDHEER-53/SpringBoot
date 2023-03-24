package com.carsh.dto;

public class CarRequest {
	private String cType;
	private double cPrice;
	public CarRequest() {
		super();
	}
	public CarRequest(String cType, double cPrice) {
		super();
		this.cType = cType;
		this.cPrice = cPrice;
	}
	public String getcType() {
		return cType;
	}
	public void setcType(String cType) {
		this.cType = cType;
	}
	public double getcPrice() {
		return cPrice;
	}
	public void setcPrice(double cPrice) {
		this.cPrice = cPrice;
	}
	@Override
	public String toString() {
		return "CarRequest [cType=" + cType + ", cPrice=" + cPrice + "]";
	}

	
	
}
