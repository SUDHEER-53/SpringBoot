package com.car.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document (collection = "Car")
public class CarDetails {
@Id
private int id;
private String cName;
private String cType;
private double cPrice;
public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}
public String getcName() {
	return cName;
}
public void setcName(String cName) {
	this.cName = cName;
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
	return "CarDetails [id=" + id + ", cName=" + cName + ", cType=" + cType + ", cPrice=" + cPrice + "]";
}

}
