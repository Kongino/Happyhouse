package com.ssafy.happyhouse.dto;

import java.io.Serializable;

public class CommercialArea implements Serializable {

	private String shopname;
	private String localname;
	private String codename3;
	private String address;
	private String dong;
	
	private String lat;
	private String lng;
	
	private String code1;
	
	public String getCode1() {
		return code1;
	}

	public void setCode1(String code1) {
		this.code1 = code1;
	}

	public CommercialArea() {}
	
	public String getShopname() {
		return shopname;
	}
	public void setShopname(String shopname) {
		this.shopname = shopname;
	}
	public String getLocalname() {
		return localname;
	}
	public void setLocalname(String localname) {
		this.localname = localname;
	}
	public String getCodename3() {
		return codename3;
	}
	public void setCodename3(String codename3) {
		this.codename3 = codename3;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDong() {
		return dong;
	}
	public void setDong(String dong) {
		this.dong = dong;
	}
	public String getLat() {
		String lt = lat.substring(1, lat.length()-1);
		return lt;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getLng() {
		String ln = lng.substring(1, lng.length()-1);
		return ln;
	}
	public void setLng(String lng) {
		this.lng = lng;
	}
	
	
	
	
}
