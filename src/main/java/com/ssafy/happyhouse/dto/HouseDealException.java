package com.ssafy.happyhouse.dto;

public class HouseDealException extends RuntimeException {
	public HouseDealException() {
		super("거래 정보 처리 중 오류 발생");
	}
	public HouseDealException(String msg) {
		super(msg);
	}
}
