package com.ssafy.happyhouse.dto;

import java.io.Serializable;

public class Pollution implements Serializable {
	private String name;
	private String dong;
	private String address;
	private String lng;
	private String lat;

	public Pollution(String name, String dong, String address, String lng, String lat) {
		this.name = name;
		this.dong = dong;
		this.address = address;
		this.lng = lng;
		this.lat = lat;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDong() {
		return dong;
	}

	public void setDong(String dong) {
		this.dong = dong;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}
}
