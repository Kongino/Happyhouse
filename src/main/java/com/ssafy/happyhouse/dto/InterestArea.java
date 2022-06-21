package com.ssafy.happyhouse.dto;

import java.io.Serializable;

public class InterestArea implements Serializable {
	private String sido;
	private String gugun;
	private String dongname;
	private String userid;
	private int no;
	public InterestArea() {}
	public String getSido() {
		return sido;
	}
	public void setSido(String sido) {
		this.sido = sido;
	}
	public String getGugun() {
		return gugun;
	}
	public void setGugun(String gugun) {
		this.gugun = gugun;
	}
	public String getDongname() {
		return dongname;
	}
	public void setDongName(String dongname) {
		this.dongname = dongname;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	
	

	
	
	
	
	
	
	
}
