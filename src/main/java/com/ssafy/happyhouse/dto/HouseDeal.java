package com.ssafy.happyhouse.dto;

import java.io.Serializable;

public class HouseDeal implements Serializable {
	private long aptCode        ;
	private String dealAmount  ;
	private int dealYear      ;
	private int dealMonth     ;
	private int dealDay;
	private String area;
	private String floor;
	private String type;
	private String rentMoney;
	private long no;
	private String dong;
	private String apartmentName;
	private String roadName;
	private String buildYear;
	
	
	
	
	public String getBuildYear() {
		return buildYear;
	}



	public void setBuildYear(String buildYear) {
		this.buildYear = buildYear;
	}



	public String getDong() {
		return dong;
	}



	public void setDong(String dong) {
		this.dong = dong;
	}



	public String getApartmentName() {
		return apartmentName;
	}



	public void setApartmentName(String apartmentName) {
		this.apartmentName = apartmentName;
	}



	public String getRoadName() {
		return roadName;
	}



	public void setRoadName(String roadName) {
		this.roadName = roadName;
	}

	private String lat;
	private String lng;
	public String getLat() {
		return lat;
	}



	public void setLat(String lat) {
		this.lat = lat;
	}



	public String getLng() {
		return lng;
	}



	public void setLng(String lng) {
		this.lng = lng;
	}



	public HouseDeal() {}
	
	
	
	public String getAptName() {
		return apartmentName;
	}



	public void setAptName(String apartmentName) {
		this.apartmentName = apartmentName;
	}



//	public HouseDeal(int aptCode, String dealAmount, int dealYear, int dealMonth, int dealDay, String area,
//			String floor, String type, String rentMoney, String dongName, String aptName, int no, String lat, String lng) {
//		super();
//		this.aptCode = aptCode;
//		this.dealAmount = dealAmount;
//		this.dealYear = dealYear;
//		this.dealMonth = dealMonth;
//		this.dealDay = dealDay;
//		this.area = area;
//		this.floor = floor;
//		this.type = type;
//		this.rentMoney = rentMoney;
//		this.dongName = dongName;
//		this.aptName = aptName;
//		this.no = no;
//		this.lat = lat;
//		this.lng = lng;
//	}
	public String getDongName() {
		return dong;
	}
	public void setDongName(String dong) {
		this.dong = dong;
	}
//	public HouseDeal(int aptCode, String dealAmount, int dealYear, int dealMonth, int dealDay, String area,
//			String floor, String type) {
//		super();
//		this.aptCode = aptCode;
//		this.dealAmount = dealAmount;
//		this.dealYear = dealYear;
//		this.dealMonth = dealMonth;
//		this.dealDay = dealDay;
//		this.area = area;
//		this.floor = floor;
//		this.type = type;
//	}

//	public HouseDeal(int aptCode, String dealAmount, int dealYear, int dealMonth, int dealDay, String area,
//			String floor, String type, String rentMoney) {
//		super();
//		this.aptCode = aptCode;
//		this.dealAmount = dealAmount;
//		this.dealYear = dealYear;
//		this.dealMonth = dealMonth;
//		this.dealDay = dealDay;
//		this.area = area;
//		this.floor = floor;
//		this.type = type;
//		this.rentMoney = rentMoney;
//	}

	public long getAptCode() {
		return aptCode;
	}
	public void setAptCode(long aptCode) {
		this.aptCode = aptCode;
	}
	public String getDealAmount() {
		return dealAmount;
	}
	public void setDealAmount(String dealAmount) {
		this.dealAmount = dealAmount;
	}
	public int getDealYear() {
		return dealYear;
	}
	public void setDealYear(int dealYear) {
		this.dealYear = dealYear;
	}
	public int getDealMonth() {
		return dealMonth;
	}
	public void setDealMonth(int dealMonth) {
		this.dealMonth = dealMonth;
	}
	public int getDealDay() {
		return dealDay;
	}
	public void setDealDay(int dealDay) {
		this.dealDay = dealDay;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getFloor() {
		return floor;
	}
	public void setFloor(String floor) {
		this.floor = floor;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getRentMoney() {
		return rentMoney;
	}
	public void setRentMoney(String rentMoney) {
		this.rentMoney = rentMoney;
	}
	
	public long getNo() {
		return no;
	}

	public void setNo(long no) {
		this.no = no;
	}

//	@Override
//	public String toString() {
//		StringBuilder builder = new StringBuilder();
//		builder.append("HouseDeal [aptCode=").append(aptCode).append(", dealAmount=").append(dealAmount)
//				.append(", dealYear=").append(dealYear).append(", dealMonth=").append(dealMonth).append(", dealDay=")
//				.append(dealDay).append(", area=").append(area).append(", floor=").append(floor).append(", type=")
//				.append(type).append(", rentMoney=").append(rentMoney).append(", no=").append(no).append(", dongName=")
//				.append(dongName).append(", aptName=").append(aptName).append("]");
//		return builder.toString();
//	}

	public String toString() {
		String str = "";
		str+="아파트 이름 : "+apartmentName + "<br>";
		str+="법정동 : "+dong+"<br>";
		str+="거래 일자 : "+dealYear+"."+dealMonth+"."+dealDay+"<br>";
		str+="면적 : "+area+"m<sup>2</sup><br>";
		str+="층 : "+floor+"<br>";
		str+="거래 가격 : "+dealAmount+"<br>";
		str+="건축 연도 : "+buildYear+"<br>";
		str+="도로명 : "+roadName+"<br>";
		str+="위도 : "+lat+"<br>";
		str+="경도 : "+lng+"<br>";
		return str;
		
		
	}




	

}
